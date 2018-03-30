package chess_game;

//use JFrame class to have basic window features
import javax.swing.JFrame;
//use Container and JPanel class to generate containers
import java.awt.Container;
import javax.swing.JPanel;
//use JButton class to generate squares on the chess board
import javax.swing.JButton;
//use LineBoard to add border to JButton
import javax.swing.border.LineBorder;
//use BorderLayout and GridBagLayout(GridBagConstraints) class to arrange components
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//use GridLayout class to arrange the 8x8 buttons
import java.awt.GridLayout;
//use Color class to set the background color of the buttons
import java.awt.Color;

//avoid warning of "class ChessGame does not declare a static final serialVersionUID field"
@SuppressWarnings("serial")
public class Board extends JFrame{
	private Container container;
	private JPanel buttonPanel;
	private JButton hintBtn;
	
	//a static boardPanle that can be repainted across classes
	public static JPanel boardPanel;
	
	//a static 2D JButton array to store the 8x8 squares for the board that can be accessed across classes
	public static JButton[][] boardButtons;
	
	//a static 2D state array to store the ownership of all the JButtons
	//1 means the JButton has a piece of the White player, 2 means the JButton has a piece of the Black player, 
	//0 means there is no piece on the JButton
	public static int[][] pieceLayout;
	
	//a static 2D state array to store the state of all the JButtons when one piece is selected
	//1 means the JButton is the highlighted move, 2 means the JButton is selected
	//0 means the JButton is the trigger to cancel the current select
	public static int[][] pieceState;
	
	//a static integer that counts how many move is made, then infer the player's turn
	public static int turnCounter;

	//constructor, no parameters are taken in
	public Board() {
		super("Chess");
		
		container = getContentPane();
		
		//use GridLayout to store the 8x8 JButtons in board JPanel
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(8, 8));
		
		container.add(boardPanel);
		
		boardButtons = new JButton[8][8];
			
		//execute a for loop to add the buttons to board
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				boardButtons[row][column] = new JButton(); 
				boardPanel.add(boardButtons[row][column]); 
			}
		}
		
		//execute a for loop to set the color of each square/button
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				//when the sum of row and column index is even, the square is light colored.
				if ((row + column) % 2 == 0) {
					boardButtons[row][column].setBackground(Color.white);
				}
				//when the sum of row and column index is odd, the square is dark colored.
				else {
					boardButtons[row][column].setBackground(Color.gray);
				}
				//set JButton's background color and border
				boardButtons[row][column].setOpaque(true);
				boardButtons[row][column].setFocusPainted(false);
				boardButtons[row][column].setBorder(new LineBorder(Color.black));
				
			}
		}
		
		//set Icon to the Black's pieces
		boardButtons[0][0].setIcon(PieceConstant.BLACK_ROOK);		
		boardButtons[0][1].setIcon(PieceConstant.BLACK_KNIGHT);	
		boardButtons[0][2].setIcon(PieceConstant.BLACK_BISHOP);
		boardButtons[0][3].setIcon(PieceConstant.BLACK_QUEEN);
		boardButtons[0][4].setIcon(PieceConstant.BLACK_KING);
		boardButtons[0][5].setIcon(PieceConstant.BLACK_BISHOP);
		boardButtons[0][6].setIcon(PieceConstant.BLACK_KNIGHT);		
		boardButtons[0][7].setIcon(PieceConstant.BLACK_ROOK);
		
		for (int column = 0; column < 8; column++) {			
			boardButtons[1][column].setIcon(PieceConstant.BLACK_PAWN);
		}
		
		//set Icon to the White's pieces
		boardButtons[7][0].setIcon(PieceConstant.WHITE_ROOK);
		boardButtons[7][1].setIcon(PieceConstant.WHITE_KNIGHT);
		boardButtons[7][2].setIcon(PieceConstant.WHITE_BISHOP);
		boardButtons[7][3].setIcon(PieceConstant.WHITE_QUEEN);
		boardButtons[7][4].setIcon(PieceConstant.WHITE_KING);
		boardButtons[7][5].setIcon(PieceConstant.WHITE_BISHOP);
		boardButtons[7][6].setIcon(PieceConstant.WHITE_KNIGHT);
		boardButtons[7][7].setIcon(PieceConstant.WHITE_ROOK);
		
		for (int column = 0; column < 8; column++) {			
			boardButtons[6][column].setIcon(PieceConstant.WHITE_PAWN);
		}
		
		//add action listeners to all the JButtons
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				PieceActionListener pieceActionListener = new PieceActionListener(row, column);
				boardButtons[row][column].addActionListener(pieceActionListener);
			}
		}
		
		//initialize the pieceLayout array and set the white pieces with "prepare" action command
		pieceLayout = new int[8][8];
		
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if (row == 0 || row == 1) {
					pieceLayout[row][column] = 2;
				}
				else if (row == 6 || row == 7) {
					pieceLayout[row][column] = 1;
					boardButtons[row][column].setActionCommand("prepare");
				}
				else {
					pieceLayout[row][column] = 0;
				}
			}
		}
		
		//initialize the pieceState array. Since no piece is selected at the beginning, every element is 0. 
		pieceState = new int[8][8];
		
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				pieceState[row][column] = 0;
			}
		}
		
		//arrange the Hint JButton and the board
		buttonPanel = new JPanel(new GridBagLayout());
		hintBtn = new JButton(" Hint ");
		GridBagConstraints gbc = new GridBagConstraints();
		buttonPanel.add(hintBtn, gbc);
		
		container.add(boardPanel, BorderLayout.WEST);
		container.add(buttonPanel, BorderLayout.EAST);
		
		//add action listener to Hint JButton
		HintActionListener hintActionListener = new HintActionListener();
		hintBtn.addActionListener(hintActionListener);
		
		// set the frame to exit when it is closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//pack the components to fitted size
		pack();
		//make the frame visible
		setVisible(true);
		//make the frame size fixed
		setResizable(false);
	}
	
	//static method to get the current player
	//1 means it's White's turn, 2 means it's Black's turn
	public static int currentPlayer() {
		if (turnCounter % 2 == 0) {
			return 1;
		}
		
		return 2;
	}
	
	//static method to get the opponent player
	public static int opponentPlayer(){
		if (turnCounter % 2 == 0) {
			return 2;
		}
		
		return 1;
	}
	
	//static method to reset the board
	public static void resetBoard() {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if ((row + column) % 2 == 0) {
					boardButtons[row][column].setBackground(Color.white);
				}
				else {
					boardButtons[row][column].setBackground(Color.gray);
				}
				boardButtons[row][column].setOpaque(true);
				boardButtons[row][column].setFocusPainted(false);
				boardButtons[row][column].setBorder(new LineBorder(Color.black));
				
			}
		}
		
		//add a default "init" action command to all the JButtons 
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				pieceState[row][column] = 0;
				boardButtons[row][column].setActionCommand("init");
			}
		}
		
		//add "prepare" action command to the pieces/JButtons that is in the turn
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if (currentPlayer() == 1) {
					if (pieceLayout[row][column] == 1) {
						boardButtons[row][column].setActionCommand("prepare");
					}
				}
				else {
					if (pieceLayout[row][column] == 2) {
						boardButtons[row][column].setActionCommand("prepare");
					}
				}
			}
		}
		
	}
	
}
