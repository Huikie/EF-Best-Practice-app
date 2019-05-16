package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class CalculateEfActivity extends AppCompatActivity {

    Float efpc_calc, energy_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_ef);
        Intent intent = getIntent();
        Float efpc = intent.getFloatExtra("efpc", 0);
        Float energy = intent.getFloatExtra("energy", 0);
        efpc_calc = efpc;
        energy_calc = energy;
    }

    public void CompareEf(View v){
        try{
            TextView efpc = findViewById(R.id.efpc);
            TextView energy = findViewById(R.id.energy);
            efpc.setText("");
            energy.setText("");
            EditText input_energy = findViewById(R.id.input_energy);
            EditText input_efpc = findViewById(R.id.input_efpc);
            if(!input_efpc.getText().toString().isEmpty()){
                efpc.setVisibility(VISIBLE);
                Float efpc_f = Float.parseFloat(input_efpc.getText().toString());
                efpc.setText("Per capita % difference with BP "+((efpc_calc - efpc_f) / efpc_calc * 100 + " %"));
            }
            if(input_efpc.getText().toString().isEmpty()){
                efpc.setVisibility(GONE);
            }

            if(input_energy.getText().toString().isEmpty()){
                energy.setVisibility(GONE);
            }
            if(!input_energy.getText().toString().isEmpty()) {
                energy.setVisibility(VISIBLE);
                Float energy_f = Float.parseFloat(input_energy.getText().toString());
                energy.setText("Energy % difference with BP " + (((energy_calc - energy_f) / energy_calc)) * 100 + " %");
            }
        }
        catch (Exception e){Log.d("shit", ""+e);}
    }
}
