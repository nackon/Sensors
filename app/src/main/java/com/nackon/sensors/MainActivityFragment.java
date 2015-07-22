package com.nackon.sensors;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    SensorManager mSensorManager;
    Context mContext;
    SensorArrayAdapter<Sensor> mSensorListAdapter;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = (Context)getActivity();
        mSensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> allSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        ListView slv = (ListView)getActivity().findViewById(R.id.sensorlist);
        mSensorListAdapter = new SensorArrayAdapter<Sensor>(mContext, R.layout.rowdata, allSensors);
        slv.setAdapter(mSensorListAdapter);
        slv.setOnItemClickListener(listener);

        for (Sensor s: allSensors)
        {
            Log.v("SensorActivity", s.toString());
        }

    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id)
        {
            Sensor s = (Sensor)mSensorListAdapter.getItem(position);
            Intent intent = new Intent();
            intent.setClassName(mContext.getPackageName(), "com.nackon.sensors.SensorActivity");
            intent.putExtra(Utils.SENSORTYPE, s.getType());

            startActivity(intent);

        }
    };

}
