package Text_NetWork.Tcp.TcpFileCopy;

import CustomFeatures.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket  = serverSocket.accept();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\WorkSpace\\code2023\\javacode\\AndroidText1\\src\\shenli.vip"));
        byte by[] = new byte[1024];
        int len;
        while((len = bufferedInputStream.read(by)) != -1){
            bufferedOutputStream.write(by, 0, len);
        }

        bufferedWriter.write("收到图片");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();


    }
}
