package me.jakir.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Realm realm;
    private RealmConfiguration realmConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realmConfig = new RealmConfiguration.Builder(this).name("test1.realm").build();
        realm = Realm.getInstance(realmConfig);



        realm.beginTransaction();

        // Create an object
        realm.where(Country.class).findAll().clear();
        Country country1 = realm.createObject(Country.class);
        // Set its fields
        country1.setName("Norway");
        country1.setPopulation(5165800);

        Country country2 = realm.createObject(Country.class);
        // Set its fields
        country2.setName("Bangladesh");
        country2.setPopulation(5165800);
        Country country3 = realm.createObject(Country.class);
        // Set its fields
        country3.setName("India");
        country3.setPopulation(10165800);

        realm.commitTransaction();



        RealmResults<Country> results1 =
                realm.where(Country.class).findAll();

        for(Country c:results1) {
            Log.d("results1", c.getName());
        }

// Prints Norway, Russia


    }
}
