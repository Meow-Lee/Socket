import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException{
        try{
            ServerSocket serverSocket = new ServerSocket(8080);

            while(true){
                System.out.println("연결 대기 중");
                Socket socket = serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("연결 수락 됨" + isa.getHostName());

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = reader.readLine();

                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                pw.println(line);
                pw.flush();
            }
        }
        catch(IOException e){}
    }
}
