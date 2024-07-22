package Text_NetWork.Tcp.Tcp1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        //1.在本机的9999端口进行监听，等待连接，（要求没有其他服务在监听9999）
        //2.当没有客户端连接进来时，程序会阻塞，等待连接，有客户端连接时就会返回Socket对象，连接成功
        Socket socket = serverSocket.accept();
        //3.通过getOutputStream()获取客户写入数据通道的数据
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream =socket.getOutputStream();

        byte by[] = new byte[1024];
        int len = inputStream.read(by);
        System.out.println(new String(by, 0, len));
        outputStream.write("yuanshenqidong".getBytes());
        socket.close();
        serverSocket.close();
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}
