package Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Teacher_Test {
    public static final int dm = 1;
    public static final int ww = 2;
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface Teacher{

    }
    public static void test(int teacher){
        System.out.println(teacher);
    }

    public static void main(String[] args) {
        //test(Teacher.dm);
    }
}








