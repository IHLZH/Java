package Text_Streams;

import java.io.*;

public class InputStreamReader_OutputStreamWrite {
    public static void main(String[] args) throws IOException {
        output();
        input();
    }

    public static void input() throws IOException{
        String filePath = "E:\\FileTest\\news51.txt";
        //字节流转化为字符流 两步包装：
        //1.将 FileInputStream 转化为 InputStreamReader，并指定编码 gbk
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //2.把 InputStreamReader 装入包装流 BufferedReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //3.读取
        String len;
        while((len = bufferedReader.readLine()) != null)
        {
            System.out.println(len);
        }
        bufferedReader.close();//关外层流即可
    }

    public static void output() throws IOException{
        String filePath = "E:\\FileTest\\news51.txt";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hello world！");
        bufferedWriter.close();
    }
}
