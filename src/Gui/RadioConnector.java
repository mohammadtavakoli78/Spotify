package Gui;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class RadioConnector {
    static Player player;
    public RadioConnector() throws IOException, JavaLayerException {
        URLConnection urlConnection = new URL("http://radio.flex.ru:8000/radionami").openConnection();
        urlConnection.connect();
        player = new Player(urlConnection.getInputStream());
        player.play();
    }
    public void stop(){
        player.close();
    }
}