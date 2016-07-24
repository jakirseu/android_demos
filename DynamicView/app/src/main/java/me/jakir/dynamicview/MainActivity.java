package me.jakir.dynamicview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd;
    LinearLayout linearLayout;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        linearLayout = (LinearLayout) (findViewById(R.id.main));

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnAdd)
        {
            tv = new TextView(this);
            tv.setText("This text added dynamically.");
            tv.setTextColor(0xff000000);
            linearLayout.addView(tv);


        }
    }
}
