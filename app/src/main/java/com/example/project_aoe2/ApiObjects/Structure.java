package com.example.project_aoe2.ApiObjects;

import java.util.List;

public class Structure {
    private int id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    private Cost cost;
    private int build_time;
    private int hit_points;
    private int line_of_sights;
    private String armor;
    private String range;
    private int reload_time;
    private int attack;
    private List<String> special;

    public Structure(int id, String name, String description, String expansion, String age, Cost cost, int build_time, int hit_points, int line_of_sights, String armor, String range, int reload_time, int attack, List<String> special) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expansion = expansion;
        this.age = age;
        this.cost = cost;
        this.build_time = build_time;
        this.hit_points = hit_points;
        this.line_of_sights = line_of_sights;
        this.armor = armor;
        this.range = range;
        this.reload_time = reload_time;
        this.attack = attack;
        this.special = special;
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

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public int getBuild_time() {
        return build_time;
    }

    public void setBuild_time(int build_time) {
        this.build_time = build_time;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public int getLine_of_sights() {
        return line_of_sights;
    }

    public void setLine_of_sights(int line_of_sights) {
        this.line_of_sights = line_of_sights;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getReload_time() {
        return reload_time;
    }

    public void setReload_time(int reload_time) {
        this.reload_time = reload_time;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public List<String> getSpecial() {
        return special;
    }

    public void setSpecial(List<String> special) {
        this.special = special;
    }
}
