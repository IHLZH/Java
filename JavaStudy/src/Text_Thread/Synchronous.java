package Text_Thread;

public class Synchronous {
    public static void main(String[] args) throws InterruptedException {
        TestSynchronous testSynchronous = new TestSynchronous();
        Thread thread = new Thread(testSynchronous);
        Thread thread1 = new Thread(testSynchronous);
        Thread thread2 = new Thread(testSynchronous);

        thread.start();
        thread1.start();
        thread2.start();
        for(int i = 1; i <= 10; i++)
        {
            if(i == 5)thread.join();
            else System.out.println(i);
        }

    }
}

class TestSynchronous implements Runnable{
    private int doTimes = 100;
    private boolean flag = true;

    public synchronized void doit(){  //Synchronous 同步方法，每个时刻最多只有一个线程执行这个方法
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

    @Override
    public void run() {

        while(flag){
            doit();

        }
    }
}
