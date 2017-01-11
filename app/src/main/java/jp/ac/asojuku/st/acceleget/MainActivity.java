package jp.ac.asojuku.st.acceleget;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        StringBuilder stringBuild = new StringBuilder();

        stringBuild.append("X軸");
        stringBuild.append(event.values[0]);
        stringBuild.append("\n");
        stringBuild.append("Y軸");
        stringBuild.append(event.values[1]);
        stringBuild.append("\n");
        stringBuild.append("Z軸");
        stringBuild.append(event.values[2]);
        stringBuild.append("\n");

        TextView txt01= (TextView)findViewById(R.id.txt01);
        txt01.setText(stringBuild.toString());


    }
}
