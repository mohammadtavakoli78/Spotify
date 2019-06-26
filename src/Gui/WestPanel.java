package Gui;

import Files.AllSongsAdresses;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class WestPanel extends JPanel {


    private JFileChooser jFileChooser = new JFileChooser();

    static int counter = 0;

    static Thread t1;

    static Player player;

    AllSongsAdresses  allSongsAdresses = null;

    File newSong = null;
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

        favoritButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui.choice=3;
                Gui.removeCenter();
                try {
                    Gui.centerPanel=new CenterPanel(3);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                Gui.update();
                Gui.frame.setVisible(true);
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
        addLibraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if( counter == 0)
                {
                    allSongsAdresses =  new AllSongsAdresses("allSongs");
                    counter++;
                }
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                // i dont know
                int res = jFileChooser.showOpenDialog(addPlayListButton);
                if( res == JFileChooser.CANCEL_OPTION);
                if( res == JFileChooser.APPROVE_OPTION){
                    newSong = jFileChooser.getSelectedFile();
                    String songPath = newSong.getAbsolutePath();
                    allSongsAdresses.addSong(songPath);

                    Gui.choice=1;
                    Gui.removeCenter();
                    try {
                        Gui.centerPanel=new CenterPanel(1);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    Gui.update();
                    Gui.frame.setVisible(true);

                }
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

        songsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CenterPanel.panel=null;
                Gui.choice=1;
                Gui.removeCenter();
                try {
                    Gui.centerPanel=new CenterPanel(1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                Gui.update();
                Gui.frame.setVisible(true);
//                allSongsAdresses.getSongsAdress();
//                Gui.centerPanel=new CenterPanel(1);
//                GuiController.gui.setVisible(true);
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

        albumsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CenterPanel.panel=null;
                Gui.choice=2;
                Gui.removeCenter();
                try {
                    Gui.centerPanel=new CenterPanel(2);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                Gui.update();
                Gui.frame.setVisible(true);
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


            playListPanel.setLayout(new GridLayout(100, 1));


            // labael
            JLabel label = new JLabel("      playLists  ");

            label.setFont(new Font("Italic", Font.BOLD, 25));

            playListPanel.add(label, BorderLayout.CENTER);

            playListPanel.add(favoritButton);

            for(String i : playLists.keySet()){
                    JButton newButton=playLists.get(i);
                    newButton.setContentAreaFilled(false);
                    newButton.setBorderPainted(false);
                    newButton.setFocusPainted(false);
                    newButton.setText(i);
                    newButton.setOpaque(true);
                    newButton.setBackground(Color.BLACK);
                    newButton.addMouseListener(new MouseListener() {
                        Color color=newButton.getForeground();
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if(e.getButton()==1){



                                //show playlist here........


                            }
                            else if(e.getButton()==3){
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

                                JButton rename=new JButton();
                                rename.setContentAreaFilled(false);
                                rename.setBorderPainted(false);
                                rename.setFocusPainted(false);
                                rename.setText("rename");
                                rename.setFont(new Font("Italic",Font.ITALIC,18));

                                JButton delete=new JButton();
                                delete.setContentAreaFilled(false);
                                delete.setBorderPainted(false);
                                delete.setFocusPainted(false);
                                delete.setText("delete");
                                delete.setFont(new Font("Italic",Font.ITALIC,18));

                                rename.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame1.dispose();
                                        JFrame frame2=new JFrame();
                                        frame2.setSize(400,200);
                                        frame2.setLayout(new GridLayout(2,1));
                                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                                        int width=(int)screenSize.getWidth();
                                        int height=(int)screenSize.getHeight();
                                        frame2.setLocation(width/2-200,height/2-100);
                                        frame2.getContentPane().setBackground(Color.gray);
                                        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
                                        frame2.setIconImage(icon);

                                        JTextField textField1=new JTextField();
                                        textField1.setText("Enter your new playlist name");
                                        textField1.setFont(new Font("Italic",Font.ITALIC,25));
                                        textField1.setBackground(Color.gray);
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
                                        ok1.setFont(new Font("Italic",Font.ITALIC,18));
                                        ok1.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                Iterator<String> it=playLists.keySet().iterator();
                                                while(it.hasNext()){
                                                    String buttonName=it.next();
                                                    if(buttonName.equals(newButton.getText())){
                                                        it.remove();
                                                    }
                                                }
                                                playLists.put(textField1.getText(),newButton);
                                                newButton.setText(textField1.getText());
                                                playLists.replace(textField1.getText(),newButton);
                                                frame2.dispose();
                                            }
                                        });
                                        frame2.add(textField1);
                                        frame2.add(ok1);
                                        frame2.setVisible(true);
                                    }
                                });

                                delete.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        Iterator<String> it=playLists.keySet().iterator();
                                        while(it.hasNext()){
                                            String buttonName=it.next();
                                            if(buttonName.equals(newButton.getText())){
                                                it.remove();
                                            }
                                        }
                                        playListPanel.remove(newButton);
                                        Gui.frame.setVisible(true);
                                    }
                                });

                                frame1.add(rename);
                                frame1.add(delete);
                                frame1.setVisible(true);
                            }
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
                    Gui.frame.setVisible(true);
            }
