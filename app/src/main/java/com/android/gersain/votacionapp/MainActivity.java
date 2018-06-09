package com.android.gersain.votacionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

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

        BackgroundTask hilo1 = new BackgroundTask(this);
        hilo1.execute("lista", "", "");
      /*  String lista = null;
        try {
            lista = hilo1.get();
            JSONArray ja = new JSONArray(lista);
            JSONObject jo;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }*/

    }
}
