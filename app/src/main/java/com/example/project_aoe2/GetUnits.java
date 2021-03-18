package com.example.project_aoe2;

import android.util.Log;

import com.example.project_aoe2.ApiObjects.Cost;
import com.example.project_aoe2.ApiObjects.Unit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetUnits implements GetRawData.IProcessRawData{
    private List<Unit> unitList;
    private IDisplay display;

    public GetUnits(String url, IDisplay context){
        this.unitList = new ArrayList<Unit>();
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonData = new JSONObject(json);
            JSONArray items = jsonData.getJSONArray("units");
            for(int i = 0; i < items.length(); i++){
                JSONObject jsonUnit = items.getJSONObject(i);

                // retrieve data of each attribute of the json
                int id = jsonUnit.getInt("id");
                String name = jsonUnit.getString("name");

                // create Unit object
                Unit unit = new Unit(id, name);

                // Add it to the list
                unitList.add(unit);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(Unit unit : unitList){
            Log.d("UNIT", unit.toString());
        }
        display.displayUnit(this.unitList);
    }
    interface IDisplay{
        public void displayUnit(List<Unit> unitList);
    }
}
