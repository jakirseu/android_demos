package me.jakir.listviewtoactivity;

/**
 * Created by Jack on 2/17/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItem extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_item);

        TextView billionaireLabel = (TextView) findViewById(R.id.billionaire_label);
        TextView billionaireInfo = (TextView) findViewById(R.id.billionaire_info);

        // get data
        Intent i = getIntent();
        String billionaireName = i.getStringExtra("billionaireName");

        // set data to view
        billionaireLabel.setText(billionaireName);
        billionaireInfo.setText("Something cool about " + billionaireName);

    }
}