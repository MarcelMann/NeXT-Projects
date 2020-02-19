package next.api;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.BaseSensor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.internal.ev3.EV3LCD;
import lejos.utility.Delay;

public class MindroidFullApi {
    static EV3LargeRegulatedMotor motorL, motorR;
    static BaseSensor usSens, gyroSens, colorSensL, colorSensR;

    static protected boolean gyro = false, us = false, colorL = false, colorR = false;
    public static void init(){

        motorL = new EV3LargeRegulatedMotor(MotorPort.A);
        motorR = new EV3LargeRegulatedMotor(MotorPort.D);

        if(us) {
            usSens = new EV3UltrasonicSensor(SensorPort.S2);
        }
        if(gyro) {
            gyroSens = new EV3GyroSensor(SensorPort.S3);
        }
        if (colorL){
            colorSensL = new EV3ColorSensor(SensorPort.S1);
        }
        if (colorR){
            colorSensR = new EV3ColorSensor(SensorPort.S4);
        }
    }

    // TODO: DriveToWallAndTurn
    // TODO: DriveUntil Colour
    // TODO: Turn(int angle)
    /**
     * Displays the given text onto the EV3 display at the given row.
     * Row starting Pixel = (Row-1) * 16
     * @param text the text to display
     * @param row the row in which the text should be displayed, filtered by modulo 8 to produce values 0 to 7
     */
    public static final void drawString(final String text, final int row){
        LCD.drawString(text, 0, row);
    }

    /**
     * Displays the given text onto the EV3 display at the 4th row (of 8). (see drawString(final String text, final int row)
     * @param text
     */
    public static final void drawString(final String text){
        drawString(text, 3);
    }
    protected static void delay(int ms){
        Delay.msDelay(ms);
    }
    protected static float getDistance(){
        if (usSens!=null) {
            float signalwert[] = new float[usSens.sampleSize()];
            usSens.fetchSample(signalwert, 0);
            return signalwert[0];
        }else
            throw new UnsupportedOperationException("Ultrasonic Sensor not initialized.");
    }

    protected static float getAngle(){
        if (gyroSens != null) {
            float signalwert[] = new float[gyroSens.sampleSize()];
            gyroSens.fetchSample(signalwert, 0);
            return signalwert[0];
        }else
            throw new UnsupportedOperationException("Gyrosensor not initialized.");
    }

    protected static float getColorL(){
        if(colorSensL!=null) {
            float signalwert[] = new float[colorSensL.sampleSize()];
            colorSensL.fetchSample(signalwert, 0);
            return signalwert[0];
        }else
            throw new UnsupportedOperationException("Color Sensor Left not initialized.");
    }
    protected static float getColorR(){
        if(colorSensR!=null) {
            float signalwert[] = new float[colorSensR.sampleSize()];
            colorSensR.fetchSample(signalwert, 0);
            return signalwert[0];
        }else
            throw new UnsupportedOperationException("Color Sensor Right not initialized.");
    }
    protected static void stop(){
        motorL.stop();
        motorR.stop();
    }

    protected static void forward(){
        motorL.forward();
        motorR.forward();
    }

    protected static void forward(int milis){
        forward();
        delay(milis);
        stop();
    }

    protected static void backward(){
        motorL.backward();
        motorR.backward();
    }

    protected static void backward(int milis){
        backward();
        delay(milis);
        stop();
    }

    protected static void turnRight(){
        motorL.forward();
        motorR.backward();
    }

    protected static void turnRight(int milis){
        turnRight();
        delay(milis);
        stop();
    }

    protected static void turnLeft(){
        motorL.forward();
        motorR.backward();
    }

    protected static void turnLeft(int milis){
        turnLeft();
        delay(milis);
        stop();
    }
}
