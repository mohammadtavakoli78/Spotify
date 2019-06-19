package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SouthPanel extends JPanel {
    public SouthPanel(){

        super();
        setLayout(new FlowLayout());

        setOpaque(true);
        setBackground(Color.gray);

        JPanel playerButtons=new JPanel();
        JPanel soundManager=new JPanel();
        JPanel buttons=new JPanel();
        JPanel progressBar=new JPanel();

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
            img = ImageIO.read(getClass().getResource("Icons\\next.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextMusic.setIcon(new ImageIcon(img));
//        nextMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\next.png")));
        playMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\play.png")));
        previousMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\previous.png")));
        shuffle.setIcon(new ImageIcon(getClass().getResource("Icons\\shuffle.png")));
        repeatMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\repeat.png")));
//        nextMusic.setBorder(null);
//        nextMusic.setMargin(new Insets(0, 0, 0, 0));
        nextMusic.setBorderPainted(false);
        nextMusic.setFocusPainted(false);
        nextMusic.setContentAreaFilled(false);
//        nextMusic.setPreferredSize(new Dimension(50,50));
//        playMusic.setBorder(null);
//        playMusic.setMargin(new Insets(0, 0, 0, 0));
        playMusic.setBorderPainted(false);
        playMusic.setFocusPainted(false);
        playMusic.setContentAreaFilled(false);
//        playMusic.setPreferredSize(new Dimension(100,100));
//        previousMusic.setBorder(null);
//        previousMusic.setMargin(new Insets(0, 0, 0, 0));
        previousMusic.setContentAreaFilled(false);
        shuffle.setBorder(null);
        shuffle.setMargin(new Insets(0, 0, 0, 0));
        shuffle.setContentAreaFilled(false);
        repeatMusic.setBorder(null);
        repeatMusic.setMargin(new Insets(0, 0, 0, 0));
        repeatMusic.setContentAreaFilled(false);
        buttons.add(shuffle);
        buttons.add(previousMusic);
        buttons.add(playMusic);
        buttons.add(nextMusic);
        buttons.add(repeatMusic);
        JSlider musicSlider=new JSlider(JSlider.HORIZONTAL,0,100,0);
        playerButtons.add(buttons,BorderLayout.NORTH);
        playerButtons.add(musicSlider,BorderLayout.SOUTH);
        add(playerButtons);
    }
}
