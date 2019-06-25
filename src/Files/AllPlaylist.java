package Files;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AllPlaylist implements Serializable
{


    private HashMap <String , ArrayList<String> >  playlists =  null;




    File file;

    FileInputStream fileInputStream = null;

    FileOutputStream fileOutputStream = null;

    ObjectOutputStream objectOutputStream = null;

    ObjectInputStream objectInputStream = null;

    public AllPlaylist()

    {

      file = new File("PlayLists");

      if ( !file.exists() )
      {


          try {
              file.createNewFile();
          } catch (IOException e) {
              e.printStackTrace();
          }


          playlists = new HashMap<>();


          try {
              fileOutputStream = new FileOutputStream(file);
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          try {
              objectOutputStream = new ObjectOutputStream(fileOutputStream);
          } catch (IOException e) {
              e.printStackTrace();
          }

          try {
              objectOutputStream.writeObject(playlists);
          } catch (IOException e) {
              e.printStackTrace();
          }


      }

      else
      {

          try {
              fileInputStream = new FileInputStream(file);
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          try {
              objectInputStream = new ObjectInputStream(fileInputStream);
          } catch (IOException e) {
              e.printStackTrace();
          }

          try {
              playlists = (HashMap<String,ArrayList<String>>) objectInputStream.readObject();
          } catch (IOException e) {
              e.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }


      }


    }

  public  ArrayList<String> playlistName ()
  {

      ArrayList<String> arrayList = new ArrayList<>();

      for (String s: playlists.keySet()
           ) {
          arrayList.add(s);
      }
      return arrayList;
  }
  
  public void addPlayList(String playlistName , ArrayList<String>songs)
  {
      
      playlists.put(playlistName,songs);
      
      
      file.delete();
      
      file = new File("PlayLists");

      try {
          fileOutputStream = new FileOutputStream(file);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      try {
          objectOutputStream = new ObjectOutputStream(fileOutputStream);
      } catch (IOException e) {
          e.printStackTrace();
      }

      try {
          objectOutputStream.writeObject(playlists);
      } catch (IOException e) {
          e.printStackTrace();
      }


  }
  
  public String removePlaylist(String playlistname)
  {
      int res = 0;
      for (String s: playlists.keySet()
           ) {

          if (s.equals(playlistname))
          {
              playlists.remove(playlistname);
              res ++;
          }
      }

      if(res == 0 ) return "no such playlist";

      else return "the selected playlist is removed successfully";
      
  }
  public void changePlaylist(String playListname,ArrayList<String > newsongs)
  {
      for (String s: playlists.keySet()
           ) {
          if( s.equals(playListname))
          {

              playlists.replace(playListname,newsongs);


          }

      }







  }


}