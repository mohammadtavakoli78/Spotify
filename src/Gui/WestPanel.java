package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class WestPanel extends JPanel {

    public WestPanel() {
        super();

        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Image homeimage = null;

        try {
            homeimage = ImageIO.read(getClass().getResource("Icons\\HomeIcon.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println("harer");
            e.printStackTrace();
        }


        Image addimg = null;
        try {
            addimg = ImageIO.read(getClass().getResource("Icons\\plus.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        } catch (IOException e) {

            e.printStackTrace();
        }

        Image browse = null;
        try {
            browse = ImageIO.read(getClass().getResource("Icons\\Browse.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        } catch (IOException e) {

            e.printStackTrace();
        }


        Image favorite = null;
        try {
            favorite = ImageIO.read(getClass().getResource("Icons\\favorite.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        } catch (IOException e) {

            e.printStackTrace();
        }
//        Image library = null;
//        try {
//            library= ImageIO.read(getClass().getResource("Icons\\library.jpg")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }

        JPanel playListPanel = new JPanel();
        JPanel albumPanel = new JPanel();
        JPanel homePanel = new JPanel();
        JPanel southPanel = new JPanel();

        JButton addPlayListButton = new MyButton("add playlist  ", Color.BLACK, "click to add a new playlist", addimg);
        JButton homeButton = new MyButton("HOME                 ", Color.BLACK, "Click to go home", homeimage);
        JButton browseButton = new MyButton("Browse              ", Color.BLACK, "Browse", browse);
        JButton favoritButton = new MyButton("Favorit playlist        ",Color.BLACK,"Favorit",favorite);
        JButton addLibraryButton = new MyButton("Add to Library          ",Color.BLACK,"Library",null);
        JButton songsButton     = new MyButton("Songs         " , Color.black,"Songs",null);
        JButton albumsButton    = new MyButton("Albums       ",Color.BLACK,"Albums",null);


        JLabel libraryLabel = new JLabel("      Library");

        playListPanel.setOpaque(true);
        albumPanel.setOpaque(true);
        homePanel.setOpaque(true);
        southPanel.setOpaque(true);


        playListPanel.setBackground(Color.BLACK);
        albumPanel.setBackground(Color.BLACK);
        homePanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);



        //////////////////////////////////////////////////

        ///  home panel

        homePanel.setLayout(new GridLayout(2,1));

        homePanel.add(homeButton);

        homePanel.add(browseButton);


/////////////////////////////////////////////////
        //// album panel

        albumPanel.setLayout(new GridLayout(5,1));




        libraryLabel.setFont(new Font("     Italic",Font.BOLD,20));




        albumPanel.add(libraryLabel);
        albumPanel.add(addLibraryButton);
        albumPanel.add(songsButton);
        albumPanel.add(albumsButton);

        ///  play list components

        {


            playListPanel.setLayout(new GridLayout(20, 1));


            // labael
            JLabel label = new JLabel("      playLists  ");

            label.setFont(new Font("Italic", Font.BOLD, 18));

            playListPanel.add(label, BorderLayout.CENTER);

            playListPanel.add(favoritButton);



//            JButton button=new MyButton("amir",Color.BLACK," ",null);

            //   playListPanel.add(button,BorderLayout.SOUTH);

// add new play list button

            JButton b1=new JButton();
            JButton b2=new JButton();
            JButton b3=new JButton();
            JButton b4=new JButton();
            JButton b5=new JButton();
            JButton b6=new JButton();
            JButton b7=new JButton();
            JButton b8=new JButton();
            b1.setText("ali");
            b1.setContentAreaFilled(false);
            b1.setFocusPainted(false);
            b1.setBorderPainted(false);
            playListPanel.add(b1);
            b2.setText("mohammad");
            b2.setContentAreaFilled(false);
            b2.setFocusPainted(false);
            b2.setBorderPainted(false);
            b3.setText("hasan");
            b3.setContentAreaFilled(false);
            b3.setFocusPainted(false);
            b3.setBorderPainted(false);
            b4.setText("reza");
            b4.setContentAreaFilled(false);
            b4.setFocusPainted(false);
            b4.setBorderPainted(false);
            b5.setText("alireza");
            b5.setContentAreaFilled(false);
            b5.setFocusPainted(false);
            b5.setBorderPainted(false);
            b6.setText("aliali");
            b6.setContentAreaFilled(false);
            b6.setFocusPainted(false);
            b6.setBorderPainted(false);
            b7.setText("alialiali");
            b7.setContentAreaFilled(false);
            b7.setFocusPainted(false);
            b7.setBorderPainted(false);
            b8.setText("alialiali");
            b8.setContentAreaFilled(false);
            b8.setFocusPainted(false);
            b8.setBorderPainted(false);
            playListPanel.add(b1);
            playListPanel.add(b2);
            playListPanel.add(b3);
            playListPanel.add(b4);
            playListPanel.add(b5);
            playListPanel.add(b6);
            playListPanel.add(b7);
            playListPanel.add(b8);
            addPlayListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                }
            });


            // /////////////////////////////////////////////////////////////////////////

            // south panel
            southPanel.add(addPlayListButton);


            southPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseEntered(e);
                    System.out.println("entered here");
                    playListPanel.add(new MyButton("another playlist", Color.red, null, null));
                }
            });


        }

    JScrollPane jScrollPane = new JScrollPane(playListPanel);
//      jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       jScrollPane.setOpaque(true);
//       jScrollPane.setPreferredSize(new Dimension(0,10));
       jScrollPane.setBackground(Color.black);
        add(homePanel);
        add(albumPanel);
//     add(playListPanel);
        add(jScrollPane);
        add(southPanel);



    }

}

class MyButton extends JButton {

    public MyButton(String name, Color color, String tipPoint, Image image) {


        super();


        setText(name);
        if (color != null) {
            setOpaque(true);
            setBackground(color);
        }
        setLayout(new FlowLayout());
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setFont(new Font("Italic", Font.ITALIC, 15));
        if(image!=null)
            setIcon(new ImageIcon(image));


    }


}
