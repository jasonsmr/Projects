package chess;

public class Bishop extends ChessPiece implements Cloneable{
	public static boolean hasMoved;
	private Player player;

	public Bishop(Player player) {
		super(player);
		this.player = player;
		this.hasMoved = false;
	}

	public String type() {
		return "Bishop";
	}
	
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		int stepOnRow, stepOnCol;
		boolean valid = true;
		if(super.isValidMove(move, board) == false) {
			valid = false;
		}
		if(move.fromRow == move.toRow || move.fromColumn == move.toColumn){
			//Did not move diagonally
			valid = false;
		}

		//check that its not moving just vertically or horizontally
		if(move.fromRow < move.toRow){stepOnRow = 1;
		}else{stepOnRow = -1;}

		if(move.fromColumn < move.toColumn){stepOnCol = 1;
		}else{stepOnCol = -1;}

		//math shows when moving diagonally the row should equal column
		if(Math.abs(move.toRow - move.fromRow) != Math.abs(move.toColumn - move.fromColumn)) {
			valid = false;
		}
		int col = move.fromColumn + (stepOnCol);
		int row = move.fromRow +(stepOnRow);
		//pieces blocking move
		while(row != move.toRow){
			if(board[row][col] != null) {
				valid = false;
				break;
			}
			row += stepOnRow;
			col += stepOnCol;
		}

		return valid;
	}

	public boolean isEnPassante() {
		return false;
	}

	public void clearEnPassante() {
	}
}
