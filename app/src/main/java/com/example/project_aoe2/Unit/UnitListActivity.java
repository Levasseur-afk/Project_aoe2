package com.example.project_aoe2.Unit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;


import com.example.project_aoe2.ApiObjects.Unit;
import com.example.project_aoe2.R;
import com.example.project_aoe2.Tools.TouchListener;

import java.util.ArrayList;
import java.util.List;

public class UnitListActivity extends AppCompatActivity implements GetUnits.IDisplay{

    private RecyclerViewAdapterUnit recyclerViewAdapterUnit;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_unit_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_unit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        this.recyclerViewAdapterUnit = new RecyclerViewAdapterUnit(this, new ArrayList<Unit>());
        recyclerView.setAdapter(this.recyclerViewAdapterUnit);
        recyclerView.addOnItemTouchListener(new TouchListener(this, recyclerView, new TouchListener.ITouchListener() {
            @Override
            public void onClick(View v, int position) {
                Unit unit = recyclerViewAdapterUnit.getUnitAtPosition(position);
                Intent intent = new Intent(context, UnitDetailActivity.class);
                intent.putExtra("unit", unit);
                startActivity(intent);
            }
        }));
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/units";
        GetUnits getUnits = new GetUnits(url, this);
    }

    public void displayUnit(List<Unit> unitList){
        recyclerViewAdapterUnit.showNewUnitList(unitList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =  (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerViewAdapterUnit.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}