package Files;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class ChangePlaylist extends JFrame {

    private String nameOfPlayList;

    private ArrayList<String > previousSongs;

    private ArrayList<String> allSongs;

    private ArrayList<String> selectedSongs;

    private ArrayList<JCheckBox> jCheckBoxes;

    FileInputStream fileInputStream = null;

    FileOutputStream fileOutputStream = null;

    ObjectOutputStream objectOutputStream = null;

    ObjectInputStream objectInputStream = null;


    public ChangePlaylist(String name,ArrayList<String> allSongs) {



        super("Adding songs");

        setLayout(new GridLayout(allSongs.size()+1,1));

        setBackground(Color.gray);


        this.allSongs = allSongs;

        setLocation(750,350);


        jCheckBoxes = new ArrayList<>();

        selectedSongs = null;

        previousSongs = readPreviosSongs();



        for (int i = 0; i <allSongs.size() ; i++)
        {

            JPanel jPanel = new JPanel();
            jPanel.setLayout(new FlowLayout());

            Mp3File mp3File = null;

            try {
                 mp3File = new Mp3File(allSongs.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedTagException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }
            ID3v2 id3v2 = mp3File.getId3v2Tag();


            JCheckBox jCheckBox = new JCheckBox();

            jCheckBox.setFont(new Font("Italic",Font.BOLD,15));



            byte[] imageFile = id3v2.getAlbumImage();



            ImageIcon imageIcon =new ImageIcon(imageFile);


            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);


            if(previousSongs.contains(allSongs.get(i)))

                jCheckBox.setSelected(true);

            jCheckBox.setBorderPaintedFlat(false);

            jCheckBox.setBorderPainted(false);

            jCheckBox.setEnabled(true);


            jCheckBox.setBackground(Color.gray);

            jCheckBoxes.add(jCheckBox);

            JLabel jLabel = new JLabel();

            jLabel.setIcon(imageIcon);

            jLabel.setFont(new Font("Italic",Font.BOLD,15));

            jLabel.setText( id3v2.getTitle() + "  " + id3v2.getAlbumArtist() + "   " );

            jPanel.add(jLabel);

            jPanel.add(jCheckBox);

            jPanel.setBackground(Color.gray);

            add(jPanel);
        }







       JButton button =  new JButton("Done");

        button.setBorderPainted(false);

        button.setBackground(Color.gray);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                selectedSongsf();


          ArrayList<String > arrayList = getSelectedSongs();

          AllPlaylist allPlaylist = new AllPlaylist();

          allPlaylist.changePlaylistSongs(name,arrayList);


            }
        });

        add(button);


        setSize(800, 700);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    public ArrayList<String > readPreviosSongs()
    {


        File file = new File("PlayLists");

        HashMap<String , ArrayList<String> > playlists = null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            playlists = (HashMap<String,ArrayList<String>>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       return playlists.get(nameOfPlayList);



    }



    public void selectedSongsf ()
    {



        for (int i = 0; i <jCheckBoxes.size() ; i++)
        {
            if(jCheckBoxes.get(i).isSelected())

                selectedSongs.add(allSongs.get(i));
        }
    }

    public ArrayList<String > getSelectedSongs()
    {
        return selectedSongs;
    }
}
