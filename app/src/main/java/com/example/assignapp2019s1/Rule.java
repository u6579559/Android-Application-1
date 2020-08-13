package com.example.assignapp2019s1;
// build a class for the listview Item
public class Rule {
    private String name;

    private int imageID;

    public Rule (String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }

    public String getName(){
        return name;
    }

    public int getImageID(){
        return imageID;
    }
}
