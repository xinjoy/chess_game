package chess_game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class HintActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {

		//reset the board first when Hint button is clicked
		Board.resetBoard();
		
		Helper.hintMode = true;
		
		//clear the ArrayList when Hint button is clicked
		Helper.hintResult.clear();
		
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		
		//create a thread for each piece and add the customized runnable to the thread
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if (Board.pieceLayout[row][column] == Board.currentPlayer()) {
					OptimumRunnable runnable = new OptimumRunnable(row, column);
					Thread thread = new Thread(runnable);
					threadList.add(thread);
					thread.start();
				}
			}
		}
		
		//make sure all the threads are finished
		for (Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
		}
		
		//if the hintResult ArrayList has elements in it, find the optimum move and highlight it
		//otherwise, show a dialog
		if (Helper.hintResult.size() > 0) {
			
			//sort the ArrayList using the customized comparator
			Collections.sort(Helper.hintResult, new OptimumComparator());
			
			//reset and add init action command to all the JButtons
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					Board.pieceState[row][column] = 0;
					Board.boardButtons[row][column].setActionCommand("init");
				}
			}
			
			//get the optimum move and update the board with correct highlighting and action commands
			Move optimumMove = Helper.hintResult.get(Helper.hintResult.size() - 1);

			Board.boardButtons[optimumMove.getEndRowIndex()][optimumMove.getEndColumnIndex()].setBackground(Color.GREEN);
			Board.boardButtons[optimumMove.getEndRowIndex()][optimumMove.getEndColumnIndex()].setOpaque(true);

			Board.boardButtons[optimumMove.getEndRowIndex()][optimumMove.getEndColumnIndex()].setActionCommand("move");

			Board.pieceState[optimumMove.getEndRowIndex()][optimumMove.getEndColumnIndex()] = 1;


			Board.boardButtons[optimumMove.getStartRowIndex()][optimumMove.getStartColumnIndex()].setBackground(Color.ORANGE);
			Board.boardButtons[optimumMove.getStartRowIndex()][optimumMove.getStartColumnIndex()].setOpaque(true);
			Board.pieceState[optimumMove.getStartRowIndex()][optimumMove.getStartColumnIndex()] = 2;

			Helper.hintMode = false;

			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					if (Board.pieceState[row][column] != 1) {
						Board.boardButtons[row][column].setActionCommand("cancel");
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog( null, "No piece exists for current player." );
		}

		//repaint/refresh the boardPanel
		Board.boardPanel.repaint();
	}
}
