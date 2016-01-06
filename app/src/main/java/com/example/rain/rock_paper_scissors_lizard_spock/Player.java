package com.example.rain.rock_paper_scissors_lizard_spock;

/**
 * Created by rain on 1/6/2016.
 */
public class Player {
    protected String choice;
    protected int point;

    public String play() {
        return "";
    }

    public void addPoint(){
        this.point += 1;
    }

    public int getPoint(){
        return this.point;
    }

    public String getChoice(){
        return this.choice;
    }
}
