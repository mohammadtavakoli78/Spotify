package Client;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

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

   private ClientSender clientSender;
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
}
