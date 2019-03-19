package chess;

public class Pawn extends ChessPiece implements Cloneable{

	public boolean hasMoved;
	private Player player;

	//check for en passante move chance
	private boolean enPassante;
	public boolean enPassanteTaken;

	public Pawn(Player player) {
		super(player);
		this.player = player;
		this.hasMoved = false;
	}

	public String type() {
		return "Pawn";
	}

	// determines if the move is valid for a pawn piece
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = false;
		//check if super pulls it off.
		if (super.isValidMove(move, board) == true) {
			//Tell me which side have I chosen
			if (player() == Player.WHITE) {
				//what direction for player type

				//check if its the pawns first move or not.
				if (!hasMoved) {
					//does the pawn move two spaces forward in its first move
					if ((move.toRow == (move.fromRow - 1) || move.toRow == (move.fromRow - 2)) && move.toColumn == move.fromColumn ) {
						valid = true;
						hasMoved = true;
					}
				} else {
					//Check if pawn just moving one square forward (not taking a piece)
					if (board[move.toRow][move.toColumn] == null) {
						if (move.toRow == (move.fromRow - 1) && move.toColumn == move.fromColumn) {
							valid = true;
							hasMoved = true;
							enPassante = true;
						}
						//for enPassante
						//checks if white pawn is currently at 5th rank
						else if(move.fromRow == 4) {
							if (move.toRow == (move.fromRow - 1) && move.toColumn == (move.fromColumn - 1) ||
									move.toRow == (move.fromRow - 1) && move.toColumn == (move.fromColumn + 1)) {
								if (board[move.toRow - 1][move.toColumn].player().equals(Player.BLACK) &&
										board[move.toRow - 1][move.toColumn].type().equals("Pawn")) {
									if(board[move.toRow - 1][move.toColumn].isEnPassante()) {
										valid = true;
										enPassanteTaken = true;
									}
								}
							}
						}
					}
					//Checks valid moves for taking a black piece
					else if (board[move.toRow][move.toColumn].player().equals(Player.BLACK)){
						//Moves to the Northwest.
						if (move.toRow == (move.fromRow - 1) && move.toColumn == (move.fromColumn - 1)) {
							valid = true;
							hasMoved = true;
						}
						//Moves to the Northeast
						if (move.toRow == (move.fromRow - 1) && move.toColumn == (move.fromColumn + 1)) {
							valid = true;
							hasMoved = true;
						}
					}

				}
			}
			//Else Player is Black and takes turn
			else {
				//what direction for player type

				//check if its the pawns first move or not.
				if (!hasMoved) {
					//does the pawn move two spaces forward in its first move
					if ((move.toRow == (move.fromRow + 1) || move.toRow == (move.fromRow + 2)) && move.toColumn == move.fromColumn ) {
						valid = true;
						hasMoved = true;
						enPassante = true;
					}
				} else {
					//Check if pawn just moving one square forward (not taking a piece)
					if (board[move.toRow][move.toColumn] == null) {
						if (move.toRow == (move.fromRow + 1) && move.toColumn == move.fromColumn) {
							valid = true;
							hasMoved = true;
						}
						//for enPassante
						//checks if black pawn is currently at 5th rank
						else if(move.fromRow == 3) {
							if (move.toRow == (move.fromRow + 1) && move.toColumn == (move.fromColumn - 1) ||
									move.toRow == (move.fromRow + 1) && move.toColumn == (move.fromColumn + 1)) {
								if (board[move.toRow - 1][move.toColumn].player().equals(Player.WHITE) &&
										board[move.toRow + 1][move.toColumn].type().equals("Pawn")) {
									if(board[move.toRow + 1][move.toColumn].isEnPassante()) {
										valid = true;
										enPassanteTaken = true;
									}
								}
							}

						}
					}
					//Checks valid moves for taking a white piece
					else if (board[move.toRow][move.toColumn].player().equals(Player.WHITE)){
						//Moves to the Southwest.
						if (move.toRow == (move.fromRow + 1) && move.toColumn == (move.fromColumn - 1)) {
							valid = true;
							hasMoved = true;
						}
						//Moves to the Southeast
						if (move.toRow == (move.fromRow + 1) && move.toColumn == (move.fromColumn + 1)) {
							valid = true;
							hasMoved = true;
						}
					}

				}
			}
		}
		//return false unless one of above rules are met
		return valid;
	}

	public boolean isEnPassante() {
		return enPassante;
	}

	public void clearEnPassante() {
		this.enPassante = false;
	}

//	if(fromPiece.player() == Player.WHITE) {
//		if (move.fromRow == 4)
//			if (board[move.toRow - 1][move.toColumn].isEnPassante()) {
//				valid = true;
//			}
//	}else if(fromPiece.player() == Player.BLACK) {
//		if (move.fromRow == 3)
//			if (board[move.toRow + 1][move.toColumn].isEnPassante()) {
//				valid = true;
//			}
//	}

}
