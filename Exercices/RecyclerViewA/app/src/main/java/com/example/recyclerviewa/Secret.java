package com.example.recyclerviewa;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.format.DateTimeFormatter;

public class Secret {
    public String mSecret;
    public String nom;
    public java.time.LocalDateTime date;
    public Long nbGrand;

    public Secret(String pNom, java.time.LocalDateTime pDate, Long pNbGrand){
           nom = pNom;
           date = pDate;
           nbGrand = pNbGrand;
    }

    @SuppressLint("DefaultLocale")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getFormattedString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s - %s - %d", nom, date.format(formatter), nbGrand);
    }
}
