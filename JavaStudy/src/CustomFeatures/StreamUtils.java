package CustomFeatures;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils {
    //将输入流转化成字节数组
    public static byte[] streamToByteArray(InputStream is) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte by[] = new byte[1024];
        int len;
        while((len = is.read(by)) != -1){
            byteArrayOutputStream.write(by, 0, len);
        }
        byte array[] = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return array;
    }

    //将输入流转化成字符串
    public static String streamToString(InputStream is) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while((str = bufferedReader.readLine()) != null){
            stringBuilder.append(str+"\r\n");
        }
        return stringBuilder.toString();
    }
}
