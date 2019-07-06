package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CalculateEfActivity extends AppCompatActivity implements UniversityInfoRequest.Callback{

    public Float min_efpc = Float.parseFloat("1");
    public Float min_energy = Float.parseFloat("1");
    public Float min_paper = Float.parseFloat("1");
    public Float min_food = Float.parseFloat("1");
    public Float min_built_land = Float.parseFloat("1");
    public Float min_water = Float.parseFloat("1");
    public Float min_mobility = Float.parseFloat("1");
    public Float min_waste = Float.parseFloat("1");

    Float energy, built_land, mobility, food, waste, water, paper;
    Integer check = 0;
    Integer check1 = 0;
    Integer check2= 0;
    Integer check3 = 0;
    Integer check4 = 0;
    Integer check5 = 0;
    Integer check6 = 0;
    Integer check7 = 0;
    Integer check8 = 0;
    Integer check9 = 0;
    Integer check10 = 0;
    Integer check11 = 0;
    Integer check12 = 0;
    Integer check13 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_ef);


        UniversityInfoRequest x = new UniversityInfoRequest(this);
        x.getUniInfo(this);

    }

    @Override
    public void gotUniInfo(ArrayList<University> universities) {
        try {
            for (int i = 0; i < universities.size(); i++) {

                String Efpc = universities.get(i).getEfpc();
                if (!Efpc.isEmpty()) {
                    Float Efpc_i = Float.parseFloat(Efpc);
                    if (Efpc_i < min_efpc) {
                        min_efpc = Efpc_i;
                    }
                }

                String energy = universities.get(i).getEnergy();
                if (!energy.isEmpty()) {
                    Float energy_i = Float.parseFloat(energy);
                    if (energy_i < min_energy) {
                        min_energy = energy_i;
                    }
                }

                String paper = universities.get(i).getPaper();
                if (!paper.isEmpty()) {
                    Float paper_i = Float.parseFloat(paper);
                    if (paper_i < min_paper) {
                        min_paper = paper_i;
                    }
                }

                String food = universities.get(i).getFood();
                if (!food.isEmpty()) {
                    Float food_i = Float.parseFloat(food);
                    if (food_i < min_food) {
                        min_food = food_i;
                    }
                }

                String built_land = universities.get(i).getBuilt_land();
                if (!built_land.isEmpty()) {
                    Float built_land_i = Float.parseFloat(built_land);
                    if (built_land_i < min_built_land) {
                        min_built_land = built_land_i;
                    }
                }

                String water = universities.get(i).getWater();
                if (!water.isEmpty()) {
                    Float water_i = Float.parseFloat(water);
                    if (water_i < min_water) {
                        min_water = water_i;
                    }
                }

                String mobility = universities.get(i).getMobility();
                if (!mobility.isEmpty()) {
                    Float mobility_i = Float.parseFloat(mobility);
                    if (mobility_i < min_mobility) {
                        min_mobility = mobility_i;
                    }
                }

                String waste = universities.get(i).getWaste();
                if (!waste.isEmpty()) {
                    Float waste_i = Float.parseFloat(waste);
                    if (waste_i < min_waste) {
                        min_waste = waste_i;
                    }
                }

            }
        }catch(Exception e){
            Toast.makeText(this, "Something went wrong, please make sure you're connected to the internet!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void gotUniInfoError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void blCalc(View v) {

        String[] items = new String[] {"Built land (m2) * 0,000283", "--------------------------------------------- +", "Total / university's population"};
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

    public void energyCalc(View v) {

        String[] items = new String[] {"Natural gas (m3) * 0,00048885", "Sun (kWh) * 0,000024","Wind (kWh) * 0,000024","--------------------------------------------- +", "Total / university's population"};
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

    public void foodCalc(View v) {

        String[] items = new String[] {"Diary (kg) * 0,00199","Fish & other seafood (kg) * 0,0227","Fruit (kg) * 0,0005","Grain (kg) * 0,0017","Meat (kg) * 0.0069","Vegetables (kg) * 0,0004", "-------------------------------------------- +", "Total / university's population"};
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

    public void mobilityCalc(View v) {

        String[] items = new String[] {"Bicycle (km) * 0,0000026","Car (km) * 0,0000395","Motorbike (km) * 0,0000129","Public transport (km) * 0,000011", "-------------------------------------------- +", "Total / university's population"};
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

    public void paperCalc(View v) {

        String[] items = new String[] {"Paper (tonnes) * 2,01","-------------------------------------------- +", "Total / university's population"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        new AlertDialog.Builder(this)
                .setTitle("Paper calculation")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).create().show();
    }

    public void wasteCalc(View v) {

        String[] items = new String[] {"Food (kg) * 0,000103","Glass (kg) * 0,001902","Metals (kg) * 0,00217724337","Paper (kg) * 0,0028","Plastic (kg) * 0,0036","Unsorted * 0,00465","-------------------------------------------- +", "Total / university's population"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        new AlertDialog.Builder(this)
                .setTitle("Waste calculation")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).create().show();
    }

    public void waterCalc(View v) {

        String[] items = new String[] {"Water (m3) * 0,00524","-------------------------------------------- +", "Total / university's population"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        new AlertDialog.Builder(this)
                .setTitle("Water calculation")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).create().show();
    }

    public void compareEF(View v){
        EditText input_energy = findViewById(R.id.input_energy);
        EditText input_built_land = findViewById(R.id.input_bl);
        EditText input_mobility = findViewById(R.id.input_mobility);
        EditText input_food = findViewById(R.id.input_food);
        EditText input_waste = findViewById(R.id.input_waste);
        EditText input_water = findViewById(R.id.input_water);
        EditText input_paper = findViewById(R.id.input_paper);

        EditText input_uni = findViewById(R.id.input_uni);

        try{
            if (!input_energy.getText().toString().isEmpty()) {
                Float energy_f = Float.parseFloat(input_energy.getText().toString());
                energy = energy_f;
                check = 0;
                check1 = 0;
            }
        }catch(Exception e){
            input_energy.setError("Make sure floating input has been written with a dot (.)!");
            check1 = 1;
        }

        try{
            if (!input_built_land.getText().toString().isEmpty()) {
                Float built_land_f = Float.parseFloat(input_built_land.getText().toString());
                built_land = built_land_f;
                check2 = 0;
                check3 = 0;
            }
        }catch(Exception e){
            input_built_land.setError("Make sure floating input has been written with a dot (.)!");
            check3 = 1;
        }

        try{
            if (!input_mobility.getText().toString().isEmpty()) {
                Float mobility_f = Float.parseFloat(input_mobility.getText().toString());
                mobility = mobility_f;
                check4 = 0;
                check5 = 0;
            }
        }catch(Exception e){
            input_mobility.setError("Make sure floating input has been written with a dot (.)!");
            check5 = 1;
        }

        try{
            if (!input_food.getText().toString().isEmpty()) {
                Float food_f = Float.parseFloat(input_food.getText().toString());
                food = food_f;
                check6 = 0;
                check7 =0;
            }
        }catch(Exception e){
            input_food.setError("Make sure floating input has been written with a dot (.)!");
            check7 = 1;
        }

        try{
            if (!input_waste.getText().toString().isEmpty()) {
                Float waste_f = Float.parseFloat(input_waste.getText().toString());
                waste = waste_f;
                check8 = 0;
                check9 = 0;

            }
        }catch(Exception e){
            input_waste.setError("Make sure floating input has been written with a dot (.)!");
            check9 = 1;
        }

        try{
            if (!input_water.getText().toString().isEmpty()) {
                Float water_f = Float.parseFloat(input_water.getText().toString());
                water = water_f;
                check10 = 0;
                check11 = 0;
            }
        }catch(Exception e){
            input_water.setError("Make sure floating input has been written with a dot (.)!");
            check11 = 1;
        }

        try{
            if (!input_paper.getText().toString().isEmpty()) {
                Float paper_f = Float.parseFloat(input_paper.getText().toString());
                paper = paper_f;
                check12 = 0;
                check13 = 0;
            }
        }catch(Exception e){
            input_paper.setError("Make sure floating input has been written with a dot (.)!");
            check13 = 1;
        }

        if (TextUtils.isEmpty(input_uni.getText())){
            input_uni.setError("Fill in your university's name!");
        }


        else if(check != 1 && check1 != 1 && check2 != 1 && check3 != 1 && check4 != 1 && check5 != 1 && check6 != 1 && check7 != 1 && check8 != 1 && check9 != 1 && check10 != 1 &&
            check11 != 1 && check12 != 1 && check13 != 1) {
            Intent intent = new Intent(this, CompareEfActivity.class);
            intent.putExtra("energy", energy);
            intent.putExtra("built_land", built_land);
            intent.putExtra("paper", paper);
            intent.putExtra("water", water);
            intent.putExtra("waste", waste);
            intent.putExtra("food", food);
            intent.putExtra("mobility", mobility);

            intent.putExtra("min_energy", min_energy);
            intent.putExtra("min_built_land", min_built_land);
            intent.putExtra("min_paper", min_paper);
            intent.putExtra("min_water", min_water);
            intent.putExtra("min_waste", min_waste);
            intent.putExtra("min_food", min_food);
            intent.putExtra("min_mobility", min_mobility);
            intent.putExtra("min_efpc", min_efpc);

            String uni_name = input_uni.getText().toString();
            intent.putExtra("uni_name", uni_name);

            startActivity(intent);}
    }
}
