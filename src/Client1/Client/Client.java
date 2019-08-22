package Client1.Client;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.net.Socket;

/**
 *  client class is here
 * @author  mohammad and amir
 *
 *
 */

public class Client implements Runnable{

   private Socket socket;

   private int port;

   private String ip;

   static ClientSender clientSender;
   private ClientReceiver clientReceiver;

   /**
    *
    * constructor of Client
    *
    */

    public Client()
    {
        ip = "127.0.0.1";
        port = 1337;
        try {

            socket = new Socket(ip, port);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * implementing the methods of thread
     *
     * @auther mohammad &amir
     *
     */

    @Override
    public void run() {


        clientReceiver = new ClientReceiver(socket);

        clientSender = new ClientSender(socket);


        new Thread(clientSender).start();

        new Thread(clientReceiver).start();

    }

    public ClientSender getClientSender(){
        return clientSender;
    }

    public static void main(String[] args) {
        Client c = new Client();
        Thread t = new Thread(c);
        t.start();
        try {
            Mp3File mp3File = new Mp3File("C:\\Users\\Win 1809 UEFI\\Downloads\\Music\\b.mp3");
            c.clientSender.setMp3Files(mp3File);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }
}
