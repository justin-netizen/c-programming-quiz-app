package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showUsernameInputDialog();
            }
        }, SPLASH_TIMEOUT);
    }

    private void showUsernameInputDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_username_input, null);
        dialogBuilder.setView(dialogView);

        final TextInputEditText usernameEditText = dialogView.findViewById(R.id.usernameEditText);

        dialogBuilder.setTitle("Hello! Please enter your name.");
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String enteredUsername = usernameEditText.getText().toString().trim();
                if (!enteredUsername.isEmpty()) {
                    // Start the MainActivity and pass the username as an extra
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra("username", enteredUsername);
                    startActivity(intent);
                    finish();
                } else {
                    showUsernameInputDialog();
                }
            }
        });

        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }
}
