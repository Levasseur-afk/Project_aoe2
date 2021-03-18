package com.example.project_aoe2.Technology;

import com.example.project_aoe2.ApiObjects.Cost;
import com.example.project_aoe2.ApiObjects.Technology;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetTechnology implements GetRawData.IProcessRawData{
    private Technology technology;
    private IDisplay display;

    public GetTechnology(String url, IDisplay context){
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonTechnology = new JSONObject(json);
            technology = new Technology();
            if(!jsonTechnology.isNull("id")){
                technology.setId(jsonTechnology.getInt("id"));
            }
            if(!jsonTechnology.isNull("name")){
                technology.setName(jsonTechnology.getString("name"));
            }
            if(!jsonTechnology.isNull("description")){
                technology.setDescription(jsonTechnology.getString("description"));
            }
            if(!jsonTechnology.isNull("expansion")){
                technology.setExpansion(jsonTechnology.getString("expansion"));
            }
            if(!jsonTechnology.isNull("age")){
                technology.setAge(jsonTechnology.getString("age"));
            }
            if(!jsonTechnology.isNull("develops_in")){
                technology.setDevelops_in(jsonTechnology.getString("develops_in"));
            }
            if(!jsonTechnology.isNull("cost")){
                JSONObject jsonCost = jsonTechnology.getJSONObject("cost");
                Cost cost = new Cost();
                if(!jsonCost.isNull("Wood")){
                    cost.setWood(jsonCost.getInt("Wood"));
                }
                if(!jsonCost.isNull("Food")){
                    cost.setFood(jsonCost.getInt("Food"));
                }
                if(!jsonCost.isNull("Stone")){
                    cost.setStone(jsonCost.getInt("Stone"));
                }
                if(!jsonCost.isNull("Gold")){
                    cost.setGold(jsonCost.getInt("Gold"));
                }
                technology.setCost(cost);
            }
            if(!jsonTechnology.isNull("build_time")){
                technology.setBuild_time(jsonTechnology.getInt("build_time"));
            }
            if(!jsonTechnology.isNull("applies_to")){
                List<String> applies_to = new ArrayList<String>();
                JSONArray a = jsonTechnology.getJSONArray("applies_to");
                for(int j = 0; j < a.length(); j++){
                    applies_to.add(a.getString(j));
                }
                technology.setApplies_to(applies_to);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        display.displayTechnology(technology);
    }
    interface IDisplay{
        public void displayTechnology(Technology technology);
    }
}