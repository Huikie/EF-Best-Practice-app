package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity implements UniversityInfoRequest.Callback {

    public Float min_efpc = Float.parseFloat("1");
    public Float min_energy = Float.parseFloat("1");
    public Float min_paper = Float.parseFloat("1");
    public Float min_food = Float.parseFloat("1");
    public Float min_built_land = Float.parseFloat("1");
    public Float min_water = Float.parseFloat("1");
    public Float min_mobility = Float.parseFloat("1");
    public Float min_waste = Float.parseFloat("1");
    public String university_efpc, university_energy, university_paper, university_food, university_built_land, university_water, university_mobility, university_waste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UniversityInfoRequest x = new UniversityInfoRequest(this);
        x.getUniInfo(this);

    }

    @Override
    public void gotUniInfo(ArrayList<University> universities) {
        Toast.makeText(this, "succes", Toast.LENGTH_LONG).show();
        try{
            for(int i=0; i<universities.size();i++) {

                String Efpc = universities.get(i).getEfpc();
                if (!Efpc.isEmpty()) {
                    Float Efpc_i = Float.parseFloat(Efpc);
                    if (Efpc_i < min_efpc) {
                        min_efpc = Efpc_i;
                        university_efpc = universities.get(i).getName();
                    }
                }

                String energy = universities.get(i).getEnergy();
                if (!energy.isEmpty()) {
                    Float energy_i = Float.parseFloat(energy);
                    if (energy_i < min_energy) {
                        min_energy = energy_i;
                        university_energy = universities.get(i).getName();
                    }
                }

                String paper = universities.get(i).getPaper();
                if (!paper.isEmpty()) {
                    Float paper_i = Float.parseFloat(paper);
                    if (paper_i < min_paper) {
                        min_paper = paper_i;
                        university_paper = universities.get(i).getName();
                    }
                }

                String food = universities.get(i).getFood();
                if (!food.isEmpty()) {
                    Float food_i = Float.parseFloat(food);
                    if (food_i < min_food) {
                        min_food = food_i;
                        university_food = universities.get(i).getName();
                    }
                }

                String built_land = universities.get(i).getBuilt_land();
                if (!built_land.isEmpty()) {
                    Float built_land_i = Float.parseFloat(built_land);
                    if (built_land_i < min_built_land) {
                        min_built_land = built_land_i;
                        university_built_land = universities.get(i).getName();
                    }
                }

                String water = universities.get(i).getWater();
                if (!water.isEmpty()) {
                    Float water_i = Float.parseFloat(water);
                    if (water_i < min_water) {
                        min_water = water_i;
                        university_water = universities.get(i).getName();
                    }
                }

                String mobility = universities.get(i).getMobility();
                if (!mobility.isEmpty()) {
                    Float mobility_i = Float.parseFloat(mobility);
                    if (mobility_i < min_mobility) {
                        min_mobility = mobility_i;
                        university_mobility = universities.get(i).getName();
                    }
                }

                String waste = universities.get(i).getWaste();
                if (!waste.isEmpty()) {
                    Float waste_i = Float.parseFloat(waste);
                    if (waste_i < min_waste) {
                        min_waste = waste_i;
                        university_waste = universities.get(i).getName();
                    }
                }

            }
            ArrayList<University_bp> bp_unis = new ArrayList<>();
            bp_unis.add(new University_bp(university_efpc, "<b>EF:</b> "+min_efpc));
            bp_unis.add(new University_bp(university_energy, "<b>Energy EF:</b> "+min_energy));
            bp_unis.add(new University_bp(university_paper, "<b>Paper EF:</b> "+min_paper));
            bp_unis.add(new University_bp(university_food, "<b>Food EF:</b> "+min_food));
            bp_unis.add(new University_bp(university_built_land,"<b>Built land EF:</b> "+min_built_land));
            bp_unis.add(new University_bp(university_water, "<b>Water EF:</b> "+min_water));
            bp_unis.add(new University_bp(university_mobility, "<b>Mobility EF:</b> "+min_mobility));
            bp_unis.add(new University_bp(university_waste, "<b>Waste EF:</b> "+min_waste));

            // Sort the spots in alphabetic order based on the spot name.
            Collections.sort(bp_unis);

            BpUniAdapter adapter = new BpUniAdapter(this, R.layout.bp_item, bp_unis);
            ListView lv = findViewById(R.id.bp_list);
            lv.setAdapter(adapter);

        }catch(Exception e){
            Log.d("jammer", ""+e);
        }
    }

    @Override
    public void gotUniInfoError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void CalculateEf(View v){
        Intent intent = new Intent(this, CalculateEfActivity.class);
        intent.putExtra("efpc",min_efpc);
        intent.putExtra("energy",min_energy);
        intent.putExtra("mobility",min_mobility);
        intent.putExtra("food",min_food);
        intent.putExtra("waste",min_waste);
        intent.putExtra("water",min_water);
        intent.putExtra("built_land",min_built_land);
        intent.putExtra("paper",min_paper);
        startActivity(intent);
    }

}
