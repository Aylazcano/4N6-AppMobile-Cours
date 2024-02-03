package com.example.tiroira;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tiroira.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle abdToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Chercher element
        NavigationView nv = binding.navView;
        DrawerLayout dLayout = binding.drawerLayout;


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;

                if (item.getItemId() == R.id.nav_home) {
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.nav_profile) {
                    Toast.makeText(MainActivity.this, "Alexis Lazcano", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.nav_logout) {
                    Log.d("MainActivity", "Utilisateur déconnecté");
                    return true;
                }

                // Switch HELP:
                //C:\Users\0370102\Desktop\4N6-AppMobile-Cours\Exercices\TiroirA\app\src\main\java\com\example\tiroira\MainActivity.java:55: error: constant expression required
                //                    case R.id.nav_home:
                //                             ^
                //C:\Users\0370102\Desktop\4N6-AppMobile-Cours\Exercices\TiroirA\app\src\main\java\com\example\tiroira\MainActivity.java:58: error: constant expression required
                //                    case R.id.nav_profile:
                //                             ^
                //C:\Users\0370102\Desktop\4N6-AppMobile-Cours\Exercices\TiroirA\app\src\main\java\com\example\tiroira\MainActivity.java:61: error: constant expression required
                //                    case R.id.nav_logout:
                //
                //                             ^
                /*
                switch (item.getItemId()){
                    case R.id.nav_home:
                        finish();
                        return true;
                    case R.id.nav_profile:
                        Toast.makeText(MainActivity.this, "Alexis Lazcano", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_logout:
                        Log.d("MainActivity", "Utilisateur déconnecté");
                        return true;
                }
                */

                return false;
            }
        });

    }
}