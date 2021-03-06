package com.example.project_aoe2.Technology;

import com.example.project_aoe2.ApiObjects.Technology;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetTechnologies implements GetRawData.IProcessRawData{
    private final List<Technology> technologyList;
    private final IDisplay display;

    // download the json file from the api and will trigger processRawData to convert into Java Object
    public GetTechnologies(String url, IDisplay context){
        this.technologyList = new ArrayList<Technology>();
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    // convert json to Java Object
    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonData = new JSONObject(json);
            JSONArray items = jsonData.getJSONArray("technologies");
            for(int i = 0; i < items.length(); i++){
                JSONObject jsonTechnology = items.getJSONObject(i);

                // retrieve data of each attribute of the json
                int id = jsonTechnology.getInt("id");
                String name = jsonTechnology.getString("name");

                // Create civilization
                Technology technology = new Technology(id, name);

                // Add it to the list
                technologyList.add(technology);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        display.displayTechnology(this.technologyList);
    }
    public interface IDisplay{
        void displayTechnology(List<Technology> technologyList);
    }
}