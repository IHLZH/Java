package Text_Streams.File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoStreams {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//字符流读取

//        do{
//            c = (char)bufferedReader.read(); //read方法从输入流读取字符并返回一个整数值，读取结束时返回-1，该方法抛出 IOException。
//        }while(c != 'q');

        String str;
        System.out.println(str = bufferedReader.readLine());  //readLine返回String类型字符串，该方法抛出 IOException。
    }
}
