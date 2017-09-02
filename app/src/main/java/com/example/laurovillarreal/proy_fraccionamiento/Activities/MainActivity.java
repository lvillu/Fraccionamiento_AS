package com.example.laurovillarreal.proy_fraccionamiento.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.laurovillarreal.proy_fraccionamiento.Fragments.AdministradorFragment;
import com.example.laurovillarreal.proy_fraccionamiento.Fragments.BancoFragment;
import com.example.laurovillarreal.proy_fraccionamiento.Fragments.InicioFragment;
import com.example.laurovillarreal.proy_fraccionamiento.Fragments.PagosFragment;
import com.example.laurovillarreal.proy_fraccionamiento.Fragments.PropuestasFragment;
import com.example.laurovillarreal.proy_fraccionamiento.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolBar();
        BindUI();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean bFragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.menu_inicio:
                        fragment = new InicioFragment();
                        bFragmentTransaction = true;
                        break;

                    case R.id.menu_banco:
                        fragment = new BancoFragment();
                        bFragmentTransaction = true;
                        break;

                    case R.id.menu_pagos:
                        fragment = new PagosFragment();
                        bFragmentTransaction = true;
                        break;

                    case R.id.menu_propuestas:
                        fragment = new PropuestasFragment();
                        bFragmentTransaction = true;
                        break;

                    case R.id.menu_proyectos:
                        fragment = new PropuestasFragment();
                        bFragmentTransaction = true;
                        break;

                    case R.id.menu_admin:
                        fragment = new AdministradorFragment();
                        bFragmentTransaction = true;
                        break;
                }

                if (bFragmentTransaction){
                    changeFragment(fragment, item);
                }
                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setToolBar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void changeFragment(Fragment fragment, MenuItem item){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }

    private void BindUI(){
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navview);
    }
}
