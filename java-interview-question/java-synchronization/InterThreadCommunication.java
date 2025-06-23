/**
 * interprocess communication (IPC): it refers to techniques that allow different processes (possibly on the same machine) to communicate and exchange data. 
 */

/**
 * Inter-thread communication:
 *  => when 2 or more threads exchange some informations, Inter-thread communication is achieved by using the wait(), notify(), notifyAll() methods of the Object clsas.
 */
class Chat{
    boolean flag=false;
    public synchronized void Question(String msg){
        if(flag){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag=true;
        notify();
    }
    public synchronized void Answer(String msg){
        if(!flag){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag=false;
        notify();
    }
}
class T1 implements Runnable{
    Chat m;
    String[] s1={"Hi", "How are you ?", "I am also doing fine!" };
    public T1(Chat m1){
        this.m=m1;
        new Thread(this, "Question").start();
    }
    public void run(){
        for(int i=0;i<s1.length;i++){
            m.Question(s1[i]);
        }
    }
}
class T2 implements Runnable{
    Chat m;
    String s2[]={"Hi", "I am good, what about you?", "Great!"};
    public T2(Chat m2){
        this.m=m2;
        new Thread(this, "Answer").start();
    }
    public void run(){
        for(int i=0;i<s2.length;i++){
            m.Answer(s2[i]);
        }
    }
}
public class Main{
    public static void main(String[] args){
        Chat m=new Chat();
        new T1(m);
        new T2(m);
    }
} 