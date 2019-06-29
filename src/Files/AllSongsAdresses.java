package Files;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;

/**
 * This class is for conserving all songs
 * This class manage all songs.
 * This class arranges all songs according to last access.
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class AllSongsAdresses implements Serializable {

    static ArrayList< String > songsAdress ;
    private String filename;
    File file;
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream objectInputStream = null;

    /**
     * Constructor for AllSongsAdresses
     */
    public AllSongsAdresses (String filename)
    {
        this.filename = filename;
        file = new File(filename);
        if(!file.exists())
        {
            //  creating new file if doesnot exist;
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            songsAdress = new ArrayList<String>();
        }
        else if( file.exists() )
        {
            // if file exists we must read the previous songs's address;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                } catch (IOException e ) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                songsAdress =(ArrayList<String>) objectInputStream.readObject();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * get name of file
     *
     * @return String
     */
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setSongsAdress(ArrayList<String> songsAdress) {
        this.songsAdress = songsAdress;
    }

    /**
     * get all songs
     *
     * @return Arraylist of String
     */
    public ArrayList<String> getSongsAdress()
    {
        try {
            FileInputStream fileInputStream=new FileInputStream("allSongs");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lastAccessSorting();
        return songsAdress;
    }

    /**
     * get all songs
     *
     * @return Arraylist of String
     */
    public ArrayList<String> getAllSongs(){
        try {
            File file=new File("allSongs");
            if(file.exists()){
                FileInputStream fileInputStream=new FileInputStream(file);
                try {
                    ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
                    try {
                        songsAdress =(ArrayList<String>) objectInputStream.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lastAccessSorting();
        return songsAdress;
    }

    /**
     * add a new song
     *
     * @Param filePath
     * @return void
     */
    public void addSong(String filePath)
    {
        songsAdress.add(filePath);
        if(songsAdress.size() >= 2)
        {
            lastAccessSorting();
        }

        file.delete();
        file  = new File(filename);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            lastAccessSorting();
            objectOutputStream.writeObject(songsAdress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sort all songs according to last access to the file
     *
     * @return void
     */
    public void lastAccessSorting() {
        Collections.sort(songsAdress, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                File file1 = new File(s1);
                String path1 = file1.getAbsolutePath();
                File file2 = new File(s2);
                String path2 = file2.getAbsolutePath();

                if (file1.exists() && file2.exists()) {

                    BasicFileAttributes basicFileAttributes1 = null;
                    try {
                        basicFileAttributes1 = Files.readAttributes(Paths.get(path1), BasicFileAttributes.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BasicFileAttributes basicFileAttributes2 = null;
                    try {
                        basicFileAttributes2 = Files.readAttributes(Paths.get(path2), BasicFileAttributes.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    FileTime fileTime1 = basicFileAttributes1.lastAccessTime();
                    FileTime fileTime2 = basicFileAttributes2.lastAccessTime();

                    int res1 = fileTime1.compareTo(fileTime2);
                    if (res1 < 0) return 1;
                    else return -1;
                }
                return 0;
            }
        });
    }
}