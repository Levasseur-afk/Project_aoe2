package com.example.project_aoe2.ApiObjects;

import java.io.Serializable;

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
        return "Cost{ }";
    }
}
