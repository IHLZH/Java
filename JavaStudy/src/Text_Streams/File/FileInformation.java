package Text_Streams.File;

import java.io.File;
import java.io.IOException;

public class FileInformation {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\FileTest\\news4.txt");
        file.createNewFile();
        System.out.println(file.getParent());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}

//2.获取文件相关信息
//getName getAbsolutePath getparent length(文件大小，按字节算) exists(文件是否存在，是否被创建) isFile(是不是一个文件) isDirectory(是不是一个目录)

