package chess_game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public final class PieceConstant {
	//12 static final Icons representing different roles that can be accessed across classes
	public static final Icon BLACK_ROOK = new ImageIcon(PieceConstant.class.getResource("/resources/images/black_rook.png"));
	public static final Icon BLACK_KNIGHT = new ImageIcon(PieceConstant.class.getResource("/resources/images/black_knight.png"));
	public static final Icon BLACK_BISHOP = new ImageIcon(PieceConstant.class.getResource("/resources/images/black_bishop.png"));
	public static final Icon BLACK_QUEEN = new ImageIcon(PieceConstant.class.getResource("/resources/images/black_queen.png"));
	public static final Icon BLACK_KING = new ImageIcon(PieceConstant.class.getResource("/resources/images/black_king.png"));
	public static final Icon BLACK_PAWN = new ImageIcon(PieceConstant.class.getResource("/resources/images/black_pawn.png"));
	public static final Icon WHITE_ROOK = new ImageIcon(PieceConstant.class.getResource("/resources/images/white_rook.png"));
	public static final Icon WHITE_KNIGHT = new ImageIcon(PieceConstant.class.getResource("/resources/images/white_knight.png"));
	public static final Icon WHITE_BISHOP = new ImageIcon(PieceConstant.class.getResource("/resources/images/white_bishop.png"));
	public static final Icon WHITE_QUEEN = new ImageIcon(PieceConstant.class.getResource("/resources/images/white_queen.png"));
	public static final Icon WHITE_KING = new ImageIcon(PieceConstant.class.getResource("/resources/images/white_king.png"));
	public static final Icon WHITE_PAWN = new ImageIcon(PieceConstant.class.getResource("/resources/images/white_pawn.png"));
	
	private PieceConstant() {
		
	}

}
