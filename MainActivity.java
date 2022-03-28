package com.example.tronzomb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
        private float width;
        private float height;
        private Bitmap bitmap;
        private Button exit;
        private Button start;
        private Button contin;
        private Button options;
        private Button credits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.backgroundmenu);
                exit=findViewById(R.id.exitbut);
                start=findViewById(R.id.startbut);
                contin=findViewById(R.id.continbut);
                options=findViewById(R.id.optionbut);
                credits=findViewById(R.id.creditsbut);

                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent start = new Intent(getBaseContext(), NewCharacterActivity.class);
                        startActivity(start);
                    }
                });
                contin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                options.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                credits.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        }