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
import java.util.Scanner;

/**
 * An example class implementing Agent class for human players. 
 * The implementation is coupled with the actual game (here, TickTackToe) the agent is playing.
 * @author Azad
 *
 */
public class HumanReversiAgent extends Agent
{

	static Scanner in = new Scanner(System.in);
	public HumanReversiAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		int row,col;
		ReversiGame tttGame = (ReversiGame) game;
		
		boolean first = true;
		do
		{
			if(first) 	System.out.println("Insert row and column ([0,2])");
			else System.out.println("Invalid input! Insert row and column ([0,2]) again.");
			row = in.nextInt();
			col = in.nextInt();
			first=false;
		}while(!tttGame.isValidCell(row, col));
		
		tttGame.board[row][col] = role;
	}


	

}