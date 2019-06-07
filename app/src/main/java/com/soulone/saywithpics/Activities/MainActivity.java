package com.soulone.saywithpics.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.soulone.saywithpics.R;

public class MainActivity extends AppCompatActivity {


    private static final String TAG ="Main Activity" ;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    public Button btninicioSesion;
    public Button btnRegistrar;
    public TextView linkOlvideContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicialize();
        setContentView(R.layout.activity_main);

        btninicioSesion = findViewById(R.id.btnGotoSingIn);
        btnRegistrar =  findViewById(R.id.btnGotoRegister);
        linkOlvideContraseña = findViewById(R.id.linkgotoForgotPassword);

        linkOlvideContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperarContraseña();
            }
        });
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

    private void recuperarContraseña(String email) {
FirebaseAuth auth =  FirebaseAuth.getInstance();
String emailAddres =  "user@example.com";
auth.sendPasswordResetEmail(emailAddres)
        .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d(TAG,"Notificacion Enviada");
                }
            }
        });
    }

    private void inicialize() {
        firebaseAuth  = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseAuth != null){
                    Log.w(TAG,"onAuthStateChanged - singned_in "+ firebaseUser.getUid());
                    Log.w(TAG,"onAuthStateChanged - singned_in "+ firebaseUser.getEmail());
                }else {
                    Log.w(TAG,"onAuthStateChanged - singned_out");
                }
            }
        };
    }

    private void irEmailRegistro() {
        Intent intent = new Intent(this, EmailRegistrerActivity.class);
        startActivity(intent);
        finish();
    }

    private void irEmailInicioSesion() {
        Intent intent = new Intent(this, EmailSingInActivy.class);
        startActivity(intent);
        finish();
    }
}
