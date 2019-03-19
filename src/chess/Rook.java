package chess;

public class Rook extends ChessPiece implements Cloneable{

	public static boolean hasMoved;
	private Player player;
	private int stepOn;
	private int stepDown;
	public static boolean hasCastled;

	public Rook(Player player) {
		super(player);
		this.player = player;
		this.hasMoved = false;
		
	}

	public String type() {
		return "Rook";
	}

	//Tell me which side have I chosen


	// determines if the move is valid for a rook piece
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		boolean valid = true;
		//check if super pulls it off.
		if (super.isValidMove(move, board) == false) {
			return false;
		}
			//checking if moves along rows vertically
			if (move.fromRow == move.toRow) {
				// Determine which part of the move is greater.
				if (move.fromColumn > move.toColumn) {
					stepOn = move.fromColumn;
					stepDown = move.toColumn;
				} else {
					stepOn = move.toColumn;
					stepDown = move.fromColumn;
				}

				//  Find if there are any pieces in between the rows.
				for (int row = stepDown + 1; row < stepOn; row++)
					if (board[move.toRow][row] != null) {
						valid = false;
						break;
					}
			}
			//checking if moves along columns horizontally
			// Check if it is vertical.
			else if (move.fromColumn == move.toColumn) {
				// Determine which part of the move is greater.
				if (move.fromRow > move.toRow) {
					stepOn = move.fromRow;
					stepDown = move.toRow;
				} else {
					stepOn = move.toRow;
					stepDown = move.fromRow;
				}

				//  Find if there are any pieces in between the rows.
				for (int row = stepDown + 1; row < stepOn; row++)
					if (board[row][move.toColumn] != null) {
						valid = false;
						break;
					}
			}
			else valid = false;

		if(valid) {
			this.hasMoved = true;
			System.out.println("Rook Moved");
		}
		//returns false if did not move in a row or column (moved diagonal)
		return valid;
	}
	public boolean isEnPassante() {return false;}

	public void clearEnPassante() {}
}
