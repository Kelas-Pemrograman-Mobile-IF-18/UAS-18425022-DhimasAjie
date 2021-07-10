package com.david.projekdhimas.pelanggan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.david.projekdhimas.R;
import com.david.projekdhimas.server.BaseURL;
import com.squareup.picasso.Picasso;

public class DetailHotel extends AppCompatActivity {

    EditText edtNomorKamar, edtTipeKamar, edtDeskripsiKamar, edtHargaKamar;
    ImageView imgGambarHotel;
    String strNomorKamar, strTipeKamar, strDeskripsiKamar, strHargaKamar, strGambar, _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        edtNomorKamar = (EditText) findViewById(R.id.edtNomorKamarD);
        edtTipeKamar = (EditText) findViewById(R.id.edtTipeKamarD);
        edtDeskripsiKamar = (EditText) findViewById(R.id.edtDeskripsiKamarD);
        edtHargaKamar = (EditText) findViewById(R.id.edtHargaKamarD);

        imgGambarHotel = (ImageView) findViewById(R.id.gambar);

        Intent i = getIntent();
        strNomorKamar = i.getStringExtra("nomorKamar");
        strTipeKamar = i.getStringExtra("tipeKamar");
        strDeskripsiKamar = i.getStringExtra("deskripsiKamar");
        strHargaKamar = i.getStringExtra("hargaKamar");
        strGambar = i.getStringExtra("gambar");
        _id = i.getStringExtra("_id");

        edtNomorKamar.setText(strNomorKamar);
        edtTipeKamar.setText(strTipeKamar);
        edtDeskripsiKamar.setText(strDeskripsiKamar);
        edtHargaKamar.setText(strHargaKamar);
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + strGambar)
                .into(imgGambarHotel);
    }
}