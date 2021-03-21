package com.example.project_aoe2.Unit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project_aoe2.ApiObjects.Cost;
import com.example.project_aoe2.ApiObjects.Unit;
import com.example.project_aoe2.R;

import java.util.List;


public class UnitDetailActivity extends AppCompatActivity implements GetUnit.IDisplay{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_detail);

        Intent intent = getIntent();
        Unit unit = (Unit) intent.getSerializableExtra("unit");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/unit/" + unit.getId();
        new GetUnit(url, this);
    }

    public void displayUnit(Unit unit){
        ImageView img = findViewById(R.id.unit_icon_detail);
        int id = 0;
        try {
            String toReplace[] = {" ", "-", "(", ")"};
            String name = unit.getName().toLowerCase() + "_aoe2de";
            for(String ch : toReplace){
                name = name.replace(ch,"_");
            }
            id = R.drawable.class.getField(name).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        img.setImageResource(id);


        TextView name = findViewById(R.id.unit_name);
        name.setText(unit.getName());

        String text;
        text = "Description : <strong><font color=#d4af37>" + unit.getDescription() + "</font></strong>";
        TextView description = findViewById(R.id.unit_description);
        description.setText(Html.fromHtml(text));

        ImageView expansion = findViewById(R.id.unit_expansion_img);
        id = 0;
        try {
            id = R.drawable.class.getField(unit.getExpansion().toLowerCase().replace(" ", "_")).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        expansion.setImageResource(id);

        ImageView age = findViewById(R.id.unit_age_img);
        id = 0;
        try {
            id = R.drawable.class.getField(unit.getAge().toLowerCase().replace(" ", "_")+"_age").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        age.setImageResource(id);

        ImageView created_in_img = findViewById(R.id.unit_created_in_img);
        id = 0;
        try {
            String link = unit.getCreated_in();
            String created_in = ((link.split("/"))[link.split("/").length - 1]).replace("_", " ");
            id = R.drawable.class.getField(created_in.toLowerCase().replace(" ", "_") + "_aoe2de").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        created_in_img.setImageResource(id);

        text = "Cost : ";
        Cost cost = unit.getCost();
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
        TextView cost_txtView = findViewById(R.id.cost_unit_txt_view);
        cost_txtView.setText(Html.fromHtml(text));

        text = "Build Time : <strong><font color=#03ac13>" + unit.getBuild_time() + "s" + "</font></strong>";
        TextView build_time = findViewById(R.id.unit_build_time);
        build_time.setText(Html.fromHtml(text));

        LinearLayout unit_layout = findViewById(R.id.unit_layout);
        if(unit.getReload_time() != 0){
            text = "Reload Time : <strong><font color=#03ac13>" + unit.getReload_time() + "s" + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getAttack_delay() != 0){
            text = "Attack Delay : <strong><font color=#03ac13>" + unit.getAttack_delay() + "s" + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getMovement_rate() != 0){
            text = "Movement Rate : <strong><font color=#03ac13>" + unit.getMovement_rate() + "s" + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getLine_of_sight() != 0){
            text = "Line of Sight : <strong><font color=#03ac13>" + unit.getLine_of_sight() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getHit_points() != 0){
            text = "Hit Points : <strong><font color=#03ac13>" + unit.getHit_points() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getRange() != null && !unit.getRange().isEmpty()){
            text = "Range : <strong><font color=#03ac13>" + unit.getRange() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getAttack() != 0){
            text = "Attack : <strong><font color=#03ac13>" + unit.getAttack() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getArmor() != null && !unit.getArmor().isEmpty()){
            text = "Armor : <strong><font color=#03ac13>" + unit.getArmor() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }

        if(unit.getAttack_bonus() != null){
            LinearLayout unit_attack_bonus = new LinearLayout(this);
            unit_attack_bonus.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            unit_attack_bonus.setGravity(Gravity.CENTER_HORIZONTAL);
            unit_attack_bonus.setOrientation(LinearLayout.VERTICAL);
            unit_layout.addView(unit_attack_bonus);
            createDynamicTextView("Attack Bonus : ", unit_attack_bonus);
            for (String bonus : unit.getAttack_bonus()) {
                text = "<strong><font color=#03ac13>" + bonus + "</font></strong>";
                createDynamicTextView(text, unit_attack_bonus);
            }
        }
        if(unit.getArmor_bonus() != null){
            LinearLayout unit_armor_bonus = new LinearLayout(this);
            unit_armor_bonus.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            unit_armor_bonus.setGravity(Gravity.CENTER_HORIZONTAL);
            unit_armor_bonus.setOrientation(LinearLayout.VERTICAL);
            unit_layout.addView(unit_armor_bonus);
            createDynamicTextView("Armor Bonus : ", unit_armor_bonus);
            for (String bonus : unit.getArmor_bonus()) {
                text = "<strong><font color=#03ac13>" + bonus + "</font></strong>";
                createDynamicTextView(text, unit_armor_bonus);
            }
        }
        if(unit.getSearch_radius() != 0){
            text = "Search Radius : <strong><font color=#03ac13>" + unit.getSearch_radius() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getAccuracy() != null && !unit.getAccuracy().isEmpty()){
            text = "Accuracy : <strong><font color=#03ac13>" + unit.getAccuracy() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        if(unit.getBlast_radius() != 0){
            text = "Blast Radius : <strong><font color=#03ac13>" + unit.getBlast_radius() + "</font></strong>";
            createDynamicTextView(text,unit_layout);
        }
        // Trick to add virtual "padding" at the end of scrollview dynamically
        createDynamicTextView("",unit_layout);
        createDynamicTextView("",unit_layout);
        createDynamicTextView("",unit_layout);
    }

    public void createDynamicTextView(String text, LinearLayout unit_layout){
        TextView textView = new TextView(this);
        textView.setText(Html.fromHtml(text));
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextSize(15);
        unit_layout.addView(textView);
    }
}