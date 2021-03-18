package com.example.project_aoe2.Structure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import com.example.project_aoe2.ApiObjects.Structure;
import com.example.project_aoe2.R;


public class StructureDetailActivity extends AppCompatActivity implements GetStructure.IDisplay{

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_detail);

        Intent intent = getIntent();
        Structure structure = (Structure) intent.getSerializableExtra("structure");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/structure/" + structure.getId();
        new GetStructure(url, this);
        txt = findViewById(R.id.structure_details);

    }
    public void displayStructure(Structure structure){
        txt.setText(structure.toString());
    }
}