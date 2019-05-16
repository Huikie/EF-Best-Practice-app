package com.example.daan.bestpracticeecologicalfootprintforuniversities;

/**Daan Huikeshoven - 11066628
 * University of Amsterdam*/

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**Helper that is used to GET UniInfo from the a spreadsheet script API.*/
public class UniversityInfoRequest implements com.android.volley.Response.Listener<JSONObject>, com.android.volley.Response.ErrorListener{
    private Context context;
    private Callback callbackActivity;
    private ArrayList<University> universities = new ArrayList<>();

    /**Method that makes it possible to do a callback from a different activity.*/
    public interface Callback {
        void gotUniInfo(ArrayList<University> universities);
        void gotUniInfoError(String message);
    }

    // Constructor
    public UniversityInfoRequest(Context context) {
        this.context = context;
    }

    /**This method will attempt to retrieve uni info from the API and if successful,
     * will notify the activity that instantiated the request
     *  that it is done through the callback. */
    public void getUniInfo(Callback activity){
        callbackActivity = activity;

        //Do an API request to an url
        String jsonUrl = "https://script.googleusercontent.com/macros/echo?user_content_key=gJYlwmtryWVSAILJb9gIJx6OodToLLlNr-dLTJiY-r-KpQo7pm3KX8D7k0EZgtGGCI0XEFtnU8VDHgaIgHQXVjF0pOr2jmXQOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUZpDaQxmIJFE15E1AhO5xdXvoUQzz687Ek_Hr5DfoZ7ORT1yk8Kwv8FMWOco81SH1kCxLIU7AeD2LBKv4w0mCCw&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva";
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(jsonUrl, null, this,this);
        queue.add(jsonObjectRequest);
    }

    @Override
    /**When something goes wrong with getting the UniInfo this method displays an error message.*/
    public void onErrorResponse(VolleyError error) {
        callbackActivity.gotUniInfoError(error.getMessage());
    }

    @Override
    /**When everything goes as expected the response parameter will contain a JSONObject with UniInfo where the wanted information can be extracted from.*/
    public void onResponse(JSONObject response) {
        try {
            JSONArray ja = response.getJSONArray("Blad1");
            for (int i = 0; i < ja.length(); i++) {

                JSONObject uni_info = ja.getJSONObject(i);
                String name = uni_info.getString("Universiteiten");
                String location = uni_info.getString("Locatie");
                String research = uni_info.getString("Onderzoek");
                String continent = uni_info.getString("Continent");
                String population = uni_info.getString("Populatie");
                String year = uni_info.getString("Jaar");
                String ef = uni_info.getString("EF");
                String efpc = uni_info.getString("Efpc");
                String energy = uni_info.getString("Energie");
                String mobility = uni_info.getString("Mobiliteit");
                String waste = uni_info.getString("Afval");
                String paper = uni_info.getString("Papier");
                String food = uni_info.getString("Voedsel");
                String built_land = uni_info.getString("Bebouwd_land");
                String water = uni_info.getString("Water");
                universities.add(new University(name, location, research, continent, population, year, ef, efpc, energy, mobility, waste, paper, food, built_land, water));

            }

            // Pass the ArrayList back to the activity that wanted to have it.
            callbackActivity.gotUniInfo(universities);

        }

        catch(JSONException e){
            System.out.println(e.toString());
        }


    }

}