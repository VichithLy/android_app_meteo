package com.example.p1701575.appmeteo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.p1701575.appmeteo.thread.MyAsyncTask;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    URL url;
    Button button_rss;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.coord);
        button_rss = findViewById(R.id.button_rss);

        button_rss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=fbf2a1c3702c4a6ed9b5b64f9ebc712f");

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                new MyAsyncTask().execute(url,content);

            }
        });






    }
}
