package com.example.project_aoe2.Structure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.project_aoe2.ApiObjects.Cost;
import com.example.project_aoe2.ApiObjects.Structure;
import com.example.project_aoe2.R;


public class StructureDetailActivity extends AppCompatActivity implements GetStructure.IDisplay{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_detail);

        Intent intent = getIntent();
        Structure structure = (Structure) intent.getSerializableExtra("structure");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/structure/" + structure.getId();
        new GetStructure(url, this);
    }
    @SuppressLint("SetTextI18n")
    public void displayStructure(Structure structure){
        ImageView img = findViewById(R.id.structure_icon_detail);
        int id = 0;
        try {
            id = R.drawable.class.getField(structure.getName().toLowerCase()+ "_aoe2de").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        img.setImageResource(id);


        TextView name = findViewById(R.id.structure_name);
        name.setText(structure.getName());

        ImageView expansion = findViewById(R.id.structure_expansion_img);
        int ide = 0;
        try {
            ide = R.drawable.class.getField(structure.getExpansion().toLowerCase().replace(" ", "_")).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        expansion.setImageResource(ide);

        ImageView age = findViewById(R.id.structure_age_img);
        ide = 0;
        try {
            ide = R.drawable.class.getField(structure.getAge().toLowerCase().replace(" ", "_")+"_age").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        age.setImageResource(ide);


        String text;

        text = "Cost : ";
        Cost cost = structure.getCost();
        if(cost.getWood() != 0){
            text += "<strong><font color=#97572b>" + cost.getWood() + " wood  " + "</font></strong>";
        }
        if(cost.getFood() != 0){
            text += "<strong><font color=#fc4c4e>" + cost.getFood() + " food  " + "</font></strong>";
        }
        if(cost.getStone() != 0){
            text += "<strong><font color=#60676b>" + cost.getStone() + " stone  " + "</font></strong>";
        }
        if(cost.getGold() != 0){
            text += "<strong><font color=#d4af37>" + cost.getGold() + " gold  " + "</font></strong>";
        }
        TextView cost_txtView = findViewById(R.id.cost_txt_view);
        cost_txtView.setText(Html.fromHtml(text));

        text = "Build Time : <strong><font color=#03ac13>" + structure.getBuild_time() + "</font></strong>";
        TextView build_time = findViewById(R.id.structure_build_time);
        build_time.setText(Html.fromHtml(text));

        text = "Hit Points : <strong><font color=#03ac13>" + structure.getHit_points() + "</font></strong>";
        TextView hit_points = findViewById(R.id.structure_hit_points);
        hit_points.setText(Html.fromHtml(text));

        text = "Line of Sight : <strong><font color=#03ac13>" + structure.getLine_of_sight() + "</font></strong>";
        TextView line_of_sight = findViewById(R.id.structure_line_of_sight);
        line_of_sight.setText(Html.fromHtml(text));

        text = "Armor : <strong><font color=#03ac13>" + structure.getArmor() + "</font></strong>";
        TextView armor = findViewById(R.id.structure_armor);
        armor.setText(Html.fromHtml(text));

        if(structure.getRange() != null && !structure.getRange().isEmpty()){
            text = "Range(min-max) : <strong><font color=#03ac13>" + structure.getRange() + "</font></strong>";
            TextView range = findViewById(R.id.structure_range);
            range.setText(Html.fromHtml(text));
        }

        if(structure.getAttack() != 0){
            text = "Attack : <strong><font color=#03ac13>" + structure.getAttack() + "</font></strong>";
            TextView attack = findViewById(R.id.structure_attack);
            attack.setText(Html.fromHtml(text));
        }

        if(structure.getSpecial() != null){
            LinearLayout structure_special = findViewById(R.id.structure_special);
            TextView txt = findViewById(R.id.structure_special_txt);
            txt.setText("Special :");
            for (String special : structure.getSpecial()) {
                TextView textView = new TextView(this);
                textView.setTextSize(12);
                textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                text = "<strong><font color=#03ac13>" + special + "</font></strong>";
                textView.setText(Html.fromHtml(text));
                structure_special.addView(textView);
            }
        }
    }
}