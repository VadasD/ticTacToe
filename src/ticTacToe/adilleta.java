package ticTacToe;
	import java.util.Scanner; //allows me to take in input

	/**
	 * TIC TAC TOE
	 * 
	 * @author adilettad
	 */
	public class adilleta {

		public static void main(String[] args) {
			int[][] gameBoard = new int[3][3]; // 3x3 array for the game board
			boolean player1 = true; // keeps track of whose turn it is
			System.out.println("Let's play"); // welcome message
			while (CheckWinner(gameBoard)) { // start game loop
				GameBoardPrint(gameBoard); // print the current status
				System.out.println("It's " + WhoseTurn(player1) + "'s turn.");
				gameBoard = Tic(gameBoard, player1); // input move
				player1 = !player1; // switch whose turn it is
			}
		}

		public static void GameBoardPrint(int[][] gameBoard) {
			String newLine = System.getProperty("line.separator");// This will
																	// retrieve line
																	// separator
																	// dependent on
																	// OS.
			for (int y = 0; y < 3; y++) { // printing vertically
				for (int x = 0; x < 3; x++) {
					System.out.print("[ " + gameBoard[x][y] + " ]");
				}
				System.out.print(newLine); // create a new line
			}
		}

		public static int[][] Tic(int[][] gameBoard, Boolean player1) {
			// TODO: subtract 1 from inputs so they adjust to array's 0 start point
			Scanner xi = new Scanner(System.in); // store the x coordinate
			Scanner yi = new Scanner(System.in); // store the y coordinate
			System.out.println("Please enter your desired X coordinate");
			int x = xi.nextInt(); // TODO needs execption handling
			System.out.println("Please enter your desired Y coordinate");
			int y = yi.nextInt(); // TODO needs execption handling
			if (player1) {
				gameBoard[x][y] = x;
			} else {
				gameBoard[x][y] = y;
			}
			return gameBoard;
		}

		public static boolean CheckWinner(int[][] gameBoard) {
			int current;
			int last = 0;
			int counter = 0;
			int yDiag = 2;
			for (int x = 0; x < 3; x++) { // check for vertical pattern
				for (int y = 0; y < 3; y++) {
					current = gameBoard[x][y];
					if (last == current && last != 0) {
						counter++; // keep track of how many in a row we've found
					}
					if (counter == 3) {
						System.out.println("You won!");
						return false;
					}
					last = current;
				}
			}
			for (int y = 0; y < 3; y++) { // check for a horizontal pattern
				for (int x = 0; x < 3; x++) {
					current = gameBoard[x][y];
					if (last == current && last != 0) {
						counter++;
					}
					if (counter == 3) {
						System.out.println("You won!");
						return false;
					}
					last = current;
				}
			}
			for (int y = 0; y < 3; y++) { // check for a diagnal down pattern
				current = gameBoard[y][y];
				if (last == current && last != 0) {
					counter++;
				}
				if (counter == 3) {
					System.out.println("You won!");
					return false;
				}
				last = current;
			}
			for (int x = 0; x < 3; x++) { // check for a diagnal up pattern
				current = gameBoard[x][yDiag];
				if (last == current && last != 0) {
					counter++;
				}
				if (counter == 3) {
					System.out.println("You won!");
					return false;
				}
				last = current;
				yDiag--;
			}
			return true;
		}

		public static String WhoseTurn(boolean player1) { // handy little method to
															// return a string of
															// who's turn it is.
			if (player1) {
				return "Player 1";
			} else {
				return "Player 2";
			}
		}
	}

