package Text_NetWork.Tcp.Tcp2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        new Thread(new Read(socket)).start();
        new Thread(new Write(socket)).start();
        //socket.close();
    }
}
