package com.example.rain.rock_paper_scissors_lizard_spock;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public String userChoice;
    public String computerChoice;
    public int userPoint = 0;
    public int computerPoint = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public String choose(){
        List<String> options = new ArrayList<String>();
        options.add("Rock");
        options.add("Paper");
        options.add("Scissor");
        int index = (new Random()).nextInt(3);
        int[] images = new int[3];
        images[0] = R.mipmap.rock;
        images[1] = R.mipmap.paper;
        images[2] = R.mipmap.scissor;
        ImageButton button = (ImageButton)findViewById(R.id.imageComputer);
        button.setImageResource(images[index]);
        return options.get(index);
    }
    public void chooseRock(View v){
        this.userChoice = "Rock";
        this.play();
    }

    public void choosePaper(View v){
        this.userChoice = "Paper";
        this.play();
    }

    public void chooseScissor(View v){
        this.userChoice = "Scissor";
        this.play();
    }

    public void play(){
        String userChoice = this.userChoice;
        String computerChoice = this.choose();
        String result = "";
        Map<String, String> rules = new HashMap<String, String>();
        rules.put("Rock", "Scissor");
        rules.put("Scissor", "Paper");
        rules.put("Paper", "Rock");
        if(userChoice == computerChoice){
            result = "Draw";
        } else if(rules.get(userChoice) == computerChoice){
           result = "Win";
            this.userPoint += 1;
        } else {
            result = "Lose";
            this.computerPoint += 1;
        }
        ((TextView)findViewById(R.id.textUserPoint)).setText(String.valueOf(this.userPoint));
        ((TextView)findViewById(R.id.textComputerPoint)).setText(String.valueOf(this.computerPoint));
        ((TextView)findViewById(R.id.textResult)).setText(result);
    }
}
