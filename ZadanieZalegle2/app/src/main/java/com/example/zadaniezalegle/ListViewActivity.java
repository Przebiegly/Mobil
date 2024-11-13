package com.example.zadaniezalegle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<Item> itemList;
    private ArrayAdapter<Item> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        // Inicjalizacja przykładowych danych
        DataAsyncTask.initializeSampleData();

        listView = findViewById(R.id.listView);
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);

        listView.setAdapter(adapter);

        // Zainicjujemy DataAsyncTask
        DataAsyncTask dataAsyncTask = new DataAsyncTask(adapter);
        dataAsyncTask.execute(); // Uruchomienie asynchronicznej aktualizacji listy

        // Obsługa kliknięcia na element listy
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                // Przejście do ekranu edycji przedmiotu
                Intent intent = new Intent(ListViewActivity.this, EditItemActivity.class);
                intent.putExtra("itemIndex", position); // Przekazujemy indeks przedmiotu do edycji
                startActivity(intent);
            }
        });
    }
}
