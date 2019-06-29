package Gui;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is for playing songs
 *
 *
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class Player implements Runnable{

    static ArrayList<String> songsAdresses = new ArrayList<String>();
    static int start;
    static int counter;
    static volatile boolean isPaused = false;
    static boolean seek=false;
    static boolean stop=false;
    static int frame;
    static FileInputStream fileInputStream;
    static AdvancedPlayer player;
    static int framse;
    static boolean isPlayed=false;
    static  javax.swing.Timer t;
    boolean repeat;
    boolean shuffle;

    /**
     *
     * constructor for player class
     */
    public Player(ArrayList<String> songsAdresses) throws JavaLayerException, FileNotFoundException {
        this(songsAdresses, 0);
    }

    /**
     *
     * constructor for player class
     */
    public Player(ArrayList<String> songsAdresses, int start) throws JavaLayerException, FileNotFoundException {
        this.songsAdresses = songsAdresses;
        this.start = start;
        this.repeat=false;
        this.shuffle=false;
    }

    /**
     * get arrylists of playing songs
     *
     * @return Arraylist of String
     */
    public ArrayList<String> getSongsAdresses() {
        return songsAdresses;
    }

    /**
     * set arraylist of songs
     * @param songsAdresses Arraylist String
     * @return void
     */
    public void setSongsAdresses(ArrayList<String> songsAdresses) {
        this.songsAdresses = songsAdresses;
    }

    /**
     * setCounter
     * @param counter for counting
     * @return void
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * set isPlayed
     *
     * @return void
     */
    public void setIsPlayed(){
        isPlayed=true;
    }

    /**
     * get isPlayed boolean
     *
     * @return boolean
     */
    public boolean getIsPlayed(){
        return isPlayed;
    }

    /**
     * close player
     *
     * @return void
     */
    public void close(){
        player.close();
    }

    /**
     * notify the threads
     *
     * @return void
     */
    public void set(){
        player.notifyAll();
    }

    /**
     * get counter
     *
     * @return int
     */
    public int getCounter(){
        return counter;
    }

    /**
     * plus the counter
     *
     * @return void
     */
    public void counterPlus() {
        new Thread(){
            @Override
            public void run(){
                ++counter;
            }
        }.start();
    }

    /**
     * decrease the counter
     *
     * @return void
     */
    public void counterminus() {
        new Thread(){
            @Override
            public void run(){
                --counter;
            }
        }.start();
    }

    /**
     * get isPuased boolean
     *
     * @return boolean
     */
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * set ispuased boolean
     * @param paused for setting
     * @return void
     */
    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    /**
     * ovverride the runclass
     *
     * @return void
     */
    @Override
    public void run() {

        for (int i = start; i < songsAdresses.size(); i++) {
            if(i<0 || i>=songsAdresses.size()){
                i=0;
            }
            if(shuffle){
                Random r1=new Random();
                int random=r1.nextInt(songsAdresses.size()-1);
                i=random;
            }
            Mp3File mp3File= null;
            try {
                mp3File = new Mp3File(songsAdresses.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedTagException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            byte[] songImage=id3v2Tag.getAlbumImage();

            ImageIcon imageIcon = new ImageIcon(songImage);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(85, 85,  java.awt.Image.SCALE_SMOOTH);

            ToDigital toDigital=new ToDigital();
            if(t!=null){
                t.stop();
            }
            t=new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SouthPanel.musicSlider.setValue(SouthPanel.musicSlider.getValue()+1);
                    SouthPanel.l2.setText(toDigital.toDigital(SouthPanel.musicSlider.getValue()));
                }
            });
            Player.framse=mp3File.getFrameCount();
            SouthPanel.musicButton.setIcon(new ImageIcon(newimg));
            SouthPanel.albumName.setText(id3v2Tag.getAlbum());
            SouthPanel.artist.setText(id3v2Tag.getArtist());
            SouthPanel.songName.setText(id3v2Tag.getTitle());
            SouthPanel.musicImage.add(SouthPanel.heartButton);
            SouthPanel.musicSlider.setValue(0);
            SouthPanel.musicSlider.setMaximum((int)mp3File.getLengthInSeconds());
            Mp3File finalMp3File = mp3File;
            SouthPanel.l1.setText(toDigital.toDigital((int)mp3File.getLengthInSeconds()));
            Gui.frame.setVisible(true);

            counter = i;
            String path = songsAdresses.get(i);
            try {
                fileInputStream = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                player = new AdvancedPlayer(fileInputStream);
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
            while (true) {
                if (counter != i) {
                    break;
                }
                try {
                    if (!player.play(1)) break;
                    t.start();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
                if (isPaused) {
                    synchronized (player) {
                        try {
                            t.stop();
                            player.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if(seek){
                    synchronized (player) {
                        player.close();
                        try {
                            player = new AdvancedPlayer(new FileInputStream(path));
                        } catch (JavaLayerException e) {
                            e.printStackTrace();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        try {
                            player.play(frame,frame+1);
                            seek=false;
                        } catch (JavaLayerException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
            if (counter != i && counter < 0) {
                i = counter + 1;
            }
            if (counter != i && counter >= songsAdresses.size()) {
                i = -1;
            }
            if (counter == i && i == songsAdresses.size()-1) {
                i = -1;
            }
            if(repeat){
                i-=1;
            }
        }
    }

    /**
     * set ispaused to true
     *
     * @return void
     */
    public void mp3Pause() {
        Player.isPaused = true;
    }

    /**
     * for puasing the player
     *
     * @return void
     */
    public void mp3Resume() {
        Player.isPaused = false;
        synchronized (player) {
            player.notifyAll();
        }
    }

    /**
     * for seeking the player
     *
     * @return void
     */
    public void seekTo(int frame) {
        this.seek=true;
        this.frame=frame;
    }

    /**
     * for setting seek boolean
     *
     * @return void
     */
    public void setSeek(boolean b){
        seek=b;
    }

    /**
     * for setting repeat for songs
     *
     * @return void
     */
    public void setRepeat(boolean repeat){
        this.repeat=repeat;
    }

    /**
     * for setting shuffle
     *
     * @return void
     */
    public void setShuffle(boolean shuffle){
        this.shuffle=shuffle;
    }
}
