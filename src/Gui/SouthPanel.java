package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {
    public SouthPanel(){

        super();
        setLayout(new BorderLayout());
        setBackground(new Color(0x14000000, true));

        JPanel playerButtons=new JPanel();
        JPanel soundManager=new JPanel();
        JPanel buttons=new JPanel();
        JPanel progressBar=new JPanel();

        playerButtons.setLayout(new BorderLayout());
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton playButton=new JButton();
        playButton.setIcon(new ImageIcon("C:\\Users\\Win 1809 UEFI\\Desktop\\play.jpg"));
        buttons.add(playButton);
        playerButtons.add(buttons);
        add(playButton,BorderLayout.CENTER);
    }
}
