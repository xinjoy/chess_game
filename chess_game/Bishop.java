package chess_game;

public class Bishop extends Role{


	public Bishop(int rowIndex, int columnIndex) {
		super(rowIndex, columnIndex);
	}

	public void setHighlightColor(int highlightRow, int highlightColumn) {
		paintMoveColor(highlightRow, highlightColumn);
	}

	public void highlight() {
		
		paintSelectColor();
		
		//(X + n, Y + n)
		for (int count = 1; count < 8; count++) {
			if ((rowIndex + count < 8) && (columnIndex + count < 8)) {
				//if the move meets its own piece, stop highlighting this one and further ones
				if (Board.pieceLayout[rowIndex + count][columnIndex + count] == Board.currentPlayer()) {
					break;
				}
				//if the move meets opponent's piece, highlight this one but stop highlighting further ones
				if (Board.pieceLayout[rowIndex + count][columnIndex + count] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex + count, columnIndex + count);
					break;
				}

				setHighlightColor(rowIndex + count, columnIndex + count);
			}				
		}

		//(X - n, Y - n)
		for (int count = 1; count < 8; count++) {
			if ((rowIndex - count > -1) && (columnIndex - count > -1)) {
				if (Board.pieceLayout[rowIndex - count][columnIndex - count] == Board.currentPlayer()) {
					break;
				}
				if (Board.pieceLayout[rowIndex - count][columnIndex - count] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex - count, columnIndex - count);
					break;
				}

				setHighlightColor(rowIndex - count, columnIndex - count);
			}
		}

		//(X + n, Y - n)
		for (int count = 1; count < 8; count++) {
			if ((rowIndex + count < 8) && (columnIndex - count > -1)) {
				if (Board.pieceLayout[rowIndex + count][columnIndex - count] == Board.currentPlayer()) {
					break;
				}
				if (Board.pieceLayout[rowIndex + count][columnIndex - count] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex + count, columnIndex - count);
					break;
				}

				setHighlightColor(rowIndex + count, columnIndex - count);
			}
		}

		//(X - n, Y + n)
		for (int count = 1; count < 8; count++) {
			if ((rowIndex - count > -1) && (columnIndex + count < 8)) {
				if (Board.pieceLayout[rowIndex - count][columnIndex + count] == Board.currentPlayer()) {
					break;
				}
				if (Board.pieceLayout[rowIndex - count][columnIndex + count] == Board.opponentPlayer()) {
					setHighlightColor(rowIndex - count, columnIndex + count);
					break;
				}

				setHighlightColor(rowIndex - count, columnIndex + count);
			}
		}
	
		
	}

}
