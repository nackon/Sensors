package com.nackon.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nackon on 2015/07/22.
 */
public class SensorArrayAdapter<T> extends ArrayAdapter<T> {

    public SensorArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public SensorArrayAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }

    public SensorArrayAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
    }

    public SensorArrayAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public SensorArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public SensorArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        super(context, resource, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        if (v instanceof TextView) {
            T item = getItem(position);
            if (item instanceof Sensor) {
                int type = ((Sensor) item).getType();
                String ts = Utils.sensorTypeToName((Sensor)item);
                ((TextView)v).setText(ts);
            }
        }
        return v;
    }


}
