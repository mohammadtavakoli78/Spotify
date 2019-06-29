package Gui;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class is for playing radio.
 * This class uses url connection for getting the waves.
 * radio button is in the west panel.
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class RadioConnector {
    static Player player;
    private URLConnection urlConnection;
    static boolean flag;
    /**
     *
     * constructor for Radio Connector class
     */
    public RadioConnector() throws IOException, JavaLayerException {
        flag=true;
        urlConnection = new URL("http://radio.flex.ru:8000/radionami").openConnection();
        urlConnection.connect();
        player = new Player(urlConnection.getInputStream());
        if(flag)
        player.play();
    }

    /**
     * stops the player.
     *
     * @return void
     */
    public void stop(){
        player.close();
    }
}