package me.jakir.androidxmlparsing;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button loadXML;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set main activity
        setContentView(R.layout.activity_main);
        // reference to view
        loadXML =(Button) findViewById(R.id.loadXML);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        loadXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (isOnline()){
                     BackgroundTask task = new BackgroundTask(MainActivity.this);
                      task.execute("http://www.w3schools.com/xml/simple.xml");
                 }
            }
        });
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }else return false;
    }

}
