package com.soulone.saywithpics.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.soulone.saywithpics.R;


public class EmailSingInActivy extends AppCompatActivity {
    private static final String TAG = "Login Activity";
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicialize();
        setContentView(R.layout.activity_email_sing_in_activy);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Button btnLoginEmail = findViewById(R.id.btnSubmitSingin);
        final EditText edtCorreo = findViewById(R.id.singin_edtCorreo);
        final EditText edtContraseña = findViewById(R.id.singin_edtContraseña);
        FloatingActionButton fab = findViewById(R.id.fabCrearRutina);


        //Config Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Volver al inicio");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Programaticamente

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
                LoginEmail(edtCorreo.getText().toString(), edtContraseña.getText().toString());

            }
        });
    }

    private void inicialize() {
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseAuth != null) {
                    Log.w(TAG, "onAuthStateChanged - singned_in " + firebaseUser.getUid());
                    Log.w(TAG, "onAuthStateChanged - singned_in " + firebaseUser.getEmail());
                } else {
                    Log.w(TAG, "onAuthStateChanged - singned_out");
                }
            }
        };
    }

    private void LoginEmail(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(EmailSingInActivy.this, "Usted esta logeado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EmailSingInActivy.this,TutorialActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(EmailSingInActivy.this, "Un error a ocurrido :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}
