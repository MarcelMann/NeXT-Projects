package next;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
public class Main {
    public static void main (String[] args){
        // Hiernach programmieren
        LCD.drawString("test",1,1);
        Delay.msDelay(2000);
    }
}
