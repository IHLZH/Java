package Text_Thread;

public class Lock {
    public static void main(String[] args) {
        TestSynchronous testSynchronous = new TestSynchronous();
        Thread thread = new Thread(testSynchronous);
        Thread thread1 = new Thread(testSynchronous);
        Thread thread2 = new Thread(testSynchronous);

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class TestLock implements Runnable{
    private int doTimes = 100;
    private boolean flag = true;

    public synchronized void doit(){  //非静态同步方法的锁默认是当前类的对象，即this，静态同步方法的锁默认是当前类的字节码文件，即 类名.class
        if(doTimes <= 0)              //同步方法和同步代码块的锁是同一对象时，才能实现同步
        {                             //继承Thread创建线程会导致锁的对象不一致
            flag = false;
            return;
        }
        System.out.println("线程：" + Thread.currentThread().getName() + " 执行 " + doTimes--);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        while(flag){
            //doit();

            synchronized (/*TestLock.class*/ this){  //同步代码块
                if(doTimes <= 0)
                {
                    flag = false;
                    return;
                }
                System.out.println("线程：" + Thread.currentThread().getName() + " 执行 " + doTimes--);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
