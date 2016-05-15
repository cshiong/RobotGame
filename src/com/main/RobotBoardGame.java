package com.main;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
*  RobotBoardGame class will read a file of commands to play with the robot on the board around
 * */
public class RobotBoardGame {

    public static void main(String... arg) {
        Robot toy = new Robot();
        Board board = new Board();

        try {
            File file = new File("../test/testData.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String cmd = scanner.next();

                if (cmd.startsWith("place")) {
                    String[] placeCMdcmd = cmd.split(",");
                    toy.place(Integer.valueOf(placeCMdcmd[1]),
                            Integer.valueOf(placeCMdcmd[2]), placeCMdcmd[3], board);

                } else {

                    switch (cmd) {
                        case "move":
                            toy.move(board);
                            break;
                        case "left":
                            toy.left();
                            break;
                        case "right":
                            toy.right();
                            break;
                        case "report":
                            toy.report();
                            break;
                        default:
                            //for any other cases , it will ignore the command to continue the next line command.
                    }

                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}