package ticTacToe;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		/* declares class */
		/* initialize 2d array */
		char[][] gameBoard = new char[3][3];
		/* Input array data */
		boolean gameStatus;
		/* initialize turn counter */
		boolean p1 = true;
		System.out.println("shall we play a game?");

		/* Check if win condition has been met */
		while (gameStatus(gameBoard)){
		printDatBoard(gameBoard);
		System.out.println((p1) + " make your move");
		tic(gameBoard, p1);
		p1 = !p1;/* apparently functions as a turn counter */
	
		}//closes while loop
	}//closes main method
	public static void printDatBoard(char[][] gameBoard) {
		String newLine = System.getProperty("line.separator");
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				System.out.print("[ " + gameBoard[x][y] + " ]");
			}
			System.out.print(newLine);
		}
	}//closes printDatBoard

	/* based on turn counter print array & directions for input P1/P2 */
	public static char[][] tic(char[][] gameBoard, boolean p1) {
		if (p1 = true) {
			System.out.println("P1 its your turn");
		} else {
			System.out.println("P2 its your turn");
		}
		Scanner xi = new Scanner(System.in);
		Scanner yi = new Scanner(System.in);
		System.out.println("Enter desired X coordinate");
		int x = xi.nextInt();
		System.out.println("Enter desired Y coordinate");
		int y = yi.nextInt();
		if (p1) {
			gameBoard[x][y] = 'X';
		} else {
			gameBoard[x][y] = 'O';
		}
		return gameBoard;
	} //closes tic method

	/* accept input of correct type */
	/* check if input is acceptable */
	/* update array with acceptable input */

	/* if win condition has been met display MSG & end */
	public static boolean gameStatus(char[][] gameBoard) {
		char current;
		char last = 0;
		char counter = 0;
		char yDiag = 2;
		for (int x = 0; x < 3; x++) { // check for vertical pattern
			for (int y = 0; y < 3; y++) {
				current = gameBoard[x][y];
				if (last == current && last != 0) {
					counter++; // keep track of how many in a row we've found
				}
				if (counter == 2) { 
					System.out.println("You won!");
					return false;
				}
				last = current;
			}
		}
		counter = 0; //reset the counter back to 0 before the next check
		for (int y = 0; y < 3; y++) { // check for a horizontal pattern
			for (int x = 0; x < 3; x++) {
				current = gameBoard[x][y];
				if (last == current && last != 0) {
					counter++;
				}
				if (counter == 2) {
					System.out.println("You won!");
					return false;
				}
				last = current;
			}
		}
		counter = 0; //reset the counter back to 0 before the next check
		for (int y = 0; y < 3; y++) { // check for a diagnal down pattern
			current = gameBoard[y][y];
			if (last == current && last != 0) {
				counter++;
			}
			if (counter == 2) {
				System.out.println("You won!");
				return false;
			}
			last = current;
		}
		counter = 0; //reset the counter back to 0 before the next check
		for (int x = 0; x < 3; x++) { // check for a diagnal up pattern
			current = gameBoard[x][yDiag];
			if (last == current && last != 0) {
				counter++;
			}
			if (counter == 2) {
				System.out.println("You won!");
				return false;
			}
			last = current;
			yDiag--;
		}
		return true;
	}//closes gameStatus method
}//closes Game class

	/* if tie condition has been met display MSG & end */

