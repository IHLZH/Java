package Text_NetWork;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机 InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //2.根据主机名获取指定的 InetAddress 对象
        InetAddress host1 = InetAddress.getByName("LAPTOP-TE6QI6K6");
        System.out.println(host1);

        //3.根据域名获取 InetAddress 对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //4.根据 InetAddress 对象，获取ip地址
        String hostAddress = host2.getHostAddress();
        System.out.println(hostAddress);

        //5.根据 InetAddress 对象，获取域名
        String hostName = host2.getHostName();
        System.out.println(hostName);
    }
}
