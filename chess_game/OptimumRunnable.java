package chess_game;

//define a new runnable that finds all the possible moves
public class OptimumRunnable implements Runnable{
	private int rowIndex;
	private int columnIndex;
	
	public OptimumRunnable(int rowIndex, int columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
	
	@Override
	public void run() {
		
		String pieceRole = Helper.getPieceRoleName(Board.boardButtons[rowIndex][columnIndex]);
		
		switch(pieceRole) {
		case "bishop" :
			Bishop bishop = new Bishop(rowIndex, columnIndex);
			bishop.highlight();
			break;
		
		case "king" :
			King king = new King(rowIndex, columnIndex);
			king.highlight();
			break;
			
		case "knight":
			Knight knight = new Knight(rowIndex, columnIndex);
			knight.highlight();
			break;
			
		case "pawn":
			Pawn pawn = new Pawn(rowIndex, columnIndex);
			pawn.highlight();
			break;
		
		case "queen" :
			Queen queen = new Queen(rowIndex, columnIndex);
			queen.highlight();
			break;
			
		case "rook":
			Rook rook = new Rook(rowIndex, columnIndex);
			rook.highlight();
			break;
		
		}
		
		
	}

}