// add new play list button


            // /////////////////////////////////////////////////////////////////////////

            // south panel
            southPanel.add(addPlayListButton);

            addPlayListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame=new JFrame();
                    frame.setSize(400,200);
                    frame.setLayout(new GridLayout(2,1));
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    int width=(int)screenSize.getWidth();
                    int height=(int)screenSize.getHeight();
                    frame.setLocation(width/2-200,height/2-100);
                    frame.getContentPane().setBackground(Color.gray);
                    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
                    frame.setIconImage(icon);
                    JTextField textField=new JTextField();
                    textField.setText("Enter your playlist name");
                    textField.setFont(new Font("Italic",Font.ITALIC,25));
                    textField.setBackground(Color.gray);
                    textField.setPreferredSize(new Dimension(100,20));
                    textField.addKeyListener(new KeyListener() {
                        int counter=0;
                        @Override
                        public void keyTyped(KeyEvent e) {
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            ++counter;
                            if(counter==1){
                                textField.setText(null);
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
                                    if(e.getButton()==1){



                                        //show playlist here........


                                    }
                                    else if(e.getButton()==3){
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

                                        JButton rename=new JButton();
                                        rename.setContentAreaFilled(false);
                                        rename.setBorderPainted(false);
                                        rename.setFocusPainted(false);
                                        rename.setText("rename");
                                        rename.setFont(new Font("Italic",Font.ITALIC,18));

                                        JButton delete=new JButton();
                                        delete.setContentAreaFilled(false);
                                        delete.setBorderPainted(false);
                                        delete.setFocusPainted(false);
                                        delete.setText("delete");
                                        delete.setFont(new Font("Italic",Font.ITALIC,18));

                                        rename.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                frame1.dispose();
                                                JFrame frame2=new JFrame();
                                                frame2.setSize(400,200);
                                                frame2.setLayout(new GridLayout(2,1));
                                                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                                                int width=(int)screenSize.getWidth();
                                                int height=(int)screenSize.getHeight();
                                                frame2.setLocation(width/2-200,height/2-100);
                                                frame2.getContentPane().setBackground(Color.gray);
                                                Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
                                                frame2.setIconImage(icon);

                                                JTextField textField1=new JTextField();
                                                textField1.setText("Enter your new playlist name");
                                                textField1.setFont(new Font("Italic",Font.ITALIC,25));
                                                textField1.setBackground(Color.gray);
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
                                                ok1.setFont(new Font("Italic",Font.ITALIC,18));
                                                ok1.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        Iterator<String> it=playLists.keySet().iterator();
                                                        while(it.hasNext()){
                                                            String buttonName=it.next();
                                                            if(buttonName.equals(newButton.getText())){
                                                                it.remove();
                                                            }
                                                        }
                                                        playLists.put(textField1.getText(),newButton);
                                                        newButton.setText(textField1.getText());
                                                        playLists.replace(textField1.getText(),newButton);
                                                        frame2.dispose();
                                                    }
                                                });
                                                frame2.add(textField1);
                                                frame2.add(ok1);
                                                frame2.setVisible(true);
                                            }
                                        });

                                        delete.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                Iterator<String> it=playLists.keySet().iterator();
                                                while(it.hasNext()){
                                                    String buttonName=it.next();
                                                    if(buttonName.equals(newButton.getText())){
                                                        it.remove();
                                                    }
                                                }
                                                playListPanel.remove(newButton);
                                                Gui.frame.setVisible(true);
                                            }
                                        });

                                        frame1.add(rename);
                                        frame1.add(delete);
                                        frame1.setVisible(true);
                                    }
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
                            Gui.frame.setVisible(true);
//                            GuiController.gui.setVisible(true);
                        }
                    });
                    frame.add(textField);
                    frame.add(click);
                    frame.setVisible(true);
                }
            });
        }

    JScrollPane jScrollPane = new JScrollPane(playListPanel);
       jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       jScrollPane.setOpaque(true);
       jScrollPane.setBackground(Color.black);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(homePanel);
        add(albumPanel);
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
