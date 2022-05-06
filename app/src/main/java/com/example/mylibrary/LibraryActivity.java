package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {


    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

            adapter = new BookRecViewAdapter(this);
            booksRecView = findViewById(R.id.booksRecView);

            booksRecView.setAdapter(adapter);
            booksRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


            adapter.setBook(Utils.getInstance().getAllBooks());

            // Create a action bar to go back the home screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}