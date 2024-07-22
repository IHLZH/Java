package Text_Streams;

public class Simulation {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.fileReaders(10);
    }
}

abstract class Reader_{
    public void Read(){};
}

class FileReader_ extends Reader_{
    public void Read(){
        System.out.println("文件读取！");
    }
}

class BufferedReader_ extends Reader_{  //节点流是低级流，直接与数据源接触
                                        //处理流包装了节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输
                                        // 使用了修饰器设计模式，不会直接与数据源相连
    Reader_ reader_;
    public BufferedReader_(Reader_ reader_){
        this.reader_ = reader_;
    }


    public void fileReaders(int num){
        for(int i = 1; i <= num; i++){
            reader_.Read();
        }
    }
}


