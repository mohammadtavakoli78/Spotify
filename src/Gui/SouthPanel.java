package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class SouthPanel extends JPanel {
    private int heartButtonCounter=0;
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
        JButton playMusic=new JButton();
        JButton nextMusic=new JButton();
        JButton previousMusic=new JButton();
        JButton shuffle=new JButton();
        JButton repeatMusic=new JButton();
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
        JSlider musicSlider=new JSlider(JSlider.HORIZONTAL,0,100,0);
        musicSlider.setOpaque(true);
        musicSlider.setBackground(Color.gray);
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
            img = ImageIO.read(getClass().getResource("Icons\\like1.png")).getScaledInstance(35,35,Image.SCALE_SMOOTH);
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
                        img = ImageIO.read(getClass().getResource("Icons\\like1.png")).getScaledInstance(35,35,Image.SCALE_SMOOTH);
                    }
                    else{
                        img = ImageIO.read(getClass().getResource("Icons\\like.png")).getScaledInstance(35,35,Image.SCALE_SMOOTH);
                    }
                    heartButton.setIcon(new ImageIcon(img));
                    GuiController.gui.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        musicImage.add(heartButton);
        add(musicImage);
        add(playerButtons);
        add(soundManager);
    }
}
