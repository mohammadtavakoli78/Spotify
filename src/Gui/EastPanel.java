package Gui;

import Client.Client;
import Files.AllSongsAdresses;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class EastPanel extends JPanel {
    JPanel friendPanel;
    JButton sendButton;
    JLabel friendLabel;
    public EastPanel(){
        super();
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(Color.black);

        friendLabel=new JLabel();
        friendPanel=new JPanel();
        sendButton=new JButton();

        friendLabel.setText("         Friends Activity");
        friendLabel.setFont(new Font("Italic",Font.ITALIC,20));

        friendPanel.setOpaque(true);
        friendPanel.setBackground(Color.black);

        JScrollPane jScrollPane = new JScrollPane(friendPanel);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setOpaque(true);
        jScrollPane.setBackground(Color.black);

        sendButton.setContentAreaFilled(false);
        sendButton.setBorderPainted(false);
        sendButton.setFocusPainted(false);
        sendButton.setText("Send music to the friends");
        sendButton.setFont(new Font("Italic",Font.ITALIC,18));
        sendButton.addMouseListener(new MouseListener() {
            Color color=sendButton.getForeground();
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
                sendButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sendButton.setForeground(color);
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3=new JFrame();
                Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons\\spotify.png"));
                frame3.setIconImage(icon);
                frame3.setLayout(new BorderLayout());
                frame3.setBackground(Color.gray);
                frame3.setSize(1000,800);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int width=(int)screenSize.getWidth();
                int height=(int)screenSize.getHeight();
                frame3.setLocation(width/2-500,height/2-400);
                ArrayList<JCheckBox> jCheckBoxes = new ArrayList<>();
                ArrayList<String> songs=new ArrayList<>();
                AllSongsAdresses allSongsAdresses=new AllSongsAdresses("allSongs");
                songs= allSongsAdresses.getAllSongs();
                JPanel panel3=new JPanel();
                panel3.setLayout(new GridLayout(songs.size(),1));
                panel3.setOpaque(true);
                panel3.setBackground(Color.gray);
                for (int i = 0; i <songs.size() ; i++)
                {
                    JPanel jPanel4 = new JPanel();
                    jPanel4.setLayout(new GridLayout(1,2));
                    Mp3File mp3File = null;
                    try {
                        mp3File = new Mp3File(songs.get(i));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (UnsupportedTagException ex) {
                        ex.printStackTrace();
                    } catch (InvalidDataException ex) {
                        ex.printStackTrace();
                    }
                    ID3v2 id3v2 = mp3File.getId3v2Tag();
                    JCheckBox jCheckBox = new JCheckBox();
                    jCheckBox.setFont(new Font("Italic",Font.BOLD,15));
                    byte[] imageFile = id3v2.getAlbumImage();
                    ImageIcon imageIcon =new ImageIcon(imageFile);
                    Image image = imageIcon.getImage(); // transform it
                    Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                    imageIcon = new ImageIcon(newimg);
                    jCheckBox.setBorderPaintedFlat(false);
                    jCheckBox.setBorderPainted(false);
                    jCheckBox.setEnabled(true);
                    jCheckBox.setBackground(Color.gray);
                    jCheckBoxes.add(jCheckBox);
                    JLabel jLabel = new JLabel();
                    jLabel.setIcon(imageIcon);
                    jLabel.setFont(new Font("Italic",Font.BOLD,15));
                    jLabel.setText( id3v2.getTitle() + "  " + id3v2.getAlbumArtist() + "   " );
                    jPanel4.add(jLabel);
                    jPanel4.add(jCheckBox);
                    jPanel4.setBackground(Color.gray);
                    panel3.add(jPanel4);
                }
                JScrollPane jScrollPane = new JScrollPane(panel3);
                jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                jScrollPane.setOpaque(true);
                jScrollPane.setBackground(Color.gray);

                JButton button =  new JButton("Done");
                button.setBorderPainted(false);
                button.setBackground(Color.gray);
                ArrayList<String> finalSongs = songs;
                button.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ArrayList<String> selectedSongs=new ArrayList<>();
                        for (int i = 0; i <jCheckBoxes.size() ; i++)
                        {
                            if(jCheckBoxes.get(i).isSelected()){
                                selectedSongs.add(finalSongs.get(i));
                            }
                        }
                        frame3.dispose();
                        Gui.frame.setVisible(true);
                        try {
                            Mp3File mp3File=new Mp3File(selectedSongs.get(0));
                            Client client=new Client();
                            client.getClientSender().setMp3Files(mp3File);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (UnsupportedTagException e1) {
                            e1.printStackTrace();
                        } catch (InvalidDataException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

                frame3.add(jScrollPane,BorderLayout.CENTER);
                frame3.add(button,BorderLayout.SOUTH);
                frame3.setVisible(true);
            }
        });

        add(friendLabel,BorderLayout.NORTH);
        add(jScrollPane,BorderLayout.CENTER);
        add(sendButton,BorderLayout.SOUTH);
    }
}
