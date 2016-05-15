package com.test;

import com.main.Board;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class BoardTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void isOnTheBoardTest(){

        Board b = new Board(10);

        assertTrue("on the board",b.isOnTheBoard(9,8));

        assertTrue("on the board",b.isOnTheBoard(0,0));

        assertFalse("off the board",b.isOnTheBoard(-1,8));

        assertFalse("off the board",b.isOnTheBoard(11,11));

        Board a = new Board();

        assertTrue("on the board",a.isOnTheBoard(2,5));

    }

    @Test
    public void invalidBoardTest(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(containsString("out of boundary"));
        new Board(0);


    }

}