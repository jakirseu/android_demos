package me.jakir.gson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    TextView jsonView, objectView;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        jsonView = (TextView) findViewById(R.id.jsonView);
        objectView = (TextView) findViewById(R.id.objectView);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend friend = new Friend();
                friend.setName("Elon Musk");
                friend.setEmail("Elonmuskoffice@spacex.com");

                //Object to JSON
                jsonView.setText(gson.toJson(friend));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // JSON to Object
                objectView.setText(String.valueOf((
                        gson.fromJson("{\"email\":\"Elonmuskoffice@spacex.com\",\"name\":\"Elon Musk\"}",
                                Friend.class))));
            }
        });



    }
}
