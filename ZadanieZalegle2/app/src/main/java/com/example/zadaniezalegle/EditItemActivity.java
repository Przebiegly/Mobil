package com.example.zadaniezalegle;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EditItemActivity extends AppCompatActivity {

    private EditText titleEditText, priceEditText, descriptionEditText;
    private Button saveButton;
    private Item itemToEdit;
    private int position; // Indeks przedmiotu, który edytujemy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // Pobierz indeks przedmiotu do edycji
        position = getIntent().getIntExtra("itemIndex", -1);
        itemToEdit = DataAsyncTask.getItemList().get(position);

        titleEditText = findViewById(R.id.titleEditText);
        priceEditText = findViewById(R.id.priceEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        saveButton = findViewById(R.id.saveButton);

        // Wypełnij formularz danymi przedmiotu
        titleEditText.setText(itemToEdit.getTitle());
        priceEditText.setText(itemToEdit.getPrice());
        descriptionEditText.setText(itemToEdit.getDescription());

        final DataAsyncTask dataAsyncTask = new DataAsyncTask(null);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Zaktualizuj dane w itemToEdit
                itemToEdit.setTitle(titleEditText.getText().toString());
                itemToEdit.setPrice(priceEditText.getText().toString());
                itemToEdit.setDescription(descriptionEditText.getText().toString());

                // Zaktualizuj przedmiot w liście
                dataAsyncTask.editItemInList(position, itemToEdit);

                // Zakończ Activity
                finish();
            }
        });
    }
}
