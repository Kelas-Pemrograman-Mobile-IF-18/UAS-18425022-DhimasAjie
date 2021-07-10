package com.david.projekdhimas.model;

public class ModelHotel {
    String  _id, nomorKamar, tipeKamar, deskripsiKamar, hargaKamar, Gambar;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public String getDeskripsiKamar() {
        return deskripsiKamar;
    }

    public void setDeskripsiKamar(String deskripsiKamar) {
        this.deskripsiKamar = deskripsiKamar;
    }

    public String getHargaKamar() {
        return hargaKamar;
    }

    public void setHargaKamar(String hargaKamar) {
        this.hargaKamar = hargaKamar;
    }

    public String getGambar() {
        return Gambar;
    }

    public void setGambar(String gambar) {
        Gambar = gambar;
    }
}
