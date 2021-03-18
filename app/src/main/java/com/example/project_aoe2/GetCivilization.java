package com.example.project_aoe2;

import android.util.Log;

import com.example.project_aoe2.ApiObjects.Civilization;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetCivilization implements GetRawData.IProcessRawData{
    private Civilization civilization;
    private IDisplay display;

    public GetCivilization(String url, IDisplay context){
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonCivilization = new JSONObject(json);

            int id = jsonCivilization.getInt("id");
            String name = jsonCivilization.getString("name");
            String expansion = jsonCivilization.getString("expansion");
            String army_type = jsonCivilization.getString("army_type");

            List<String> unique_unit = new ArrayList<String>();
            JSONArray units = jsonCivilization.getJSONArray("unique_unit");
            for(int j = 0; j < units.length(); j++){
                unique_unit.add(units.getString(j));
            }
            List<String> unique_tech = new ArrayList<String>();
            JSONArray techs = jsonCivilization.getJSONArray("unique_tech");
            for(int j = 0; j < techs.length(); j++){
                unique_tech.add(techs.getString(j));
            }
            String team_bonus = jsonCivilization.getString("team_bonus");

            List<String> civilization_bonus = new ArrayList<String>();
            JSONArray bonus = jsonCivilization.getJSONArray("civilization_bonus");
            for(int j = 0; j < bonus.length(); j++){
                civilization_bonus.add(bonus.getString(j));
            }
            // create Civilization object
            civilization = new Civilization(id, name, expansion, army_type, unique_unit, unique_tech, team_bonus, civilization_bonus);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        display.displayCivilization(civilization);
    }
    interface IDisplay{
        public void displayCivilization(Civilization civilization);
    }
}
