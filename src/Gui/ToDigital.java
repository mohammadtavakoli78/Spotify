package Gui;

/**
 * This class is for converting the time to a string
 * This class is useful for when we want to show the remaining
 * and all time of a mp3file and we should show it in String object.
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class ToDigital {

    /**
     * get string that is converted from an integer
     *
     * @return String
     */
    public  String toDigital(int seconds)
    {
        int min = seconds/60;
        int second = seconds%60;

        String out = String.format("%s",min) + " : ";
        if(second>=10)
        {
            out += String.format("%s",second);
        }
        else
        {
            out+= String.format("0%s",second);
        }
        return out;
    }
}
