package com.example.assignapp2019s1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {
    gameActivity game = new gameActivity();

    @Test
    public void game_isInit() {
        assertEquals(game.score, 0);
        assertEquals(game.mouseNumber, 0);
        assertEquals(game.currentTime, 0);
        assertEquals(game.startTime, 0);
        assertEquals(game.remainingTime, 0);
        assertEquals(game.appear_hole, null);
    }

    @Test
    public void gameStateChange() {
        game.setInit(5,6);
        assertEquals(game.score, 5);
        assertEquals(game.mouseNumber, 6);
    }

    @Test
    public void delay(){
        assertEquals(200,gameActivity.delayTime(26,3));
        assertEquals(0,gameActivity.delayTime(17,5));
        assertEquals(130,gameActivity.delayTime(12,2));

    }

    @Test
    public void miss(){
        assertEquals(2,gameActivity.missed(5,2));
        assertEquals(3,gameActivity.missed(7,3));
        assertEquals(4,gameActivity.missed(10,5));
    }



}