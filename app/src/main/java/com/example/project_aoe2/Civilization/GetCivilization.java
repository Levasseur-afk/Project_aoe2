package com.example.project_aoe2.Civilization;

import com.example.project_aoe2.ApiObjects.Civilization;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetCivilization implements GetRawData.IProcessRawData{
    private Civilization civilization;
    private final IDisplay display;

    // download the json file from the api and will trigger processRawData to convert into Java Object
    public GetCivilization(String url, IDisplay context){
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    // convert json to Java Object
    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonCivilization = new JSONObject(json);
            civilization = new Civilization();
            // making sure I don't call a missing json key
            if(!jsonCivilization.isNull("id")){
                civilization.setId(jsonCivilization.getInt("id"));
            }
            if(!jsonCivilization.isNull("name")){
                civilization.setName(jsonCivilization.getString("name"));
            }
            if(!jsonCivilization.isNull("expansion")){
                civilization.setExpansion(jsonCivilization.getString("expansion"));
            }
            if(!jsonCivilization.isNull("army_type")){
                civilization.setArmy_type(jsonCivilization.getString("army_type"));
            }
            if(!jsonCivilization.isNull("unique_unit")){
                List<String> unique_unit = new ArrayList<String>();
                JSONArray units = jsonCivilization.getJSONArray("unique_unit");
                for(int j = 0; j < units.length(); j++){
                    unique_unit.add(units.getString(j));
                }
                civilization.setUnique_unit(unique_unit);
            }
            if(!jsonCivilization.isNull("unique_tech")){
                List<String> unique_tech = new ArrayList<String>();
                JSONArray techs = jsonCivilization.getJSONArray("unique_tech");
                for(int j = 0; j < techs.length(); j++){
                    unique_tech.add(techs.getString(j));
                }
                civilization.setUnique_tech(unique_tech);
            }
            if(!jsonCivilization.isNull("team_bonus")){
                civilization.setTeam_bonus(jsonCivilization.getString("team_bonus"));
            }
            if(!jsonCivilization.isNull("civilization_bonus")){
                List<String> civilization_bonus = new ArrayList<String>();
                JSONArray bonus = jsonCivilization.getJSONArray("civilization_bonus");
                for(int j = 0; j < bonus.length(); j++){
                    civilization_bonus.add(bonus.getString(j));
                }
                civilization.setCivilization_bonus(civilization_bonus);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        display.displayCivilization(civilization);
    }
    public interface IDisplay{
        void displayCivilization(Civilization civilization);
    }
}
