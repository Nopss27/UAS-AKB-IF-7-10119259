package com.naufal.mydiary10119259;

/*
 * Naufal Daffa Ilyasa
 * 10119259
 * IF7*/

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialized firebase auth
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticateUser();
            }
        });

        TextView tvSwitchToRegister = findViewById(R.id.tvSwitchToRegister);
        tvSwitchToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToRegister();
            }
        });
    }

   private void authenticateUser() {
       EditText etLoginEmail = findViewById(R.id.etLoginEmail);
       EditText etLoginPassword = findViewById(R.id.etLoginPassword);

       String email = etLoginEmail.getText().toString();
       String password = etLoginPassword.getText().toString();

       if (email.isEmpty() || password.isEmpty()) {
           Toast.makeText(this, "Tolong isi semua textfield", Toast.LENGTH_LONG).show();
           return;
       }

       mAuth.signInWithEmailAndPassword(email, password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           showNotesActivity();
                       } else {
                           Toast.makeText(LoginActivity.this, "Authentication failed.",
                                   Toast.LENGTH_SHORT).show();
                       }
                   }
               });
   }

   private void showNotesActivity() {
       Intent intent = new Intent(this, NewNotes.class);
       startActivity(intent);
       finish();
   }

    private void switchToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}