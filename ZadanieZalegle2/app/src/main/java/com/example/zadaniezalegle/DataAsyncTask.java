package com.example.zadaniezalegle;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class DataAsyncTask extends AsyncTask<Void, Void, List<Item>> {

    // Lista przedmiotów
    private static List<Item> items = new ArrayList<>();
    private ArrayAdapter<Item> adapter;

    // Publiczny konstruktor przyjmujący tylko adapter
    public DataAsyncTask(ArrayAdapter<Item> adapter) {
        this.adapter = adapter;
    }

    // Metoda statyczna do uzyskiwania listy przedmiotów
    public static List<Item> getItemList() {
        return items;
    }

    // Dodawanie nowego przedmiotu do listy
    public void addItemToList(Item item) {
        items.add(item);
        new DataAsyncTask(adapter).execute(); // Uruchomienie asynchronicznej aktualizacji listy
    }

    // Edytowanie przedmiotu w liście
    public void editItemInList(int position, Item updatedItem) {
        items.set(position, updatedItem);
        new DataAsyncTask(adapter).execute(); // Uruchomienie asynchronicznej aktualizacji listy
    }

    // Asynchroniczna metoda do odświeżania listy
    @Override
    protected List<Item> doInBackground(Void... voids) {
        try {
            Thread.sleep(3000); // Symulacja opóźnienia 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Po zakończeniu procesu w tle aktualizujemy adapter
    @Override
    protected void onPostExecute(List<Item> result) {
        super.onPostExecute(result);
        if (adapter != null) {
            adapter.clear();
            adapter.addAll(result);
            adapter.notifyDataSetChanged();
        }
    }

    // Inicjalizacja przykładowych danych
    public static void initializeSampleData() {
        if (items.isEmpty()) {
            items.add(new Item("Laptop", "$1000", "Wydajny laptop dla graczy"));
            items.add(new Item("Smartphone", "$500", "Nowoczesny telefon z wyświetlaczem OLED"));
            items.add(new Item("Tablet", "$300", "Tablet do pracy i zabawy"));
        }
    }
}
