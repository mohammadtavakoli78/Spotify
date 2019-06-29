package Gui;

import Files.Albums;
import Files.AllSongsAdresses;
import Files.FavoritPlaylist;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is for showing centerPanel
 * This class shows all songs,albums,playlists,favorite playlist and ...
 * This class uses mp3agic library.
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class CenterPanel extends JPanel {
    private int temp;
    private int choose;
    private String str;
    private ArrayList<String> song;
    private ArrayList<String> favourite;
    static ArrayList<String> playLists;
    private ArrayList<Mp3File> mp3Files;
    private HashMap<String,ArrayList<String>> albums;
    static Player player;
    static Thread t1;
    static JPanel panel;

    /**
     *
     * constructor for CenterPanel class
     */
    public CenterPanel(int choose) throws IOException, ClassNotFoundException {
        this.choose=choose;
        /**
         *
         * shows all songs
         */
        if(choose==1){
            File file=new File("allSongs");
            setBackground(Color.DARK_GRAY);
            if(file.exists()){
                AllSongsAdresses allSongsAdresses=new AllSongsAdresses("allSongs");
                song=allSongsAdresses.getAllSongs();
                int size=song.size();
                panel=new JPanel();
                panel.setBackground(Color.DARK_GRAY);
                panel.setLayout(new GridLayout(size/4+1,4));
                for(int i=0; i<=size-1; ++i){
                    int counter=i;
                    JPanel panel1=new JPanel();
                    panel1.setPreferredSize(new Dimension(300,300));
                    panel1.setBackground(Color.DARK_GRAY);
                    panel1.setLayout(new BorderLayout());
                    JButton button=new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setLayout(new BorderLayout());
                    button.setBackground(Color.darkGray);
                    JLabel label=new JLabel();
                    try {
                        Mp3File mp3File=new Mp3File(song.get(i));
                        ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                        byte[] songImage=id3v2Tag.getAlbumImage();

                        ImageIcon imageIcon = new ImageIcon(songImage);
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(280, 280,  java.awt.Image.SCALE_SMOOTH);
                        button.setIcon(new ImageIcon(newimg));
                        label.setText("            "+id3v2Tag.getTitle());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (UnsupportedTagException e) {
                        e.printStackTrace();
                    } catch (InvalidDataException e) {
                        e.printStackTrace();
                    }
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if(t1==null){
                                    Image img = null;
                                    try {
                                        img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    if(Player.t!=null){
                                        Player.t.stop();
                                    }
                                    SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                    Gui.frame.setVisible(true);
                                    player=new Player(song,counter);
                                    t1=new Thread(player);
                                    t1.start();
                                }
                                else{
                                    Image img = null;
                                    try {
                                        img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    Player.t.stop();
                                    SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                    Gui.frame.setVisible(true);
                                    t1.stop();
                                    player=new Player(song,counter);
                                    t1=new Thread(player);
                                    t1.start();
                                }
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    panel1.add(button,BorderLayout.NORTH);
                    panel1.add(label,BorderLayout.CENTER);
                    this.panel.add(panel1);
                }
                add(panel);
                Gui.frame.setVisible(true);
            }
        }

        /**
         *
         * shows all albums
         */
        if(choose==2){
            File file=new File("allSongs");
            setBackground(Color.DARK_GRAY);
            if(file.exists()){
                AllSongsAdresses allSongsAdresses=new AllSongsAdresses("allSongs");
                song=allSongsAdresses.getAllSongs();
                Albums allAlbums=new Albums(song);
                albums=allAlbums.getAllAlbums();
                int size=albums.size();
                panel=new JPanel();
                panel.setBackground(Color.DARK_GRAY);
                panel.setLayout(new GridLayout(size/4+1,4));
                for(int i=0; i<=size-1; ++i){
                    int counterString=0;
                    String albumString="";
                    for(String string : albums.keySet()){
                        if(counterString==i){
                            albumString=string;
                            break;
                        }
                        else{
                            ++counterString;
                        }
                    }
                    str=albumString;
                    temp=i;
                    JPanel panel1=new JPanel();
                    panel1.setBackground(Color.DARK_GRAY);
                    panel1.setLayout(new BorderLayout());
                    panel1.setPreferredSize(new Dimension(300,300));
                    JLabel label=new JLabel();
                    JButton button=new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setBackground(Color.darkGray);
                    try {
                        Mp3File mp3File=new Mp3File(albums.get(albumString).get(0));
                        ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                        byte[] songImage=id3v2Tag.getAlbumImage();
                        ImageIcon imageIcon = new ImageIcon(songImage);
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(260, 260,  java.awt.Image.SCALE_SMOOTH);
                        button.setIcon(new ImageIcon(newimg));
                        label.setText("            "+id3v2Tag.getAlbum());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (UnsupportedTagException e) {
                        e.printStackTrace();
                    } catch (InvalidDataException e) {
                        e.printStackTrace();
                    }
                    int finalI = i;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                try {
                                    int counter=0;
                                    String str1="";
                                    for(String string : albums.keySet()){
                                        if(counter== finalI){
                                            str1=string;
                                            break;
                                        }
                                        else{
                                            ++counter;
                                        }
                                    }
                                    if(t1==null){
                                        Image img = null;
                                        try {
                                            img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                        } catch (IOException ex) {
                                            ex.printStackTrace();
                                        }
                                        if(Player.t!=null){
                                            Player.t.stop();
                                        }
                                        SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                        Gui.frame.setVisible(true);
                                        player=new Player(albums.get(str1));
                                        t1=new Thread(player);
                                        t1.start();
                                    }
                                    else{
                                        Image img = null;
                                        try {
                                            img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                        } catch (IOException ex) {
                                            ex.printStackTrace();
                                        }
                                        Player.t.stop();
                                        SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                        Gui.frame.setVisible(true);
                                        t1.stop();
                                        player=new Player(albums.get(str1));
                                        t1=new Thread(player);
                                        t1.start();
                                    }
                                } catch (JavaLayerException e1) {
                                    e1.printStackTrace();
                                } catch (FileNotFoundException e1) {
                                    e1.printStackTrace();
                                }
                        }
                    });
                    panel1.add(button,BorderLayout.NORTH);
                    panel1.add(label,BorderLayout.CENTER);
                    panel.add(panel1);
                }
               add(panel);
                Gui.frame.setVisible(true);
            }
        }

        /**
         *
         * shows all favorite playlist
         */
        if(choose==3){
            File file=new File("FavoritePlaylist");
            setBackground(Color.DARK_GRAY);
            if(file.exists()){
                FavoritPlaylist favoritPlaylist=new FavoritPlaylist();
                favourite=favoritPlaylist.getFavoritePlaylist();
                int size=favourite.size();
                panel=new JPanel();
                panel.setBackground(Color.DARK_GRAY);
                panel.setLayout(new GridLayout(size/4+1,4));
                for(int i=0; i<=size-1; ++i){
                    int counter=i;
                    JPanel panel1=new JPanel();
                    panel1.setPreferredSize(new Dimension(300,300));
                    panel1.setBackground(Color.DARK_GRAY);
                    JButton button=new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setBackground(Color.darkGray);
                    JLabel label=new JLabel();
                    try {
                        Mp3File mp3File=new Mp3File(favourite.get(i));
                        ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                        byte[] songImage=id3v2Tag.getAlbumImage();
                        ImageIcon imageIcon = new ImageIcon(songImage);
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(260, 260,  java.awt.Image.SCALE_SMOOTH);
                        button.setIcon(new ImageIcon(newimg));
                        label.setText("            "+id3v2Tag.getTitle());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (UnsupportedTagException e) {
                        e.printStackTrace();
                    } catch (InvalidDataException e) {
                        e.printStackTrace();
                    }
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if(t1==null){
                                    Image img = null;
                                    try {
                                        img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    if(Player.t!=null){
                                        Player.t.stop();
                                    }
                                    SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                    Gui.frame.setVisible(true);
                                    player=new Player(favourite,counter);
                                    t1=new Thread(player);
                                    t1.start();
                                }
                                else{
                                    Image img = null;
                                    try {
                                        img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    Player.t.stop();
                                    SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                    Gui.frame.setVisible(true);
                                    t1.stop();
                                    player=new Player(favourite,counter);
                                    t1=new Thread(player);
                                    t1.start();
                                }
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    panel1.add(button,BorderLayout.NORTH);
                    panel1.add(label,BorderLayout.SOUTH);
                    panel.add(panel1);
                }
                add(panel);
                Gui.frame.setVisible(true);
            }
        }

        /**
         *
         * shows all playlists
         */
        if(choose==4){
            File file=new File("PlayLists");
            setBackground(Color.DARK_GRAY);
            if(file.exists() && playLists!=null){
                int size=playLists.size();
                panel=new JPanel();
                panel.setBackground(Color.DARK_GRAY);
                panel.setLayout(new GridLayout(size/4+1,4));
                for(int i=0; i<=size-1; ++i){
                    int counter=i;
                    JPanel panel1=new JPanel();
                    panel1.setPreferredSize(new Dimension(300,300));
                    panel1.setBackground(Color.DARK_GRAY);
                    JButton button=new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setBackground(Color.darkGray);
                    JLabel label=new JLabel();
                    try {
                        Mp3File mp3File=new Mp3File(playLists.get(i));
                        ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                        byte[] songImage=id3v2Tag.getAlbumImage();
                        ImageIcon imageIcon = new ImageIcon(songImage);
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(260, 260,  java.awt.Image.SCALE_SMOOTH);
                        button.setIcon(new ImageIcon(newimg));
                        label.setText("            "+id3v2Tag.getTitle());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (UnsupportedTagException e) {
                        e.printStackTrace();
                    } catch (InvalidDataException e) {
                        e.printStackTrace();
                    }
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if(t1==null){
                                    Image img = null;
                                    try {
                                        img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    if(Player.t!=null){
                                        Player.t.stop();
                                    }
                                    SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                    Gui.frame.setVisible(true);
                                    player=new Player(playLists,counter);
                                    t1=new Thread(player);
                                    t1.start();
                                }
                                else{
                                    Image img = null;
                                    try {
                                        img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    Player.t.stop();
                                    SouthPanel.playMusic.setIcon(new ImageIcon(img));
                                    Gui.frame.setVisible(true);
                                    t1.stop();
                                    player=new Player(playLists,counter);
                                    t1=new Thread(player);
                                    t1.start();
                                }
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    panel1.add(button,BorderLayout.NORTH);
                    panel1.add(label,BorderLayout.SOUTH);
                    panel.add(panel1);
                }
                add(panel);
                Gui.frame.setVisible(true);
            }
        }
        if(choose==5){
            File file=new File("download");
            setBackground(Color.DARK_GRAY);
            if(file.exists()){
                FileInputStream fileInputStream=new FileInputStream(file);
                try {
                    ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
                    try {
                        mp3Files =(ArrayList<Mp3File>) objectInputStream.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int size=mp3Files.size();
                panel=new JPanel();
                panel.setBackground(Color.DARK_GRAY);
                panel.setLayout(new GridLayout(size/4+1,4));
                for(int i=0; i<=size-1; ++i){
                    int counter=i;
                    JPanel panel1=new JPanel();
                    panel1.setPreferredSize(new Dimension(300,300));
                    panel1.setBackground(Color.DARK_GRAY);
                    panel1.setLayout(new BorderLayout());
                    JButton button=new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setLayout(new BorderLayout());
                    button.setBackground(Color.darkGray);
                    JLabel label=new JLabel();
                    ID3v2 id3v2Tag = mp3Files.get(i).getId3v2Tag();
                    byte[] songImage=id3v2Tag.getAlbumImage();
                    ImageIcon imageIcon = new ImageIcon(songImage);
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(280, 280,  java.awt.Image.SCALE_SMOOTH);
                    button.setIcon(new ImageIcon(newimg));
                    label.setText("            "+id3v2Tag.getTitle());
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                    panel1.add(button,BorderLayout.NORTH);
                    panel1.add(label,BorderLayout.CENTER);
                    this.panel.add(panel1);
                }
                add(panel);
                Gui.frame.setVisible(true);
            }
        }
    }
}