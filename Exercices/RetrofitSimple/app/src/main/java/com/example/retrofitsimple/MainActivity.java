package com.example.retrofitsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitsimple.http.RetrofitUtil;
import com.example.retrofitsimple.http.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private EditText editTextNumber;
private Button button;
private TextView textViewResult;
private Service service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation view
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.buttonDouble);
        textViewResult = findViewById(R.id.textViewResult);

        //Initialisation service Retrofit
        service = RetrofitUtil.get();

        //ClickListener
        button.setOnClickListener(v -> {
            int number = Integer.parseInt(editTextNumber.getText().toString());

            Call<String> call = service.getDouble(number);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful() && response.body() != null){
                        String result = response.body();
                        textViewResult.setText(result);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    // Show error message if the network call fails
                    Toast.makeText(MainActivity.this, "Network call failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}