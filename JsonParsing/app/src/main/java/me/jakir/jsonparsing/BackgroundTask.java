package me.jakir.jsonparsing;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class BackgroundTask extends AsyncTask<String, String, String> {

    Activity mainActivity;
    ProgressBar progressBar;
    TextView output;
    List<Food> foodList;


    public BackgroundTask(Activity activity) {
        mainActivity = activity;
    }


    @Override
    protected void onPreExecute() {
        // show progress bar
        progressBar = (ProgressBar) mainActivity.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... params) {

        String content = getData(params[0]);
        return content;
    }


    @Override
    protected void onPostExecute(String result) {
        // Hide Progress bar
        progressBar.setVisibility(View.INVISIBLE);
        output = (TextView) mainActivity.findViewById(R.id.output);


        foodList = JsonParser.parse(result);


        if (foodList != null) {
            for (Food foodItem : foodList) {
                output.append("working!");
                output.append("Item name: " + foodItem.getName() + "\n");
                output.append("Item price: " + foodItem.getPrice() + "\n");
                output.append("Item Description: " + foodItem.getDescription() + "\n \n \n");


            }
        }


    }


    // Method for get JSON data using HTTP Request
    private String getData(String uri) {
        BufferedReader reader;

        try {
            URL url = new URL(uri);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            StringBuilder stringBuilder = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}


