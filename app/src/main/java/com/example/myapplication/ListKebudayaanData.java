package com.example.myapplication;

import java.util.ArrayList;

public class ListKebudayaanData {
    private static String dataListKebudayaan[][] = new String[][]{
            {"Pulau Sumatera", "Kebudayaan yang berada di daerah Sumatera", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Sumatra_Topography.png/260px-Sumatra_Topography.png"},
            {"Pulau Jawa", "Kebudayaan yang berada di daerah Jawa", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Java_Topography.png/390px-Java_Topography.png"},
            {"Pulau Kalimantan", "Kebudayaan yang berada di daerah Kalimantan", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Indonesia_Kalimantan_location_map.svg/330px-Indonesia_Kalimantan_location_map.svg.png"},
            {"Pulau Sulawesi", "Kebudayaan yang berada di daerah Sulawesi", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Sulawesi_map.PNG/390px-Sulawesi_map.PNG"},
            {"Pulau Nusa Tenggara", "Kebudayaan yang berada di daerah Nusa Tenggara", "http://beautiful-indonesia.umm.ac.id/files/image/peta/Nusa%20Tenggara.png"},
            {"Pulau Maluku dan Papua", "Kebudayaan yang berada di daerah Maluku dan Papua", "http://papuaweb.org/gb/peta/p-pwb/papua-maluku.gif"}
    };

    public static ArrayList<Kebudayaan> getListData() {
        Kebudayaan kebudayaan = null;
        ArrayList<Kebudayaan> list = new ArrayList<>();
        for (String[] aData : dataListKebudayaan) {
            kebudayaan = new Kebudayaan();
            kebudayaan.setNamaKebudayaan(aData[0]);
            kebudayaan.setDeskripsiKebudayaan(aData[1]);
            kebudayaan.setFoto(aData[2]);

            list.add(kebudayaan);
        }

        return list;
    }
}
