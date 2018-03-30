package chess_game;

public class Rook extends Role{

	public Rook(int rowIndex, int columnIndex) {
		super(rowIndex, columnIndex);
	}
	
	public void setHighlightColor(int highlightRow, int highlightColumn) {
		paintMoveColor(highlightRow, highlightColumn);
	}
	
	public void highlight() {		
		paintSelectColor();
		
		//(X + n, Y)
		for (int row = 1; row < 8; row++) {
			if (rowIndex + row < 8) {
				//if the move meets its own piece, stop highlighting this one and further ones
				if (Board.pieceLayout[rowIndex + row][columnIndex] == Board.currentPlayer()) {
					break;
				}
				//if the move meets opponent's piece, highlight this one but stop highlighting further ones
				if (Board.pieceLayout[rowIndex + row][columnIndex] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex + row, columnIndex);
					break;
				}

				setHighlightColor(rowIndex + row, columnIndex);
			}
		}
		
		//(X - n, Y)
		for (int row = 1; row < 8; row++) {
			if (rowIndex - row > -1) {
				if (Board.pieceLayout[rowIndex - row][columnIndex] == Board.currentPlayer()) {
					break;
				}
				if (Board.pieceLayout[rowIndex - row][columnIndex] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex - row, columnIndex);
					break;
				}

				setHighlightColor(rowIndex - row, columnIndex);
			}
		}

		//(X, Y + n)
		for (int col = 1; col < 8; col++) {
			if (columnIndex + col < 8) {
				if (Board.pieceLayout[rowIndex][columnIndex + col] == Board.currentPlayer()) {
					break;
				}
				if (Board.pieceLayout[rowIndex][columnIndex + col] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex, columnIndex + col);
					break;
				}

				setHighlightColor(rowIndex, columnIndex + col);
			}
		}
		
		//(X, Y - n)
		for (int col = 1; col < 8; col++) {
			if (columnIndex - col > -1) {
				if (Board.pieceLayout[rowIndex][columnIndex - col] == Board.currentPlayer()) {
					break;
				}
				if (Board.pieceLayout[rowIndex][columnIndex - col] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex, columnIndex - col);
					break;
				}

				setHighlightColor(rowIndex, columnIndex - col);
			}
		}
	
	}

}
