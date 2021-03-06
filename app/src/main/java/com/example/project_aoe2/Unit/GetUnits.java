package com.example.project_aoe2.Unit;


import android.util.Log;

import com.example.project_aoe2.ApiObjects.Unit;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetUnits implements GetRawData.IProcessRawData{
    private final List<Unit> unitList;
    private final IDisplay display;

    // download the json file from the api and will trigger processRawData to convert into Java Object
    public GetUnits(String url, IDisplay context){
        this.unitList = new ArrayList<Unit>();
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    // convert json to Java Object
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
        for (Unit unit : unitList){
            Log.d("UNIT", unit.getName());
        }
        display.displayUnit(this.unitList);
    }
    interface IDisplay{
        void displayUnit(List<Unit> unitList);
    }
}
