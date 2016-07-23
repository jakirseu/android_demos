package me.jakir.firebaserealtimedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView mNameTextView;
    EditText mNameEditText;
    Button mButtonUpdate;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRef = mRootRef.child("name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI elements

        mNameTextView = (TextView)findViewById(R.id.textViewName);
        mNameEditText = (EditText) findViewById(R.id.editTextName);
        mButtonUpdate = (Button)findViewById(R.id.buttonUpdate);



    }

    @Override
    protected void onStart() {
        super.onStart();
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               String text = dataSnapshot.getValue(String.class);
                mNameTextView.setText(text);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue(mNameEditText.getText().toString());
            }
        });


    }
}
