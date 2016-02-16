package me.jakir.bangla;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sonar_bangla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sonar_bangla = (TextView) findViewById(R.id.sonar_bangla);
        Typeface font= Typeface.createFromAsset(getAssets(), "kalpurush.ttf");
        sonar_bangla.setTypeface(font);
    }
}
