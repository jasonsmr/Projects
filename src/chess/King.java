package chess;

public class King extends ChessPiece implements Cloneable{

	public boolean hasMoved;
	private Player player;
	public boolean hasCastledKingSide;
	public boolean hasCastledQueenSide;

	public King(Player player) {
		super(player);
		this.player = player;
		this.hasMoved = false;
		this.hasCastledKingSide = false;
		this.hasCastledQueenSide = false;
	}

	public String type() {
		return "King";
	}

	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = false;
		//check if super pulls it off.
		if (super.isValidMove(move, board) == true) {
			//King doesnt move more than once in any direction
			if(Math.abs(move.toRow - move.fromRow) == 1 ||
					Math.abs(move.toColumn - move.fromColumn) == 1){
				valid = true;
				this.hasMoved = true;
			}else {
				valid = false;
				this.hasMoved = false;
			}
		}
		else
			if (!this.hasMoved){
				//Castled or not
				if(move.fromRow == move.toRow && move.toColumn - move.fromColumn == 3){
					//Logic for castling King_Side check all spots
					// between king and KS-Bishop are in the clear
					if(board[move.toRow][move.fromColumn + 1] == null &&
							board[move.toRow][move.fromColumn + 2] == null){
						if(board[move.toRow][move.toColumn].type().equals("Rook") &&
								((Rook)board[move.toRow][move.toColumn]).hasMoved == false) {
							this.hasMoved = true;
							this.hasCastledKingSide = true;
							valid = true;
						}
					}

				}else if(move.fromRow == move.toRow && move.fromColumn - move.toColumn == 4) {
					//Logic for castling Queen_Side check all spots
					// between king and QS-Bishop are in the clear
					if (board[move.toRow][move.fromColumn - 1] == null &&
							board[move.toRow][move.fromColumn - 2] == null &&
							board[move.toRow][move.fromColumn - 3] == null) {
						if(board[move.toRow][move.toColumn].type().equals("Rook") &&
								((Rook)board[move.toRow][move.toColumn]).hasMoved == false) {
							this.hasMoved = true;
							this.hasCastledQueenSide = true;
							valid = true;
						}
					}
				}
			}
		return valid;
	}

	public boolean isEnPassante() {return false;}

	public void clearEnPassante() {}
}
