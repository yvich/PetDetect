package com.example.petdetect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petdetect.DBHandler;

public class MainLogin extends AppCompatActivity {
    private EditText emailAdd, pass;
    private Button signIn, forgotPassword, signUp;
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

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  String emailAddress = emailAdd.getText().toString();
                String password = pass.getText().toString();

                // validating if the text fields are empty or not.
                if (emailAddress.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainLogin.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewEmail(emailAddress, password);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainLogin.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                emailAdd.setText("");
                pass.setText(""); */
            }

    }
}
