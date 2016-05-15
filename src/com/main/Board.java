package com.main;




/**
* Board class defines the board which the Robot will play on.
 * You can define the board with a specific size.
 * if no size specified, it will be default to size 5 on both x, y axis
*
* */
public class Board {

    public static final String INVALID_BOARD_SIZE_MESSAGE = "Board size is out of boundary";
    public final static int MAX_SIZE = 99;

    private int size =5;


    public Board(){

    }

    /**
    * Constructor to create a new square board with a specific size.
     * @param x the board size
     *
    * */
    public Board(int x) throws IllegalArgumentException {
        if( x < 1 || x > MAX_SIZE ){
            throw new IllegalArgumentException(INVALID_BOARD_SIZE_MESSAGE);
        }
        size = x;

    }

    /**
     *Check if the specific position in insider the boundary of the board
     * @return  true if it is inside the boundary or false .
     */
    public boolean isOnTheBoard(int x , int y) {
        if (x < 0 || x > size || y < 0 || y > size)
            return false;
        return true;
    }
}
