package com.example.project_aoe2.ApiObjects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_aoe2.R;

import java.io.Serializable;
import java.util.List;

public class Unit implements Serializable {
    private int id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    private String created_in;
    private int build_time;
    private int reload_time;
    private int attack_delay;
    private int movement_rate;
    private int line_of_sight;
    private int hit_points;
    private String range;
    private int attack;
    private String armor;
    private List<String> attack_bonus;
    private List<String> armor_bonus;
    private int search_radius;
    private String accuracy;
    private int blast_radius;


    public Unit() {
    }

    public Unit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCreated_in() {
        return created_in;
    }

    public void setCreated_in(String created_in) {
        this.created_in = created_in;
    }

    public int getBuild_time() {
        return build_time;
    }

    public void setBuild_time(int build_time) {
        this.build_time = build_time;
    }

    public int getReload_time() {
        return reload_time;
    }

    public void setReload_time(int reload_time) {
        this.reload_time = reload_time;
    }

    public int getAttack_delay() {
        return attack_delay;
    }

    public void setAttack_delay(int attack_delay) {
        this.attack_delay = attack_delay;
    }

    public int getMovement_rate() {
        return movement_rate;
    }

    public void setMovement_rate(int movement_rate) {
        this.movement_rate = movement_rate;
    }

    public int getLine_of_sight() {
        return line_of_sight;
    }

    public void setLine_of_sight(int line_of_sight) {
        this.line_of_sight = line_of_sight;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public List<String> getAttack_bonus() {
        return attack_bonus;
    }

    public void setAttack_bonus(List<String> attack_bonus) {
        this.attack_bonus = attack_bonus;
    }

    public List<String> getArmor_bonus() {
        return armor_bonus;
    }

    public void setArmor_bonus(List<String> armor_bonus) {
        this.armor_bonus = armor_bonus;
    }

    public int getSearch_radius() {
        return search_radius;
    }

    public void setSearch_radius(int search_radius) {
        this.search_radius = search_radius;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public int getBlast_radius() {
        return blast_radius;
    }

    public void setBlast_radius(int blast_radius) {
        this.blast_radius = blast_radius;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expansion='" + expansion + '\'' +
                ", age='" + age + '\'' +
                ", created_in='" + created_in + '\'' +
                ", build_time=" + build_time +
                ", reload_time=" + reload_time +
                ", attack_delay=" + attack_delay +
                ", movement_rate=" + movement_rate +
                ", line_of_sight=" + line_of_sight +
                ", hit_points=" + hit_points +
                ", range='" + range + '\'' +
                ", attack=" + attack +
                ", armor='" + armor + '\'' +
                ", attack_bonus=" + attack_bonus +
                ", armor_bonus=" + armor_bonus +
                ", search_radius=" + search_radius +
                ", accuracy='" + accuracy + '\'' +
                ", blast_radius=" + blast_radius +
                '}';
    }
}
