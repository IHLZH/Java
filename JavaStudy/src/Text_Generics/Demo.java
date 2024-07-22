package Text_Generics;

public class Demo {

    public <T> T Text(T...number){
        return number[0];
    }

    public static void main(String arg[]){

        Demo demo = new Demo();
        System.out.println(demo.Text("string", 2, 3));

        Generics<String, Integer> generics = new Generics<>(); //不能传基本数据类型 如：int
        //generics.
        Generics<String, Integer>[] generics1;
       // Generics<String, Integer>[] generics1 = new Generics<String, Integer>[10]  不可初始化数组


        Generics2<Father> generics2 = new Generics2<>();
        Generics2<Son> generics21 = new Generics2<>();//无继承关系

        Generics3<Father> generics3 = new Generics3<>();
        Generics3<Son> generics31 = new Generics3<>();

        Generics2.print(generics2);
        Generics2.print(generics21);

        Generics2<? extends Father> c = generics2;  //通配符extends限定了c的类型
        Son son = new Son();                        //导致原泛型类中获取泛型参数的方法不能使用  因为传入的参数可能比需求的大
        Father father = new Father();
        //c.print1(father);                         //返回方法可以，因为可以向下转型，返回值类型一定比接收类型小

        Generics3<? super Son> d = generics3;  //通配符super限定了c的类型
        Son son1 = new Son();
        Father father1 = new Father();
        //Father father2 = d.getData();        //导致原泛型类中返回泛型参数的方法不能使用  因为用来接收的属性类型可能比返回的小
        d.print1(son1);                        //获取泛型参数的方法可以使用，因为传入的参数一定比需求的小
    }
}

class ExtendGenerics<T> extends Generics2<T>{  //可以继承泛型类

}
