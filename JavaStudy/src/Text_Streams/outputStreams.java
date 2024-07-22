package Text_Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class outputStreams {
    public static void main(String[] args) throws IOException {
        //writeFile();
        copy();
    }

    public static void writeFile() throws IOException {
        String filePath = "E:\\FileTest\\news4.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath,true);

        String str = "ysqdysqd";
        fileOutputStream.write('y'); //1.写入一个字节
        fileOutputStream.write(str.getBytes());  //2.写入字符串，getBytes将字符串转换为字节数组
        fileOutputStream.write(str.getBytes(), 0, 4);  //3.从off开始,将字节数组中长度为len的字节输出

        // new FileOutputStream(filePath); 直接覆盖原来的内容
        // new FileOutputStream(filePath,true); 将append置为true，写入的内容会追加到原有内容之后
        fileOutputStream.close();
    }

    //文件拷贝
    public static void copy() throws IOException{
        String filePath = "E:\\FileTest\\learn.jpg";
        String filePath2 = "E:\\FileTest\\learn1.jpg";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath2);
        int len;
        byte by[] = new byte[1024];
        while((len = fileInputStream.read(by)) != -1){
            fileOutputStream.write(by, 0, len);
        }
        if(fileOutputStream != null)fileOutputStream.close();
        if(fileInputStream != null)fileInputStream.close();
    }
}
