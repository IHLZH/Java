package Text_Thread;

//模拟死锁
public class DeadLock {
    public static void main(String[] args) {
        TestDeadLock A = new TestDeadLock(true);
        Thread Thread_A = new Thread(A);
        TestDeadLock B = new TestDeadLock(false);
        Thread Thread_B = new Thread(B);

        Thread_A.setName("线程A");
        Thread_B.setName("线程B");

        Thread_A.start();
        Thread_B.start();
    }
}

class TestDeadLock implements Runnable{
    static Object o1 = new Object();  //static 表示该类所有对象共享o1， o2对象
    static Object o2 = new Object();
    boolean flag;
    @Override
    public void run() {
        if(flag)
        {
            synchronized (o1){   //线程A需要线程B完成，线程B又需要线程A完成，从而导致死锁
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        }
        else{
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + "进入2");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + "进入1");
                }
            }
        }
    }

    public TestDeadLock(boolean flag)
    {
        this.flag = flag;
    }
}
