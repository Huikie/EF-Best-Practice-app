package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class CalculateEfActivity extends AppCompatActivity {

    Float efpc_calc, energy_calc, mobility_calc, food_calc, waste_calc, water_calc, paper_calc, bl_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_ef);

//        if(savedInstanceState != null){
//            Log.d("hier", "goed");
//            TextView efpc = findViewById(R.id.efpc);
//            efpc.setText(Html.fromHtml(savedInstanceState.getString("efpc",null)));
//            EditText input_efpc = findViewById(R.id.input_efpc);
//            String saved_efpc = savedInstanceState.getString("i_efpc", "");
//            input_efpc.setText(saved_efpc);
//        }

        Intent intent = getIntent();
        Float efpc = intent.getFloatExtra("efpc", 0);
        Float energy = intent.getFloatExtra("energy", 0);
        Float mobility = intent.getFloatExtra("mobility", 0);
        Float waste = intent.getFloatExtra("waste", 0);
        Float water = intent.getFloatExtra("water", 0);
        Float food = intent.getFloatExtra("food", 0);
        Float built_land = intent.getFloatExtra("built_land", 0);
        Float paper = intent.getFloatExtra("paper", 0);

        efpc_calc = efpc;
        energy_calc = energy;
        mobility_calc = mobility;
        food_calc = food;
        waste_calc = waste;
        water_calc = water;
        paper_calc = paper;
        bl_calc = built_land;
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.d("saved", "ja");
//        TextView efpc = findViewById(R.id.efpc);
//        TextView energy = findViewById(R.id.energy);
//        TextView built_land = findViewById(R.id.built_land);
//        TextView mobility = findViewById(R.id.mobility);
//        TextView food = findViewById(R.id.food);
//        TextView waste = findViewById(R.id.waste);
//        TextView water = findViewById(R.id.water);
//        TextView paper = findViewById(R.id.paper);
//
//        outState.putString("efpc", efpc.getText().toString());
//        outState.putInt("arms", arms.getVisibility());
//        outState.putInt("eyes", eyes.getVisibility());
//        outState.putInt("eyebrows", eyebrows.getVisibility());
//        outState.putInt("ears", ears.getVisibility());
//        outState.putInt("mustache", mustache.getVisibility());
//        outState.putInt("nose", nose.getVisibility());
//        outState.putInt("shoes", shoes.getVisibility());
//        outState.putInt("mouth", mouth.getVisibility());
//        outState.putInt("glasses", glasses.getVisibility());
//
//        EditText input_energy = findViewById(R.id.input_energy);
//        EditText input_efpc = findViewById(R.id.input_efpc);
//        EditText input_built_land = findViewById(R.id.input_bl);
//        EditText input_mobility = findViewById(R.id.input_mobility);
//        EditText input_food = findViewById(R.id.input_food);
//        EditText input_waste = findViewById(R.id.input_waste);
//        EditText input_water = findViewById(R.id.input_water);
//        EditText input_paper = findViewById(R.id.input_paper);
//
//        outState.putString("i_efpc", input_efpc.getText().toString());
//    }


    public void CompareEf(View v){
        try{
            TextView efpc = findViewById(R.id.efpc);
            TextView energy = findViewById(R.id.energy);
            TextView built_land = findViewById(R.id.built_land);
            TextView mobility = findViewById(R.id.mobility);
            TextView food = findViewById(R.id.food);
            TextView waste = findViewById(R.id.waste);
            TextView water = findViewById(R.id.water);
            TextView paper = findViewById(R.id.paper);

            efpc.setText("");
            energy.setText("");
            built_land.setText("");
            mobility.setText("");
            food.setText("");
            waste.setText("");
            water.setText("");
            paper.setText("");

            EditText input_energy = findViewById(R.id.input_energy);
            EditText input_efpc = findViewById(R.id.input_efpc);
            EditText input_built_land = findViewById(R.id.input_bl);
            EditText input_mobility = findViewById(R.id.input_mobility);
            EditText input_food = findViewById(R.id.input_food);
            EditText input_waste = findViewById(R.id.input_waste);
            EditText input_water = findViewById(R.id.input_water);
            EditText input_paper = findViewById(R.id.input_paper);

            try{
                if (!input_efpc.getText().toString().isEmpty()) {
                    efpc.setVisibility(VISIBLE);
                    Float efpc_f = Float.parseFloat(input_efpc.getText().toString());
                    Log.d("input", input_efpc.getText().getClass().getName());
                    Float end_efpc = Float.valueOf(new DecimalFormat("#.#").format((((efpc_calc - efpc_f) / efpc_calc) * 100)));
                    if (end_efpc < 0) {
                        efpc.setText(Html.fromHtml("Per capita % difference with BP <font color='red'>" + end_efpc.toString().substring(1) + "%</font>"));
                    } else {
                        efpc.setText(Html.fromHtml("Per capita % difference with BP <font color='green'>" + end_efpc + "%</font>"));
                    }
                }
                if (input_efpc.getText().toString().isEmpty()) {
                    efpc.setVisibility(GONE);
                }

            }catch(NumberFormatException e){
                input_efpc.setVisibility(GONE);
                input_efpc.setError("Make sure floating input is written with a dot (.)!");
                }
                try{
                    if (!input_energy.getText().toString().isEmpty()) {
                        energy.setVisibility(VISIBLE);
                        Float energy_f = Float.parseFloat(input_energy.getText().toString());
                        Float end_energy = Float.valueOf(new DecimalFormat("#.#").format((((energy_calc - energy_f) / energy_calc) * 100)));
                        if (end_energy < 0) {
                            energy.setText(Html.fromHtml("Energy % difference with BP <font color='red'>" + end_energy.toString().substring(1) + "%</font>"));
                        } else {
                            energy.setText(Html.fromHtml("Energy % difference with BP <font color='green'>" + end_energy + "%</font>"));
                        }
                    }

                    if (input_energy.getText().toString().isEmpty()) {
                        energy.setVisibility(GONE);
                    }
                }
                catch(NumberFormatException e){
                    energy.setVisibility(GONE);
                    input_energy.setError("Make sure floating input is written with a dot (.)!");
                }

                try {
                    if (!input_mobility.getText().toString().isEmpty()) {
                        mobility.setVisibility(VISIBLE);
                        Float mobility_f = Float.parseFloat(input_mobility.getText().toString());
                        Float end_mobility = Float.valueOf(new DecimalFormat("#.#").format((((mobility_calc - mobility_f) / mobility_calc) * 100)));
                        if (end_mobility < 0) {
                            mobility.setText(Html.fromHtml("Mobility % difference with BP <font color='red'>" + end_mobility.toString().substring(1) + "%</font>"));
                        } else {
                            mobility.setText(Html.fromHtml("Mobility % difference with BP <font color='green'>" + end_mobility + "%</font>"));
                        }
                    }

                    if (input_mobility.getText().toString().isEmpty()) {
                        mobility.setVisibility(GONE);
                    }
                }catch(NumberFormatException e){
                    mobility.setVisibility(GONE);
                    input_mobility.setError("Make sure floating input is written with a dot (.)!");
                }

                try {
                    if (!input_food.getText().toString().isEmpty()) {
                        food.setVisibility(VISIBLE);
                        Float food_f = Float.parseFloat(input_food.getText().toString());
                        Float end_food = Float.valueOf(new DecimalFormat("#.#").format((((food_calc - food_f) / food_calc) * 100)));
                        if (end_food < 0) {
                            food.setText(Html.fromHtml("Food % difference with BP <font color='red'>" + end_food.toString().substring(1) + "%</font>"));
                        } else {
                            food.setText(Html.fromHtml("Food % difference with BP <font color='green'>" + end_food + "%</font>"));
                        }
                    }

                    if (input_food.getText().toString().isEmpty()) {
                        food.setVisibility(GONE);
                    }
                }catch(NumberFormatException e){
                    food.setVisibility(GONE);
                    input_food.setError("Make sure floating input is written with a dot (.)!");
                }

                try{
                if (!input_built_land.getText().toString().isEmpty()) {
                    built_land.setVisibility(VISIBLE);
                    Float built_land_f = Float.parseFloat(input_built_land.getText().toString());
                    Float end_built_land = Float.valueOf(new DecimalFormat("#.#").format((((bl_calc - built_land_f) / bl_calc) * 100)));
                    if (end_built_land < 0) {
                        built_land.setText(Html.fromHtml("Built land % difference with BP <font color='red'>" + end_built_land.toString().substring(1) + "%</font>"));
                    } else {
                        built_land.setText(Html.fromHtml("Built land % difference with BP <font color='green'>" + end_built_land + "%</font>"));
                    }
                }

                if (input_built_land.getText().toString().isEmpty()) {
                built_land.setVisibility(GONE);
                }

                }catch(NumberFormatException e){
                    built_land.setVisibility(GONE);
                    input_built_land.setError("Make sure floating input is written with a dot (.)!");
                }
                try {
                    if (!input_paper.getText().toString().isEmpty()) {
                        paper.setVisibility(VISIBLE);
                        Float paper_f = Float.parseFloat(input_paper.getText().toString());
                        Float end_paper = Float.valueOf(new DecimalFormat("#.#").format((((paper_calc - paper_f) / paper_calc) * 100)));
                        if (end_paper < 0) {
                            paper.setText(Html.fromHtml("Paper % difference with BP <font color='red'>" + end_paper.toString().substring(1) + "%</font>"));
                        } else {
                            paper.setText(Html.fromHtml("Paper % difference with BP <font color='green'>" + end_paper + "%</font>"));
                        }
                    }

                    if (input_paper.getText().toString().isEmpty()) {
                        paper.setVisibility(GONE);
                    }
                }catch(NumberFormatException e){
                    paper.setVisibility(GONE);
                    input_paper.setError("Make sure floating input is written with a dot (.)!");
                }

                try {
                    if (!input_waste.getText().toString().isEmpty()) {
                        waste.setVisibility(VISIBLE);
                        Float waste_f = Float.parseFloat(input_waste.getText().toString());
                        Float end_waste = Float.valueOf(new DecimalFormat("#.#").format((((waste_calc - waste_f) / waste_calc) * 100)));
                        if (end_waste < 0) {
                            waste.setText(Html.fromHtml("Waste % difference with BP <font color='red'>" + end_waste.toString().substring(1) + "%</font>"));
                        } else {
                            waste.setText(Html.fromHtml("Waste % difference with BP <font color='green'>" + end_waste + "%</font>"));
                        }
                    }

                    if (input_waste.getText().toString().isEmpty()) {
                        waste.setVisibility(GONE);
                    }
                }catch(NumberFormatException e){
                    waste.setVisibility(GONE);
                    input_waste.setError("Make sure floating input is written with a dot (.)!");
                }

                try {
                    if (!input_water.getText().toString().isEmpty()) {
                        water.setVisibility(VISIBLE);
                        Float water_f = Float.parseFloat(input_water.getText().toString());
                        Float end_water = Float.valueOf(new DecimalFormat("#.#").format(((water_calc - water_f) / water_calc) * 100));
                        if (end_water < 0) {
                            water.setText(Html.fromHtml("Water % difference with BP <font color='red'>" + end_water.toString().substring(1) + "%</font>"));
                        } else {
                            water.setText(Html.fromHtml("Water % difference with BP <font color='green'>" + end_water + "%</font>"));
                        }
                    }

                    if (input_water.getText().toString().isEmpty()) {
                        water.setVisibility(GONE);
                    }
                }catch(NumberFormatException e){
                    water.setVisibility(GONE);
                    input_water.setError("Make sure floating input is written with a dot (.)!");
                }
        }
        catch (Exception e){
            Toast.makeText(this, "Something went wrong!",Toast.LENGTH_LONG).show();
        }
    }
}
