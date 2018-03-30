package chess_game;

public class Pawn extends Role {

	public Pawn(int rowIndex, int columnIndex) {
		super(rowIndex, columnIndex);
	}
	
	public void setHighlightColor(int highlightRow, int highlightColumn) {
		//when the move doesn't meet its own piece, highlight it
		if (Board.pieceLayout[highlightRow][highlightColumn] != Board.currentPlayer()) {
			paintMoveColor(highlightRow, highlightColumn);
		}
	}
	
	public void highlight() {
		paintSelectColor();
		
		//White's turn
		if (Board.currentPlayer() == 1) {
			//move upward 1 or 2 squares
			if (rowIndex == 6) {
				if (Board.pieceLayout[rowIndex - 1][columnIndex] == 0) {
					setHighlightColor(rowIndex - 1, columnIndex);
				}
				if ((Board.pieceLayout[rowIndex - 2][columnIndex] == 0) && (Board.pieceLayout[rowIndex - 1][columnIndex] == 0)) {
					setHighlightColor(rowIndex - 2, columnIndex);
				}
			}
			else {
				if (rowIndex > 0) {
					if ((rowIndex - 1 > -1) && (Board.pieceLayout[rowIndex - 1][columnIndex] == 0)) {
						setHighlightColor(rowIndex - 1, columnIndex);
					}
				}
			}
			
			//leftward or rightward if it's opponent's piece
			if ((rowIndex - 1 > -1) && (columnIndex - 1 > -1)) {
				if (Board.pieceLayout[rowIndex - 1][columnIndex - 1] == 2)  {
					setHighlightColor(rowIndex - 1, columnIndex - 1);
				}
			}
			
			if ((rowIndex - 1 > -1) && (columnIndex + 1 < 8)) {
				if (Board.pieceLayout[rowIndex - 1][columnIndex + 1] == 2)  {
					setHighlightColor(rowIndex - 1, columnIndex + 1);
				}
			}
			
			
		}
		
		//Black's turn
		else {
			if (rowIndex == 1) {
				if (Board.pieceLayout[rowIndex + 1][columnIndex] == 0) {
					setHighlightColor(rowIndex + 1, columnIndex);
				}
				if ((Board.pieceLayout[rowIndex + 2][columnIndex] == 0) && (Board.pieceLayout[rowIndex + 1][columnIndex] == 0)) {
					setHighlightColor(rowIndex + 2, columnIndex);
				}
			}
			else {
				if (rowIndex < 7) {
					if ((rowIndex + 1 < 8)  && (Board.pieceLayout[rowIndex + 1][columnIndex] == 0)) {
						setHighlightColor(rowIndex + 1, columnIndex);
					}
				}
			}
			
			if ((rowIndex + 1 < 8) && (columnIndex - 1 > -1)) {
				if (Board.pieceLayout[rowIndex + 1][columnIndex - 1] == 1)  {
					setHighlightColor(rowIndex + 1, columnIndex - 1);
				}
			}
			
			if ((rowIndex + 1 < 8) && (columnIndex + 1 < 8)) {
				if (Board.pieceLayout[rowIndex + 1][columnIndex + 1] == 1)  {
					setHighlightColor(rowIndex + 1, columnIndex + 1);
				}
			}
		}
		
	}
	
	
}
