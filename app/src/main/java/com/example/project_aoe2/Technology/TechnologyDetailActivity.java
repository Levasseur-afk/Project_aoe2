package com.example.project_aoe2.Technology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project_aoe2.ApiObjects.Cost;
import com.example.project_aoe2.ApiObjects.Technology;
import com.example.project_aoe2.R;

public class TechnologyDetailActivity extends AppCompatActivity implements GetTechnology.IDisplay{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_detail);

        Intent intent = getIntent();
        Technology technology = (Technology) intent.getSerializableExtra("technology");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/technology/" + technology.getId();
        new GetTechnology(url, this);

    }
    public void displayTechnology(Technology technology){
        ImageView img = findViewById(R.id.technology_icon_detail);
        int id = 0;
        try {
            String toReplace[] = {" ", "-", "(", ")"};
            String name = technology.getName().toLowerCase();
            for(String ch : toReplace){
                name = name.replace(ch,"_");
            }
            id = R.drawable.class.getField(name).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        img.setImageResource(id);


        TextView name = findViewById(R.id.technology_name);
        name.setText(technology.getName());

        String text;
        text = "Description : <strong><font color=#d4af37>" + technology.getDescription() + "</font></strong>";
        TextView description = findViewById(R.id.technology_description);
        description.setText(Html.fromHtml(text));

        ImageView expansion = findViewById(R.id.technology_expansion_img);
        id = 0;
        try {
            id = R.drawable.class.getField(technology.getExpansion().toLowerCase().replace(" ", "_")).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        expansion.setImageResource(id);

        ImageView age = findViewById(R.id.technology_age_img);
        id = 0;
        try {
            id = R.drawable.class.getField(technology.getAge().toLowerCase().replace(" ", "_")+"_age").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        age.setImageResource(id);

        ImageView develops_in = findViewById(R.id.technology_develops_in_img);
        id = 0;
        try {
            String link = technology.getDevelops_in();
            String in = ((link.split("/"))[link.split("/").length - 1]).replace("_", " ");
            id = R.drawable.class.getField(in.toLowerCase()+ "_aoe2de").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        develops_in.setImageResource(id);

        text = "Cost : ";
        Cost cost = technology.getCost();
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
        TextView cost_txtView = findViewById(R.id.cost_technology_txt_view);
        cost_txtView.setText(Html.fromHtml(text));

        text = "Build Time : <strong><font color=#03ac13>" + technology.getBuild_time() + "</font></strong>";
        TextView build_time = findViewById(R.id.technology_build_time);
        build_time.setText(Html.fromHtml(text));

        text = "Applies to : <strong><font color=#03ac13>| ";
        for (String apply : technology.getApplies_to()) {
            String filtered = ((apply.split("/"))[apply.split("/").length - 1]).replace("_", " ");
            String final_name = "";
            for (String m : filtered.split(" ")) {
                String firstLtr = m.substring(0, 1).toUpperCase();
                String restLtrs = m.substring(1);
                final_name += firstLtr + restLtrs + " ";
            }
            text += final_name + " | ";
        }
        text += "</font></strong>";
        TextView applies_to = findViewById(R.id.technology_applies_to);
        applies_to.setText(Html.fromHtml(text));
    }
}