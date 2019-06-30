package com.example.myapplication;

public class KebudayaanDetail {

    private String namaKebudayaan, asalKebudayaan, deskripsiKebudayaan, foto;

    public String getNamaKebudayaan() {
        return this.namaKebudayaan;
    }

    public void setNamaKebudayaan(String namaKebudayaan) {
        this.namaKebudayaan = namaKebudayaan;
    }

    public String getDeskripsiKebudayaan() {
        return this.deskripsiKebudayaan;
    }

    public void setDeskripsiKebudayaan(String deskripsiKebudayaan) {
        this.deskripsiKebudayaan = deskripsiKebudayaan;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setAsalKebudayaan(String asalKebudayaan) { this.asalKebudayaan = asalKebudayaan; }

    public String getAsalKebudayaan() { return this.asalKebudayaan; }

}
