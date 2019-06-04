package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void ToOverview(View view){
        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);
    }

    public void CalculateCompare(View view){
        Intent intent = new Intent(this, CalculateEfActivity.class);
        startActivity(intent);
    }

}
