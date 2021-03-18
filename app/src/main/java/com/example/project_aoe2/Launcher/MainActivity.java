package com.example.project_aoe2.Launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project_aoe2.Civilization.CivilizationListActivity;
import com.example.project_aoe2.R;
import com.example.project_aoe2.Structure.StructureListActivity;
import com.example.project_aoe2.Unit.UnitListActivity;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToCivilizations(View v){
        Intent intent = new Intent(this, CivilizationListActivity.class);
        startActivity(intent);
    }
    public void goToUnits(View v){
        Intent intent = new Intent(this, UnitListActivity.class);
        startActivity(intent);
    }
    public void goToStructures(View v){
        Intent intent = new Intent(this, StructureListActivity.class);
        startActivity(intent);
    }
    public void goToTechnologies(View v){

    }


}