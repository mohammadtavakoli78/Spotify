package Files;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is for saving favorite playlists in a file
 * This class is for when user tap to the heart button.
 * and can remove it again with again tap to the heart button.
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class FavoritPlaylist {

    private ArrayList<String > favoritePlaylist;


    private String filename = new String("FavoritePlaylist");

    File file = null;

    FileInputStream fileInputStream = null;

    FileOutputStream fileOutputStream = null;

    ObjectOutputStream objectOutputStream = null;

    ObjectInputStream objectInputStream = null;

    /**
     * Constructor for FavoritePlaylist
     */
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

    /**
     * get favorite songs
     *
     *
     * @return Arraylist of string
     */
    public ArrayList<String> getFavoritePlaylist() {
        return favoritePlaylist;
    }

    /**
     * add a new song to favorite playlist
     *
     * @Param songPath String
     * @return void
     */
    public void addsong(String songPath) throws IOException {

        favoritePlaylist.add(songPath);

        file.delete();

        file = new File(filename);

        fileOutputStream = new FileOutputStream(file);

        objectOutputStream  = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(favoritePlaylist);


    }

    /**
     * remove a song from all playlists
     *
     * @Param songPath
     * @return void
     */
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
