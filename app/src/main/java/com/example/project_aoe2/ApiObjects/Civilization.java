package com.example.project_aoe2.ApiObjects;

import java.io.Serializable;
import java.util.List;

public class Civilization implements Serializable {
    private int id;
    private String name;
    private String expansion;
    private String army_type;
    private List<String> unique_unit;
    private List<String> unique_tech;
    private String team_bonus;
    private List<String> civilization_bonus;

    public Civilization(){}

    public Civilization(int id, String name){
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

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getArmy_type() {
        return army_type;
    }

    public void setArmy_type(String army_type) {
        this.army_type = army_type;
    }

    public List<String> getUnique_unit() {
        return unique_unit;
    }

    public void setUnique_unit(List<String> unique_unit) {
        this.unique_unit = unique_unit;
    }

    public List<String> getUnique_tech() {
        return unique_tech;
    }

    public void setUnique_tech(List<String> unique_tech) {
        this.unique_tech = unique_tech;
    }

    public String getTeam_bonus() {
        return team_bonus;
    }

    public void setTeam_bonus(String team_bonus) {
        this.team_bonus = team_bonus;
    }

    public List<String> getCivilization_bonus() {
        return civilization_bonus;
    }

    public void setCivilization_bonus(List<String> civilization_bonus) {
        this.civilization_bonus = civilization_bonus;
    }

    @Override
    public String toString() {
        return "Civilization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expansion='" + expansion + '\'' +
                ", army_type='" + army_type + '\'' +
                ", unique_unit=" + unique_unit +
                ", unique_tech=" + unique_tech +
                ", team_bonus='" + team_bonus + '\'' +
                ", civilization_bonus=" + civilization_bonus +
                '}';
    }
}
