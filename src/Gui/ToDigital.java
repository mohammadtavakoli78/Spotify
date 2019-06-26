package Gui;

public class ToDigital {

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
