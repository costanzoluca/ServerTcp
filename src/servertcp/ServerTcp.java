package servertcp;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
public class ServerTcp {
    public static void main(String[] args) {
        int port=2000;
        ServerSocket serversocket;
        Socket Connect;
        //OutputStream Outputsocket;
        PrintWriter streamOut;
        //InputStream Inputsocket;
        Scanner streamIn;
        String echo;
        System.out.println("Apertura porta in corso...");
        try{
            serversocket = new ServerSocket(port);
            while(true){
                System.out.println("Server in ascolto sulla porta "+port+"\n");
                Connect = serversocket.accept();
                InputStream is = Connect.getInputStream(); 
                DataInputStream netIn = new DataInputStream(is);
                echo=netIn.readUTF();
                OutputStream os = Connect.getOutputStream(); 
                DataOutputStream netOut = new DataOutputStream(os);
                netOut.writeUTF(echo);
                System.out.println("Connessione riuscita "+echo);
                System.out.println("Risposta inviata");
            }
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
