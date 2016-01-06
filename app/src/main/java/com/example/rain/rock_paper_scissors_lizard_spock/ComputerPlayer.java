package com.example.rain.rock_paper_scissors_lizard_spock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rain on 1/6/2016.
 */
public class ComputerPlayer extends Player {
    @Override
    public String play() {
        List<String> options = new ArrayList<String>();
        options.add("Rock");
        options.add("Paper");
        options.add("Scissor");
        int index = (new Random()).nextInt(3);
        this.choice = options.get(index);
        return options.get(index);
    }
}
