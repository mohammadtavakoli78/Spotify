package Gui;

import Files.FavoritPlaylist;
import javazoom.jl.decoder.JavaLayerException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is for showing southPanel and showing play music button artworks and....
 *
 *
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class SouthPanel extends JPanel {

    private int shuffleCounter=0;
    private int repeatCounter=0;
    private int heartButtonCounter=0;
    static int max;
    static int playButton=0;
    static JButton playMusic;
    static JProgressBar musicSlider;
    JButton nextMusic;
    JButton previousMusic;
    JButton shuffle;
    JButton repeatMusic;
    static String artistString=null;
    static String songNameString=null;
    static String albumNameString=null;
    static JButton musicButton=null;
    static JPanel musicImage;
    static JLabel artist;
    static JLabel songName;
    static JLabel albumName;
    static JButton heartButton;
    static JPanel p1;
    static JLabel l1;
    static JLabel l2;
    public SouthPanel(){

        super();
        setLayout(new GridLayout(0,3,10,10));

        setOpaque(true);
        setBackground(Color.gray);

        JPanel playerButtons=new JPanel();
        JPanel soundManager=new JPanel();
        JPanel buttons=new JPanel();
        musicImage=new JPanel();

        playerButtons.setLayout(new BorderLayout());
        buttons.setOpaque(true);
        buttons.setBackground(Color.gray);
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        playMusic=new JButton();
        nextMusic=new JButton();
        previousMusic=new JButton();
        shuffle=new JButton();  ///////////
        repeatMusic=new JButton(); //////////
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("Icons\\next.png")).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextMusic.setIcon(new ImageIcon(img));
        nextMusic.setRolloverIcon(new ImageIcon(img));
        try {
            img = ImageIO.read(getClass().getResource("Icons\\play.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        playMusic.setIcon(new ImageIcon(img));
        try {
            img = ImageIO.read(getClass().getResource("Icons\\previous.png")).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        previousMusic.setIcon(new ImageIcon(img));
        try {
            img = ImageIO.read(getClass().getResource("Icons\\shuffle.png")).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        shuffle.setIcon(new ImageIcon(img));
        try {
            img = ImageIO.read(getClass().getResource("Icons\\repeat.png")).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        repeatMusic.setIcon(new ImageIcon(img));

        nextMusic.setContentAreaFilled(false);
        nextMusic.setFocusPainted(false);
        nextMusic.setBorderPainted(false);
        playMusic.setBorderPainted(false);
        playMusic.setFocusPainted(false);
        playMusic.setContentAreaFilled(false);
        previousMusic.setBorderPainted(false);
        previousMusic.setFocusPainted(false);
        previousMusic.setContentAreaFilled(false);
        shuffle.setBorderPainted(false);
        shuffle.setFocusPainted(false);
        shuffle.setContentAreaFilled(false);
        repeatMusic.setBorderPainted(false);
        repeatMusic.setFocusPainted(false);
        repeatMusic.setContentAreaFilled(false);
        buttons.add(shuffle);
        buttons.add(previousMusic);
        buttons.add(playMusic);
        buttons.add(nextMusic);
        buttons.add(repeatMusic);
        musicSlider=new JProgressBar(0,0,100);
        musicSlider.setOpaque(true);
        musicSlider.setBackground(Color.gray);
        musicSlider.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CenterPanel.player.setSeek(false);
//                CenterPanel.player.seekTo(musicSlider.getValue()*1000/26);
//                System.out.println(musicSlider.getValue());
                int mouseX = e.getX();
                //Computes how far along the mouse is relative to the component width then multiply it by the progress bar's maximum value.
                int progressBarVal = (int)Math.round(((double)mouseX / (double)musicSlider.getWidth()) * musicSlider.getMaximum());
                musicSlider.setValue(progressBarVal);
//                CenterPanel.player.seekTo(musicSlider.getValue()*1000/26);
                CenterPanel.player.seekTo(musicSlider.getValue()*1000/26);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
//        musicSlider.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
////                musicSlider.setValue(musicSlider.getValue());
//            }
//        });
        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setOpaque(true);
        p1.setBackground(Color.gray);
        l1=new JLabel("");
        l2=new JLabel("");
        p1.add(l2);
        p1.add(musicSlider);
        p1.add(l1);
        playerButtons.add(buttons,BorderLayout.NORTH);
        playerButtons.add(p1,BorderLayout.SOUTH);

        soundManager.setLayout(new BorderLayout());
        JPanel sound=new JPanel();
        sound.setOpaque(true);
        sound.setBackground(Color.gray);
        soundManager.setOpaque(true);
        soundManager.setBackground(Color.gray);
        JButton music=new JButton();
        JButton devices=new JButton();
        JButton queue=new JButton();
        try {
            img = ImageIO.read(getClass().getResource("Icons\\sound.png")).getScaledInstance(20,20,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        music.setIcon(new ImageIcon(img));
        try {
            img = ImageIO.read(getClass().getResource("Icons\\devices.png")).getScaledInstance(20,20,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        devices.setIcon(new ImageIcon(img));
        try {
            img = ImageIO.read(getClass().getResource("Icons\\queue.png")).getScaledInstance(20,20,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        queue.setIcon(new ImageIcon(img));

        music.setBorderPainted(false);
        music.setFocusPainted(false);
        music.setContentAreaFilled(false);
        devices.setBorderPainted(false);
        devices.setFocusPainted(false);
        devices.setContentAreaFilled(false);
        queue.setBorderPainted(false);
        queue.setFocusPainted(false);
        queue.setContentAreaFilled(false);
        JSlider volumeSlider=new JSlider(JSlider.HORIZONTAL,0,100,0);
        volumeSlider.setOpaque(true);
        volumeSlider.setBackground(Color.gray);
        Audio.setMasterOutputMute(false);
        volumeSlider.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int jsliderBarVal = (int)Math.round(((double)mouseX / (double)volumeSlider.getWidth()) * volumeSlider.getMaximum());
                volumeSlider.setValue(jsliderBarVal);
                Audio.setMasterOutputVolume(jsliderBarVal/100f);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        sound.add(queue);
        sound.add(devices);
        sound.add(music);
        sound.add(volumeSlider);
        soundManager.add(sound,BorderLayout.SOUTH);

        musicImage.setLayout(new FlowLayout(FlowLayout.LEFT));
        musicImage.setOpaque(true);
        musicImage.setBackground(Color.gray);
        musicButton=new JButton();
        musicButton.setContentAreaFilled(false);
        musicButton.setBorderPainted(false);
        musicButton.setFocusPainted(false);
        JPanel songNamePanel=new JPanel(new BorderLayout());
        songNamePanel.setOpaque(true);
        songNamePanel.setBackground(Color.gray);
        songNamePanel.setLayout(new BorderLayout());
        artist=new JLabel();
        songName=new JLabel();
        albumName=new JLabel();
        songName.setText(songNameString);
        songName.setFont(new Font("Italic",Font.ITALIC,18));
        albumName.setText(albumNameString);
        albumName.setFont(new Font("Italic",Font.ITALIC,18));
        artist.setText(artistString);
        artist.setFont(new Font("Italic",Font.ITALIC,18));
        heartButton=new JButton();
        heartButton.setContentAreaFilled(false);
        heartButton.setBorderPainted(false);
        heartButton.setFocusPainted(false);
//        try {
//            img = ImageIO.read(getClass().getResource("Icons\\mohammad.jpg")).getScaledInstance(85,85,Image.SCALE_SMOOTH);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        musicButton.setIcon(new ImageIcon(img));
        musicImage.add(musicButton,BorderLayout.WEST);
        try {
            img = ImageIO.read(getClass().getResource("Icons\\like1.png")).getScaledInstance(30,30,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        heartButton.setIcon(new ImageIcon(img));
        heartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ++heartButtonCounter;
                    Image img = null;
                    if(heartButtonCounter%2==0){
                        img = ImageIO.read(getClass().getResource("Icons\\like1.png")).getScaledInstance(30,30,Image.SCALE_SMOOTH);
                        if(CenterPanel.t1!=null && CenterPanel.player!=null){
                            int counter=0;
                            String song="";
                            int counter1=CenterPanel.player.getCounter();
                            ArrayList<String> songs=CenterPanel.player.getSongsAdresses();
                            for(String i : songs){
                                if(counter==counter1){
                                    song=i;
                                    break;
                                }
                                else{
                                    ++counter;
                                }
                            }
                            try {
                                FavoritPlaylist favoritPlaylist=new FavoritPlaylist();
                                favoritPlaylist.removeSong(song);
                                Gui.frame.setVisible(true);
                            } catch (ClassNotFoundException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }
                    else{
                        img = ImageIO.read(getClass().getResource("Icons\\like.png")).getScaledInstance(30,30,Image.SCALE_SMOOTH);
                        if(CenterPanel.t1!=null && CenterPanel.player!=null){
                            int counter=0;
                            String song="";
                            int counter1=CenterPanel.player.getCounter();
                            ArrayList<String> songs=CenterPanel.player.getSongsAdresses();
                            for(String i : songs){
                                if(counter==counter1){
                                    song=i;
                                    break;
                                }
                                else{
                                    ++counter;
                                }
                            }
                            try {
                                FavoritPlaylist favoritPlaylist=new FavoritPlaylist();
                                favoritPlaylist.addsong(song);
                                Gui.frame.setVisible(true);
                            } catch (ClassNotFoundException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }
                    heartButton.setIcon(new ImageIcon(img));
//                    GuiController.gui.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        nextMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CenterPanel.t1!=null){
                    CenterPanel.t1.stop();
                    try {
                        if(Player.t!=null){
                            Player.t.stop();
                        }
                        CenterPanel.player=new Player(CenterPanel.player.getSongsAdresses(),CenterPanel.player.getCounter()+1);
                    } catch (JavaLayerException e1) {
                        e1.printStackTrace();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    CenterPanel.t1=new Thread(CenterPanel.player);
                    CenterPanel.t1.start();
                }
            }
        });
        previousMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CenterPanel.t1!=null){
                    CenterPanel.t1.stop();
                    try {
                        if(Player.t!=null){
                            Player.t.stop();
                        }
                        CenterPanel.player=new Player(CenterPanel.player.getSongsAdresses(),CenterPanel.player.getCounter()-1);
                    } catch (JavaLayerException e1) {
                        e1.printStackTrace();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    CenterPanel.t1=new Thread(CenterPanel.player);
                    CenterPanel.t1.start();
                }
            }
        });
        playMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++playButton;
                if(CenterPanel.t1==null){
                    if(playButton%2==0){
                        Image img = null;
                        try {
                            img = ImageIO.read(getClass().getResource("Icons\\play.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        playMusic.setIcon(new ImageIcon(img));
                    }
                    else{
                        Image img = null;
                        try {
                            img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        playMusic.setIcon(new ImageIcon(img));
                    }
                }
                else{
                    if(CenterPanel.player.isPaused()){
                        Image img = null;
                        try {
                            img = ImageIO.read(getClass().getResource("Icons\\pause.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        playMusic.setIcon(new ImageIcon(img));
                        CenterPanel.player.mp3Resume();

                    }
                    else{
                        Image img = null;
                        try {
                            img = ImageIO.read(getClass().getResource("Icons\\play.png")).getScaledInstance(75,75,Image.SCALE_SMOOTH);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        playMusic.setIcon(new ImageIcon(img));
                        CenterPanel.player.mp3Pause();
                    }
                }
            }
        });
        repeatMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++repeatCounter;
                if(repeatCounter%2==0){
                    CenterPanel.player.setRepeat(false);
                }
                else{
                    CenterPanel.player.setRepeat(true);
                }
            }
        });
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++shuffleCounter;
                if(shuffleCounter%2==0){
                    CenterPanel.player.setShuffle(false);
                }
                else{
                    CenterPanel.player.setShuffle(true);
                }
            }
        });
        songNamePanel.add(artist,BorderLayout.NORTH);
        songNamePanel.add(songName,BorderLayout.CENTER);
        songNamePanel.add(albumName,BorderLayout.SOUTH);
        musicImage.add(songNamePanel);
        if(CenterPanel.player!=null){
            musicImage.add(heartButton);
        }
        add(musicImage);
        add(playerButtons);
        add(soundManager);
    }
}
