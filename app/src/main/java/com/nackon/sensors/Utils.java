package com.nackon.sensors;

import android.hardware.Sensor;
import android.os.Build;

/**
 * Created by nackon on 2015/07/22.
 */
public class Utils {
    static String SENSORTYPE = "sensor_type";

    static public String sensorTypeToName(Sensor sensor)
    {
        if (Build.VERSION.SDK_INT >= 20)
        {
            return sensor.getStringType() + "\n" + sensorTypeToName(sensor.getType());
        }  else {
            return sensorTypeToName(sensor.getType());
        }
    }
    static public String sensorTypeToName(int type)
    {
        switch (type)
        {
            case Sensor.TYPE_ACCELEROMETER:return "TYPE_ACCELEROMETER";
            case Sensor.TYPE_MAGNETIC_FIELD:return "TYPE_MAGNETIC_FIELD";
            case Sensor.TYPE_ORIENTATION:return "TYPE_ORIENTATION";
            case Sensor.TYPE_GYROSCOPE:return "TYPE_GYROSCOPE";
            case Sensor.TYPE_LIGHT:return "TYPE_LIGHT";
            case Sensor.TYPE_PRESSURE:return "TYPE_PRESSURE";
            case Sensor.TYPE_TEMPERATURE:return "TYPE_TEMPERATURE";
            case Sensor.TYPE_PROXIMITY:return "TYPE_PROXIMITY";
            case Sensor.TYPE_GRAVITY:return "TYPE_GRAVITY";
            case Sensor.TYPE_LINEAR_ACCELERATION:return "TYPE_LINEAR_ACCELERATION";
            case Sensor.TYPE_ROTATION_VECTOR:return "TYPE_ROTATION_VECTOR";
            case Sensor.TYPE_RELATIVE_HUMIDITY:return "TYPE_RELATIVE_HUMIDITY";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:return "TYPE_AMBIENT_TEMPERATURE";
            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:return "TYPE_MAGNETIC_FIELD_UNCALIBRATED";
            case Sensor.TYPE_GAME_ROTATION_VECTOR:return "TYPE_GAME_ROTATION_VECTOR";
            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:return "TYPE_GYROSCOPE_UNCALIBRATED";
            case Sensor.TYPE_SIGNIFICANT_MOTION:return "TYPE_SIGNIFICANT_MOTION";
            case Sensor.TYPE_STEP_DETECTOR:return "TYPE_STEP_DETECTOR";
            case Sensor.TYPE_STEP_COUNTER:return "TYPE_STEP_COUNTER";
            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:return "TYPE_GEOMAGNETIC_ROTATION_VECTOR";
            case Sensor.TYPE_HEART_RATE:return "TYPE_HEART_RATE";
//            case Sensor.TYPE_TILT_DETECTOR:return "TYPE_TILT_DETECTOR";
//            case Sensor.TYPE_WAKE_GESTURE:return "TYPE_WAKE_GESTURE";
//            case Sensor.TYPE_GLANCE_GESTURE:return "TYPE_GLANCE_GESTURE";
//            case Sensor.TYPE_PICK_UP_GESTURE:return "TYPE_PICK_UP_GESTURE";
//            case Sensor.TYPE_MOTION_ACCEL:return "TYPE_MOTION_ACCEL";
            case Sensor.TYPE_ALL:return "TYPE_ALL";
        }

        return "UNKNOWN:" + Integer.toString(type);
    }

}
