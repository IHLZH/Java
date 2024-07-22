package Text_Thread;

import javax.sound.sampled.Port;

public class Text_Proxy {
    public static void main(String[] args) {
        Test_Runnable tr = new Test_Runnable();
        Proxy proxy = new Proxy(tr);
        proxy.start();
    }
}

//模拟极简的Runnable运行过程， 代理模式
class Proxy implements Runnable{
    private Runnable target = null;
    @Override
    public void run() {
        if(target != null)
        {
            target.run();
        }
    }

    public Proxy(Runnable target){
        this.target = target;
    }

    public void start(){
        start0();
    }
    public void start0(){
        run();
    }
}
