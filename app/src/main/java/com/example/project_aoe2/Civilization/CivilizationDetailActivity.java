package com.example.project_aoe2.Civilization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project_aoe2.ApiObjects.Civilization;
import com.example.project_aoe2.R;


public class CivilizationDetailActivity extends AppCompatActivity implements GetCivilization.IDisplay {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilization_detail);
        Intent intent = getIntent();
        Civilization civ = (Civilization) intent.getSerializableExtra("civ");
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/civilization/" + civ.getId();
        new GetCivilization(url, this);

    }
    // Once the download of data is done, this function fill content of View using the item clicked
    public void displayCivilization(Civilization civ) {
        ImageView img = findViewById(R.id.civ_icon_detail);
        int id = 0;
        try {
            id = R.drawable.class.getField(civ.getName().toLowerCase()).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        img.setImageResource(id);


        TextView name = findViewById(R.id.civ_name);
        name.setText(civ.getName());

        String text;
        text = "Best at : <strong><font color=#d4af37>" + civ.getArmy_type() + "</font></strong>";
        TextView army_type = findViewById(R.id.civ_army_type);
        army_type.setText(Html.fromHtml(text));

        ImageView expansion = findViewById(R.id.civ_expansion);
        int ide = 0;
        try {
            ide = R.drawable.class.getField(civ.getExpansion().toLowerCase().replace(" ", "_")).getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        expansion.setImageResource(ide);

        LinearLayout unique_units = findViewById(R.id.unique_units);
        for (String unit : civ.getUnique_unit()) {
            String curr_name = ((unit.split("/"))[unit.split("/").length - 1]).replace("_", " ");

            ImageView unit_icon = new ImageView(this);
            unit_icon.setLayoutParams(new FrameLayout.LayoutParams(75, 75));
            unit_icon.setPaddingRelative(10, 0, 10, 0);

            unit_icon.setScaleType(ImageView.ScaleType.FIT_START);

            int idu = 0;
            try {
                idu = R.drawable.class.getField(curr_name.toLowerCase().replace(" ", "_") + "_aoe2de").getInt(null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            unit_icon.setImageResource(idu);
            unique_units.addView(unit_icon);

            TextView unit_name = new TextView(this);
            unit_name.setTextSize(15);
            String final_name = "";
            for (String m : curr_name.split(" ")) {
                String firstLtr = m.substring(0, 1).toUpperCase();
                String restLtrs = m.substring(1);
                final_name += firstLtr + restLtrs + " ";
            }
            text = "<strong><font color=#d4af37>" + final_name + "</font></strong>";
            unit_name.setText(Html.fromHtml(text));
            unique_units.addView(unit_name);
        }

        LinearLayout unique_techs = findViewById(R.id.unique_techs);
        for (String tech : civ.getUnique_tech()) {
            String curr_name = ((tech.split("/"))[tech.split("/").length - 1]).replace("_", " ");

            ImageView tech_icon = new ImageView(this);
            tech_icon.setLayoutParams(new FrameLayout.LayoutParams(75, 75));
            tech_icon.setPaddingRelative(10, 0, 10, 0);

            tech_icon.setScaleType(ImageView.ScaleType.FIT_START);

            int idu = 0;
            try {
                idu = R.drawable.class.getField(curr_name.toLowerCase().replace(" ", "_")).getInt(null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            tech_icon.setImageResource(idu);
            unique_techs.addView(tech_icon);

            TextView tech_name = new TextView(this);
            tech_name.setTextSize(15);
            String final_name = "";
            for (String m : curr_name.split(" ")) {
                String firstLtr = m.substring(0, 1).toUpperCase();
                String restLtrs = m.substring(1);
                final_name += firstLtr + restLtrs + " ";
            }
            text = "<strong><font color=#d4af37>" + final_name + "</font></strong>";
            tech_name.setText(Html.fromHtml(text));
            unique_techs.addView(tech_name);
        }

        text = "Team Bonus : <strong><font color=#03ac13>" + civ.getTeam_bonus() + "</font></strong>";
        TextView team_bonus = findViewById(R.id.civ_team_bonus);
        team_bonus.setText(Html.fromHtml(text));

        LinearLayout civ_bonus = findViewById(R.id.civ_bonus);
        for (String bonus : civ.getCivilization_bonus()) {
            TextView textView = new TextView(this);
            textView.setTextSize(15);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            text = "<strong><font color=#03ac13>" + bonus + "</font></strong>";
            textView.setText(Html.fromHtml(text));
            civ_bonus.addView(textView);
        }
    }
}