package com.example.recyclerviewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init du recycler
        this.initRecycle();
    }

    private void initRecycle(){
        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Use a linear layout manager
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(linearLayoutManager);
        // Specify an adapter
        //mAdapter = new MyAdapter(myDataset);
        //recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // create list
        ArrayList<Secret> secrets = new ArrayList<Secret>();
        for(int i = 0; i < 20; i++) {
            secrets.add(new Secret());
        }
        SecretAdapter secretAdapter = new SecretAdapter(secrets);

        // Specify an adapter
        recyclerView.setAdapter(secretAdapter);

    }
}