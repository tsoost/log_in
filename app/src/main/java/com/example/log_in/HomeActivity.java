package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    private Button login;
    private Button signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            setContentView(R.layout.activity_home);
            login = (Button) findViewById(R.id.login);
            signup = (Button) findViewById(R.id.sign_up);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);

                }
            });
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(HomeActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}