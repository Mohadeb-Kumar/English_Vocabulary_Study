package com.example.englishvocabularyquiztest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class IdiomsActivity extends AppCompatActivity {

    private Button quizBtn1;
    private Button quizBtn2;
    private Button quizBtn3;
    private Button quizBtn4;
    private Button quizBtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioms);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        quizBtn1=findViewById(R.id.quizBtnID1);
        quizBtn2=findViewById(R.id.quizBtnID2);
        quizBtn3=findViewById(R.id.quizBtnID3);
        quizBtn4=findViewById(R.id.quizBtnID4);
        quizBtn5=findViewById(R.id.quizBtnID5);

        quizBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(IdiomsActivity.this,IdiomsActivity1.class);
                startActivity(categoryIntent);
                finish();
            }
        });

/*
        quizBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(SpellActivity.this,SpellActivity1.class);
                startActivity(categoryIntent);
                finish();
            }
        });


        quizBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(SpellActivity.this,SpellActivity1.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        quizBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(SpellActivity.this,SpellActivity1.class);
                startActivity(categoryIntent);
                finish();
            }
        });


        quizBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(SpellActivity.this,SpellActivity1.class);
                startActivity(categoryIntent);
                finish();
            }
        });*/
    }



    @Override
    public void onBackPressed() {
        Intent intent=new Intent(IdiomsActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            Intent intent=new Intent(IdiomsActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}