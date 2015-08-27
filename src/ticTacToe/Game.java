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
		P1 = !P1;/*apparently functions as a turn counter*/
/*Check if win condition has been met*/
		//while (gameStatus(gameBoard));
			PrintDatBoard(gameBoard);
			//System.out.println(turncounter(P1) + "make your move");
			gameBoard = Tic(gameBoard, P1);
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
	public static int[][] Tic(int[][] gameBoard, Boolean P1) {
		
		Scanner xi = new Scanner(System.in); 
		Scanner yi = new Scanner(System.in); 
		System.out.println("Enter desired X coordinate");
		int x = xi.nextInt(); 
		System.out.println("Enter desired Y coordinate");
		int y = yi.nextInt(); 
		if (P1) {
			gameBoard[x][y] = 1;
		} else {
			gameBoard[x][y] = 2;
		}
		return gameBoard;
/*accept input of correct type*/
/*check if input is acceptable*/
/*update array with acceptable input*/

/*if win condition has been met display MSG & end*/
	
/*if tie condition has been met display MSG & end*/
	}
}


