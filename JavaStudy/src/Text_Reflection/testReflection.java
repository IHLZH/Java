package Text_Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class testReflection {
    public static void main(String[] args) throws Exception{
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream("src/Text_Reflection/data1.properties"));
        String className = properties1.get("className").toString();
        String methodName = properties1.get("methodName").toString();

        Class cls = Class.forName(className);
        Object object = cls.newInstance();
        System.out.println("object的运行类型为" + object.getClass());

        Method method = cls.getMethod(methodName);
        method.invoke(object); //通过invoke（对象）的方法来调用方法

        //getField无法获得私有属性
        Field name = cls.getField("name");
        System.out.println(name.get(object)); //通过get（对象）的方法得到成员变量

        //获取无参构造
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        //获取有参构造
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);

        //反射缺点：影响执行速度
    }
}
