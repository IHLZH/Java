package HomeWork;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

public class Reception implements Runnable{
    Socket socket;
    public Reception(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        while(true){
            try {
                InputStream inputStream = socket.getInputStream();
                byte by[] = new byte[8];
                int len = inputStream.read(by);
                if(new String(by, 0, len).equals("1")) {
                    Server.times.put(socket.getInetAddress().getHostAddress(), System.currentTimeMillis());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
