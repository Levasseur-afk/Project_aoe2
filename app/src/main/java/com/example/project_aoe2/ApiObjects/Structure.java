package com.example.project_aoe2.ApiObjects;

import java.io.Serializable;
import java.util.List;
// Classic POJO
public class Structure implements Serializable {
    private int id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    private Cost cost;
    private int build_time;
    private int hit_points;
    private int line_of_sight;
    private String armor;
    private String range;
    private int reload_time;
    private int attack;
    private List<String> special;

    public Structure(){}

    public Structure(int id, String name){
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

    public int getLine_of_sight() {
        return line_of_sight;
    }

    public void setLine_of_sight(int line_of_sight) {
        this.line_of_sight = line_of_sight;
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

    @Override
    public String toString() {
        return "Structure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expansion='" + expansion + '\'' +
                ", age='" + age + '\'' +
                ", " + cost.toString() +
                ", build_time=" + build_time +
                ", hit_points=" + hit_points +
                ", line_of_sight=" + line_of_sight +
                ", armor='" + armor + '\'' +
                ", range='" + range + '\'' +
                ", reload_time=" + reload_time +
                ", attack=" + attack +
                ", special=" + special +
                '}';
    }
}
