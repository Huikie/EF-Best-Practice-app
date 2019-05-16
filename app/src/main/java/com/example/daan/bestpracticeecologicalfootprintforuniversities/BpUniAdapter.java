package com.example.daan.bestpracticeecologicalfootprintforuniversities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import android.support.annotation.NonNull;

public class BpUniAdapter extends ArrayAdapter<University_bp> {
    ArrayList<University_bp> bp_universities;
    // Constructor
    public BpUniAdapter(@NonNull Context context, int resource, @NonNull ArrayList<University_bp> objects) {
        super(context, resource, objects);
        bp_universities = objects;
    }


    @NonNull
    @Override
    /** Get information from the friends array for every friend in the array and put it in the right views.*/
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bp_item, parent, false);
        }
        int index = position;
        TextView university = convertView.findViewById(R.id.university);
        TextView eenheid = convertView.findViewById(R.id.eenheid);
        //EditText input = convertView.findViewById(R.id.EF_input);
        //input.setHint(bp_universities.get(index).getValue());
        university.setText(bp_universities.get(index).getUniversity());
        eenheid.setText(Html.fromHtml(""+bp_universities.get(index).getValue()));

        return convertView;
    }

}

