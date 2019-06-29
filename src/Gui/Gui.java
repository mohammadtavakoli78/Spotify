package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        JFrame frame1=new JFrame();
        frame1.setSize(400,200);
        frame1.setLayout(new GridLayout(2,1));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height=(int)screenSize.getHeight();
        frame1.setLocation(width/2-200,height/2-100);
        frame1.getContentPane().setBackground(Color.gray);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
        frame1.setIconImage(icon);

        JTextField textField1=new JTextField();
        textField1.setText("Enter your name");
        textField1.setFont(new Font("Italic",Font.ITALIC,25));
        textField1.setBackground(Color.DARK_GRAY);
        textField1.setPreferredSize(new Dimension(100,20));
        textField1.addKeyListener(new KeyListener() {
            int counter=0;
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                ++counter;
                if(counter==1){
                    textField1.setText(null);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        JButton ok1=new JButton();
        ok1.setContentAreaFilled(false);
        ok1.setBorderPainted(false);
        ok1.setFocusPainted(false);
        ok1.setText("ok");
        ok1.setOpaque(true);
        ok1.setBackground(Color.DARK_GRAY);
        ok1.setFont(new Font("Italic",Font.ITALIC,18));
        ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NorthPanel.name=textField1.getText();
                frame1.dispose();
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
        });
        frame1.add(textField1);
        frame1.add(ok1);
        frame1.setVisible(true);

//        frame=new JFrame();
//        frame.setSize(1600,1000);
//
//        icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
//        frame.setIconImage(icon);
//        frame.setLayout(new BorderLayout());
//        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        width=(int)screenSize.getWidth();
//        height=(int)screenSize.getHeight();
//        frame.setLocation(width/2-800,height/2-500);
//        frame.getContentPane().setBackground(Color.DARK_GRAY);
//        SouthPanel southPanel=new SouthPanel();
//        WestPanel westPanel=new WestPanel();
//        NorthPanel northPanel=new NorthPanel();
//        frame.add(southPanel,BorderLayout.SOUTH);
//        frame.add(westPanel,BorderLayout.WEST);
//        frame.add(northPanel,BorderLayout.NORTH);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
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
