package todo.javatechig.com.acti14;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private Sensor sensor;
    private SensorManager sensorManager;
    private TextView Distance;
    private TextView Heat;
    private TextView Lux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Distance = (TextView) findViewById(R.id.textView);
        Heat = (TextView) findViewById(R.id.textView2);
        Lux = (TextView) findViewById(R.id.textView3);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,sensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Distance.setText("X = "+sensorEvent.values[0]);
        Heat.setText("Y = "+sensorEvent.values[1]);
        Lux.setText("Z = "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
