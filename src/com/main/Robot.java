package com.main;


import static com.main.Face.*;

/*
 * Toy Robot class
 */
public class Robot {
    public static final String OUT_OFF_BOARD_MESSAGE = "Robot can't be placed out of the board!";
    public static final String NOT_ON_BOARD_MESSAGE = "Robot can't do anything without being on board first";

    private int Xpoint=-1;
    private int Ypoint=-1;
    private Face face;

   /* public Robot(){
    }


    public Robot(int i, int y, String n) throws IllegalArgumentException{
        Xpoint = i;
        Ypoint = y;
        setFace(n);

    }*/

    /**
    * check if the robot is placed on the board already
    * @return true if it is already placed on board.
    */
    private boolean isPlacedBoard(){
        return (Xpoint == -1 || Ypoint == -1)? false:true;
    }


    /**
    * move command will move the robot one step further on the direction it faces
    * without place the robot on board first, the move wont do anything.
     * if the move will move the robot off the board, it won't do anything either
    * */
    public void move(Board b) {
        if  (b == null)
            throw new NullPointerException();

        if (!isPlacedBoard()) {
            System.out.println(NOT_ON_BOARD_MESSAGE);
            return;
        }
        switch (face){
            case E:
                if (b.isOnTheBoard(Xpoint+1,Ypoint))
                    Xpoint++;
                break;
            case N:
                if (b.isOnTheBoard(Xpoint,Ypoint+1))
                    Ypoint++;
                break;
            case W:
                if (b.isOnTheBoard(Xpoint-1,Ypoint))
                    Xpoint--;
                break;
            default:
                if (b.isOnTheBoard(Xpoint,Ypoint-1))
                    Ypoint--;
                break;

        }
    }

    
   /**
    * Place command will place the robot on the board as the specified position
    * if the position is out of the board this command will do nothing
    * @param  x
    * @param  y
    * @param  b
    */
    public void place(int x, int y, String f,Board b)  {
       if ( b == null )
           throw new IllegalArgumentException("Board is null");

       if (b.isOnTheBoard(x,y)) {
           Xpoint = x;
           Ypoint = y;
           setFace(f);
           return;
       }

       System.out.println(OUT_OFF_BOARD_MESSAGE);

    }



    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (Xpoint != robot.Xpoint) return false;
        if (Ypoint != robot.Ypoint) return false;
        return face == robot.face;

    }

    @Override
    public int hashCode() {
        int result = Xpoint;
        result = 31 * result + Ypoint;
        result = 31 * result + face.hashCode();
        return result;
    }*/

    /**
    * setFace  will set the robot facing direction
    * @param  f  is the direction the robot will now face.
    */
    private void setFace(String f) {
        switch (f) {
            case "N":
                face = N;
                break;
            case "E":
                face = E;
                break;
            case "S":
                face = S;
                break;
            case "W":
                face = W;
                break;
            default:
                throw new IllegalArgumentException("face only accept N, W, E, S value");
            }
}

    /**
     * will rotate the robot 90 degrees in the left direction
     * without changing the position of the robot.
     * if the robot is not placed on the board, no action will take
     *
     */
    public void left() {
        if (!isPlacedBoard()){
            System.out.println(NOT_ON_BOARD_MESSAGE);
            return;
        }

        switch (face) {
            case N:
                face = W;
                break;
            case E:
                face = N;
                break;
            case S:
                face = E;
                break;
            default:
                face = S;
        }
    }

    /**
    * will rotate the robot 90 degrees in the right direction
    * without changing the position of the robot.
    * if the robot is not placed on the board, no action will take
    *
    */
    public void right() {

        if (!isPlacedBoard()){
            System.out.println(NOT_ON_BOARD_MESSAGE);
            return;
        }
        switch (face) {
            case N:
                face = E;
                break;
            case E:
                face = S;
                break;
            case S:
                face = W;
                break;
            default:
                face = N;
        }


    }

    /**
    *  will announce the position of the robot in X,Y axis and facing direction.
    * if the robot is not placed on the board, no action will take
    * @return x,y,face
    */
    public String report() {
        if (!isPlacedBoard()){
            System.out.println(NOT_ON_BOARD_MESSAGE);
            return "";
        }
        return Xpoint + "," + Ypoint + "," + face.toString();

    }

    @Override
    public String toString(){
        if (face != null)
           return Xpoint+","+Ypoint+","+ face.toString();
        else
            return Xpoint+","+Ypoint;

    }
}
