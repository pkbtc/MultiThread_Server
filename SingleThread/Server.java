import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public void run() throws IOException{
        int port=8010;
        ServerSocket socket=new ServerSocket(port);
        socket.setSoTimeout(10000);
        while(true){
            System.out.println("server is listening on port "+port);
            Socket acceptedConnecion=socket.accept();
            System.out.println("server got a connection from "+acceptedConnecion.getRemoteSocketAddress());
            PrintWriter toClient=new PrintWriter(acceptedConnecion.getOutputStream(),true);
            BufferedReader fromClinet=new BufferedReader(new InputStreamReader(acceptedConnecion.getInputStream()));
            toClient.println("Hello from the server");
            toClient.close();
            fromClinet.close();
            acceptedConnecion.close();
            

        }
        
    }
    public static void main(String[] args) {
        Server server=new Server();
        try {
            server.run();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}