package Gui;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CenterPanel extends JPanel {
    private int choose;
    private ArrayList<String> song;
    private HashMap<String,ArrayList<String>> albums;
    private HashMap<String,ArrayList<String>> playLists;
    public CenterPanel(int choose){
        this.choose=choose;
        if(choose==1){

            int size=song.size();
            ArrayList<JButton> buttons=new ArrayList<JButton>();
            setOpaque(true);
            setBackground(Color.DARK_GRAY);

            for(int i=0; i<=size-1; ++i){

                setLayout(new GridLayout(size/4+1,4));

                JButton button=new JButton();
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setBorderPainted(false);
                button.setLayout(new GridLayout(2,1));
                button.setOpaque(true);
                button.setBackground(Color.darkGray);
                try {
                    Mp3File mp3File=new Mp3File(song.get(i));
                    ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                    button.setText(id3v2Tag.getTitle());
                    byte[] songImage=id3v2Tag.getAlbumImage();
                    button.setIcon(new ImageIcon(songImage));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedTagException e) {
                    e.printStackTrace();
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                }
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                buttons.add(button);
                add(button);
                GuiController.gui.setVisible(true);
            }
        }
        if(choose==2){

        }
        if(choose==3){

        }
    }
}