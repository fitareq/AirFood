package com.airmoll.airfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.airmoll.airfood.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);


        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }

    private void registerNewUser()
    {
        String username = binding.registerUsernameEdttxt.getText().toString();
        String email = binding.registerEmailEdttxt.getText().toString();
        String phone = binding.registerPhoneEdttxt.getText().toString();
        String password = binding.registerPasswordEdttxt.getText().toString();
        String confirmPassword = binding.registerConfirmPasswordEdttxt.getText().toString();

        if (TextUtils.isEmpty(username))
        {
            binding.registerUsername.setError("Required Field");
        }else if(TextUtils.isEmpty(email))
        {
            binding.registerEmail.setError("Required Field");
        }else if (TextUtils.isEmpty(phone))
        {
            binding.registerPhone.setError("Required Field");
        }else if (TextUtils.isEmpty(password))
        {
            binding.registerPassword.setError("Required Field");
        }else if(!TextUtils.equals(password,confirmPassword))
        {
            binding.registerPasswordEdttxt.setError("Password didn't match");
        }
    }
}