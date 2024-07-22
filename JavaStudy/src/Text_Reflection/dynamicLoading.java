package Text_Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class dynamicLoading {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Cat cat = new Cat(); //静态加载，编译时就会加载，没有该类的话就会报错，依赖性太强
        cat.call();

        Class cls = Class.forName("Text_Reflection.Cat");
        Object object = cls.newInstance();  //动态加载，运行时才会加载
        Method method = cls.getMethod("call");
        method.invoke(object);


    }

    static int a = 1;

     int b = 1;
}
