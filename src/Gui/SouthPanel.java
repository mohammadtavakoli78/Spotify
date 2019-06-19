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
        nextMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\next.png")));
        playMusic.setIcon(new ImageIcon(getClass().getResource("Icons\\play.png")));
        buttons.add(nextMusic);
        buttons.add(playMusic);
        playerButtons.add(buttons,BorderLayout.NORTH);
        add(playerButtons,BorderLayout.CENTER);
    }
}
