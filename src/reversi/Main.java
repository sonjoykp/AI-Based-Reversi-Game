/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

/**
 *
 * @author sonjoy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //static int noMoveCount=0;
    //static int[][] boarddata = new int[9][9];
    //static int next_player=-5;    // if 1 then starts from black if -1 then starts from blue move 


    public static void main(String[] args) {
        

        ReversiBoard intialBoard = new ReversiBoard();
//        boarddata[4][4] = -1;
//        boarddata[4][5] = 1;
//        boarddata[5][4] = 1;
//        boarddata[5][5] = -1;

        intialBoard.setVisible(true);
        //intialBoard.update();
        //intialBoard.showAvailavleMoves(next_player);

        //this line for 2 player mode 
        //intialBoard.next_move(intialBoard.validMovesList.get(2).x, intialBoard.validMovesList.get(2).y);

    }

}
