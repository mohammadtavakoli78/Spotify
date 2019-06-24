package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    static CenterPanel centerPanel;
    static int choice;
    static JFrame frame;
    public Gui(){
        super();
        frame=new JFrame();
        frame.setSize(1600,1000);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
        frame.setIconImage(icon);
        frame.setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height=(int)screenSize.getHeight();
        frame.setLocation(width/2-800,height/2-500);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        SouthPanel southPanel=new SouthPanel();
        WestPanel westPanel=new WestPanel();
        frame.add(southPanel,BorderLayout.SOUTH);
        frame.add(westPanel,BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void update(){
        centerPanel=new CenterPanel(choice);
        frame.add(centerPanel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
//        GuiController guiController=new GuiController();
        Gui gui=new Gui();
    }
}
