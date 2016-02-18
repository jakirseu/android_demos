package me.jakir.localxmlparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView1);

        List<Food> foods = null;
        try {
            XmlParser parser = new XmlParser();
            InputStream content = getAssets().open("food.xml");
            foods = parser.parse(content);

            ArrayAdapter<Food> adapter =new ArrayAdapter<Food>
                    (this,android.R.layout.simple_list_item_1, foods);
            listView.setAdapter(adapter);

        } catch (IOException e) {e.printStackTrace();}

    }
}