package ticTacToe;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
/*declares class*/ 
/*initialize 2d array*/
		int[][] gameBoard = new int[3][3];
/*Input array data*/
/*initialize turn counter*/
		boolean P1 = true;
		System.out.println("shall we play a game?");
/*Check if win condition has been met*/
		while (gameStatus(gameBoard));
		PrintDatBoard(gameBoard);
	}
	public static void PrintDatBoard(int[][] gameBoard){
		String newLine = System.getProperty("line.separator");
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				System.out.print("[ " + gameBoard[x][y] + " ]");
			}
			System.out.print(newLine);
			}
		}
/*based on turn counter print array & directions for input P1/P2*/
/*accept input of correct type*/
/*check if input is acceptable*/
/*update array with acceptable input*/

/*if win condition has been met display MSG & end*/
/*if tie condition has been met display MSG & end*/
	}

}
