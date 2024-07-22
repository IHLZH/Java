package HomeWork;

import java.util.Date;
import java.net.Socket;

public class HeartBeat implements Runnable{
    Socket socket;
    public HeartBeat(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true){
            String ip = new String(socket.getInetAddress().getHostAddress());
            Long time = Server.times.get(ip);
            Long time1 = System.currentTimeMillis();
            if(time1 - time > 10100){
                System.out.println(time1);
                System.out.println(time);
                System.out.println("客户" + ip + "未在10s内发送！");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
