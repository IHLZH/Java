package Text_Streams;

import java.io.*;

public class BufferedReader_Writer {
    public static void main(String[] args) throws IOException {
        read1();
        //write1();
        //read2();
    }

    //处理流
    public static void read1() throws IOException {
        String filePath = "E:\\FileTest\\news5.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));  //包装了一个FileReader节点流
        String len;
        while((len = bufferedReader.readLine()) != null){  //readLine读取结束返回null
            System.out.println(len);
        }
        bufferedReader.close();  //关闭外部流即可，因为底层会自动关闭节点流
    }
    public static void write1() throws IOException{
        String filePath = "E:\\FileTest\\news5.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        String str = "原神启动！";
        bufferedWriter.write(str);
        bufferedWriter.newLine(); //插入换行符
        bufferedWriter.close();
    }





}
