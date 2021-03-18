package com.example.project_aoe2.Unit;

import com.example.project_aoe2.ApiObjects.Cost;
import com.example.project_aoe2.ApiObjects.Unit;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetUnit implements GetRawData.IProcessRawData{
    private Unit unit;
    private IDisplay display;

    public GetUnit(String url, IDisplay context){
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    @Override
    public void processRawData(String json){
        try {
            unit = new Unit();
            JSONObject jsonUnit = new JSONObject(json);

            // retrieve data of each attribute of the json

            if(!jsonUnit.isNull("id")){
                unit.setId(jsonUnit.getInt("id"));
            }
            if(!jsonUnit.isNull("name")){
                unit.setName(jsonUnit.getString("name"));
            }
            if(!jsonUnit.isNull("description")){
                unit.setDescription(jsonUnit.getString("description"));
            }
            if(!jsonUnit.isNull("expansion")){
                unit.setExpansion(jsonUnit.getString("expansion"));
            }
            if(!jsonUnit.isNull("age")){
                unit.setAge(jsonUnit.getString("age"));
            }
            if(!jsonUnit.isNull("created_in")){
                unit.setCreated_in(jsonUnit.getString("created_in"));
            }
            if(!jsonUnit.isNull("cost")){
                JSONObject jsonCost = jsonUnit.getJSONObject("cost");
                Cost cost = new Cost();
                if(!jsonUnit.isNull("Wood")){
                    cost.setWood(jsonCost.getInt("Wood"));
                }
                if(!jsonUnit.isNull("Food")){
                    cost.setFood(jsonCost.getInt("Food"));
                }
                if(!jsonUnit.isNull("Stone")){
                    cost.setStone(jsonCost.getInt("Stone"));
                }
                if(!jsonUnit.isNull("Gold")){
                    cost.setGold(jsonCost.getInt("Gold"));
                }
            }
            if(!jsonUnit.isNull("build_time")){
                unit.setBuild_time(jsonUnit.getInt("build_time"));
            }
            if(!jsonUnit.isNull("reload_time")){
                unit.setReload_time(jsonUnit.getInt("reload_time"));
            }
            if(!jsonUnit.isNull("attack_delay")){
                unit.setAttack_delay(jsonUnit.getInt("attack_delay"));
            }
            if(!jsonUnit.isNull("movement_rate")){
                unit.setMovement_rate(jsonUnit.getInt("movement_rate"));
            }
            if(!jsonUnit.isNull("line_of_sight")){
                unit.setLine_of_sight(jsonUnit.getInt("line_of_sight"));
            }
            if(!jsonUnit.isNull("hit_points")){
                unit.setHit_points(jsonUnit.getInt("hit_points"));
            }
            if(!jsonUnit.isNull("range")){
                unit.setRange(jsonUnit.getString("range"));
            }
            if(!jsonUnit.isNull("attack")){
                unit.setAttack(jsonUnit.getInt("attack"));
            }
            if(!jsonUnit.isNull("armor")){
                unit.setArmor(jsonUnit.getString("armor"));
            }
            if(!jsonUnit.isNull("attack_bonus")){
                List<String> attack_bonus = new ArrayList<String>();
                JSONArray attack_b = jsonUnit.getJSONArray("attack_bonus");
                for(int j = 0; j < attack_b.length(); j++){
                    attack_bonus.add(attack_b.getString(j));
                }
                unit.setAttack_bonus(attack_bonus);
            }
            if(!jsonUnit.isNull("armor_bonus")){
                List<String> armor_bonus = new ArrayList<String>();
                JSONArray armor_b = jsonUnit.getJSONArray("armor_bonus");
                for(int j = 0; j < armor_b.length(); j++){
                    armor_bonus.add(armor_b.getString(j));
                }
                unit.setArmor_bonus(armor_bonus);
            }
            if(!jsonUnit.isNull("search_radius")){
                unit.setSearch_radius(jsonUnit.getInt("search_radius"));
            }
            if(!jsonUnit.isNull("accuracy")){
                unit.setAccuracy(jsonUnit.getString("accuracy"));
            }
            if(!jsonUnit.isNull("blast_radius")){
                unit.setBlast_radius(jsonUnit.getInt("blast_radius"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        display.displayUnit(this.unit);
    }
    interface IDisplay{
        public void displayUnit(Unit unit);
    }
}
