**Annotations:**  Annotations in spring boot are a form of metadata added to java code (classes, methods, fields) to provide additional information and configuration instructions to the spring framework.

**Some important spring boot annotations**
- **@Autowired**: It automatically wires beans by type. This means that spring will look for a bean of the same type as the field, constructor, or method parameter marked with @Autowired, and inject it for you.
     You don't have to write any manual wiring code or worry about creating objects yourself.
     **NOTE**:  One thing to keep in mind is that if there are multiple beans of the same type, Spring will get confused and throw an exception. To avoid this, you can use the **@Qualifier** annotation to specify
     which bean you want to use.
    
- **@Qualifier**: To use **@Qualifier**, you first need to give a name to your beans using the **@Component** or **@Service** annotations. Then, in your code, you can annotate with @Autowired and @Qualifier,
     speicifying the name of the bean you want to use.

# Example:
      @Component("myBean")
      public class MyBean{
        //code.
      }
      @Service
      public class MyService{
        @Autowired
        @Qualifier("myBean")
        private MyBean myBean;
      }
-  **@Value**: It's a powerful annotation used to inject values from various sources into your beans. These sources include properties files, environment variables, and command line arguments.
# Example:
      myapp.username=John
      myapp.password=secret
      - You can use @Value to inject these values into your beans:
        @Service
        public class MyService{
          @Value("${myapp.username}")
          private String username;
          @Value("${myapp.password}")
          private String password;
        }

  - **ResponseBody**: In a spring MVC application, when a controller method is invoked, it typically processes the request necessary operations or logic, and then returns the name of the view
       that should be rendered. The view resolution process kicks in to locate the appropriate view template based on the returned view name.
       By annotating a method with **@ResponseBody**, you instruct Spring to bypass the view resolution process and write the method's return value directly to the HTTP response body.
       Meaning, if you have a method in your controller that returns a value, but instead of rendering it through a view template or HTML page, you want to send it directly as the response body.
# Example:
      @Controller
      public class MyController{
        @GetMapping("/data")
        @ResponseBody
        public String getData(){
          return "This is raw data"
        }
      }

  - **@Component**: By becoming a **@Component**, your class becomes a Spring-managed bean. meaning **Spring Boot takes care of creating and managing instances of that class within the application context**,
       you can then inject and use this bean in other parts of your application by using **@Autowired** or other dependency injection mechanisms.
        - **@Component** annotation is the base annotation for other specialized annotations in Spring, such as **@Service**, **@Repository**, and **@Controller**. These specialized annotations provide additional semantics
        - and functionality tailored to specific use cases.
# Example:
      @Component
      public class ComponentDemo{
        public void doSomething(){
          //code
        }
      }

      @Service
      public class MyService{
        @Autowired
        private ComponentDemo component;
        public void performAction(){
          component.doSomething();    //using component
        }
      }

  - **@Controller**: When you annotate a class with **@Controller**, you're telling Spring Boot that this class will be **responsible for handling web requests**. It serves as the **entry point for the request-response flow**.
       You can then use method-level annotations like **@GetMapping**, **@PostMapping**, **@PutMapping**, **@DeleteMapping** to specify the type of HTTP request that the methods in your controller will handle.
# Example:
    @Controller
    @RequestMapping("/users")
    public class UserController{
      @GetMapping("/${id}")
      public UserGetUser @PathVariable Long id, Model model){
        //Retrieve user from database and add it to the model.
        User user=userService.getUserById(id);
        return user;
      }
    }


  - **@RestController**: @RestController=@Controller+@ResponseBody
       - @RestController handles requests and effortlessly produces the response as-is, without the need for any view templates.

# Example:
      @RestContoller
      @RequestMapping("/api")
      public class SuperHeroController{
        @GetMapping("/heroes")
        public List<Superhero> getAllHeroes(){
        //Retrieve all superheroes from the database.
        List<Superhero> heroes= superheroService.getAllHeroes();
        return heroes;
        }
      }

  - **@Service**: Services encapsulates the business logic of your application and are responsible for performing specific tasks and coordinating actions b/w different components.
# Example: 
      @Service
      public class UserService{
        @Autowired
        private UserRepository userRepository;
        public User getUserById(Long id){
          return userRepository.findById(id);
        }
      }

  - **@RequestBody**: It is used to bind the request body of an HTTP request to a method parameter or an object.
        - When a client sends a HTTP request, they can include data in the request body, like JSON or XML informations. By using **@RequestBody**, you can automatically extract and use that data.
          
# Example: 
      @PostMapping("/users")
      public ResponseEntity<User> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok(user);
      }
      @Data      //@Data annotations in Java is a feature provided by Lombok, It automatically generates several common methods, saving developers from writing them manually.(example @Getting, @Setter, @ToString etc).
      public class User{
        private String name;
        private String email;
      }

      //when a client sends a HTTP Post request to the "/users" endpoint with a JSON body like this, Spring will automatically deserialze the JSON and bind it to a User object.

  - **@PathVariable**: The **@PathVariable** annotation in Spring allows you to extract values from the URL and use them in your code. It's like picking up a specific part of the URL and using it as a variable.
        - For example: URL like "/user/1234", where "123" is a dynamic value representing a user ID, with **@PathVariable**, you can capture that "123" and use it in your method.

# Example:
        @GetMapping("/user/{id}")
        public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
          User user= userService.getUserById(userId);
          return ResponseEntity.ok(user);
        }

  - **@RequestParam**: When a client sends a HTTP request, they can include extra information in the URL called query parameters. These parameters appear after a question mark(?) in the URL and are typically in the form of key-value pairs.
        - Example: in the URL: "/users?id=123", the query parameter is "id" with a value of "123".
        - By using **@RequestParam**, you can retrieve the value of a specific query parameter and use it in your code.

# Example:
      @GetMapping
      public ResponseEntity<User> getUserById(@RequestParam("id") Long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
      }

  - **@Bean**: It is used to declare a bean, It is similar to the <bean/> element in XML configuration. By annotating a method with **@Bean**, you can define a bean and register it in the Spring application context.
        - It indicates that a method produces a bean to be managed by the Spring container. It is typically used within a class annotated with **@Configuration** or **@Component**.

# Example:
      @Configuration
      public class AppConfig{
        @Bean
        public MyBean myBean(){
          return new MyBean();
        }
      }

  - **@Configuration**: This annotation in Spring is used to indicate that a class provides configuration for the application context. It is typically used in conjunction(Connect) with other annotations like **@Bean** to define beans and configure various
        aspects of the Spring application.

  - **@ControllerAdvice**: When you annotate a class with **@ControllerAdvice**, it becomes a global exception handler. It can contain exception handling methods that will be invoked when exceptions are thrown from controller methods. It allows you to **centralize exception
        handling logic and apply it uniformly** across different controllers.

# Example:
        @ControllerAdvice
        public class GlobalExceptionHandler{
          @ExceptionHandler(Exception.class)
          public ResponseEntity<String> handleException(Exception ex){
            //Exception handling logic.
            return new ResponseEntity<>("An error occured: "+ ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
          }
        }

  - **ExceptionHandler**: When an exception occurs within a controller method, the @ExceptionHandler -annotated method is invoked to handle that specific exception.
        
      
