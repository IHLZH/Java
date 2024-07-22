package HomeWork;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;

public class Server {
    public static HashMap<String, Long> times = new HashMap<>();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while(true) {
            Socket socket = serverSocket.accept();
            times.put(socket.getInetAddress().getHostAddress(), System.currentTimeMillis( ));
            new Thread(new Reception(socket)).start();
            new Thread(new HeartBeat(socket)).start();
        }
    }
}


