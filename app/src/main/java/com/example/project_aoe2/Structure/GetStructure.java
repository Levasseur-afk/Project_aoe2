package com.example.project_aoe2.Structure;


import com.example.project_aoe2.ApiObjects.Cost;
import com.example.project_aoe2.ApiObjects.Structure;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetStructure implements GetRawData.IProcessRawData{
    private Structure structure;
    private IDisplay display;

    public GetStructure(String url, GetStructure.IDisplay context){
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonStructure = new JSONObject(json);
            structure = new Structure();
            if(!jsonStructure.isNull("id")){
                structure.setId(jsonStructure.getInt("id"));
            }
            if(!jsonStructure.isNull("name")){
                structure.setName(jsonStructure.getString("name"));
            }
            if(!jsonStructure.isNull("description")){
                structure.setDescription(jsonStructure.getString("description"));
            }
            if(!jsonStructure.isNull("expansion")){
                structure.setExpansion(jsonStructure.getString("expansion"));
            }
            if(!jsonStructure.isNull("age")){
                structure.setAge(jsonStructure.getString("age"));
            }
            if(!jsonStructure.isNull("cost")){
                JSONObject jsonCost = jsonStructure.getJSONObject("cost");
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
                structure.setCost(cost);
            }
            if(!jsonStructure.isNull("build_time")){
                structure.setBuild_time(jsonStructure.getInt("build_time"));
            }
            if(!jsonStructure.isNull("hit_points")){
                structure.setHit_points(jsonStructure.getInt("hit_points"));
            }
            if(!jsonStructure.isNull("line_of_sight")){
                structure.setLine_of_sight(jsonStructure.getInt("line_of_sight"));
            }
            if(!jsonStructure.isNull("armor")){
                structure.setArmor(jsonStructure.getString("armor"));
            }
            if(!jsonStructure.isNull("range")){
                structure.setRange(jsonStructure.getString("range"));
            }
            if(!jsonStructure.isNull("reload_time")){
                structure.setReload_time(jsonStructure.getInt("reload_time"));
            }
            if(!jsonStructure.isNull("attack")){
                structure.setAttack(jsonStructure.getInt("attack"));
            }

            if(!jsonStructure.isNull("special")){
                List<String> special = new ArrayList<String>();
                JSONArray s = jsonStructure.getJSONArray("special");
                for(int j = 0; j < s.length(); j++){
                    special.add(s.getString(j));
                }
                structure.setSpecial(special);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        display.displayStructure(structure);
    }
    interface IDisplay{
        public void displayStructure(Structure structure);
    }
}
