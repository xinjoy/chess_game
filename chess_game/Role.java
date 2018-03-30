package chess_game;

import java.awt.Color;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//abstract class that Bishop, King, Knight, Pawn, Queen and Rook will inherit
public abstract class Role {
	protected int rowIndex;
	protected int columnIndex;
	//the lock is used when adding new element to ArrayList
	private Lock lock;

	
	public Role(int rowIndex, int columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.lock = new ReentrantLock();
	}
	
	//common method that highlights the possible moves when it's not under Hint mode,
	//add the possible move to the ArrayList when it's under Hint mode
	public void paintMoveColor(int highlightRow, int highlightColumn) {
		if (!Helper.hintMode) {
			Board.boardButtons[highlightRow][highlightColumn].setBackground(Color.GREEN);
			
			Board.boardButtons[highlightRow][highlightColumn].setActionCommand("move");

			Board.pieceState[highlightRow][highlightColumn] = 1;
		}
		else {
			lock.lock();
			Move pieceMove = new Move(rowIndex, columnIndex, highlightRow, highlightColumn);
			try {	
				Helper.hintResult.add(pieceMove);
			} finally {
				lock.unlock();
			}
			
		}		
	}
	
	//common method that updates the state of the selected piece
	//and if it's not under Hint mode, highlight the selected piece 
	public void paintSelectColor() {
		Board.pieceState[rowIndex][columnIndex] = 2;
		
		if (!Helper.hintMode) {
			Board.boardButtons[rowIndex][columnIndex].setBackground(Color.ORANGE);
		}
	}
	
	//two abstract methods
	public abstract void setHighlightColor(int highlightRow, int highlightColumn);
	
	public abstract void highlight();
	
	
}
