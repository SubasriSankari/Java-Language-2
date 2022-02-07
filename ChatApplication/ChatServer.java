import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    static int port;
    static ServerSocket serverSocket;
    static Socket socket;

    public static void main(String[] args) {

        Receivemsg receive = new Receivemsg();
        Sendmsg send = new Sendmsg();

        Thread receiver = new Thread(receive);
        Thread sender = new Thread(send);

        try{
            port = Integer.parseInt(args[0]);
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started with port: " + serverSocket.getLocalPort());

            socket = serverSocket.accept();
            System.out.println("Connection Established with client: " + socket.getRemoteSocketAddress());
            System.out.println("** Note: Type 'bye' and press Enter to disconnect **");

            receiver.start();
            sender.start();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


class Sendmsg implements Runnable {
    @Override
    public void run() {
        String input;
        PrintWriter out = null;
        try {
            out = new PrintWriter(ChatServer.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!(input = br.readLine()).equals("bye")){
                out.println(input);
            }
            out.println("Server disconnected");
            ChatServer.socket.close();
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}

class Receivemsg implements Runnable {
    @Override
    public void run() {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(ChatServer.socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while((line = in.readLine()) != null) {
                if(line.equals("Client disconnected")){
                    System.out.println("> Client: bye");
                    System.out.println(line);
                    break;
                }
                System.out.println("> Client: " + line);
            }
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}