package com.example.crosstheroad;

import org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GameFragmentTest {

    private static final int TIMEOUT = 200;

    private GameFragment gameFragment;

    @Test(timeout = TIMEOUT)
    public void characterCheck() {
        //Checking Sprite by correct values
        if(gameFragment.getSpriteInt() == 0) {
            Assert.assertEquals(R.drawable.blue_up, gameFragment.getSpriteInt());
        } else if(gameFragment.getSpriteInt() == 1){
            Assert.assertEquals(R.drawable.green_up,gameFragment.getSpriteInt());
        } else {
            Assert.assertEquals(R.drawable.yellow_up, gameFragment.getSpriteInt());
        }
    }

    @Test(timeout = TIMEOUT)
    public void nameCheck() {
        String names = gameFragment.getName();

        //Check Empty and null input from the user name
        if(names == null) {
            Assert.assertNull("Your name is null", null);
            Assert.assertFalse("Your name is null", false);
            Assert.assertNull("Your input is empty","");

        }
    }

    @Test(timeout = TIMEOUT)
    public void liveDifficultyCheck() {
        int lives = gameFragment.getLives();

        //getDifficulty(int lives)
        if (lives == 3){
            Assert.assertEquals("Hard", gameFragment.getDifficulty());
        } else if (lives == 5){
            Assert.assertEquals("Normal", gameFragment.getDifficulty());
        } else if (lives == 7){
            Assert.assertEquals("Easy", gameFragment.getDifficulty());
        }
    }

    @Test(timeout = TIMEOUT)
    public void scoreTest() {
        double totalScore = gameFragment.getScore();

        Assert.assertEquals(0,0);
        Assert.assertEquals(-1, 0);
        Assert.assertEquals( 1,1);
        Assert.assertEquals( 4,4);
    }

    @Test(timeout = TIMEOUT)
    public void moveUp() {
        Assert.assertFalse(R.id.up_arrow, getClick(R.id.bottom_arrow));
        Assert.assertTrue(R.id.up_arrow, getClick(R.id.up_arrow));
        Assert.assertFalse(R.id.up_arrow, getClick(R.id.right_arrow));
        Assert.assertFalse(R.id.up_arrow, getClick(R.id.left_arrow));
    }

    @Test(timeout = TIMEOUT)
    public void moveDown() {
        Assert.assertTrue(R.id.bottom_arrow, getClick(R.id.bottom_arrow));
        Assert.assertFalse(R.id.bottom_arrow, getClick(R.id.up_arrow));
        Assert.assertFalse(R.id.bottom_arrow, getClick(R.id.right_arrow));
        Assert.assertFalse(R.id.bottom_arrow, getClick(R.id.left_arrow));
    }

    @Test(timeout = TIMEOUT)
    public void moveLeft() {
        Assert.assertFalse(R.id.left_arrow, getClick(R.id.bottom_arrow));
        Assert.assertFalse(R.id.left_arrow, getClick(R.id.up_arrow));
        Assert.assertFalse(R.id.left_arrow, getClick(R.id.right_arrow));
        Assert.assertTrue(R.id.left_arrow, getClick(R.id.left_arrow));
    }

    @Test(timeout = TIMEOUT)
    public void moveRight() {
        Assert.assertFalse(R.id.right_arrow, getClick(R.id.bottom_arrow));
        Assert.assertFalse(R.id.right_arrow, getClick(R.id.up_arrow));
        Assert.assertTrue(R.id.bottom_arrow, getClick(R.id.right_arrow));
        Assert.assertFalse(R.id.right_arrow, getClick(R.id.left_arrow));
    }

    @Test(timeout = TIMEOUT)
    public void boundaryUp() {
        Assert.assertFalse("The character does over the" +
                "boundary", character.getY() >= 2000);
        Assert.assertTrue("The character does not go over the" +
                "boundary", character.getY() == 700);
        Assert.assertTrue("The character does not go over the" +
                "boundary", character.getY() == 800);
    }

    @Test(timeout = TIMEOUT)
    public void boundaryBottom() {
        Assert.assertFalse("The character went over the screen" +
                " boundary", gameFragment.onCreateView().character.getY() <= 300);
        Assert.assertTrue("The character does not go below" +
                "the screen", gameFragment.onCreateView().character.getY() == 400);
        Assert.assertTrue("The character does not go below" +
                "the screen", gameFragment.onCreateView().character.getY() == 500);
        Assert.assertTrue("The character does not go below" +
                "the screen", gameFragment.onCreateView().character.getY() == 600);
    }

    @Test(timeout = TIMEOUT)
    public void boundaryLeft() {
        Assert.assertFalse("The character went over the screen" +
                " boundary", gameFragment.onCreateView().character.getX() <= 100);
        Assert.assertTrue("The character does not go below" +
                "the screen", gameFragment.onCreateView().character.getX() == 400);
        Assert.assertTrue("The character does not go below" +
                "the screen", gameFragment.onCreateView().character.getX() == 500);
        Assert.assertTrue("The character does not go below" +
                "the screen", gameFragment.onCreateView().character.getX() == 600);

    }

    @Test(timeout = TIMEOUT)
    public void boundaryRight() {
        Assert.assertFalse("The character went over the screen" +
                " boundary", gameFragment.onCreateView().character.getX() >= 900);
        Assert.assertTrue("The character does not go over" +
                "the screen", gameFragment.onCreateView().character.getX() == 400);
        Assert.assertTrue("The character does not go over" +
                "the screen", gameFragment.onCreateView().character.getX() == 500);
        Assert.assertTrue("The character does not go over" +
                "the screen", gameFragment.onCreateView().character.getX() == 600);
    }
    @Test
    public void vehicleCheck() {
        Assert.assertFalse("The vehicle exists", );
    }
}