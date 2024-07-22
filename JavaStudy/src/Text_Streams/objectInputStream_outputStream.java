package Text_Streams;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class objectInputStream_outputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       // write();
        read1();
    }

    public static void read1() throws IOException, ClassNotFoundException {
        String filePath = "E:\\FileTest\\news6.txt";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        //读取（反序列化）的时候要与保存数据（序列化）的顺序一样
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        Object dog = objectInputStream.readObject();
        System.out.println(dog.toString());
        System.out.println(objectInputStream.readUTF());

        objectInputStream.close();
    }

    public static void write() throws IOException {
        String filePath = "E:\\FileTest\\news6.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeInt(100);  //自动装箱 int -> Integer Integer实现了Serializable
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeChar('s');
        objectOutputStream.writeObject(new Dog("神里凌华的狗", 250));  //对象序列化
        objectOutputStream.writeUTF("原神启动！");

        objectOutputStream.close();
    }

}

class Dog implements Serializable {  //想要序列化，首先要实现Serializable接口
    String name;
    int age;

    static int num = 1000;

    int number = 10;


    //private static final long serialVersionUID = 1l;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setNum(int num) {
        Dog.num = num;
    }

    public Dog(String name, int age){
        setAge(age);
        setName(name);
        //setNum(num);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + ", num=" + num;
    }
}
