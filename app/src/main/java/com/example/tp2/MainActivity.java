package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.LoginID);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = ((EditText)findViewById(R.id.UserNameID)).getText().toString();
                String pass = ((EditText)findViewById(R.id.PasswordID)).getText().toString();
                String name = ((EditText)findViewById(R.id.NameID)).getText().toString();

                if(nom.equals("isitcom") && pass.equals("0000")){
                    if(name.isEmpty()){
                        Toast.makeText(getApplicationContext(),
                                "Name field should not be empty !",Toast.LENGTH_LONG).show();
                    }else{
                        Intent i = new Intent(MainActivity.this,profile.class);
                        startActivity(i);
                    }

                }else{
                    Toast.makeText(getApplicationContext(),
                            "UserName or Password incorrect !",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button e = (Button)findViewById(R.id.ExitID1);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });


    }
}