package com.david.projekdhimas.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.david.projekdhimas.R;
import com.david.projekdhimas.model.ModelHotel;
import com.david.projekdhimas.server.BaseURL;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHotel extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<ModelHotel> item;

    public AdapterHotel(Activity activity, List<ModelHotel> item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.content_hotel, null);


        TextView NomorKamar = (TextView) convertView.findViewById(R.id.txNomorKamar);
        TextView TipeKamar = (TextView) convertView.findViewById(R.id.txTipeKamar);
        TextView DeskripsiKamar = (TextView) convertView.findViewById(R.id.txDeskripsiKamar);
        TextView HargaKamar = (TextView) convertView.findViewById(R.id.txHargaHotel);
        ImageView GambarKamar = (ImageView) convertView.findViewById(R.id.gambarHotel);

        NomorKamar.setText(item.get(position).getNomorKamar());
        TipeKamar.setText(item.get(position).getTipeKamar());
        DeskripsiKamar.setText(item.get(position).getDeskripsiKamar());
        HargaKamar.setText("Rp." + item.get(position).getHargaKamar());
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + item.get(position).getGambar())
                .resize(40, 40)
                .centerCrop()
                .into(GambarKamar);
        return convertView;
    }
}
