import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try{
            socket = new Socket("192.168.0.7", 8080);
            System.out.println("연결 성공");

            String msg = "안녕하세요!";
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            pw.println(msg);
            pw.flush();
            System.out.println("데이터 전송 완료!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println("데이터 받기 성공!: " + line);

            pw.close();
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
