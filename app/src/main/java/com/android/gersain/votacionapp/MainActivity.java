package com.android.gersain.votacionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView idUser, pass;
    Button sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idUser = (TextView)findViewById(R.id.txtUserID);
        pass = (TextView)findViewById(R.id.txtPass);
        sesion = (Button)findViewById(R.id.btnInicioSesion);
    }
}
