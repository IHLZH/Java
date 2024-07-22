package Text_Generics;

public class Generics3 <T>{

    private T generics3;
    public static <T> void print(Generics3<? super Son> generics){  //规定了Generics3的下界为Son
        System.out.println(generics.getClass());
    }

    public void print1(T generics){
        System.out.println(generics.getClass());
    }

    public T getData(){
        return generics3;
    }
}