package com.android.gersain.votacionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView idUser, pass;
    Button sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idUser = (TextView)findViewById(R.id.txtUserID);
        pass = (TextView)findViewById(R.id.txtPass);
        sesion = (Button)findViewById(R.id.btnInicioSesion);
        sesion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnInicioSesion) {

            Intent RegistroActivity = new Intent(getApplicationContext(), RegistroActivity.class);
            startActivity(RegistroActivity);

         /*  BackgroundTask hilo1 = new BackgroundTask(this);
            hilo1.execute("login", idUser.getText().toString(), pass.getText().toString());
            String lista = null;
            try {
                lista = hilo1.get();
                if(!lista.isEmpty()){
                    Intent RegistroActivity = new Intent(getApplicationContext(), RegistroActivity.class);
                    startActivity(RegistroActivity);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/


        }
    }
}
