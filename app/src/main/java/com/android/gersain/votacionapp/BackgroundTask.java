package com.android.gersain.votacionapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Gersain on 09/06/2018.
 */

public class BackgroundTask extends AsyncTask<String,Void,String>{
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx = ctx;
    }
    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Informacion");
    }

    @Override
    protected String doInBackground(String... params) {
        String login_url = "http://localhost:8084/api/usuario/validar";
        String lista_url = "http://localhost:8084/api/usuario/listar";
        String reg_url = "http://localhost:8084/api/usuario/insertar";
        String method = params[0];
        if(method.equals("register")){
            String userID = params[1];
            String nombre = params[2];
            String pass = params [3];
            try {
                final JSONObject data = new JSONObject();
                try {
                    data.put("userID", userID);
                    data.put("nombre", nombre);
                    data.put("pass", pass);
                    data.put("tipo", '0');
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
           //     bufferedWriter.write('{"userID": "888", "nombre": "nombre883", "pass": "pass2", "tipo": 1}');
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registro Exitoso";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (method.equals("login")){
            String userID = params[1];
            String pass = params[2];
            try {
                final JSONObject data = new JSONObject();
                try {
                    data.put("userID", userID);
                    data.put("nombre", "");
                    data.put("pass", pass);
                    data.put("tipo", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                bufferedWriter.write(data.toString());
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response ="";
                String line ="";
                while((line = bufferedReader.readLine())!=null){
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (RuntimeException e)
            {
                e.printStackTrace();
            }
        }
        else if (method.equals("lista")){
            Log.d("ff","sdf");
            try {
                URL url = new URL(lista_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String line ="";
                StringBuffer jsonData=new StringBuffer();
                Log.d("asdasd",bufferedReader.toString());
                while((line = bufferedReader.readLine())!=null){
                    jsonData.append(line+"n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return jsonData.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            if(result.equals("Datos Incorrectos")) {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

    }
}
