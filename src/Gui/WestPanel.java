package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WestPanel extends JPanel {
    private int numberButton=0;
    private HashMap<String,JButton> playLists=new HashMap<String,JButton>();
    public WestPanel() {
        super();

        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Image homeimage = null;

        try {
            homeimage = ImageIO.read(getClass().getResource("Icons\\HomeIcon.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        } catch (IOException e) {
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
            favorite = ImageIO.read(getClass().getResource("Icons\\favorite.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
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

        homeButton.addMouseListener(new MouseListener() {
            Color color=homeButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                homeButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                homeButton.setForeground(color);
            }
        });

        browseButton.addMouseListener(new MouseListener() {
            Color color=browseButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                browseButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                browseButton.setForeground(color);
            }
        });

        favoritButton.addMouseListener(new MouseListener() {
            Color color=favoritButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                favoritButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                favoritButton.setForeground(color);
            }
        });

        addLibraryButton.addMouseListener(new MouseListener() {
            Color color=addLibraryButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addLibraryButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addLibraryButton.setForeground(color);
            }
        });

        songsButton.addMouseListener(new MouseListener() {
            Color color=songsButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                songsButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                songsButton.setForeground(color);
            }
        });

        addPlayListButton.addMouseListener(new MouseListener() {
            Color color=addPlayListButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addPlayListButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addPlayListButton.setForeground(color);
            }
        });

        albumsButton.addMouseListener(new MouseListener() {
            Color color=albumsButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                albumsButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                albumsButton.setForeground(color);
            }
        });

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




        libraryLabel.setFont(new Font("     Italic",Font.BOLD,25));




        albumPanel.add(libraryLabel);
        albumPanel.add(addLibraryButton);
        albumPanel.add(songsButton);
        albumPanel.add(albumsButton);

        ///  play list components

        {


            playListPanel.setLayout(new GridLayout(20, 1));


            // labael
            JLabel label = new JLabel("      playLists  ");

            label.setFont(new Font("Italic", Font.BOLD, 25));

            playListPanel.add(label, BorderLayout.CENTER);

            playListPanel.add(favoritButton);



//            JButton button=new MyButton("amir",Color.BLACK," ",null);

            //   playListPanel.add(button,BorderLayout.SOUTH);

// add new play list button

//            JButton b1=new JButton();
//            JButton b2=new JButton();
//            JButton b3=new JButton();
//            JButton b4=new JButton();
//            JButton b5=new JButton();
//            JButton b6=new JButton();
//            JButton b7=new JButton();
//            JButton b8=new JButton();
//            b1.setText("ali");
//            b1.setContentAreaFilled(false);
//            b1.setFocusPainted(false);
//            b1.setBorderPainted(false);
//            playListPanel.add(b1);
//            b2.setText("mohammad");
//            b2.setContentAreaFilled(false);
//            b2.setFocusPainted(false);
//            b2.setBorderPainted(false);
//            b3.setText("hasan");
//            b3.setContentAreaFilled(false);
//            b3.setFocusPainted(false);
//            b3.setBorderPainted(false);
//            b4.setText("reza");
//            b4.setContentAreaFilled(false);
//            b4.setFocusPainted(false);
//            b4.setBorderPainted(false);
//            b5.setText("alireza");
//            b5.setContentAreaFilled(false);
//            b5.setFocusPainted(false);
//            b5.setBorderPainted(false);
//            b6.setText("aliali");
//            b6.setContentAreaFilled(false);
//            b6.setFocusPainted(false);
//            b6.setBorderPainted(false);
//            b7.setText("alialiali");
//            b7.setContentAreaFilled(false);
//            b7.setFocusPainted(false);
//            b7.setBorderPainted(false);
//            b8.setText("alialiali");
//            b8.setContentAreaFilled(false);
//            b8.setFocusPainted(false);
//            b8.setBorderPainted(false);
//            playListPanel.add(b1);
//            playListPanel.add(b2);
//            playListPanel.add(b3);
//            playListPanel.add(b4);
//            playListPanel.add(b5);
//            playListPanel.add(b6);
//            playListPanel.add(b7);
//            playListPanel.add(b8);

            addPlayListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                }
            });


            // /////////////////////////////////////////////////////////////////////////

            // south panel
            southPanel.add(addPlayListButton);

            addPlayListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame=new JFrame();
//                    frame.setLayout(new BorderLayout());
                    frame.setSize(800,400);
                    frame.setLayout(new GridLayout(2,1));
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    int width=(int)screenSize.getWidth();
                    int height=(int)screenSize.getHeight();
                    frame.setLocation(width/2-400,height/2-200);
                    frame.getContentPane().setBackground(Color.gray);
                    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
                    frame.setIconImage(icon);
                    JTextField textField=new JTextField();
                    textField.setText("Enter your playlist name");
                    textField.setFont(new Font("Italic",Font.ITALIC,25));
//                    textField.setEnabled(true);
//                    textField.setEditable(true);
//                    textField.setOpaque(true);
                    textField.setBackground(Color.gray);
                    textField.setPreferredSize(new Dimension(100,20));
                    textField.addKeyListener(new KeyListener() {
//                        String text1="";
                        int counter=0;
                        @Override
                        public void keyTyped(KeyEvent e) {
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            ++counter;
                            if(counter==1){
                                textField.setText(null);
//                                text1+=e.getKeyChar();
                            }
                            else{
//                                text1+=e.getKeyChar();
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                        }
                    });
                    JButton click=new JButton();
                    click.setContentAreaFilled(false);
                    click.setBorderPainted(false);
                    click.setFocusPainted(false);
                    click.setText("ok");
                    click.setFont(new Font("Italic",Font.ITALIC,18));
                    click.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.dispose();
                            JButton newButton=new JButton();
                            newButton.setContentAreaFilled(false);
                            newButton.setBorderPainted(false);
                            newButton.setFocusPainted(false);
                            newButton.setText(textField.getText());
                            newButton.setOpaque(true);
                            newButton.setBackground(Color.BLACK);
                            newButton.addMouseListener(new MouseListener() {
                                Color color=newButton.getForeground();
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                }

                                @Override
                                public void mousePressed(MouseEvent e) {
                                }

                                @Override
                                public void mouseReleased(MouseEvent e) {
                                }

                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    newButton.setForeground(Color.green);
                                }

                                @Override
                                public void mouseExited(MouseEvent e) {
                                    newButton.setForeground(color);
                                }
                            });
                            playListPanel.add(newButton);
                            playLists.put(newButton.getText(),newButton);
                            GuiController.gui.setVisible(true);
                        }
                    });
                    frame.add(textField);
                    frame.add(click);
                    frame.setVisible(true);
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
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
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
