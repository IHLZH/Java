package Text_Streams.File;

import java.io.File;
import java.io.IOException;

public class FliesTest {
    public static void main(String[] args) throws IOException {
        FliesTest.create03();
    }

    //1.创建文件
    public static void create01() throws IOException {
        String filePath = "E:\\FileTest\\news1.txt";
        File file = new File(filePath);  //根据路径创建文件
        file.createNewFile();  //createNewFlie()创建新文件，抛出IOException异常
    }

    public static void create02() throws IOException{
        File parent = new File("E:\\FileTest\\");
        String child = "news2.txt";
        File file = new File(parent, child); //根据父目录文件加子路径创建，file对象被创建出后被保存在内存中，调用方法createNewFile后才会被写到硬盘中
        file.createNewFile();
    }

    public static void create03() throws IOException{
        String  parent = "E:\\FileTest\\";
        String child = "news3.txt";
        File file = new File(parent, child); //根据父目录和子路径创建文件
        file.createNewFile();
    }

    //第一个方法是直接指定路径创建文件，第二种是根据已知文件名创建新文件在那已知文件目录上，第三种是通过路径，通过已知旧文件路径创建



}
