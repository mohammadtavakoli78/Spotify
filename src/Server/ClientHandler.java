package Server;



import Client.MyMp3Files;
import com.mpatric.mp3agic.Mp3File;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;



public class ClientHandler implements Runnable {

    private  Socket socket;

    private  ArrayList<ClientHandler> clientHandlers;

    private File file;

    private ObjectInputStream objectInputStream;


    private  OutputStream outputStream;

    private InputStream inputStream;

    private MyMp3Files mp3File;



    public ClientHandler(Socket socket,ArrayList<ClientHandler> clientHandlers,File file) throws IOException
 {

     this.socket = socket;

     this.clientHandlers = clientHandlers;

     this.file = file;




 }

 public void send(MyMp3Files mp3File)
 {
     ObjectOutputStream objectOutputStream = null;
     try {
         objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
     } catch (IOException e) {
         e.printStackTrace();
     }

     try {
         objectOutputStream.writeObject(mp3File);
     } catch (IOException e) {
         e.printStackTrace();
     }


 }



    public void setClientHandlers(ArrayList<ClientHandler> clientHandlers)
    {

        this.clientHandlers = clientHandlers;

    }


    @Override
    public void run()
    {

        while (true)
        {

            try {
                System.out.println("here");
                objectInputStream = new ObjectInputStream(socket.getInputStream());



//                try {
//                    mp3File = (MyMp3Files) objectInputStream.readObject();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }

//                for (ClientHandler c : clientHandlers)
//                {
//                    c.send(mp3File);
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }


}
