package com.david.projekdhimas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.david.projekdhimas.R;
import com.david.projekdhimas.session.PrefSetting;

public class Profile extends AppCompatActivity {

    TextView txtUsername, txtNamaLengkap, txtEmail, txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("Profile User");

        txtUsername = (TextView) findViewById(R.id.userName);
        txtNamaLengkap = (TextView) findViewById(R.id.namaLengkap);
        txtEmail = (TextView) findViewById(R.id.emailAdmin);
        txtPhone = (TextView) findViewById(R.id.phoneAdmin);

        txtUsername.setText(PrefSetting.userName);
        txtNamaLengkap.setText(PrefSetting.namaLengkap);
        txtEmail.setText(PrefSetting.email);
        txtPhone.setText(PrefSetting.noTelp);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Profile.this, HomeAdmin.class);
        startActivity(i);
        finish();
    }
}