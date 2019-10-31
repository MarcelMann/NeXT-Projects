package next.api;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class SpaceSensorApi {
    protected static float getDistance(EV3UltrasonicSensor usSens){
        if (usSens!=null) {
            float values[] = new float[usSens.sampleSize()];
            usSens.fetchSample(values, 0);
            return values[0];
        }else
            throw new UnsupportedOperationException("Ultrasonic Sensor not initialized.");
    }

    protected static float getAngle(EV3GyroSensor gyroSens){
        if (gyroSens != null) {
            float values[] = new float[gyroSens.sampleSize()];
            gyroSens.fetchSample(values, 0);
            return values[0];
        }else
            throw new UnsupportedOperationException("Gyrosensor not initialized.");
    }

    protected static float getColor(EV3ColorSensor colorSens){
        if(colorSens!=null) {
            float values[] = new float[colorSens.sampleSize()];
            colorSens.fetchSample(values, 0);
            return values[0];
        }else
            throw new UnsupportedOperationException("Color Sensor Left not initialized.");
    }
}
