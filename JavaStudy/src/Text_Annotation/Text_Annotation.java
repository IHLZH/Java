package Text_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Text_Annotation {  //注解通过 @interface 来定义
    int number();  // 注解的属性
    String name() default "MM";  //通过default来默认赋值
}
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.LOCAL_VARIABLE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) //元注解：解释注解的注解
@interface Text_Annotation1{
    //@interface
}

//Rentention注解，声明保留级别
//RetentionPolicy.SOURCE 保留到源级别，被编译器忽略
//RetentionPolicy.CLASS 由编译器保留，被JVM忽略
//RetentionPolicy.RUNTIME 由JVM保留，运行环境时可使用

//ElementType注解，限制可以应用注解的类型
//ElementType.ANNOTATION_TYPE 可以应用于注解类型。
// ElementType.CONSTRUCTOR 可以应用于构造函数。
// ElementType.FIELD 可以应用于字段或属性。
// ElementType.LOCAL_VARIABLE 可以应用于局部变量。
// ElementType.METHOD 可以应用于方法级注解。
// ElementType.PACKAGE 可以应用于包声明。
// ElementType.PARAMETER 可以应用于方法的参数。
// ElementType.以应用TYPE 可于类的任何元素。


abstract class AbstractClass{

    public final void fun(){};

    public final void fun(int a){};

}