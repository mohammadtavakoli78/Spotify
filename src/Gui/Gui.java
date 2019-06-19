package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    public Gui(){
        super();
        setSize(1600,1000);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
        setIconImage(icon);
        setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height=(int)screenSize.getHeight();
        setLocation(width/2-800,height/2-500);
        getContentPane().setBackground(new Color(0x040404));
        SouthPanel southPanel=new SouthPanel();
        add(southPanel,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Gui gui=new Gui();
    }
}
