package com.example.zadaniezalegle;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    private EditText titleEditText, priceEditText, descriptionEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        titleEditText = findViewById(R.id.titleEditText);
        priceEditText = findViewById(R.id.priceEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        saveButton = findViewById(R.id.saveButton);

        final DataAsyncTask dataAsyncTask = new DataAsyncTask(null); // Inicjujemy bez adaptera, ponieważ adapter zostanie zainicjowany w ListViewActivity

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobierz dane z formularza
                String title = titleEditText.getText().toString();
                String price = priceEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                // Stwórz nowy przedmiot
                Item newItem = new Item(title, price, description);

                // Dodaj przedmiot do listy w DataAsyncTask
                dataAsyncTask.addItemToList(newItem);

                // Zakończ Activity
                finish();
            }
        });
    }
}
