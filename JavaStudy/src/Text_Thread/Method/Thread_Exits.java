package Text_Thread.Method;

//  线程退出/中止
public class Thread_Exits {
    public static void main(String[] args) throws InterruptedException {

        //main线程控制子线程中止
        ThreadExit te = new ThreadExit();
        te.start();

        System.out.println("main线程开始休眠...");
        Thread.sleep(1000 * 10);

        te.setFlag(false);  //main线程通过改变flag，结束run方法，来使子线程中断
    }
}

class ThreadExit extends Thread{
    private int times = 0;
    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            System.out.println("子线程运行：" + (++times) + " 次");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
