package com.example.retrofitsimple.http;

import model.IntResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
        @GET("{intDouble}")
        Call<String> getDouble(@Path("intDouble") int intDouble);
}