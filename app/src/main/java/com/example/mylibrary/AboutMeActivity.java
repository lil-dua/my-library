package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutMeActivity extends AppCompatActivity {

    public Button btnPhone,btnFacebook, btnIns, btnGithub;
    String[] urls = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //set URL link
        urls[0] = "https://www.facebook.com/hoang.ryann";
        urls[1] = "https://www.instagram.com/hoang.ryann";
        urls[2] = "https://github.com/lil-dua";
        /*
        * set function of buttons
        */

        //execute a call to my phone number
        btnPhone = findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myNumber = "0972524570";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(myNumber));
                startActivity(intent);
            }
        });

        //get my Facebook link
        btnFacebook = findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutMeActivity.this, WebViewActivity.class);
                intent.putExtra("links", urls[0]);
                startActivity(intent);
            }
        });

        //get my Instagram link
        btnIns = findViewById(R.id.btnIns);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutMeActivity.this, WebViewActivity.class);
                intent.putExtra("links", urls[1]);
                startActivity(intent);
            }
        });

        //get my Github link
        btnGithub = findViewById(R.id.btnGithub);
        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutMeActivity.this, WebViewActivity.class);
                intent.putExtra("links", urls[2]);
                startActivity(intent);
            }
        });



    }
}