package Text_Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class inputStreams {
    public static void main(String[] args) throws IOException {
        //InputStream
        //流是文件传输的通道
        readFile1();
    }

    public static void readFile() throws IOException {
        int fileRead = 0;
        String filePath = "E:\\FileTest\\news1.txt";
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);  //创建FileInoutStream对象，读取文件（从硬盘到内存）
        while((fileRead = fileInputStream.read()) != -1){  //read方法按字节读取，读取结束时返回-1
            System.out.print((char)fileRead);  //read返回ascall码，需强转为char
        }
        fileInputStream.close();  //读取结束后要关掉输入流，以防资源浪费
    }

    public static void readFile1() throws IOException {
        byte by[] = new byte[8];
        int fileLength = 0;
        String filePath = "E:\\FileTest\\news1.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);  //创建FileInoutStream对象，读取文件（从硬盘到内存）
        while((fileLength = fileInputStream.read(by)) != -1){  //从该输入流读取最多by.length个字节到by中，返回实际读取到的字节数
            System.out.print(new String(by, 0, fileLength));  //字符串方法，将数组中指定范围的字节内容转化为字符串
        }
        fileInputStream.close();  //读取结束后要关掉输入流，以防资源浪费
    }
}
