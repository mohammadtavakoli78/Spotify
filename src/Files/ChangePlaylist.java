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

/**
 * This class is for changing playlist like add and remove a song
 * This class show all song with jcheck box format for editting.
 * This class uses mp3agic library.
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
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

    /**
     * Constructor for ChangePlaylist
     */
    public ChangePlaylist(String name,ArrayList<String> allSongs) {

        super();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("..\\Gui\\Icons\\spotify.png"));
        setIconImage(icon);
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        this.allSongs = allSongs;
        nameOfPlayList=name;
        setSize(1000,800);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height=(int)screenSize.getHeight();
        setLocation(width/2-500,height/2-400);
        jCheckBoxes = new ArrayList<>();
        selectedSongs = new ArrayList<>();
        previousSongs = readPreviosSongs();
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(allSongs.size(),1));
        panel.setOpaque(true);
        panel.setBackground(Color.gray);
        for (int i = 0; i <allSongs.size() ; i++)
        {
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new GridLayout(1,2));
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
            if(previousSongs!=null){
                if(previousSongs.contains(allSongs.get(i)))
                    jCheckBox.setSelected(true);
            }
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
            panel.add(jPanel);
        }

        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setOpaque(true);
        jScrollPane.setBackground(Color.gray);

       JButton button =  new JButton("Done");
        button.setBorderPainted(false);
        button.setBackground(Color.gray);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedSongsf();
          ArrayList<String> arrayList = getSelectedSongs();
          AllPlaylist allPlaylist = new AllPlaylist();
          allPlaylist.changePlaylistSongs(nameOfPlayList,arrayList);
          dispose();
            }
        });

        add(jScrollPane,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        setVisible(true);
    }

    /**
     * get arraylist of extist song
     *
     * @return Arraylist of String
     */
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
        }       return playlists.get(nameOfPlayList);
    }

    /**
     * get selected songs
     *
     * @return void
     */
    public void selectedSongsf ()
    {
        for (int i = 0; i <jCheckBoxes.size() ; i++)
        {
            if(jCheckBoxes.get(i).isSelected()){
                selectedSongs.add(allSongs.get(i));
            }
        }
    }

    /**
     * get arraylist of selected songs
     *
     * @return Arraylist of String
     */
    public ArrayList<String > getSelectedSongs()
    {
        return selectedSongs;
    }
}