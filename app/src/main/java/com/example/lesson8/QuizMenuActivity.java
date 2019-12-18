package com.example.lesson8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizMenuActivity extends QuizActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
}
