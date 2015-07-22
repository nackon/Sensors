package com.nackon.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class SensorActivityFragment extends Fragment {
    int mSensorType;
    SensorManager mSensorManager;
    private Sensor mSensor;

    public SensorActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(listener);
        mSensor = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        mSensorType = getActivity().getIntent().getIntExtra(Utils.SENSORTYPE, 0);
        mSensor = mSensorManager.getDefaultSensor(mSensorType);
        mSensorManager.registerListener(listener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            TextView v = (TextView)getActivity().findViewById(R.id.accuracy);
            v.setText("accuracy" + Integer.toString(accuracy));

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            StringBuilder ev = new StringBuilder("Sensor event:" + Utils.sensorTypeToName(event.sensor.getType()) + "\n");
            ev.append("accuracy = " + event.accuracy + "\n")
              .append("timestamp = " + event.timestamp + " nanosec" + "\n");
            for (float v: event.values)
            {
                ev.append("value = " + v + "\n");
            }
            ev.append(event.sensor.toString() + "\n");


            TextView v = (TextView)getActivity().findViewById(R.id.sensor);
            v.setText(ev);

        }
    };
}
