package Text_Reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class testReflectionTime {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //normalFun();
        reflectionFun();
        reflectionOptimizeFun();
    }

    public static void normalFun(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for(int i = 1; i <= 1000000000; i++){
            cat.cry();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法耗时：" + (end - start) + "秒；");
    }

    public static void reflectionFun() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("Text_Reflection.Cat");
        Object object = cls.newInstance();
        Method method = cls.getMethod("cry");
        long start = System.currentTimeMillis();
        for(int i = 1; i <= 1000000000; i++){
            method.invoke(object);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射方法耗时：" + (end - start) + "秒；");
    }

    //反射优化，取消访问检查，有优化但不多
    public static void reflectionOptimizeFun() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream("src/Text_Reflection/data1.properties"));
        String className = properties1.get("className").toString();
        String methodName = properties1.get("methodName").toString();

        Class cls = Class.forName(className);
        Object object = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.setAccessible(true); //在反射调用方法时，取消访问检查
        long start = System.currentTimeMillis();
        for(int i = 1; i <= 1000000000; i++){
            method.invoke(object);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射优化方法耗时：" + (end - start) + "秒；");
    }
}
