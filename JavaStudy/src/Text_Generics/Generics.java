package Text_Generics;

import java.util.ArrayList;

public class Generics<T, E> { //泛型类，参数不确定，直到接收到参数后才确定下来

    private T data;

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data = data;
    }

    public <T> T function(T a){  //泛型方法 T与泛型类中的 T 无关，只与泛型方法中的 T 有关
        return a;
    }


    public <T extends ArrayList&Comparable> void min(T a, T b){ //限定类型变量
        if(a.compareTo(b) > 0) System.out.println(a);
        else System.out.println(b);
    }

    //public static T function1(int a){}  静态域和静态方法中不能引用类型变量
    public static <T> T function1(T a){
        return a;
    }
    // 如果本身就是泛型函数的话 是可以的
}


