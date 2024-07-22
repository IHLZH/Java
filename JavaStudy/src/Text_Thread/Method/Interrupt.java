package Text_Thread.Method;

//线程中断
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt ti = new ThreadInterrupt();
        ti.start();

        for(int i = 1; i <= 5; i++)
        {
            Thread.sleep(1000);
            System.out.println("子线程休眠即将中断：" + i);
        }

        ti.interrupt(); //子线程休眠中断
    }
}

class ThreadInterrupt extends Thread{
    //private int times = 0;
    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            for(int times = 1; times <= 100; times++)System.out.println("子线程运行：" + times + " 次");
            try {
                System.out.println("子线程开始休眠...");
                Thread.sleep(1000 * 20); //线程休眠20秒
            } catch (InterruptedException e) {
                System.out.println("线程休眠中断...");
            }
        }
    }

}
