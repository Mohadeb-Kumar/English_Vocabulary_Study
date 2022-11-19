package com.example.englishvocabularyquiztest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView=findViewById(R.id.recyclerViewID);

        String[]title=new String[]{
                "Synonyms & Antonyms",
                "Spelling Mistakes",
                "Idioms & Phrases",
                "Analogy",
                "One Word Substitution"

        };
        String[]htmlFile=new String[]{
                "synonym_antonym_study",
                "spelling_mistakes",
                "idioms&phrases",
                "analogy",
                "one_word_subtitution"

        };

        customAdapter=new CustomAdapter(this,title,htmlFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(CategoryActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            Intent intent=new Intent(CategoryActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}