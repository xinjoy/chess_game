package chess_game;

public class Queen extends Role{
	public Queen(int rowIndex, int columnIndex) {
		super(rowIndex, columnIndex);
	}

	public void setHighlightColor(int highlightRow, int highlightColumn) {
		paintMoveColor(highlightRow, highlightColumn);
	}

	public void highlight() {
		paintSelectColor();
		
		//Rook + Bishop
		
		//(X + n, Y)
		for (int row = 1; row < 8; row++) {
			if (rowIndex + row < 8) {
				if (Board.pieceLayout[rowIndex + row][columnIndex] == Board.currentPlayer()) {
					break;
				}
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

		//(X + n, Y + n)
		for (int count = 1; count < 8; count++) {
			if ((rowIndex + count < 8) && (columnIndex + count < 8)) {
				if (Board.pieceLayout[rowIndex + count][columnIndex + count] == Board.currentPlayer()) {
					break;
				}
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
