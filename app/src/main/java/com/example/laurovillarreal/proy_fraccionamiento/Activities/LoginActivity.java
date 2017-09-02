package com.example.laurovillarreal.proy_fraccionamiento.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.laurovillarreal.proy_fraccionamiento.R;

public class LoginActivity extends AppCompatActivity {

    Button btLogin;
    Button btNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindUI();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Pendiente de programar...",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void bindUI(){
        btLogin = (Button)findViewById(R.id.btLogin_Login);
        btNuevo = (Button)findViewById(R.id.btNuevo_Login);
    }
}
