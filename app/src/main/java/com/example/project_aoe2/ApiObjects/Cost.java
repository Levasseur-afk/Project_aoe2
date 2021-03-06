package com.example.project_aoe2.ApiObjects;

import java.io.Serializable;
// Classic POJO
public class Cost implements Serializable {
    private int Wood;
    private int Food;
    private int Stone;
    private int Gold;

    public Cost(int wood, int food, int stone, int gold) {
        Wood = wood;
        Food = food;
        Stone = stone;
        Gold = gold;
    }
    public Cost(){}

    public int getWood() {
        return Wood;
    }

    public void setWood(int wood) {
        Wood = wood;
    }

    public int getFood() {
        return Food;
    }

    public void setFood(int food) {
        Food = food;
    }

    public int getStone() {
        return Stone;
    }

    public void setStone(int stone) {
        Stone = stone;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    @Override
    public String toString() {
        String display = "Cost{ ";
        if(Wood != 0){
            display += "Wood:" + Integer.toString(Wood) + ", ";
        }
        if(Food != 0){
            display += "Food:" + Integer.toString(Food) + ", ";
        }
        if(Stone != 0){
            display += "Stone:" + Integer.toString(Stone) + ", ";
        }
        if(Gold != 0){
            display += "Gold:" + Integer.toString(Gold);
        }
        display += " }";
        return display;
    }
}
