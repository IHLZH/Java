package Text_NetWork.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receiver {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象，并在9999端口接收数据；
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //2.创建一个DatagramPacket对象，准备接收数据，接收数据包的大小最多为64k
        byte by[] = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(by, by.length);//
        //3.调用接收方法，将接收到的数据填充到datagramPacket对象中
        datagramSocket.receive(datagramPacket);
        //4.对数据进行拆包，获取数据字节长度和字节数组
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        //5.输出数据
        String str = new String(data, 0, length).trim();
        System.out.println(str);

        byte[] data1 = "收到，原神启动".getBytes();
        DatagramPacket datagramPacket1 = new DatagramPacket(data1, data1.length, InetAddress.getByName("127.0.0.1"), 8888);
        datagramSocket.send(datagramPacket1);
        //6.关闭资源
        datagramSocket.close();
    }
}
