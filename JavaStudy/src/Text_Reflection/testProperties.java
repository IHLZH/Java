package Text_Reflection;

import java.io.*;
import java.util.Properties;

public class testProperties {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Text_Reflection/data.properties"));
        String line;
        //获取配置文件信息
        while((line = bufferedReader.readLine()) != null){
            String[] split = line.split("=");
            //System.out.println(split[0] + "=" + split[1]);
        }
        bufferedReader.close();

        //Properties的查询
        //1.创建Properties类
        Properties properties = new Properties();
        //2.将指定配置文件加载到类
        properties.load(new FileReader("src/Text_Reflection/data.properties"));
        //3.将键值对打印到控制台
        properties.list(System.out);
        //4.根据键值获取对应值
        String str = properties.getProperty("user");
        System.out.println("user" + "=" + str);

        //Properties的创建 修改
        Properties properties1 = new Properties();

        properties1.setProperty("user", "喜多郁代"); //使用字节流，保存的是unicode码
        properties1.setProperty("id", "2233");  //若key值不存在，即为创建，若key值已经存在，则修改对应value值
        properties1.setProperty("passward", "123456");

        properties1.store(new FileOutputStream("src/Text_Reflection/data1.properties"), null);

        //我悟了，我们码的是.java文件，编译后就是.class字节码文件，这个字节码文件就是存放这个Class的
        //一般new对象操作，就是将这个Class交给了JVM帮你创建实例或者获取静态变量,
        // 所以可以推测，类加载就是通过路径找到并编译.java文件，然后返回.class中的Class类对象
    }
}
