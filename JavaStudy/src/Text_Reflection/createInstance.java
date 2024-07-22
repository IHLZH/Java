package Text_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class createInstance {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        //create();
        //testField();
        textMethod();
    }

    public static void create() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class userClass = Class.forName("Text_Reflection.User");
        //1.public无参构造
        Object user1 = userClass.newInstance();
        //2.public有参构造
        Constructor userConstructor = userClass.getConstructor(String.class);
        userConstructor.newInstance("吴彦祖");
        //3.private有参构造
        Constructor userConstructor1 = userClass.getDeclaredConstructor(String.class, int.class);
        userConstructor1.setAccessible(true); //暴破（暴力破解），取消安全检查，使得可以访问private构造器，破环了封装性
        Object user2 = userConstructor1.newInstance("吴彦祖" , 114514);
        System.out.println(user2);
    }

    public static void testField() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class userClass = Class.forName("Text_Reflection.User");
        Object user1 = userClass.newInstance();

        Field num = userClass.getDeclaredField("num");
        num.setAccessible(true);
        num.set(user1, 114514); //更改num的值
        System.out.println(num.get(user1)); //返回num的值

        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null, "jjb"); //静态属性与对象无关，任何对象都可访问
        System.out.println(name.get(null));
    }

    public static void textMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class userClass = Class.forName("Text_Reflection.User");
        Object user = userClass.newInstance();

        Method fun = userClass.getDeclaredMethod("fun", int.class);
        fun.setAccessible(true);
        Object returnValue = fun.invoke(user, 1000);
        System.out.println(returnValue);
    }
}

class User{
    public User(){

    }
    public User(String name){

    }
    private User(String name, int num){

    }
    private int num;
    private static String name;
    private int fun(int num){
        return 2333;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}