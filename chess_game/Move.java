package chess_game;

public class Move {
	private int startRowIndex;
	private int startColumnIndex;
	private int endRowIndex;
	private int endColumnIndex;
	
	public Move(int rowIndex, int columnIndex, int endRowIndex, int endColumnIndex) {
		this.setStartRowIndex(rowIndex);
		this.setStartColumnIndex(columnIndex);
		this.setEndRowIndex(endRowIndex);
		this.setEndColumnIndex(endColumnIndex);
	}

	public int getStartRowIndex() {
		return startRowIndex;
	}

	public void setStartRowIndex(int rowIndex) {
		this.startRowIndex = rowIndex;
	}

	public int getStartColumnIndex() {
		return startColumnIndex;
	}

	public void setStartColumnIndex(int columnIndex) {
		this.startColumnIndex = columnIndex;
	}

	public int getEndRowIndex() {
		return endRowIndex;
	}

	public void setEndRowIndex(int endRowIndex) {
		this.endRowIndex = endRowIndex;
	}

	public int getEndColumnIndex() {
		return endColumnIndex;
	}

	public void setEndColumnIndex(int endColumnIndex) {
		this.endColumnIndex = endColumnIndex;
	}
	
	
}
