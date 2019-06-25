package Gui;

import javazoom.jl.decoder.JavaLayerException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SouthPanel extends JPanel {
    private int heartButtonCounter=0;
    JButton playMusic;
    JButton nextMusic;
    JButton previousMusic;
    JButton shuffle;
    JButton repeatMusic;
    public SouthPanel(){

        super();
        setLayout(new GridLayout(0,3,10,10));

        setOpaque(true);
        setBackground(Color.gray);

        JPanel playerButtons=new JPanel();
        JPanel soundManager=new JPanel();
        JPanel buttons=new JPanel();
        JPanel musicImage=new JPanel();

        playerButtons.setLayout(new BorderLayout());
        buttons.setOpaque(true);
        buttons.setBackground(Color.gray);
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        playMusic=new JButton(); /////////
        nextMusic=new JButton(); ////////
        previousMusic=new JButton(); /////////
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
        JSlider musicSlider=new JSlider(JSlider.HORIZONTAL,0,100,0); /////////////
        musicSlider.setOpaque(true);
        musicSlider.setBackground(Color.gray);
        musicSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ////////
            }
        });
        playerButtons.add(buttons,BorderLayout.NORTH);
        playerButtons.add(musicSlider,BorderLayout.SOUTH);

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
        sound.add(queue);
        sound.add(devices);
        sound.add(music);
        sound.add(volumeSlider);
        soundManager.add(sound,BorderLayout.SOUTH);

        musicImage.setLayout(new FlowLayout(FlowLayout.LEFT));
        musicImage.setOpaque(true);
        musicImage.setBackground(Color.gray);
        JButton musicButton=new JButton();
        musicButton.setContentAreaFilled(false);
        musicButton.setBorderPainted(false);
        musicButton.setFocusPainted(false);
        JPanel songNamePanel=new JPanel(new BorderLayout());
        songNamePanel.setOpaque(true);
        songNamePanel.setBackground(Color.gray);
        songNamePanel.setLayout(new BorderLayout());
        JLabel artist=new JLabel();
        JLabel songName=new JLabel();
        JLabel albumName=new JLabel();
        String artistString;
        String songNameString;
        String albumNameString;
        songName.setText("darAstane piri");
        songName.setFont(new Font("Italic",Font.ITALIC,18));
        albumName.setText("abraham");
        albumName.setFont(new Font("Italic",Font.ITALIC,18));
        artist.setText("mohsen chavoshi mohsen chavoshi sgd");
        artist.setFont(new Font("Italic",Font.ITALIC,18));
        JButton heartButton=new JButton();
        heartButton.setContentAreaFilled(false);
        heartButton.setBorderPainted(false);
        heartButton.setFocusPainted(false);
        try {
            img = ImageIO.read(getClass().getResource("Icons\\mohammad.jpg")).getScaledInstance(85,85,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        musicButton.setIcon(new ImageIcon(img));
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
                    }
                    else{
                        img = ImageIO.read(getClass().getResource("Icons\\like.png")).getScaledInstance(30,30,Image.SCALE_SMOOTH);
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
                if(WestPanel.t1!=null){
                    WestPanel.t1.stop();
                    try {
                        WestPanel.player=new Player(WestPanel.player.getSongsAdresses(),WestPanel.player.getCounter()+1);
                    } catch (JavaLayerException e1) {
                        e1.printStackTrace();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    WestPanel.t1=new Thread(WestPanel.player);
                    WestPanel.t1.start();
                }
            }
        });
        previousMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(WestPanel.t1!=null){
                    WestPanel.t1.stop();
                    try {
                        WestPanel.player=new Player(WestPanel.player.getSongsAdresses(),WestPanel.player.getCounter()-1);
                    } catch (JavaLayerException e1) {
                        e1.printStackTrace();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    WestPanel.t1=new Thread(WestPanel.player);
                    WestPanel.t1.start();
                }
            }
        });
        playMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        songNamePanel.add(artist,BorderLayout.NORTH);
        songNamePanel.add(songName,BorderLayout.CENTER);
        songNamePanel.add(albumName,BorderLayout.SOUTH);
        musicImage.add(songNamePanel);
        musicImage.add(heartButton);
        add(musicImage);
        add(playerButtons);
        add(soundManager);
    }
//    public void nextMusicButtonAcitonListener(){
//        nextMusic.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//    }
}
