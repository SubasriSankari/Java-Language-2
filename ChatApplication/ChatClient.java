import java.io.*;
import java.net.Socket;

public class ChatClient {

    static Socket socket;
    static int port;
    static String name;

    public static void main(String[] args){

        Receivemsg1 receive = new Receivemsg1();
        Sendmsg1 send = new Sendmsg1();

        Thread receiver = new Thread(receive);
        Thread sender = new Thread(send);

        try{
            port = Integer.parseInt(args[2]);
            socket = new Socket(args[1], port);
            name = args[0];
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());
            System.out.println("Welcome " + name + "!");
            System.out.println("** Note: Type 'bye' and press Enter to disconnect **");

            receiver.start();
            sender.start();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class Sendmsg1 implements Runnable {
    @Override
    public void run() {
        String input;
        PrintWriter out = null;
        try {
            out = new PrintWriter(ChatClient.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!(input = br.readLine()).equals("bye")){
                out.println(input);
            }
            out.println("Client disconnected");
            ChatClient.socket.close();
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}

class Receivemsg1 implements Runnable {
    @Override
    public void run() {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(ChatClient.socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while((line = in.readLine()) != null) {
                if(line.equals("Server disconnected")){
                    System.out.println("> Server: bye");
                    System.out.println(line);
                    break;
                }
                System.out.println("> Server: " + line);
            }
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}
