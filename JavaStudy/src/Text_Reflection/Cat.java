package Text_Reflection;

public class Cat {
    public String name = "bydCat";
    public int age = 10;
    public int horseNumber = 1000000;
    public String idCard = "磁场颠猫";

    public Cat(){

    }
    public Cat(String name){

    }
    public void cry(){
        //System.out.println(this.name + "：呱！");
    }
    public void call(){
        //System.out.println(this.name + "：战！");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
