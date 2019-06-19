package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {
    public SouthPanel(){

        super();
        setLayout(new BorderLayout());
        setForeground(new Color(0x41040304, true));
//        setBackground(new Color(0x14000000, true));

        JPanel playerButtons=new JPanel();
        JPanel soundManager=new JPanel();
        JPanel buttons=new JPanel();
        JPanel progressBar=new JPanel();

        playerButtons.setLayout(new BorderLayout());
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton playMusic=new JButton();
        JButton nextMusic=new JButton();
        playMusic.setIcon(new ImageIcon("C:\\Users\\Win 1809 UEFI\\Desktop\\play.png"));
        nextMusic.setIcon(new ImageIcon("C:\\Users\\Win 1809 UEFI\\Desktop\\next.png"));
        buttons.add(nextMusic);
        buttons.add(playMusic);
        playerButtons.add(buttons,BorderLayout.NORTH);
        add(playerButtons,BorderLayout.CENTER);
    }
}
