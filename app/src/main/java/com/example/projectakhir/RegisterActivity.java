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

public class RegisterActivity extends AppCompatActivity {

    EditText REmail;
    EditText RPassword;
    EditText RconPassword;
    Button RbtnRegis;
    TextView RbtnLogin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        REmail = findViewById(R.id.txtEmailreg);
        RPassword = findViewById(R.id.txtPassreg);
        RconPassword = findViewById(R.id.txtConPassreg);
        RbtnRegis = findViewById(R.id.btnRegister);
        RbtnLogin = findViewById(R.id.txtLoginreg);

        fAuth = FirebaseAuth.getInstance();

        RbtnLogin.setOnClickListener(v -> {
            String email = REmail.getText().toString().trim();
            String password = RPassword.getText().toString().trim();
            String cpassword = RconPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)){
                REmail.setError("Email dulu gan");
                return;
            }
            if (TextUtils.isEmpty(password)){
                RPassword.setError("Password dulu gan");
                return;
            }
            if (password.length() < 6){
                RPassword.setError("Password harus lebih dari 6 gan");
                return;
            }
            if (!password.equals(cpassword)){
                RPassword.setError("Password ngga sama gan");
            }
            else {
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Register Aman Gan", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        RbtnLogin.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));

    }
}
