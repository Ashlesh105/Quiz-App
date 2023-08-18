package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Selecionpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionpage);
    }

    public void sub1(View view) {
        Intent i = new Intent(this , MainActivity.class);
        startActivity(i);
    }

    public void sub2(View view) {
        Intent i = new Intent(this , sub2.class);
        startActivity(i);
    }

    public void sub3(View view) {
        Intent i = new Intent(this , sub3.class);
        startActivity(i);
    }

    public void sub4(View view) {
        Intent i = new Intent(this , sub4.class);
        startActivity(i);
    }
}