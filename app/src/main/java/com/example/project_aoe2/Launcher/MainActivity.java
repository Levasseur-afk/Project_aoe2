package com.example.project_aoe2.Launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project_aoe2.Civilization.CivilizationListActivity;
import com.example.project_aoe2.Personal_Notes.AddDataActivity;
import com.example.project_aoe2.R;
import com.example.project_aoe2.Structure.StructureListActivity;
import com.example.project_aoe2.Technology.TechnologyListActivity;
import com.example.project_aoe2.Unit.UnitListActivity;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // simple redirect after click on button
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
        Intent intent = new Intent(this, TechnologyListActivity.class);
        startActivity(intent);
    }
    public void goToPersonalNotes(View v){
        Intent intent = new Intent(this, AddDataActivity.class);
        startActivity(intent);
    }


}