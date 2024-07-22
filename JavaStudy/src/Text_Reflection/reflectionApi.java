package Text_Reflection;

import Text_Annotation.testAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class reflectionApi {
    public static void main(String[] args) throws ClassNotFoundException {
        //api1();
        api2();
    }
    public static void api2() throws ClassNotFoundException{
        Class cls = Class.forName("Text_Reflection.Son");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("属性:" + field.getName() + "的修饰符类型为" + field.getModifiers() + " 该属性的数据类型为" + field.getType());
        }

        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("方法" + method.getName() +"的返回类型为" + method.getReturnType());
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameter : parameterTypes) {
                System.out.println("方法" + method.getName() + "参数类型为" + parameter + " " + parameter.hashCode());
            }
        }

        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            Class[] constructorType = constructor.getParameterTypes();
            for (Class aClass : constructorType) {
                System.out.println("构造器" + constructor.getName() + "参数类型为" + aClass);
            }
        }
    }


    public static void api1() throws ClassNotFoundException {
        Class cls = Class.forName("Text_Reflection.Son");
        //getName 获取全类名
        System.out.println(cls.getName());
        //getsimpleName 获取简单类名 即Son
        System.out.println(cls.getSimpleName());
        //getFields 获取所有public属性，包括父类的
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类属性：" + field.getName());
        }
        //getDeclaredFields:获取本类所有属性 没有父类的
        Field[] fields1 = cls.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println("所有属性：" + field.getName());
        }
        //getMethods 获取所有public方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println("public方法：" + method.getName());
        }
        //getDeclaredMethods 获取所有方法 自己的，不包括父类和超类
        Method[] methods1 = cls.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println("all方法" + method.getName());
        }
        //getConstructors 获取所有public的构造器 不能拿到父类的，因为子类不会继承父类的构造器
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("public构造器:" + constructor.getName());
        }
        //getDeclaredConstructor 获取所有构造器
        Constructor[] constructors1 = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println("所有构造器" + constructor.getName());
        }
        //getPackage 获取包名
        System.out.println(cls.getPackage().getName());
        //getSuperClass 获取父类的Class对象
        System.out.println(cls.getSuperclass().getName());
        //getInterfaces 以Class[]形式返回接口信息
        Class[] classInterfaces = cls.getInterfaces();
        for (Class classInterface : classInterfaces) {
            System.out.println(classInterface);
        }
        //getAnnotations 以Annotation[]形式返回注解信息
        Annotation[] Annotations =  cls.getAnnotations();
    }
}



class Person{
    public int hubby;
    public Person(){

    }
    private Person(int num){

    }
}

class Son extends Person{
    public String name;
    private int age;
    protected int size;
    String job;

    public void fun1(String str){

    }
    protected void fun2(int num){

    }
    private void fun3(int num){

    }
    void fun4(long num){

    }
    public Son(){

    }
    protected Son(int num){

    }

}