package Text_Thread;

public class Multi_Threaded {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02();
        Thread thread = new Thread(thread01);
        Thread thread1 = new Thread(thread01);  //String.valueof(),将基本数据类型转化为字符串

        thread1.start();
        thread.start();
        //new Thread(thread01).start();  //多线程会产生冲突
    }
}

class Thread01 implements Runnable{  //实现Runnable接口方式更加符合多个线程共享有一个资源的情况，并且避免了单继承机制
    private int times = 100;
    @Override
    public void run() {

        while(true)
        {
            if(times <= 0)
            {
                System.out.println("剩余：" + times);
                break;
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello World!"  + --times + Thread.currentThread().getName());

        }
    }
}

class Thread02 implements Runnable{
    @Override
    public void run() {
        int times = 0;
        while(true)
        {
            times++;
            System.out.println("Hi World!" + Thread.currentThread().getName() + times);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times == 5)break;
        }
    }
}
