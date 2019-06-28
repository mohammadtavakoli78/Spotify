package Files;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is for creating file of all playlist
 * This class manage all playlist.
 *
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class AllPlaylist implements Serializable
{

    private HashMap <String , ArrayList<String> >  playlists =  null;
    File file;
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream objectInputStream = null;

    /**
     * Constructor for AllPlaylist
     */
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

    /**
     *
     *
     * @return Arraylist of String
     */
    public  ArrayList<String> playlistNames ()
    {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s: playlists.keySet())
        {
            arrayList.add(s);
        }
        return arrayList;
    }

    /**
     * get songs of a playlist
     * @param name name of a playlist
     * @return Arraylist of String
     */
    public ArrayList<String> getSongsOfaPlaylist(String name)
    {
        ArrayList<String > out = playlists.get(name);
        return out;
    }

    /**
     * add new Playlist
     * @param playlistName add new playlist
     * @return void
     */
    public void addNewPlayList(String playlistName)
    {
        playlists.put(playlistName,new ArrayList<String>());
        changeFile();
    }
    /**
     * removes a playlist from all playlists
     * @param playlistname remove a playlist
     * @return void
     */
    public void removePlaylist(String playlistname)
    {
        for (String s: playlists.keySet())
        {
            if (s.equals(playlistname))
            {
                playlists.remove(playlistname);
                changeFile();
                break;
            }
        }
    }
    /**
     * changes songs of a playlist
     * @param playListname & newsongs
     * @return void
     */
    public void changePlaylistSongs(String playListname,ArrayList<String > newsongs)
    {
        playlists.replace(playListname,newsongs);
        changeFile();
    }

    /**
     * change a playlist name
     * @param newName & oldname
     * @return void
     */
    public void changePlaylistName(String newName,String oldName)
    {
        ArrayList<String > arr = playlists.get(oldName);
        playlists.remove(oldName);
        playlists.put(newName,arr);
        changeFile();
    }

    /**
     * arrange a file according to last access
     *
     * @return void
     */
    public void changeFile()
    {
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
}