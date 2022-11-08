package com.example.petdetect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainLogin extends AppCompatActivity{

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // initializing all our variables.
        /// = findViewById(R.id./);
        /// = findViewById(R.id./);
       // / = findViewById(R.id./);
       // / = findViewById(R.id./);
       // / = findViewById(R.id./);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainLogin.this);

        addNewEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
