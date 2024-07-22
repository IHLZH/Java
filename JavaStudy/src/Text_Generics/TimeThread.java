package Text_Generics;

import java.util.Date;

public class TimeThread extends Thread{  //创建线程类

    public void run(){
        System.out.println(new Date().toLocaleString());
    }
}
