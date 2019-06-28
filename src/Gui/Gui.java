package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class is for showing main frame
 *
 *
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class Gui extends JFrame {
    static CenterPanel centerPanel;
    static int choice;
    static JFrame frame;
    static JScrollPane jScrollPane;

    /**
     *
     * constructor for gui class
     */
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
        NorthPanel northPanel=new NorthPanel();
        frame.add(southPanel,BorderLayout.SOUTH);
        frame.add(westPanel,BorderLayout.WEST);
        frame.add(northPanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * remove centerPanel and update it
     *
     * @return void
     */
    static void removeCenter(){
        if(centerPanel!=null){
            frame.remove(centerPanel);
        }
    }

    /**
     * add a new component
     *
     * @Param component
     * @return void
     */
    static void addComponent(Component component){
        removeCenter();
        centerPanel.add(component);
        frame.add(centerPanel);
        frame.setVisible(true);
    }

    /**
     * update centerPanel
     *
     * @return void
     */
    static void update(){
        if(jScrollPane!=null){
            frame.remove(jScrollPane);
        }
        jScrollPane = new JScrollPane(centerPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(jScrollPane,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Gui gui=new Gui();
    }
}
