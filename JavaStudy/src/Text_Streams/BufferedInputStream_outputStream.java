package Text_Streams;

import java.io.*;

public class BufferedInputStream_outputStream {
    public static void main(String[] args) throws IOException {
        copy();
    }

    public static void copy() throws IOException {
        String filePath = "E:\\FileTest\\learn2.jpg";
        String filePath1 = "E:\\FileTest\\learn3.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath1));
        byte by[] = new byte[8];
        int len;
        while((len = bufferedInputStream.read(by)) != -1){
            bufferedOutputStream.write(by, 0, len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}
