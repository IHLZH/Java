package Text_Thread.Method;

import java.util.DuplicateFormatFlagsException;

public class Daemon {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);

        //thread.setPriority(Thread.MIN_PRIORITY);  设置优先级 MIN：1，NORM：5，MAX：10
        //thread.setPriority(Thread.NORM_PRIORITY);
        //thread.setPriority(Thread.MAX_PRIORITY);

        //thread.getPriority()  获取优先级

        thread.setDaemon(true); //将子线程设为守护线程，main线程结束后，子线程会跟着结束
        thread.start();

        for(int times = 1; times <= 10; times++)
        {
            System.out.println("main线程：" + times);
            Thread.sleep(1000);
        }
    }
}
class DaemonThread implements Runnable{
    @Override
    public void run() {
        int times = 0;
        while(true)
        {
            System.out.println("子线程：" + ++times);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times == 20)break;
        }
    }
}