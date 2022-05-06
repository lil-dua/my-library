package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivityLayout extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookID";
    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToCurrReading, btnAddToFav;
    private ImageView bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        intView();

        //TODO: Get the data from recycler view in here
        // Call book data by ID
        Intent intent = getIntent();
        if(null != intent){
            int bookID = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookID != -1){
                Book incomingBook = Utils.getInstance().getBookByID(bookID);
                if(null!=incomingBook){
                    setData(incomingBook);

                    handleFavoriteBook(incomingBook);
                }
            }
        }

    }

    /**
     * Enable and Disable Button
     * Add the book to Favorite Books ArrayList
     * @param book
     */
    private void handleFavoriteBook(Book book){
        ArrayList<Book> favoriteBooks = Utils.getInstance().getFavoriteBook();
        boolean existInFavoriteBooks = false;
        for (Book b:
             favoriteBooks) {
                if (b.getId() == book.getId()){
                    existInFavoriteBooks = true;
                }

        }
        if(existInFavoriteBooks){
            btnAddToFav.setEnabled(false);
        }else {
            btnAddToFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToFavoriteBook(book)){
                        Toast.makeText(BookActivityLayout.this,"Book Added!",Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user
                        startActivity(new Intent(BookActivityLayout.this, FavoriteBookActivity.class));
                    }else {
                        Toast.makeText(BookActivityLayout.this, "Failed to add, try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void setData(Book book){
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText("Description: \n\n"+book.getShortDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookImage);
    }
    private void intView() {
        txtAuthor = findViewById(R.id.txtAuthor);
        txtBookName = findViewById(R.id.txtBookName);
        txtPages = findViewById(R.id.txtPages);
        txtDescription = findViewById(R.id.txtDescription);

        btnAddToFav = findViewById(R.id.btnAddToFav);

        bookImage = findViewById(R.id.bookImage);
    }
}

