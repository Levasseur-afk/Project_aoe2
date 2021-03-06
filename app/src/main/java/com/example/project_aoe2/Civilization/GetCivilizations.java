package com.example.project_aoe2.Civilization;

import com.example.project_aoe2.ApiObjects.Civilization;
import com.example.project_aoe2.Tools.GetRawData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetCivilizations implements GetRawData.IProcessRawData{
    private final List<Civilization> civilizationList;
    private final IDisplay display;

    // download the json file from the api and will trigger processRawData to convert into Java Object
    public GetCivilizations(String url, IDisplay context){
        this.civilizationList = new ArrayList<Civilization>();
        this.display = context;
        GetRawData getRawData = new GetRawData(url, this);
        getRawData.startDownload();
    }

    // convert json to Java Object
    @Override
    public void processRawData(String json){
        try {
            JSONObject jsonData = new JSONObject(json);
            JSONArray items = jsonData.getJSONArray("civilizations");
            for(int i = 0; i < items.length(); i++){
                JSONObject jsonCivilization = items.getJSONObject(i);

                // retrieve data of each attribute of the json
                int id = jsonCivilization.getInt("id");
                String name = jsonCivilization.getString("name");

                // Create civilization
                Civilization civilization = new Civilization(id, name);

                // Add it to the list
                civilizationList.add(civilization);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        display.displayCivilization(this.civilizationList);
    }
    public interface IDisplay{
        void displayCivilization(List<Civilization> civilizationList);
    }
}
