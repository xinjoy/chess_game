package chess_game;

import java.util.Comparator;

public class OptimumComparator implements Comparator <Move> {

	@Override
	public int compare(Move m1, Move m2) {
		//define a factor variable.
		//Since White and Black have opposite positive direction, so factor = 1 is for White and factor = -1 is for Black.
		int factor = 0;
		if (Board.currentPlayer() == 1) {
			factor = 1;
		}
		else {
			factor = -1;
		}
		
		int m1StartRowIndex = m1.getStartRowIndex();
		int m1StartColumnIndex = m1.getStartColumnIndex();
		int m1EndRowIndex = m1.getEndRowIndex();
		int m1EndColumnIndex = m1.getEndColumnIndex();
		
		int m2StartRowIndex = m2.getStartRowIndex();
		int m2StartColumnIndex = m2.getStartColumnIndex();
		int m2EndRowIndex = m2.getEndRowIndex();
		int m2EndColumnIndex = m2.getEndColumnIndex();
		
		//compare the 1st priority
		if ((Board.pieceLayout[m1EndRowIndex][m1EndColumnIndex] == Board.opponentPlayer()) && (Board.pieceLayout[m2EndRowIndex][m2EndColumnIndex] != Board.opponentPlayer())){
			return 1;
		}
		else if ((Board.pieceLayout[m1.getEndRowIndex()][m1.getEndColumnIndex()] != Board.opponentPlayer()) && (Board.pieceLayout[m2.getEndRowIndex()][m2.getEndColumnIndex()] == Board.opponentPlayer())){
			return -1;
		}
		else {
			//compare the 2nd priority 
			if (m1EndColumnIndex * factor > m2EndColumnIndex * factor) {
				return 1;
			}
			else if (m1EndColumnIndex * factor < m2EndColumnIndex * factor) {
				return -1;
			}
			
			else {
				//compare the 3rd priority
				if (m1EndRowIndex * (-1 * factor) > m2EndRowIndex * (-1 * factor)) {
					return 1;
				}
				else if (m1EndRowIndex * (-1 * factor) < m2EndRowIndex * (-1 * factor)) {
					return -1;
				}
				
				else {
					//compare the 4th priority
					if (m1StartColumnIndex * factor < m2StartColumnIndex * factor) {
						return 1;
					}
					else if (m1StartColumnIndex * factor > m2StartColumnIndex * factor) {
						return -1;
					}
					else {
						//compare the 5th priority
						if (m1StartRowIndex * factor > m2StartRowIndex * factor) {
							return 1;
						}
						else if (m1StartRowIndex * factor < m2StartRowIndex * factor) {
							return -1;
						}
						else {
							return 0;
						}
						
					}
					
				}
				
				
			}
			
		}
		
	}

}
