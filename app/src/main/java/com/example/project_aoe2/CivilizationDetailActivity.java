package com.example.project_aoe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project_aoe2.ApiObjects.Civilization;


public class CivilizationDetailActivity extends AppCompatActivity implements GetCivilization.IDisplay{

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilization_detail);

        Intent intent = getIntent();
        Civilization civ = (Civilization) intent.getSerializableExtra("civ");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/civilization/" + Integer.toString(civ.getId());
        GetCivilization getCivilization = new GetCivilization(url, this);
        txt = (TextView) findViewById(R.id.civ_details);

    }
    public void displayCivilization(Civilization civ){
        txt.setText(civ.toString());
    }
}