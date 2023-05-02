package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputEditText emailEdt, passwordEdt, cnfPasswordEdt, locationEdt;
    private Button registerBtn;
    private ProgressBar loadingPB;
    private TextView loginTV;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //init
        emailEdt = findViewById(R.id.idEdtEmail);
        passwordEdt = findViewById(R.id.idEdtPassword);
        cnfPasswordEdt = findViewById(R.id.idEdtCnfPassword);
        locationEdt = findViewById(R.id.idEdtLocation);
        registerBtn = findViewById(R.id.idBtnRegister);
        loadingPB = findViewById(R.id.idPBLoading);
        loginTV = findViewById(R.id.idTVLogin);
        mAuth = FirebaseAuth.getInstance();

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingPB.setVisibility(View.VISIBLE);

                String email = emailEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                String cnfPassword = cnfPasswordEdt.getText().toString();

                if (!password.equals(cnfPassword)) {
                    Toast.makeText(RegistrationActivity.this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(cnfPassword)) {
                    Toast.makeText(RegistrationActivity.this, "모든 항목을 입력해주십시오", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                loadingPB.setVisibility(View.GONE);
                                Toast.makeText(RegistrationActivity.this, "회원가입 되었습니다", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                loadingPB.setVisibility(View.GONE);
                                Toast.makeText(RegistrationActivity.this, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}