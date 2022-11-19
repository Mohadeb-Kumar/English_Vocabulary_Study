package com.example.englishvocabularyquiztest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import androidx.annotation.NonNull;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    private Button startBtn1;
    private Button startBtn2;

    private Button startBtn3;
    private Button startBtn4;
    private Button startBtn5;
    private Button startBtn6;
    private Button startBtn7;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startBtn1=findViewById(R.id.startBtnID1);
        startBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(HomeActivity.this,CategoryActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });



        startBtn2=findViewById(R.id.startBtnID2);
        startBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(HomeActivity.this,QuizActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startBtn2=findViewById(R.id.startBtnID3);
        startBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(HomeActivity.this,SpellActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startBtn2=findViewById(R.id.startBtnID4);
        startBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(HomeActivity.this,IdiomsActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startBtn2=findViewById(R.id.startBtnID5);
        startBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(HomeActivity.this,AnalogyActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startBtn2=findViewById(R.id.startBtnID6);
        startBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(HomeActivity.this,SubtitutionActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startBtn2=findViewById(R.id.startBtnID7);
        startBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent=new Intent(HomeActivity.this,CombineActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id=item.getItemId();
        if(id==R.id.action_privacy){
            Intent intent=new Intent(HomeActivity.this,PolicyActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        else if(id==R.id.action_about){
//                StyleableToast.makeText(getApplicationContext(),"Education Life Line",R.style.rightToast).show();
//                return true;

            Intent intent=new Intent(HomeActivity.this,AboutActivity.class);
            startActivity(intent);
            finish();
            return true;

            }
        else if(id==R.id.action_exit){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            HomeActivity.super.onBackPressed();

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });


            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }

        else{

        }


        return super.onOptionsItemSelected(item);
    }
}