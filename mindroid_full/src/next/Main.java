package next;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import next.api.MindroidFullApi;

public class Main extends MindroidFullApi {

    static{
        // gyro = true;
        // us = true;
        // colorL = true;
        // colorR = true;
        init();
    }

    public static void main (String[] args){
        // Hiernach programmieren
        LCD.drawString("test",0,0);
        Delay.msDelay(1000);
        forward(1000);

    }
}
