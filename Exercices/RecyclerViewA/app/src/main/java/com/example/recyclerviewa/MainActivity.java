package com.example.recyclerviewa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init du recycler
        this.initRecycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initRecycle(){
        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Use a linear layout manager
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(linearLayoutManager);
        // Specify an adapter
        //mAdapter = new MyAdapter(myDataset);
        //recyclerView.setAdapter(mAdapter);

        // Use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // create list
        ArrayList<Secret> secrets = new ArrayList<Secret>();
        for(int i = 1; i <= 1000; i++) {
            secrets.add(new Secret("Objet #"+i, LocalDateTime.now().plusDays((long)i), (long)i));
        }

        // Specify an adapter
        SecretAdapter secretAdapter = new SecretAdapter(secrets);
        recyclerView.setAdapter(secretAdapter);

    }
}