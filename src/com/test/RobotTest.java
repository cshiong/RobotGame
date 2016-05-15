package com.test;

import com.main.Board;
import com.main.Robot;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;




public class RobotTest {

    private Board board = new Board();

    @Rule
    public ExpectedException exception = ExpectedException.none();



    @Test
    public void placeOkTest(){

        Robot r = new Robot();
        r.place(3,4,"N",board);


        Assert.assertEquals("3,4,NORTH",r.toString());

    }

    @Test
    public void placeFailedTest(){

        Robot r = new Robot();
        //place() will place robot out of the board, so no action happened
        r.place(6,5,"N",board);
        Assert.assertEquals("-1,-1",r.toString());

    }

   @Test
    public void moveFailedTest(){
       Robot r = new Robot();
       r.place(5,5,"N",board);
       r.move(board);
       //no move happened since it will move out the board
       Assert.assertEquals("5,5,NORTH",r.report());
   }

    @Test
    public void moveFailedTest2(){
        Robot r = new Robot();
        r.move(board);
        Assert.assertEquals("-1,-1",r.toString());
    }

    @Test
    public void leftTurnFailedTest() {
        Robot r = new Robot();
        //no place() called before call
        r.left();
        Assert.assertEquals("-1,-1",r.toString());
    }

    @Test
    public void leftTurnOkTest() {
        Robot r = new Robot();
        r.place(3, 2, "N", board);

        r.left();
        Assert.assertEquals("3,2,WEST",r.toString());

    }

    @Test
    public void rightTurnFailedTest()  {

        Robot r = new Robot();
        //no place() called before call
        r.left();
        Assert.assertEquals("-1,-1",r.toString());
    }

    @Test
    public void rightTurnOkTest() {
        Robot r = new Robot();
        r.place(2, 0, "N", board);

        r.right();
        String states[] = (r.report()).split(",");
        Assert.assertEquals("EAST", states[2]);

    }

    @Test
    public void reportOKTest(){
        Robot r = new Robot();
        r.place(2, 0, "W", board);

        r.move(board);
        r.left();
        r.move(board);//no move since it will be out of board
        Assert.assertEquals("1,0,SOUTH",r.report());
    }

    @Test
    public void reportFailTest(){

        Robot r = new Robot();
        //no place() called before call report()
        Assert.assertEquals("",r.report());

    }
}