package Text_NetWork.Tcp.Tcp2;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Write implements Runnable{
    Socket socket;
    public Write(Socket socket) throws IOException {
        this.socket = socket;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        while(true){
            String str = scanner.next();
            if(str.equals("退出！")){
                break;
            }
            try {
                bufferedWriter.write(str);
                bufferedWriter.newLine(); //插入一个换行符，表示写入的内容结束，注意对方必须用readline接收；
                bufferedWriter.flush();  //手动刷新
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
