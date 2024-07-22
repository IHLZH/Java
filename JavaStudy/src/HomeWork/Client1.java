package HomeWork;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            OutputStream outputStream = socket.getOutputStream();
            while(true){
                outputStream.write("1".getBytes());
                Thread.sleep(10000);
                outputStream.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


