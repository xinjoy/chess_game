package chess_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;

public class PieceActionListener implements ActionListener {
	//data members that stores the clicked piece's coordinate
	private int rowIndex;
	private int columnIndex;
	
	//constructor
	public PieceActionListener(int rowIndex, int columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
	
	//define the corresponding action according to different action commands
	public void actionPerformed(ActionEvent e) {		
		String action = e.getActionCommand();
		
		switch(action) {
		//find the clicked piece's possible moves and highlight them with green color
		case "prepare":	
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
			
			//add "cancel" action command to all the pieces/JButtons that are not highlighted as possible moves
			//the clicked piece/JButton itself is also included
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					if (Board.pieceState[row][column] != 1) {
						Board.boardButtons[row][column].setActionCommand("cancel");
					}
				}
			}
			
			break;

		//when the highlighted JButton is clicked, move the piece to the highlighted position
		//and update the board and all the states
		case "move" :
			Icon pieceIcon = null;
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					if (Board.pieceState[row][column] == 2) {
						pieceIcon = Board.boardButtons[row][column].getIcon();
						Board.boardButtons[row][column].setIcon(null);
						
						Board.pieceLayout[row][column] = 0;
						
					}
				}
			}
					
			Board.boardButtons[rowIndex][columnIndex].setIcon(pieceIcon);
			
			if (Board.currentPlayer() == 1) {
				Board.pieceLayout[rowIndex][columnIndex] = 1;
			}
			else {
				Board.pieceLayout[rowIndex][columnIndex] = 2;
			}
			
			Board.turnCounter++;
			
			Board.resetBoard();
					
			break;
			
		//reset the board when JButton with "cancel" action command is clicked
		case "cancel":
			Board.resetBoard();

			break;
		
	    //do nothing for the default "init" action command
		default:
			break;

		}
		
		//repaint/refresh the boardPanel 
		Board.boardPanel.repaint();
		
	}
}
