package com.example.retrofitsimple.http;

import java.util.List;

import model.DoubleResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
        @GET("double")
        Call<DoubleResponse> getDouble(@Query("number") double number);
}