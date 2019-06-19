package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class CompareEfActivity extends AppCompatActivity {

    Float efpc_calc, energy_calc, mobility_calc, food_calc, waste_calc, water_calc, paper_calc, bl_calc;
    Float efpc_comp, energy_comp, mobility_comp, food_comp, waste_comp, water_comp, paper_comp, bl_comp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_ef);

        Intent intent = getIntent();

        Float energy = intent.getFloatExtra("energy",0);
        Float built_land = intent.getFloatExtra("built_land",0);
        Float mobility = intent.getFloatExtra("mobility",0);
        Float waste = intent.getFloatExtra("waste", 0);
        Float water = intent.getFloatExtra("water", 0);
        Float food = intent.getFloatExtra("food", 0);
        Float paper = intent.getFloatExtra("paper", 0);

        energy_calc = energy;
        mobility_calc = mobility;
        food_calc = food;
        waste_calc = waste;
        water_calc = water;
        paper_calc = paper;
        bl_calc = built_land;
        efpc_calc = energy + mobility + food + waste + water + paper + built_land;

        Intent intent2 = getIntent();

        Float min_energy = intent2.getFloatExtra("min_energy",0);
        Float min_built_land = intent2.getFloatExtra("min_built_land",0);
        Float min_mobility = intent2.getFloatExtra("min_mobility",0);
        Float min_waste = intent2.getFloatExtra("min_waste", 0);
        Float min_water = intent2.getFloatExtra("min_water", 0);
        Float min_food = intent2.getFloatExtra("min_food", 0);
        Float min_paper = intent2.getFloatExtra("min_paper", 0);
        Float min_efpc = intent2.getFloatExtra("min_efpc", 0);

        String uni_name = intent2.getStringExtra("uni_name");

        energy_comp = min_energy;
        mobility_comp = min_mobility;
        food_comp = min_food;
        waste_comp = min_waste;
        water_comp = min_water;
        paper_comp = min_paper;
        bl_comp = min_built_land;
        efpc_comp = min_efpc;


        TextView efpc_txt = findViewById(R.id.efpc);
        TextView energy_txt = findViewById(R.id.energy);
        TextView built_land_txt = findViewById(R.id.built_land);
        TextView mobility_txt = findViewById(R.id.mobility);
        TextView food_txt = findViewById(R.id.food);
        TextView waste_txt = findViewById(R.id.waste);
        TextView water_txt = findViewById(R.id.water);
        TextView paper_txt = findViewById(R.id.paper);
        TextView no_input = findViewById(R.id.no_input);

        ImageView bl_image = findViewById(R.id.bl_image);
        ImageView food_image = findViewById(R.id.food_image);
        ImageView paper_image = findViewById(R.id.paper_image);
        ImageView waste_image = findViewById(R.id.waste_image);
        ImageView water_image = findViewById(R.id.water_image);
        ImageView energy_image = findViewById(R.id.energy_image);
        ImageView mobility_image = findViewById(R.id.mobility_image);
        ImageView efpc_image = findViewById(R.id.efpc_image);


                if (efpc_calc != 0) {
                    efpc_txt.setVisibility(VISIBLE);
                    efpc_image.setVisibility(VISIBLE);
                    Float end_efpc = Float.valueOf(new DecimalFormat("#.#").format((((efpc_comp - efpc_calc) / efpc_comp) * 100)));
                    // and that is "+ end_efpc.toString().substring(1) + "% worse than BP.
                    Float absolute_efpc = efpc_comp - efpc_calc;
                    if (end_efpc < 0) {
                        efpc_txt.setText(Html.fromHtml(uni_name+"'s <b>EF per capita</b> is "+efpc_calc+". The BP EF per capita is "+efpc_comp+". "+uni_name+"'s EF per capita is <font color='red'>" + absolute_efpc.toString().substring(1) + "</font> away from BP."));
                    } else {
                        efpc_txt.setText(Html.fromHtml(uni_name+"'s <b>EF per capita</b> is "+efpc_calc+". The BP EF per capita is "+efpc_comp+". "+uni_name+"'s EF per capita is <font color='green'>" + absolute_efpc + "</font> better than BP."));
                    }
                } else {
                    efpc_txt.setVisibility(GONE);
                    no_input.setVisibility(VISIBLE);
                    efpc_image.setVisibility(GONE);
                }

                if (energy_calc != 0) {
                    energy_txt.setVisibility(VISIBLE);
                    Float end_energy = Float.valueOf(new DecimalFormat("#.#").format((((energy_comp - energy_calc) / energy_comp) * 100)));
                    Float absolute_energy = energy_comp - energy_calc;
                    if (end_energy < 0) {
                        energy_txt.setText(Html.fromHtml(uni_name+"'s <b>energy EF</b> is "+energy_calc+". The BP energy EF is "+energy_comp+". "+uni_name+"'s energy EF is <font color='red'>" + absolute_energy.toString().substring(1) + "</font> away from BP."));
                    } else {
                        energy_txt.setText(Html.fromHtml(uni_name+"'s <b>energy EF</b> is "+energy_calc+". The BP energy EF is "+energy_comp+". "+uni_name+"'s energy EF is <font color='green'>" + absolute_energy + "</font> better than BP."));
                    }
                } else {
                    energy_txt.setVisibility(GONE);
                    energy_image.setVisibility(GONE);
                }

                if (bl_calc != 0) {
                    built_land_txt.setVisibility(VISIBLE);
                    bl_image.setVisibility(VISIBLE);
                    Float end_built_land = Float.valueOf(new DecimalFormat("#.#").format((((bl_comp - bl_calc) / bl_comp) * 100)));
                    Float absolute_bl = bl_comp - bl_calc;
                    if (end_built_land < 0) {
                        built_land_txt.setText(Html.fromHtml(uni_name+"'s <b>built land EF</b> is "+bl_calc+". The BP built land EF is "+bl_comp+". "+uni_name+"'s built land EF is <font color='red'>" + absolute_bl.toString().substring(1) + "</font> away from BP."));
                    } else {
                        built_land_txt.setText(Html.fromHtml(uni_name+"'s <b>built land EF</b> is "+bl_calc+". The BP built land EF is "+bl_comp+". "+uni_name+"'s built land EF is <font color='green'>" + absolute_bl + "</font> better than BP."));
                    }
                } else {
                    built_land_txt.setVisibility(GONE);
                    bl_image.setVisibility(GONE);
                }

                if (mobility_calc != 0) {
                    mobility_txt.setVisibility(VISIBLE);
                    mobility_image.setVisibility(VISIBLE);
                    Float end_mobility = Float.valueOf(new DecimalFormat("#.#").format((((mobility_comp - mobility_calc) / mobility_comp) * 100)));
                    Float absolute_mobility = mobility_comp - mobility_calc;
                    if (end_mobility < 0) {
                        mobility_txt.setText(Html.fromHtml(uni_name+"'s <b>mobility EF</b> is "+mobility_calc+". The BP mobility EF is "+mobility_comp+". "+uni_name+"'s mobility EF is <font color='red'>" + absolute_mobility.toString().substring(1) + "</font> away from BP."));
                    } else {
                        mobility_txt.setText(Html.fromHtml(uni_name+"'s <b>mobility EF</b> is "+mobility_calc+". The BP mobility EF is "+mobility_comp+". "+uni_name+"'s mobility EF is <font color='green'>" + absolute_mobility + "</font> better than BP."));
                    }
                } else {
                    mobility_txt.setVisibility(GONE);
                    mobility_image.setVisibility(GONE);
                }

                if (food_calc != 0) {
                    food_txt.setVisibility(VISIBLE);
                    food_image.setVisibility(VISIBLE);
                    Float end_food = Float.valueOf(new DecimalFormat("#.#").format((((food_comp - food_calc) / food_comp) * 100)));
                    Float absolute_food = food_comp - food_calc;
                    if (end_food < 0) {
                        food_txt.setText(Html.fromHtml(uni_name+"'s <b>food EF</b> is "+food_calc+". The BP food EF is "+food_comp+". "+uni_name+"'s food EF is <font color='red'>" + absolute_food.toString().substring(1) + "</font> away from BP."));
                    } else {
                        food_txt.setText(Html.fromHtml(uni_name+"'s <b>food EF</b> is "+food_calc+". The BP food EF is "+food_comp+". "+uni_name+"'s food EF is <font color='green'>" + absolute_food + "</font> better than BP."));
                    }
                } else {
                    food_txt.setVisibility(GONE);
                    food_image.setVisibility(GONE);
                }

                if (waste_calc != 0) {
                    waste_txt.setVisibility(VISIBLE);
                    waste_image.setVisibility(VISIBLE);
                    Float end_waste = Float.valueOf(new DecimalFormat("#.#").format((((waste_comp - waste_calc) / waste_comp) * 100)));
                    Float absolute_waste = waste_comp - waste_calc;
                    if (end_waste < 0) {
                        waste_txt.setText(Html.fromHtml(uni_name+"'s <b>waste EF</b> is "+waste_calc+". The BP waste EF is "+waste_comp+". "+uni_name+"'s waste EF is <font color='red'>" + absolute_waste.toString().substring(1) + "</font> away from BP."));
                    } else {
                        waste_txt.setText(Html.fromHtml(uni_name+"'s <b>waste EF</b> is "+waste_calc+". The BP waste EF is "+waste_comp+". "+uni_name+"'s waste EF is <font color='green'>" + absolute_waste + "</font> better than BP."));
                    }
                } else {
                    waste_txt.setVisibility(GONE);
                    waste_image.setVisibility(GONE);
                }

                if (water_calc != 0) {
                    water_txt.setVisibility(VISIBLE);
                    water_image.setVisibility(VISIBLE);
                    Float end_water = Float.valueOf(new DecimalFormat("#.#").format((((water_comp - water_calc) / water_comp) * 100)));
                    Float absolute_water = water_comp - water_calc;
                    if (end_water < 0) {
                        water_txt.setText(Html.fromHtml(uni_name+"'s <b>water EF</b> is "+water_calc+". The BP water EF is "+water_comp+". "+uni_name+"'s water EF is <font color='red'>" + absolute_water.toString().substring(1) + "</font> away from BP."));
                    } else {
                        water_txt.setText(Html.fromHtml(uni_name+"'s <b>water EF</b> is "+water_calc+". The BP water EF is "+water_comp+". "+uni_name+"'s water EF is <font color='green'>" + absolute_water + "</font> better than BP."));
                    }
                } else {
                    water_txt.setVisibility(GONE);
                    water_image.setVisibility(GONE);
                }

                if (paper_calc != 0) {
                    paper_txt.setVisibility(VISIBLE);
                    paper_image.setVisibility(VISIBLE);
                    Float end_paper = Float.valueOf(new DecimalFormat("#.#").format((((paper_comp - paper_calc) / paper_comp) * 100)));
                    Float absolute_paper = paper_comp - paper_calc;
                    if (end_paper < 0) {
                        paper_txt.setText(Html.fromHtml(uni_name+"'s <b>paper EF</b> is "+paper_calc+". The BP paper EF is "+paper_comp+". "+uni_name+"'s paper EF is <font color='red'>" + absolute_paper.toString().substring(1) + "</font> away from BP."));
                    } else {
                        paper_txt.setText(Html.fromHtml(uni_name+"'s <b>paper EF</b> is "+paper_calc+". The BP paper EF is "+paper_comp+". "+uni_name+"'s paper EF is <font color='green'>" + absolute_paper + "</font> better than BP."));
                    }
                } else {
                    paper_txt.setVisibility(GONE);
                    paper_image.setVisibility(GONE);
                }
}

}
