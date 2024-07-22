package Text_Thread.Method;

public class Cut {
    public static void main(String[] args) throws InterruptedException{
        ThreadCut threadCut = new ThreadCut();
        Thread thread = new Thread(threadCut);
        thread.start();

        for(int times = 1; times <= 20; times++){
            System.out.println("main线程：" + times);
            Thread.sleep(1000);
            if(times == 5)
            {
                System.out.println("注意：子线程开始插队...");
                //thread.start();
                thread.join();   //插队，join方法可以让子线程插队，即main线程停止，子线程执行完后，main线程才恢复执行

                //System.out.println("注意：main线程开始礼让...");
                //Thread.yield();//main线程礼让，不一定成功（资源丰富时，无需礼让）
            }
        }
    }
}

class ThreadCut implements Runnable{
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
