package chess_game;

import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Helper {
	//static boolean to indicate if Hint button is clicked
	public static boolean hintMode = false;
	
	//static ArrayList to store all the possible moves under hint mode
	public static ArrayList<Move> hintResult = new ArrayList<Move>();
	
	//a helper method that return the clicked piece's role string 
	public static String getPieceRoleName(JButton button) {
		//get the icon's fileName string, the split it to get the role string
		Icon pieceIcon = button.getIcon();
		String iconFileName = "";
		
		if (pieceIcon != null) {
			String iconDescription = ((ImageIcon)pieceIcon).getDescription();

			File iconFile = new File(iconDescription);
			iconFileName = iconFile.getName();
		}
		
		String[] pieceIconFileNameArr1 = iconFileName.split("_");
		
		String[] pieceIconFileNameArr2 = pieceIconFileNameArr1[1].split("\\.");
		
		String pieceRoleName = pieceIconFileNameArr2[0];
			
		return pieceRoleName;
	}
}
