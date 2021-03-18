package com.example.project_aoe2.Technology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project_aoe2.ApiObjects.Technology;
import com.example.project_aoe2.R;

public class TechnologyDetailActivity extends AppCompatActivity implements GetTechnology.IDisplay{

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_detail);

        Intent intent = getIntent();
        Technology technology = (Technology) intent.getSerializableExtra("technology");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/technology/" + technology.getId();
        new GetTechnology(url, this);
        txt = findViewById(R.id.technology_details);

    }
    public void displayTechnology(Technology technology){
        txt.setText(technology.toString());
    }
}