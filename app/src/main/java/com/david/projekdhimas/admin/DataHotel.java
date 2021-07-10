package com.david.projekdhimas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.david.projekdhimas.R;
import com.david.projekdhimas.adapter.AdapterHotel;
import com.david.projekdhimas.model.ModelHotel;
import com.david.projekdhimas.server.BaseURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataHotel extends AppCompatActivity {

    ProgressDialog pDialog;

    AdapterHotel adapter;
    ListView list;

    ArrayList<ModelHotel> newsList = new ArrayList<ModelHotel>();
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_hotel);
        getSupportActionBar().setTitle("Data Hotel");
        mRequestQueue = Volley.newRequestQueue(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        list = (ListView) findViewById(R.id.array_list);
        newsList.clear();
        adapter = new AdapterHotel(DataHotel.this, newsList);
        list.setAdapter(adapter);
        getAllHotel();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(DataHotel.this, HomeAdmin.class);
        startActivity(i);
        finish();
    }

    private void getAllHotel() {
        // Pass second argument as "null" for GET requests
        pDialog.setMessage("Loading");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, BaseURL.LihatData, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            if (status == false) {
                                Log.d("data kamar = ", response.toString());
                                String data = response.getString("data");
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    final ModelHotel hotel = new ModelHotel();
                                    final String _id = jsonObject.getString("_id");
                                    final String NomorKamar = jsonObject.getString("nomorKamar");
                                    final String TipeKamar = jsonObject.getString("tipeKamar");
                                    final String DeskripsiKamar = jsonObject.getString("deskripsiKamar");
                                    final String HargaKamar = jsonObject.getString("hargaKamar");
                                    final String gambar = jsonObject.getString("gambar");
                                    hotel.set_id(_id);
                                    hotel.setNomorKamar(NomorKamar);
                                    hotel.setTipeKamar(TipeKamar);
                                    hotel.setDeskripsiKamar(DeskripsiKamar);
                                    hotel.setHargaKamar(HargaKamar);
                                    hotel.setGambar(gambar);

                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            // TODO Auto-generated method stub
                                            Intent a = new Intent(DataHotel.this, EditData.class);
                                            a.putExtra("_id", newsList.get(position).get_id());
                                            a.putExtra("nomorKamar", newsList.get(position).getNomorKamar());
                                            a.putExtra("tipeKamar", newsList.get(position).getTipeKamar());
                                            a.putExtra("deskripsiKamar", newsList.get(position).getDeskripsiKamar());
                                            a.putExtra("hargaKamar", newsList.get(position).getHargaKamar());
                                            a.putExtra("gambar", newsList.get(position).getGambar());
                                            startActivity(a);
                                        }
                                    });
                                    newsList.add(hotel);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}