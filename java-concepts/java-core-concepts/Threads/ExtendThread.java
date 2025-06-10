public class ExtendThread extends Thread{
    public static void main(String[] args){
        ExtendThread thread=new ExtendThread();
        thread.start();
        System.out.println("This code is outside of the thread");
    }
    @Override
    public void run(){
        System.out.println("This code is running in a thread");
    }
}