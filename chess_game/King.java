package chess_game;

public class King extends Role {
	
	public King(int rowIndex, int columnIndex) {
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
		
		//(X + 1, Y + 1)
		if ( (rowIndex + 1 < 8) && (columnIndex + 1 < 8) ) {
			setHighlightColor(rowIndex + 1, columnIndex + 1);
		}

		//(X + 1, Y - 1)
		if ( (rowIndex + 1 < 8) && (columnIndex - 1 > -1) ) {
			setHighlightColor(rowIndex + 1, columnIndex - 1);
		}

		//(X - 1, Y + 1) 
		if ( (rowIndex - 1 > -1) && (columnIndex + 1 < 8) ) {
			setHighlightColor(rowIndex - 1, columnIndex + 1);
		}

		//(X - 1, Y - 1)
		if ( (rowIndex - 1 > -1) && (columnIndex - 1 > -1) ) {
			setHighlightColor(rowIndex - 1, columnIndex - 1);
		}

		//(X + 1, Y) 
		if ( rowIndex + 1 < 8 ) {
			setHighlightColor(rowIndex + 1, columnIndex);
		}

		//(X - 1, Y)
		if ( rowIndex - 1 > -1 ) {
			setHighlightColor(rowIndex - 1, columnIndex);
		}

		//(X, Y + 1)
		if ( columnIndex + 1 < 8 ) {
			setHighlightColor(rowIndex, columnIndex + 1);
		}

		//(X, Y - 1)
		if ( columnIndex - 1 > -1 ) {
			setHighlightColor(rowIndex, columnIndex - 1);
		}
				
	}
}
