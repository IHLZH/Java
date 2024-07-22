package Text_Streams;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_FileWriter {
    public static void main(String[] args) throws IOException {
        fileRead();
    }

    public static void fileRead() throws IOException {
        String filePath = "E:\\FileTest\\news1.txt";
        String filePath1 = "E:\\FileTest\\news5.txt";
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(filePath1, true);
        int reader;
        char ch[] = new char[8];
        while((reader = fileReader.read(ch)) != -1)
        {
            fileWriter.write(ch, 0, reader);
        }
        if(fileReader != null)fileReader.close();
        fileWriter.flush();
        if(fileWriter != null)fileWriter.close();
    }
}
