package Text_Annotation;

//注解可以理解为“标签”
@Text_Annotation(number = 1,name = "qqq") //注解的属性必须赋值
@Text_Annotation1 //注解没有属性时，括号可省略
//@Retention(RetentionPolicy.CLASS)
public class testAnnotation {

}
