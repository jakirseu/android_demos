package me.jakir.sqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editName, editEmail, editID;
    TextView tvData;
    Button btnAdd, btnView, btnUpdate, btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.textName);
        editEmail = (EditText) findViewById(R.id.textEmail);
        editID = (EditText) findViewById(R.id.textID);

        tvData = (TextView) findViewById(R.id.tvData);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);


        addData();
        viewAll();
        updateData();
        deleteData();

    }


    public void addData(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted =  myDB.insertData(editName.getText().toString(), editEmail.getText().toString());

                if(isInserted == true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Insert failed", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void viewAll(){
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDB.getAllData();
                if(res.getCount() == 0){

                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_LONG).show();


                    return;
                }else {

                    StringBuffer buffer = new StringBuffer();

                    while (res.moveToNext()){
                        buffer.append("Id: " + res.getString(0) + "\n");
                        buffer.append("Name: " + res.getString(1) + "\n");
                        buffer.append("Email: " + res.getString(2) + "\n \n");

                    }

                    tvData.setText(buffer.toString());
                }
            }
        });
    }


    public void updateData(){

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = myDB.updateData( editID.getText().toString(),
                        editName.getText().toString(), editEmail.getText().toString());

                if (isUpdated == true)

                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
                else

                    Toast.makeText(MainActivity.this, "Not updated", Toast.LENGTH_LONG).show();


            }
        });
    }

    public void deleteData(){

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer isDeleted = myDB.deleteData(editID.getText().toString());

                if (isDeleted > 0)
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Not deleted", Toast.LENGTH_LONG).show();

            }
        });
    }


}
