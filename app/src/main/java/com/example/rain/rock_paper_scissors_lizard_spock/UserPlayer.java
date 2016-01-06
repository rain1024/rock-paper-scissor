package com.example.rain.rock_paper_scissors_lizard_spock;

/**
 * Created by rain on 1/6/2016.
 */
public class UserPlayer extends Player{
    @Override
    public String play() {
        return this.choice;
    }

    public void setChoice(String choice){
        this.choice = choice;
    }
}
