package Text_NetWork.Tcp.Tcp2;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Read implements Runnable{
    Socket socket;
    public Read(Socket socket) throws IOException {
        this.socket = socket;
    }
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        InputStream inputStream  = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while(true){
            String strClient = null;
            try {
                strClient = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(strClient);
        }
    }
}
