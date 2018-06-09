package com.android.gersain.votacionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    TextView idUser, nombre, pass1, pass2;
    Button registro, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        idUser = (TextView) findViewById(R.id.txtUserID);
        pass1 = (TextView) findViewById(R.id.txtPass);
        pass2 = (TextView) findViewById(R.id.txtPass);
        registro = (Button) findViewById(R.id.btnRegistrarse);
        cancelar = (Button) findViewById(R.id.btnCancelar);
        nombre = (TextView) findViewById(R.id.txtNombre);
        registro.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnCancelar) {

            Intent RegistroActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(RegistroActivity);


        }

        if (v.getId() == R.id.btnRegistrarse) {
             /*    BackgroundTask hilo1 = new BackgroundTask(this);
            hilo1.execute("register", "", "");
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
