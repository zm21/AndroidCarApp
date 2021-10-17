package com.example.shopauto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClickRegister(View view) {
        TextInputLayout textFieldEmail = findViewById(R.id.textFieldEmail);
        TextInputEditText txtEmail = findViewById(R.id.txtEmail);
        String text = txtEmail.getText().toString();
        if(text.isEmpty())
        {
            textFieldEmail.setError("Вкажіть пошту");
        }
        else {
            textFieldEmail.setError("");
        }
    }
}