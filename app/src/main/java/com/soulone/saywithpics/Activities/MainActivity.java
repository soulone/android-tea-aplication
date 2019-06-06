package com.soulone.saywithpics.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.soulone.saywithpics.R;

public class MainActivity extends AppCompatActivity {

    public Button btninicioSesion;
    public Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninicioSesion = findViewById(R.id.main_btninicioSesion);
        btnRegistrar =  findViewById(R.id.main_btnRegistrar);

        btninicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irEmailInicioSesion();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irEmailRegistro();
            }
        });
    }

    private void irEmailRegistro() {
        Intent intent = new Intent(this, EmailRegistrerActivity.class);
        startActivity(intent);
    }

    private void irEmailInicioSesion() {
        Intent intent = new Intent(this, EmailSingInActivy.class);
        startActivity(intent);
    }
}
