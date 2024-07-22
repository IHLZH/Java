package Text_Thread.HomeWorks;

import java.util.Random;

public class HomeWork2 {
    public static void main(String[] args) {
        T2 t2 = new T2();

        Thread thread = new Thread(t2);
        Thread thread1 = new Thread(t2);

        thread.start();
        thread1.start();
    }
}

class T2 implements Runnable{
    Random random = new Random();
    private int sum = 10000;
    private boolean loop = true;
    public synchronized void doit(){
        if(sum == 0)
        {
            this.loop = false;
            System.out.println("取钱结束");
            return;
        }
        System.out.println(Thread.currentThread().getName() + "取1000元，剩余：" + (sum-=1000) + "元");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while(loop)
        {
            doit();
        }
    }
    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }
}

