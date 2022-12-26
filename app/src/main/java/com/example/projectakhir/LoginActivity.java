package com.example.projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassworrd;
    Button btnLogin;
    TextView txtReg;

    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        edtEmail = findViewById(R.id.txtEmaillog);
        edtPassworrd = findViewById(R.id.txtPasslog);
        btnLogin = findViewById(R.id.btnLogin);
        txtReg = findViewById(R.id.txtRegisLog);

        fAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            String email = edtEmail.getText().toString().trim();
            String password = edtPassworrd.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                edtEmail.setError("Email dulu gan");
                return;
            }
            if(TextUtils.isEmpty(password)){
                edtPassworrd.setError("Password dulu gan");
                return;

            }
            if(password.length() < 6){
                edtPassworrd.setError("Password Must be >= 6 Characters.");
            }
            else {
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnLogin.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
        txtReg.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));
    }
}