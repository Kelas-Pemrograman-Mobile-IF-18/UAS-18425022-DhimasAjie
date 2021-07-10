package com.david.projekdhimas.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.david.projekdhimas.R;
import com.david.projekdhimas.session.PrefSetting;
import com.david.projekdhimas.session.SessionManager;
import com.david.projekdhimas.user.Login;

public class HomeAdmin extends AppCompatActivity {

    CardView cardInput, cardEditData,cardProfile, cardExit;
    SessionManager session;
    SharedPreferences prefs;
    PrefSetting prefSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        getSupportActionBar().hide();

        prefSetting = new PrefSetting(this);
        prefs = prefSetting.getSharePreferances();

        session = new SessionManager(HomeAdmin.this);

        prefSetting.isLogin(session, prefs);

        cardInput = (CardView) findViewById(R.id.cardInput);
        cardEditData = (CardView) findViewById(R.id.cardData);
        cardProfile = (CardView) findViewById(R.id.cardProfile);
        cardExit = (CardView) findViewById(R.id.cardExit);

        cardInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdmin.this, InputData.class);
                startActivity(i);
                finish();
            }
        });

        cardEditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdmin.this, DataHotel.class);
                startActivity(i);
                finish();
            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdmin.this, Profile.class);
                startActivity(i);
                finish();
            }
        });

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setLogin(false);
                session.setSessid(0);
                Intent i = new Intent(HomeAdmin.this, Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}