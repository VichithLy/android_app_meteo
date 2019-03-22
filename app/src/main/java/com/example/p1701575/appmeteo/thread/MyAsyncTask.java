package com.example.p1701575.appmeteo.thread;

import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.p1701575.appmeteo.WeatherData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

public class MyAsyncTask extends AsyncTask<Object, Void, String> {

    static String stream = null;
    TextView tv;

    @Override
    protected String doInBackground(Object... params) {

        URL url = (URL) params[0];
        //URL url = new URL(URL);
        tv = (TextView) params[1];

        // connexions http, traitements lourds, etc.
        String inputLine = "";

        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.univ-lyon1.fr",3128));
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            Log.d("Async", String.valueOf(urlConnection.getResponseCode()));

            if (urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK){

                /*InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = r.readLine()) != null)
                    sb.append(line);
                stream = sb.toString();
                Log.d("Async", in);
                in.close();*/

                //Chargement du flux
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                inputLine = in.readLine();
                Log.d("Async",inputLine);

                /*JSONObject coord = reader.getJSONObject("coord");
                JSONArray weather = reader.getJSONArray("weather");
                String base = reader.getString("base");
                JSONObject main = reader.getJSONObject("main");

                Log.d("coord", coord.toString());
                Log.d("weather", weather.toString());
                Log.d("base", base.toString());
                Log.d("main", main.toString());
                */

                in.close();

            }

            urlConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return stream;
        return inputLine;
    }

    protected void onPostExecute(String result){

        //Parsage du flux
        JSONObject reader = null;
        try {
            reader = new JSONObject(result);
            //Classe des données météo

            WeatherData wd = new WeatherData(reader);

            tv.setText(String.valueOf(wd.getLon()));
        } catch (JSONException e) {
            e.printStackTrace();
            tv.setText("Toi ca fait 20min que tu te trompes, pour la peine, tu me fais 20 pompes, et tout seul.");
        }



    }


}
