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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ComputerPlayer computer;
    public UserPlayer user;
    public String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.user = new UserPlayer();
        this.computer = new ComputerPlayer();
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

    public void updateUI(){
        Map<String, Integer> images = new HashMap<String, Integer>();
        images.put("Rock", R.mipmap.rock);
        images.put("Scissor", R.mipmap.scissor);
        images.put("Paper", R.mipmap.paper);
        ImageView imageComputer = (ImageView) findViewById(R.id.imageComputer);
        imageComputer.setImageResource(images.get(this.computer.getChoice()));
        ImageView imageUser = (ImageView) findViewById(R.id.imageUser);
        imageUser.setImageResource(images.get(this.user.getChoice()));

        ((TextView)findViewById(R.id.textUserPoint)).setText(String.valueOf(this.user.getPoint()));
        ((TextView)findViewById(R.id.textComputerPoint)).setText(String.valueOf(this.computer.getPoint()));
        ((TextView)findViewById(R.id.textResult)).setText(result);

    }

    public void chooseRock(View v){
        this.user.setChoice("Rock");
        this.play();
    }

    public void choosePaper(View v){
        this.user.setChoice("Paper");
        this.play();
    }

    public void chooseScissor(View v){
        this.user.setChoice("Scissor");
        this.play();
    }

    public void play(){
        this.computer.play();
        Map<String, String> rules = new HashMap<String, String>();
        rules.put("Rock", "Scissor");
        rules.put("Scissor", "Paper");
        rules.put("Paper", "Rock");

        String userChoice = this.user.getChoice();
        String computerChoice = this.computer.getChoice();

        if(userChoice == computerChoice){
            this.result = "Draw!";
        } else if(rules.get(userChoice) == computerChoice){
           this.result = "Win!";
            this.user.addPoint();
        } else {
            this.result = "Lose!";
            this.computer.addPoint();
        }
        this.updateUI();
    }
}
