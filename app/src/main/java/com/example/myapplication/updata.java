package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updata extends AppCompatActivity {

    Button updateFeedback;
    TextView feedback,name;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_updata);

        feedback = (TextView)findViewById(R.id.feedback);
        name = (TextView)findViewById(R.id.name);
        updateFeedback =findViewById(R.id.update);

        reference =FirebaseDatabase.getInstance().getReference().child("feedback");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String username = dataSnapshot.child("name").getValue().toString();
                String userfeedback = dataSnapshot.child("feedback").getValue().toString();


                name.setText(username);
                feedback.setText(userfeedback);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        updateFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = FirebaseDatabase.getInstance().getReference().child("feedback");

                String Uname,Ufeedback;

                Ufeedback = feedback.getText().toString();
                Uname = name.getText().toString();

                UserFeedback addnews = new UserFeedback(Uname,Ufeedback);

                reference.setValue(addnews);
                Toast.makeText(updata.this,"your feedback is updated successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(updata.this,Feedback.class);
                updata.this.startActivity(intent);
                updata.this.finish();
            }
        });

    }

}