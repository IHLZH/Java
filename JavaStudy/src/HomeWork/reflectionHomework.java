package HomeWork;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectionHomework {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        Class cls = Class.forName("HomeWork.PrivateTest");
        PrivateTest privateTest = (PrivateTest) cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(privateTest, "喜多郁代");
        //System.out.println(name.get(object));
        Method getName = cls.getDeclaredMethod("getName");
        //System.out.println(getName.invoke(privateTest));

        Class fileClass = Class.forName("java.io.File");
        Constructor[] constructors = fileClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor constructor = fileClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Object file = constructor.newInstance("E:\\FileTest\\news11.txt");
        Method method = fileClass.getMethod("createNewFile");
        method.invoke(file);
    }
}

class PrivateTest{
    private String name = "helloKitty";
    public String getName(){
        return name;
    }
}
