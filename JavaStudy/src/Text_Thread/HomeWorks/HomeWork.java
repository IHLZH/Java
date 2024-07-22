package Text_Thread.HomeWorks;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        T1 t1 = new T1();
        Thread thread = new Thread(t1);

        //thread.setDaemon(true);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        if(scanner.next().equals("Q"))
        {
            t1.setLoop(false);
        }
    }
}

class T1 implements Runnable{
    Random random = new Random();
    private boolean loop = true;
    @Override
    public void run() {
        while(loop)
        {
            int number = random.nextInt(100);
            System.out.println(number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }
}
