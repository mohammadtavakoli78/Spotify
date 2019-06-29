package Client;

import com.mpatric.mp3agic.Mp3File;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientSender implements Runnable {


private boolean flag = false;

 private DataOutputStream dataOutputStream;

 private  OutputStream outputStream;

 private ObjectOutputStream  objectOutputStream;

 private Mp3File mp3File;

 private Socket socket;


    public ClientSender(Socket socket)
 {
        this.socket = socket;

     try {
         objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
     } catch (IOException e) {
         e.printStackTrace();
     }


 }

    public void setMp3Files(Mp3File mp3Files)
    {

        this.mp3File = mp3Files;

        setFlag();

    }
    public void setFlag()
    {
        flag  = !flag;
    }


    @Override
    public  void run()

  {

      while (true)
      {



          if(flag)
          {



              try {


                  MyMp3Files myMp3Files =new MyMp3Files(mp3File);

                  objectOutputStream.writeObject(myMp3Files);

                  objectOutputStream.flush();

                  System.out.println("the file is sent");
              } catch (IOException e) {
                  e.printStackTrace();
              }

              setFlag();
          }




      }


   }





}


