package com.example.project_aoe2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project_aoe2.ApiObjects.Civilization;

import java.util.ArrayList;
import java.util.List;

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

    }
    public void goToTechnologies(View v){

    }


}