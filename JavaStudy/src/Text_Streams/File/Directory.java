package Text_Streams.File;

import java.io.File;

public class Directory {
    public static void main(String[] args) {
        String directoryPath = "E:\\FileTest\\Demo\\a";
        File file = new File(directoryPath);

        if(file.exists())
        {
            if(file.delete())
            {
                System.out.println(file.getName() + "删除成功！");
            }
            else System.out.println(file.getName() + "删除失败！");
        }
        else{
            if(file.mkdirs()){  //mkdirs创建多级目录，mkdir创建单级目录
                System.out.println(file.getName() + "创建成功！");
            }
            else System.out.println(file.getName() + "创建失败！");
        }
    }
}
