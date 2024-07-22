package Text_Reflection;

import java.lang.reflect.Field;

public class textClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String className = "Text_Reflection.Cat";
        Class cls = Class.forName(className);

        System.out.println(cls); //输出这是哪一个类的class对象
        System.out.println(cls.getClass()); //输出cls的运行类型，即java.lang.Class

        System.out.println(cls.getPackage().getName());//获取包名
        System.out.println(cls.getName());//获取全类名

        Object object  = cls.newInstance();//创建Cat对象实例
        System.out.println(object.getClass());
        System.out.println(object);
        //获取成员属性
        Field age = cls.getField("age");
        System.out.println(age.get(object));
        //通过反射更改属性的值
        age.set(object, 80);
        System.out.println(age.get(object));
        //获取全部属性
        Field[] fields = cls.getFields();
        for(Field field: fields){
            System.out.println(field.getName() + " : " +field.get(object));
        }

        //获取Class对象的方式
        String classPath = "Text_Reflection.Cat";
        Class cls1 = Class.forName(classPath);
        System.out.println(cls1);

        //类名.class 多用于参数传递
        Class cls2 = Cat.class;
        System.out.println(cls2);

        //通过getClass，有对象实例时
        Cat cat = new Cat();
        Class cls3 = cat.getClass();
        System.out.println(cls3);

        //类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class cls4 = classLoader.loadClass(className);
        System.out.println(cls4);
        //通过基本数据类型来获取class对象
        Class intClass = int.class;
        System.out.println(intClass);
        //通过.TYPE来得到对象
        Class intclass1 = Integer.TYPE;
        System.out.println(intclass1);
        //int和Integer的class对象是同一个
        System.out.println(intClass.hashCode());
        System.out.println(intclass1.hashCode());
    }
}
