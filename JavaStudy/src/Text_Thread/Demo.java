package Text_Thread;

//创建线程的两种方法：（1）继承Thread类，重写run方法（2）实现Runnable接口，重写run方法
import static java.lang.Thread.sleep;

public class Demo {
    public static void main(String[] args) throws InterruptedException{
        Test test = new Test();
        test.start(); //start启动线程，会自动调用重写的run方法
                      //这里，主线程会创建一个子线程，主线程和子线程是同时进行的
                      //主线程结束，不一定会导致整个应用程序结束

        //test.run() 直接启动run方法不会启动线程，运行的还是main线程
        //真正实现多线程的是start中的start0方法，而不是run方法xiancheng
        for(int i = 1; i <= 10; i++){
            System.out.println("主线程：" + i + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Test extends Thread{
    @Override
    public void run() { //重写run方法，写上自己的业务逻辑
        int times = 1;
        while(true){  //每隔一秒，输出一次启动
            System.out.println("子线程：启动" + (times++) + Thread.currentThread().getName());
            try {
                sleep(1000);  //休眠一秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times == 10)break;
        }
    }
}



