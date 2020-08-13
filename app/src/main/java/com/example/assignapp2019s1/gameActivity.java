package com.example.assignapp2019s1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class gameActivity extends AppCompatActivity {
    // different image to show the motion of mouse appearing from the hole
    final int a = R.drawable.show1, b = R.drawable.show2,  c =R.drawable.show3, d =R.drawable.show4, e =R.drawable.show5, f = R.drawable.show6;

    public int score = 0;         // record the score
    public int mouseNumber = 0;    //record the mouse amount
    public View appear_hole;     // the view that mouse appearing

    public long currentTime ;   // the current time
    public long startTime;     // the static time at the game beginning
    SharedPreferences preferences;
    public int remainingTime = 30;   //how many seconds remaining
    public int highestScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }

    //record the time at the game beginning and subtract it by current time to get the remaining time
    protected void setTimer(){
        currentTime = System.currentTimeMillis();
        int timer = (int) TimeUnit.SECONDS.convert(currentTime -startTime,TimeUnit.MILLISECONDS);
        remainingTime = 30 - timer;
        TextView time = (TextView) findViewById(R.id.time);
        time.setText(remainingTime+"s");
    }

    // change to the hit image if the player hits the mouse correctly
    public void hit(final View view){
        score++;
        TextView scoreNumber = (TextView) findViewById(R.id.score);
        scoreNumber.setText(score+"");
        view.setClickable(false);  //make sure score once for one hit
        view.setBackgroundResource(R.drawable.hit);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setBackgroundResource(R.drawable.emptyhole);
            }
        }, 300);
    }

    public void next_mouse() {
        setTimer();  //start to record time
        View[]  views = {findViewById(R.id.image11), findViewById(R.id.image12), findViewById(R.id.image13), findViewById(R.id.image14),
                findViewById(R.id.image21), findViewById(R.id.image22), findViewById(R.id.image23), findViewById(R.id.image24),
                findViewById(R.id.image31), findViewById(R.id.image32), findViewById(R.id.image33), findViewById(R.id.image34)};
        // set all images unclickable
        for (int i = 0; i < views.length; i++) {
            views[i].setClickable(false);
            views[i].setBackgroundResource(R.drawable.emptyhole);
        }

        //mouse starts appearing and find the random hole
        appear_hole = views[new Random().nextInt(views.length)];
        mouseNumber++;
        int miss = mouseNumber - score - 1 ;
        //set the max number of missing mouse and show remaining lives
        if (miss == 1){
            findViewById(R.id.one).setVisibility(View.INVISIBLE);
        }
        if (miss == 2){
            findViewById(R.id.two).setVisibility(View.INVISIBLE);
        }
        if (miss == 3){
            findViewById(R.id.three).setVisibility(View.INVISIBLE);
        }
        if (miss == 4){
            findViewById(R.id.four).setVisibility(View.INVISIBLE);
        }

        //increase the speed as time went by
        if (miss < 4 && remainingTime != 0){
            if(remainingTime > 25){
                delay(a,200);
            }else if(remainingTime <= 25 && remainingTime > 20 ){
                delay(a,180);
            }else if(remainingTime <= 20 && remainingTime > 15 ){
                delay(a,150);
            }else if(remainingTime <= 15 && remainingTime > 10 ){
                delay(a,130);
            }else
                delay(a,100);
        }
        // show the highest score when game ends
        if(remainingTime == 0 || miss == 4){
            if(score > highestScore) highestScore = score;
            showHighestScore();
        }
    }
    //reference: https://developer.android.com/guide/topics/ui/dialogs
    public void showHighestScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game over...");
        builder.setMessage("Your score: " + score + "\n" + "Your highest score: " + highestScore);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // delay the image to perform motions
    public void delay(final int motion, final int time ) {
            // iteration to perform the motions
            if (motion <= f) {
                appear_hole.setClickable(true);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        appear_hole.setBackgroundResource(motion);
                        delay(motion + 1, time);
                    }
                }, time);
            } // motions completed
            else next_mouse();
    }

    // reinitialize the game records
    public void start(View view){
        setInit(0,0);
        startTime = System.currentTimeMillis();
        preferences = getSharedPreferences("Time", Context.MODE_PRIVATE);
        TextView scoreNumber = (TextView) findViewById(R.id.score);
        scoreNumber.setText(score+"");
        findViewById(R.id.four).setVisibility(View.VISIBLE);
        findViewById(R.id.three).setVisibility(View.VISIBLE);
        findViewById(R.id.two).setVisibility(View.VISIBLE);
        findViewById(R.id.one).setVisibility(View.VISIBLE);
        next_mouse();
    }

    public void setInit(int score, int mouseNumber){
        this.score = score;
        this.mouseNumber = mouseNumber;
    }


    public static int delayTime(int remainingTime,int miss){
        int delay  ;
        if(miss >= 4  ){
            delay = 0  ;
        }else if ( remainingTime  > 25  ){
            delay = 200 ;
        }else if  (remainingTime <= 25 &&  remainingTime >20){
            delay = 180 ;
        }else if (remainingTime <= 20 && remainingTime  >15 ){
            delay = 150 ;
        }else if(remainingTime <= 15 && remainingTime > 10 ){
            delay = 130 ;
        }else {delay = 100;}

        return  delay ;
    }

    public static int missed(int mouseNumber  , int  score) {
        int missed ;
        missed = mouseNumber - score -1 ;
        return missed ;
    }

}







