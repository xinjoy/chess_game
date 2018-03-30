package chess_game;

public class Knight extends Role {	
	
	public Knight(int rowIndex, int columnIndex) {
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
		
		int highlightRow = 0;
		int highlightColumn = 0;
		// (X + 2, Y + 1)
		if ( (rowIndex + 2 < 8) && (columnIndex + 1 < 8) ) {
			highlightRow = rowIndex + 2;
			highlightColumn = columnIndex + 1;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		// (X + 2, Y - 1)
		if ( (rowIndex + 2 < 8) && (columnIndex - 1 > -1) ) {
			highlightRow = rowIndex + 2;
			highlightColumn = columnIndex - 1;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		// (X - 2, Y + 1)
		if ( (rowIndex - 2 > -1) && (columnIndex + 1 < 8) ) {
			highlightRow = rowIndex - 2;
			highlightColumn = columnIndex + 1;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		// (X - 2, Y - 1)
		if ( (rowIndex - 2 > -1) && (columnIndex - 1 > -1) ) {
			highlightRow = rowIndex - 2;
			highlightColumn = columnIndex - 1;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		// (X + 1, Y + 2)
		if ( (rowIndex + 1 < 8) && (columnIndex + 2 < 8) ) {
			highlightRow = rowIndex + 1;
			highlightColumn = columnIndex + 2;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		// (X + 1, Y - 2)
		if ( (rowIndex + 1 < 8) && (columnIndex - 2 > -1) ) {
			highlightRow = rowIndex + 1;
			highlightColumn = columnIndex - 2;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		// (X - 1, Y + 2)
		if ( (rowIndex - 1 > -1) && (columnIndex + 2 < 8) ) {
			highlightRow = rowIndex - 1;
			highlightColumn = columnIndex + 2;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		// (X - 1, Y - 2)
		if ( (rowIndex - 1 > -1) && (columnIndex - 2 > -1) ) {
			highlightRow = rowIndex - 1;
			highlightColumn = columnIndex - 2;
			setHighlightColor(highlightRow, highlightColumn);
		}
		
		
	}
}
