package com.example.zadaniezalegle;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listButton = findViewById(R.id.listButton);
        Button addButton = findViewById(R.id.addButton);

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Przechodzi do ListViewActivity
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Przechodzi do AddItemActivity
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivity(intent);
            }
        });
    }
}
