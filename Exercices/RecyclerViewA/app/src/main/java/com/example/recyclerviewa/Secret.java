package com.example.recyclerviewa;

import androidx.annotation.NonNull;

public class Secret {
    public String mSecret;
    public Secret(){
        mSecret = "secrettext";
    }
    @NonNull
    @Override
    public String toString() {
        return mSecret;
    }
}
