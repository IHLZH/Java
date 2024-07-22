package Text_Annotation;

public class Demo{

    public static void main(String[] args) throws ClassNotFoundException {
        testAnnotation testAnnotation = new testAnnotation();
        System.out.println(testAnnotation.getClass());
        System.out.println(testAnnotation.class);
        Class.forName("Text_Annotation.testAnnotation");
    }



}
