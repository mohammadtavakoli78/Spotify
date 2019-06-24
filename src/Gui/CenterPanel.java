package Gui;

import Files.Albums;
import Files.AllSongsAdresses;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import Files.AllSongsAdresses;

public class CenterPanel extends JPanel {
    private int choose;
    // object of files class
    private ArrayList<String> song;
    private HashMap<String,ArrayList<String>> albums;
    private HashMap<String,ArrayList<String>> playLists;
    // object of player class
    public CenterPanel(int choose){
        this.choose=choose;
        if(choose==1){

            File file=new File("allSongs");
//            setOpaque(true);
            setBackground(Color.DARK_GRAY);
            if(file.exists()){
                AllSongsAdresses allSongsAdresses=new AllSongsAdresses("allSongs");
                song=allSongsAdresses.getAllSongs();
                int size=song.size();
                ArrayList<JButton> buttons=new ArrayList<JButton>();
                JPanel panel=new JPanel();
//                panel.setOpaque(true);
                panel.setBackground(Color.DARK_GRAY);
                panel.setLayout(new GridLayout((size/4)+1,4));
                for(int i=0; i<=size-1; ++i){

                    JPanel panel1=new JPanel();
                    panel1.setPreferredSize(new Dimension(400,400));
//                    panel1.setOpaque(true);
                    panel1.setBackground(Color.DARK_GRAY);
                    panel1.setLayout(new GridLayout(2,1));
                    JButton button=new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setLayout(new BorderLayout());
//                    button.setOpaque(true);
                    button.setBackground(Color.darkGray);
                    JLabel label=new JLabel();
                    try {
                        Mp3File mp3File=new Mp3File(song.get(i));
                        ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                        byte[] songImage=id3v2Tag.getAlbumImage();

                        ImageIcon imageIcon = new ImageIcon(songImage);
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
                        button.setIcon(new ImageIcon(newimg));
                        label.setText(id3v2Tag.getTitle());
//                        button.setText(id3v2Tag.getTitle());
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
                            int counter=0;
                            for(String i : song){
                                if(i.equals(button.getText())){
                                    // pass array of song to th player class
                                    //pass the start int to the player class
                                }
                                ++counter;
                            }
                        }
                    });

                    buttons.add(button);
                    panel1.add(button);
                    panel1.add(label);
                    panel.add(panel1);
//                    panel.add(button);
//                GuiController.gui.setVisible(true);
                }
                add(panel);
            }
        }
        if(choose==2){

            File file=new File("allSongs");
            setBackground(Color.DARK_GRAY);
            if(file.exists()){
                AllSongsAdresses allSongsAdresses=new AllSongsAdresses("allSongs");
                song=allSongsAdresses.getAllSongs();
                Albums allAlbums=new Albums(song);
                albums=allAlbums.getAllAlbums();
                int size=albums.size();
                ArrayList<JButton> buttons=new ArrayList<JButton>();
//                setOpaque(true);
                setBackground(Color.DARK_GRAY);
                setLayout(new GridLayout(size/4+1,4));

                for(String i : albums.keySet()){

                    JButton button=new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setLayout(new GridLayout(2,1));
//                    button.setOpaque(true);
                    button.setBackground(Color.darkGray);
                    try {
                        Mp3File mp3File=new Mp3File(albums.get(i).get(0));
                        ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                        button.setText(i);
                        byte[] songImage=id3v2Tag.getAlbumImage();
                        button.setIcon(new ImageIcon(songImage));
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
                            int counter=0;
                            for(String i : albums.keySet()){
                                if(i.equals(button.getText())){
                                    //pass array of selected album to the player class
                                }
                                ++counter;
                            }
                        }
                    });

                    buttons.add(button);
                    add(button);
                }
            }
        }
        if(choose==3){

        }
    }
}