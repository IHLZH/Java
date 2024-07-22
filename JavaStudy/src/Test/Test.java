package Test;

import java.io.BufferedReader;
import java.io.Reader;

public class Test {
    public static void main(String[] args) {
        TestSynchronous testSynchronous1 = new TestSynchronous();
        TestSynchronous testSynchronous2 = new TestSynchronous();
        TestSynchronous testSynchronous3 = new TestSynchronous();


        testSynchronous1.start();
        testSynchronous2.start();
        testSynchronous3.start();

        //BufferedReader bufferedReader = new BufferedReader()
        //Reader
    }
}

class TestSynchronous extends Thread{
    private int doTimes = 100;
    private boolean flag = true;

    public synchronized void doit(){

    }

    @Override
    public void run() {
        while(flag){
            synchronized (TestSynchronous.class){
                if(doTimes <= 0)
                {
                    flag = false;
                    System.out.println("剩余" + doTimes + "个子任务");
                    return;
                }
                System.out.println("线程：" + Thread.currentThread().getName() + " 执行第 " + doTimes-- + " 个子任务");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class Person {
    String id;
    public Person(String id){
        this.id = id;
    }

    public static void fun(){
        System.out.println("1111");
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                '}';
    }
}

class Son extends Person{
    int num;
    public Son(String id,int num){
        super(id);
        this.num = num;
    }

    public static void fun(){
        System.out.println("2222");
    }


}
