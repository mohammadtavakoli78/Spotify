package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {
    public SouthPanel(){

        super();
        setLayout(new BorderLayout());

        JPanel playerButtons=new JPanel();
        JPanel soundManager=new JPanel();
        JPanel buttons=new JPanel();
        JPanel progressBar=new JPanel();

        playerButtons.setLayout(new BorderLayout());
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton playMusic=new JButton();
        JButton nextMusic=new JButton();
        JButton previousMusic=new JButton();
        JButton shuffle=new JButton();
        JButton repeatMusic=new JButton();
        nextMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\next.png")));
        playMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\play.png")));
        previousMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\previous.png")));
        shuffle.setIcon(new ImageIcon(getClass().getResource("Icons\\shuffle.png")));
        repeatMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\repeat.png")));
        nextMusic.setBorder(null);
        nextMusic.setMargin(new Insets(0, 0, 0, 0));
        nextMusic.setContentAreaFilled(false);
        playMusic.setBorder(null);
        playMusic.setMargin(new Insets(0, 0, 0, 0));
        playMusic.setContentAreaFilled(false);
        previousMusic.setBorder(null);
        previousMusic.setMargin(new Insets(0, 0, 0, 0));
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
        playerButtons.add(buttons,BorderLayout.NORTH);
        add(playerButtons,BorderLayout.CENTER);
    }
}
