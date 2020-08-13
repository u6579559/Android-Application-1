package com.example.assignapp2019s1;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private int flag = 0;  // check music state, 0: off, 1: on

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        // to introduction page
        Button introduction = (Button) findViewById(R.id.help);
        introduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenth =new Intent(menuActivity.this,introduction.class);
                startActivity(intenth);
            }
        });
        // to game page
        Button start =(Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(menuActivity.this, gameActivity.class);
                startActivity(intents);
            }
        });
    }

    public void onClick(View v) {
        // exit game
        if (v == findViewById(R.id.exit)) this.finish();
        // turn on/off music
        if (v == findViewById(R.id.music)) {
            if (flag == 0){ //if music is off, turn on music
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                mediaPlayer.start();
                flag = 1;  // set music flag
            }
            else {
                mediaPlayer.release();
                flag = 0;
            }
        }
    }
}
