package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CalculateEfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_ef);


//        Spinner BL_info = findViewById(R.id.BL_dd);
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,R.layout.spinner_textview,getResources().getStringArray(R.array.BL_info));
//        myAdapter.setDropDownViewResource(R.layout.dropdown_item_textview);
//        BL_info.setAdapter(myAdapter);

    }

    public void blCalc(View w) {

        String[] items = new String[] {"Built land (m2) * 0,000283", "--------------------------------------------- +", "Total hectares / university's population"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        new AlertDialog.Builder(this)
                .setTitle("Built land calculation")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).create().show();
    }

    public void energyCalc(View w) {

        String[] items = new String[] {"Natural gas (m3) * 0,00048885", "Wind (kWh) * 0,000024", "Sun (kWh) * 0,000024", "--------------------------------------------- +", "Total hectares / university's population"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        new AlertDialog.Builder(this)
                .setTitle("Energy calculation")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).create().show();
    }

    public void foodCalc(View w) {

        String[] items = new String[] {"Fish & other seafood (kg) * 0,0227", "Grain (kg) * 0,0017","Vegetables (kg) * 0,0004","Diary (kg) * 0,00199","Fruit (kg) * 0,0005", "Meat (kg) * 0.0069", "-------------------------------------------- +", "Total hectares / university's population"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        new AlertDialog.Builder(this)
                .setTitle("Food calculation")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).create().show();
    }

    public void mobilityCalc(View w) {

        String[] items = new String[] {"Public transport (km) * 0,000011", "Car (km) * 0,0000395","Motorbike (km) * 0,0000129","Bicycle (km) * 0,0000026", "-------------------------------------------- +", "Total hectares / university's population"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        new AlertDialog.Builder(this)
                .setTitle("Mobility calculation")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).create().show();
    }
}
