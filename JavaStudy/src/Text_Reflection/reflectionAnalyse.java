package Text_Reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class reflectionAnalyse {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream("src/Text_Reflection/data1.properties"));
        String className = properties1.get("className").toString();
        String methodName = properties1.get("methodName").toString();


        Class cls1 = Class.forName(className);
        Class cls2 = Class.forName(className);
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
    }
}
