package Text_Generics;

public class Generics2 <T>{

    public static <T> void print(Generics2<? extends Father> generics2){  //通配符 往往用在方法的参数上
                                                                          //规定了Generics2的上界为Father
        System.out.println(generics2.getClass());
    }

    public void print1(T generics){
        System.out.println(generics.getClass());
    }
}


