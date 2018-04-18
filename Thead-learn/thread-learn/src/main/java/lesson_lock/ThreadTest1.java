package lesson_lock;

public class ThreadTest1  extends Thread{
	private int threadNo;   
    public ThreadTest1(int threadNo) {   
        this.threadNo = threadNo;   
    }   
    public static void main(String[] args) throws Exception {   
        for (int i = 1; i < 10; i++) {   
           new ThreadTest1(i).start();   
            Thread.sleep(1);   
        }   
     }   
    
    @Override  
     public synchronized void run() {   
        for (int i = 1; i < 10000; i++) {   
            System.out.println("No." + threadNo + ":" + i);   
        }   
     }  
}
