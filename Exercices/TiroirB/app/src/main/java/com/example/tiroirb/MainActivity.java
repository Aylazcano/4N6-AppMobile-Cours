package com.example.tiroirb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.tiroirb.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Chercher element
        NavigationView nv = binding.navView;
        DrawerLayout dLayout = binding.drawerLayout;

        // Afficher icone menu et interagir
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Changement automatiqueme l'icone menu et le titre avec l'action du tiroir
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, dLayout, R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.drawer_open);
                Toast.makeText(MainActivity.this, "Ouvert", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(R.string.drawer_close);
                Toast.makeText(MainActivity.this, "Fermé", Toast.LENGTH_SHORT).show();
            }

        };
        dLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


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


    // Interaction du icone menu identique qu'avec le glisement du tiroir avec le doit
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Garde l'etats de l'icone du menu qunad il y a changement d'orientation
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    // Garde l'etats de l'icone du menu qunad il y a changement d'orientation
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }



}