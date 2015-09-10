package ticTacToe;

import java.util.Scanner;

public class Game {
	/**
	 * 
	 * @author Paul Burger
	 * @param args
	 */
	public static void main(String[] args) {
		/* declares class */
		/* initialize 2d array */
		int turnCounter = 0;
		char[][] gameBoard = new char[3][3];
		/* Input array data */
		boolean gameStatus;
		/* initialize turn counter */
		boolean p1 = true;
		System.out.println("shall we play a game?");

		/* Check if win condition has been met */
		while (gameStatus(gameBoard)) {
			printDatBoard(gameBoard);
			System.out.println("It's " + WhoseTurn(p1) + "'s turn.");
			tic(gameBoard, p1);
			p1 = !p1;
			turnCounter++;
			if((turnCounter)==9){
				System.out.print("Tied Game");
				break;}/* apparently functions as a turn counter */
			
		}// closes while loop
	}// closes main method

	/**
	 * 
	 * @param gameBoard
	 */
	public static void printDatBoard(char[][] gameBoard) {
		String newLine = System.getProperty("line.separator");
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				System.out.print("[ " + gameBoard[x][y] + " ]");
			}
			System.out.print(newLine);
		}
	}// closes printDatBoard

	/* based on turn counter print array & directions for input P1/P2 */
	/**
	 * 
	 * @param gameBoard
	 * @param p1
	 * @return
	 */
	public static char[][] tic(char[][] gameBoard, boolean p1) {
		Scanner xi = new Scanner(System.in);
		while (true) {
			System.out.println("Enter desired X coordinate");
			int x = xi.nextInt();
			if (x<0 || x>2) {
				System.out.println("please enter a valid cordinate point (0-2)");
			} else {

				System.out.println("Enter desired Y coordinate");
				int y = xi.nextInt();
				if (y<0 || y>2){
					System.out.println("please enter a valid cordinate point (0-2)");
				} else {
					if (gameBoard[x][y] == 'X' || gameBoard[x][y] == 'O') {
						System.out.println("try again");
					} else {
						if (p1) {
							gameBoard[x][y] = 'X';
						} else {
							gameBoard[x][y] = 'O';
						}
						return gameBoard;
					}
				}
			}
		}
	} // closes tic method

	/* accept input of correct type */
	/* check if input is acceptable */
	/* update array with acceptable input */

	/* if win condition has been met display MSG & end */
	/**
	 * 
	 * @param gameBoard
	 * @return
	 */
	public static boolean gameStatus(char[][] gameBoard) {
		char current;
		char last = 'l';
		int counter = 0;
		int yDiag = 2;
		for (int x = 0; x < 3; x++) { // check for vertical pattern
			for (int y = 0; y < 3; y++) {
				current = gameBoard[x][y];
				if (last == current && current != 0) {
					counter++; // keep track of how many in a row we've found
				}
				if (counter == 2) {
					System.out.println("You won!");
					return false;
				}
				last = current;
			}
		}
		counter = 0; 
		last = '1';// reset the counter back to 0 before the next check
		for (int y = 0; y < 3; y++) { // check for a horizontal pattern
			for (int x = 0; x < 3; x++) {
				current = gameBoard[x][y];
				if (last == current && current != 0) {
					counter++;
				}
				if (counter == 2) {
					System.out.println("You won!");
					return false;
				}
				last = current;
			}
		}
		counter = 0; 
		last = '1'; // reset the counter back to 0 before the next check
		for (int y = 0; y < 3; y++) { // check for a diagnal down pattern
			current = gameBoard[y][y];
			if (last == current && current != 0) {
				counter++;
			}
			if (counter == 2) {
				System.out.println("You won!");
				return false;
			}
			last = current;
		}
		counter = 0; 
		last = '1';// reset the counter back to 0 before the next check
		for (int x = 0; x < 3; x++) { // check for a diagnal up pattern
			current = gameBoard[x][yDiag];
			if (last == current && current != 0) {
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
	}// closes gameStatus method

	public static String WhoseTurn(boolean p1) { // handy little method to
		// return a string of
		// who's turn it is.
		if (p1) {
			return "Player 1";
		} else {
			return "Player 2";
		}
	}
}// closes Game class

/* if tie condition has been met display MSG & end */

