package Files;

import java.io.*;
import java.util.ArrayList;

public class FavoritPlaylist {

    private ArrayList<String > favoritePlaylist;


    private String filename = new String("FavoritePlaylist");

    File file = null;

    FileInputStream fileInputStream = null;

    FileOutputStream fileOutputStream = null;

    ObjectOutputStream objectOutputStream = null;

    ObjectInputStream objectInputStream = null;

    public FavoritPlaylist() throws IOException, ClassNotFoundException {

        file = new File("FavoritePlaylist");

        if( !file.exists())
        {

            file.createNewFile();

            favoritePlaylist = new ArrayList<>();

        }

        else
        {

            fileInputStream = new FileInputStream(file);

            objectInputStream = new ObjectInputStream(fileInputStream);

            favoritePlaylist = (ArrayList<String>)objectInputStream.readObject();

        }

    }

    public ArrayList<String> getFavoritePlaylist() {
        return favoritePlaylist;
    }

    public void addsong(String songPath) throws IOException {

        favoritePlaylist.add(songPath);

        file.delete();

        file = new File(filename);

        fileOutputStream = new FileOutputStream(file);

        objectOutputStream  = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(favoritePlaylist);


    }

    public void removeSong(String songPath) throws IOException {

        int i = 0;

        for (String s : favoritePlaylist) {
            if(s.equals(songPath)){
                break;
            }
            else{
                ++i;
            }
        }

        favoritePlaylist.remove(i);

        file.delete();

        file = new File(filename);

        fileOutputStream = new FileOutputStream(file);

        objectOutputStream  = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(favoritePlaylist);


    }
}
