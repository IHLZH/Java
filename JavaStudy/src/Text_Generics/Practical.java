package Text_Generics;

import java.util.ArrayList;

public class Practical<T extends Father> {
    ArrayList<Practical<? extends Father>> list;

    public Practical() {
        list = new ArrayList<>();
    }

    public void add(Practical<? extends Father> t) {
        list.add(t);
    }



//    public T getFirst() {
//        // return the top ranked;
//       // return list.get();
//    }

}
