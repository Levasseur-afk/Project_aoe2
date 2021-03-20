package com.example.project_aoe2.Structure;

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


import com.example.project_aoe2.ApiObjects.Structure;
import com.example.project_aoe2.R;
import com.example.project_aoe2.Tools.TouchListener;

import java.util.ArrayList;
import java.util.List;


public class StructureListActivity extends AppCompatActivity implements GetStructures.IDisplay {

    private RecyclerViewAdapterStructure recyclerViewAdapterStructure;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_structure_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_structure);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        this.recyclerViewAdapterStructure = new RecyclerViewAdapterStructure(this, new ArrayList<Structure>());
        recyclerView.setAdapter(this.recyclerViewAdapterStructure);
        recyclerView.addOnItemTouchListener(new TouchListener(this, recyclerView, new TouchListener.ITouchListener() {
            @Override
            public void onClick(View v, int position) {
                Structure structure = recyclerViewAdapterStructure.getStructureAtPosition(position);
                Intent intent = new Intent(context, StructureDetailActivity.class);
                intent.putExtra("structure", structure);
                startActivity(intent);
            }
        }));
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/structures";
        GetStructures getStructures = new GetStructures(url, this);
    }

    public void displayStructure(List<Structure> structureList){
        recyclerViewAdapterStructure.showNewStructureList(structureList);
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
                recyclerViewAdapterStructure.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}