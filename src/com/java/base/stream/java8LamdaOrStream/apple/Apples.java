package com.java.base.stream.java8LamdaOrStream.apple;

/**
 * mjt 梅锦涛
 * 2023/5/8
 *
 * @author mjt
 */
public class Apples {

    private int Weight;
    private String color;

    public Apples(int weight, String color) {
        Weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apples{" +
                "Weight=" + Weight +
                ", color='" + color + '\'' +
                '}';
    }
}
