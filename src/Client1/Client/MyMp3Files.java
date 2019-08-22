package Client1.Client;

import com.mpatric.mp3agic.Mp3File;

import java.io.Serializable;

public class MyMp3Files implements Serializable {

    private Mp3File mp3File;

    public MyMp3Files(Mp3File mp3File)
    {
        this.mp3File = mp3File;
    }

    public void setMp3File(Mp3File mp3File)
    {
        this.mp3File = mp3File;
    }

    public Mp3File getMp3File()
    {
        return mp3File;
    }
}
