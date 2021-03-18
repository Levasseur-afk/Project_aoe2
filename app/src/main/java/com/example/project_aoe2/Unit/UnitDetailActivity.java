package com.example.project_aoe2.Unit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import com.example.project_aoe2.ApiObjects.Unit;
import com.example.project_aoe2.R;
import com.example.project_aoe2.Unit.GetUnit;


public class UnitDetailActivity extends AppCompatActivity implements GetUnit.IDisplay{

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_detail);

        Intent intent = getIntent();
        Unit unit = (Unit) intent.getSerializableExtra("unit");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/unit/" + Integer.toString(unit.getId());
        GetUnit getUnit = new GetUnit(url, this);
        txt = (TextView) findViewById(R.id.unit_details);
    }

    public void displayUnit(Unit unit){
        txt.setText(unit.toString());
    }
}