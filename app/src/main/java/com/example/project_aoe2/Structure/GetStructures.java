package com.example.project_aoe2.Structure;


import com.example.project_aoe2.ApiObjects.Structure;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetStructures implements GetRawData.IProcessRawData{
    private final List<Structure> structureList;
    private final IDisplay display;

    // download the json file from the api and will trigger processRawData to convert into Java Object
    public GetStructures(String url, IDisplay context){
        this.structureList = new ArrayList<Structure>();
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    // convert json to Java Object
    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonData = new JSONObject(json);
            JSONArray items = jsonData.getJSONArray("structures");
            for(int i = 0; i < items.length(); i++){
                JSONObject jsonStructure = items.getJSONObject(i);

                // retrieve data of each attribute of the json
                int id = jsonStructure.getInt("id");
                String name = jsonStructure.getString("name");

                // Create civilization
                Structure structure = new Structure(id, name);

                // Add it to the list
                structureList.add(structure);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        display.displayStructure(this.structureList);
    }
    public interface IDisplay{
        void displayStructure(List<Structure> structureList);
    }
}
