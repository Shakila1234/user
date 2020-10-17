package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFeedback extends AppCompatActivity {

    Button submit;
    TextView Uname,Ufeedback;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);

        submit = findViewById(R.id.button9);
        Uname= findViewById(R.id.textView);
        Ufeedback = findViewById(R.id.feedback);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("feedback");

                //get values

                String name = Uname.getText().toString();
                String feedback = Ufeedback.getText().toString();

                if (TextUtils.isEmpty(Uname.getText().toString())){
                    Toast.makeText(AddFeedback.this,"no empty details allowed",Toast.LENGTH_SHORT).show();
                }else{

                UserFeedback addFeedback = new UserFeedback(name,feedback);


                    reference.setValue(addFeedback);
                    Toast.makeText(AddFeedback.this,"your feedback is successfully added",Toast.LENGTH_SHORT).show();

                }}


        });

    }
}