package woven.monopoly;

import java.io.File;
import java.util.Scanner;

public class Board {
    public Board() {

    }

    public void createBoard(String boardFilePath) {
        try {
            Scanner readBoard;
            readBoard = new Scanner(new File(boardFilePath));

            while (readBoard.hasNextLine()){

            }

        } catch (Exception e){
            System.out.println("Error reading Board File");
        }
    }
}
