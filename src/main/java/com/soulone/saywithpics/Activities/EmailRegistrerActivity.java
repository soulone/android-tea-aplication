package com.soulone.saywithpics.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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

public class EmailRegistrerActivity extends AppCompatActivity {

    private static final String TAG ="Register Activity" ;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicialize();
        setContentView(R.layout.activity_email_registrer);

        Button btnRegistrerEmail        = findViewById(R.id.btnSubmitRegister);
        Toolbar toolbar                 = findViewById(R.id.toolbar);
        FloatingActionButton fab        = findViewById(R.id.fabCrearRutina);
        final EditText edtCorreo              = findViewById(R.id.registro_edtCorreo);
        EditText edtusuario             = findViewById(R.id.registro_edtUsuario);
        final EditText edtPass                = findViewById(R.id.registro_edtContraseña);
        final EditText edtPassConfirm         = findViewById(R.id.registro_edtContraseVerificador);

        //Toolbar Config
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Volver al inicio");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Floating Action
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              fabAction();
            }
        });
        //Btn Register Email Submit
        btnRegistrerEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerEmail(edtCorreo.getText().toString(),edtPass.getText().toString());
            }
        });

    }

    private void fabAction() {
        Toast.makeText(this, "FAB ACTION", Toast.LENGTH_SHORT).show();
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

    private void registerEmail(String email , String password) {
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(EmailRegistrerActivity.this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EmailRegistrerActivity.this,EmailSingInActivy.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(EmailRegistrerActivity.this, "Un error a ocurrido :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
