package Text_Thread;

//因为Java的单继承特性，若一个类已经继承了一个父类，就无法继承Thread，这是可以通过实现Runnable来创建线程
public class Demo_Runnable {
    public static void main(String[] args) {
        Test_Runnable tr = new Test_Runnable();
        Thread thread = new Thread(tr);
        thread.start();  //Runnable没有start方法，只能通过实例化一个Thread类来调用start方法
    }
}

class Test_Runnable implements Runnable{
    @Override
    public void run() {
        int times = 0;
        while(true){
            System.out.println("Hello!" + (++times) +" " +Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times == 10)break;
        }
    }
}





