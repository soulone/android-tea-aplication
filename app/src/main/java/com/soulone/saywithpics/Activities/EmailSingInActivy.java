package com.soulone.saywithpics.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.soulone.saywithpics.R;


public class EmailSingInActivy extends AppCompatActivity {

    Button btnLoginEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sing_in_activy);

        Toolbar toolbar = findViewById(R.id.toolbar);
        btnLoginEmail =  findViewById(R.id.btnLoginEmail);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Volver al inicio");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnLoginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginEmail();
            }
        });
    }

    private void LoginEmail() {
        Intent intent = new Intent(this,TutorialActivity.class);
        startActivity(intent);
    }

}
