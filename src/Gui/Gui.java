package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    static CenterPanel centerPanel;
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
        getContentPane().setBackground(Color.DARK_GRAY);
        SouthPanel southPanel=new SouthPanel();
        WestPanel westPanel=new WestPanel();
        add(southPanel,BorderLayout.SOUTH);
        add(westPanel,BorderLayout.WEST);
//        add(centerPanel,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        GuiController guiController=new GuiController();
    }
}
