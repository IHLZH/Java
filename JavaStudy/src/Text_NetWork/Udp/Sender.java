package Text_NetWork.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;

public class Sender {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象，在8888端口号上接收数据
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //2.将数据打包，封装到DatagramPacket对象中，指明接收端的ip地址和端口号，类似发邮件时要指明收件人和地址
        byte[] data = "原神启动".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9999);
        //3.发送，关闭
        datagramSocket.send(datagramPacket);
        byte[] by = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(by, by.length);
        datagramSocket.receive(datagramPacket1);

        int length = datagramPacket1.getLength();
        byte[] data1 = datagramPacket1.getData();
        String str = new String(data1, 0, length);
        System.out.println(str);

        datagramSocket.close();
    }
}
