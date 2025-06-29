package Java_Interview_Advanced_Topics.Java_Generics;


abstract class Handler<T>{
    public T content;
    public Handler(T content){
        this.content=content;
    }
    abstract void handle();
}
public class JavaGenerics {
    public static void main(String[] args){
        //Create an anonymous class to handle 1.
        Handler<Integer> integerHandler=new Handler<Integer>(1){
            @Override
            public void handle(){
                System.out.println(content);
            }
        };
        integerHandler.handle();

        //Create an anonymous class to handle 2
        Handler<? extends Number> intHandler1=new Handler<Number>(2){
            @Override
            public void handle(){
                System.out.println(content);
            }
        };
        integerHandler.handle();


        Handler<?> handler=new Handler<Object>("test"){
            @Override
            public void handle(){
                System.out.println(content);
            }
        };
        handler.handle();
    }
}
