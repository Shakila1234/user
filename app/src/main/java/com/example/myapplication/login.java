package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Active.Prevalent;
import com.example.myapplication.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    Button LoginButton, RegisterButton;
    private EditText InputPhoneNumber, InputPassword;
    // Button LoginButton; //RegisterButton;
    private ProgressDialog loadingBar;
    private TextView AdminLink, NotAdminLink;

    private String parentDbName = "Users";


    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LoginButton = findViewById(R.id.button);

        LoginButton = (Button) findViewById(R.id.button);
        RegisterButton = (Button) findViewById(R.id.button2);
        InputPassword = (EditText) findViewById(R.id.editTextTextPersonName2);
        InputPhoneNumber = (EditText) findViewById(R.id.editTextTextPersonName);
        AdminLink = (TextView) findViewById(R.id.adminLoginText);
        NotAdminLink = (TextView) findViewById(R.id.userLoginText);
        loadingBar = new ProgressDialog(this);

        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }

        });
        /*
        button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Toast.makeText(login.this, "you are successfully login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this, profileView.class);
                startActivity(intent);
            }
        });*/


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, userPanel.class);
                startActivity(intent);
                //LoginUser();

            }
        });



       /* LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginUser();
            }
        });*/

       /* RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";
            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }



    private void LoginUser()
    {
        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please enter your phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please enter your password...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            AllowAccessToAccount(phone, password);
        }
    }



    private void AllowAccessToAccount(final String Phone, final String password)
    {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.child(parentDbName).child(Phone).exists())
                {
                    Users usersData = dataSnapshot.child(parentDbName).child("Phone").getValue(Users.class);

                    if (usersData.getPhone().equals(Phone))
                    {
                        if (usersData.getPassword().equals(password))
                        {
                            if (parentDbName.equals("Admins"))
                            {
                                Toast.makeText(login.this, "Welcome Admin, you are logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(login.this,userPanel.class);
                                startActivity(intent);

                                /*Intent intent = new Intent(login.this, MainActivity4.class);
                                startActivity(intent);*/
       /*
                            }
                            else if (parentDbName.equals("Users"))
                            {
                                Toast.makeText(login.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(login.this,userPanel.class);
                                startActivity(intent);

                            }
                        }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(login.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(login.this, "Account with this " + Phone + " number do not exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
        }
    }

    @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/
    }
}
