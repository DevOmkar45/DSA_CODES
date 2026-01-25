package Backtracking;

public class NQueenProblem {
	
	//function to place queens at right place
	public static void placeQueen(char[][] board, int row) {
		//base case
		if(row == board.length) {
			printBoard(board);
			System.out.println();
			return;
		}
		
		for(int i=0; i<board.length; i++) {
			if(isSafe(board, row, i)) {
				board[row][i] = 'Q';
				placeQueen(board, row+1);
				board[row][i] = 'X';
			}
		}
	}
	
	//function for check wheather placing 
	public static boolean isSafe(char[][] board, int row, int col) {
		
		//vertical check
		for(int i=row-1; i>=0; i--) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		
		//right diagonal 
		for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		//left diagonal 
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}
	
	//function to print chess board
	public static void printBoard(char[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		char[][] board = new char[4][4];
		
		//initialize chessboard
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				board[i][j] = 'X';
			}
		}
		
		placeQueen(board, 0);
		
	}
}
