package Client1.Client;

import com.mpatric.mp3agic.Mp3File;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientReceiver extends Thread{

 private  Socket socket;

    private Mp3File mp3File;

    private ArrayList <MyMp3Files> downloaded;

    private ObjectInputStream objectInputStream;

    public ClientReceiver(Socket socket)
    {

        this.socket = socket;


        downloaded = new ArrayList<>();


    }





    @Override
    public void run()
    {

        while (true)
        {

            try {
                try {

                    objectInputStream = new ObjectInputStream(socket.getInputStream());


                } catch (IOException e) {
                    e.printStackTrace();
                }

                MyMp3Files download = (MyMp3Files) objectInputStream.readObject();

                downloaded.add(download);



                changeFile();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }



        }

    }
 private void changeFile()
 {

     File file = new File("download");

     ObjectInputStream fileObjectInputStream;

     ObjectOutputStream fileObjectOutputStream = null;



     if( !file.exists() )
 {


         try { file.createNewFile();
         } catch (IOException e)
         {
             e.printStackTrace();
         }

     try {
         fileObjectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
     } catch (IOException e) {
         e.printStackTrace();
     }

     try {
         fileObjectOutputStream.writeObject(downloaded);
     } catch (IOException e) {
         e.printStackTrace();
     }


 }
     if ( file.exists() )
     {

         file.delete();

         file = new File("download");

         try {
             fileObjectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
         } catch (IOException e) {
             e.printStackTrace();
         }
         try {
             fileObjectOutputStream.writeObject(downloaded);
         } catch (IOException e) {
             e.printStackTrace();
         }


     }


 }
}
