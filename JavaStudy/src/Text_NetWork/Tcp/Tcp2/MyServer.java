package Text_NetWork.Tcp.Tcp2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true){
            Socket socket = serverSocket.accept();
            new Thread(new Read(socket)).start();
            new Thread(new Write(socket)).start();
        }
        //socket.close();
    }
}
