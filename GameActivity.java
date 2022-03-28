package com.example.tronzomb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    private int hp,xp;
    private Button inv,rb,lb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamea);
        inv = findViewById(R.id.invenbut);

        rb = findViewById(R.id.rightbut);
        lb = findViewById(R.id.leftbut);
        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inventory = new Intent(getBaseContext(), InventoryActivity.class);
                startActivity(inventory);
            }
        });
    }
}