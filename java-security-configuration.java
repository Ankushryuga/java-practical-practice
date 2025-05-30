import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotaion.web.builders.HttpSecurity;
import org.springframework.security.config.annotaion.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
  public class SecurityConfig{
    @Bean
    //this defines how security should be applied to HTTP requests.
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      //csrf(Cross-site request forgrey) protection: disableing for stateless APIs or non-browser clients.
      //You should only disabl CSRF if you know its safe to do so.
      //enableing cors support for working together with CorsFilter Bean
      http.csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults())
        //allow all requests
        .authorizeHttpRequests(auth->auth.anyRequest().permitAll());

      return http.build();
    }
  }
