package chess;

public class Knight extends ChessPiece implements Cloneable{
	public static boolean hasMoved;
	private Player player;

	public Knight(Player player) {
		super(player);
		this.player = player;
	}

	public String type() {
		return "Knight";
	}

	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board){

		boolean valid = false;
        if(super.isValidMove(move, board) == true) {
        	if(Math.abs(move.toRow - move.fromRow) == 2 && Math.abs(move.toColumn - move.fromColumn) == 1)
        		valid = true;
			if(Math.abs(move.toRow - move.fromRow) == 1 && Math.abs(move.toColumn - move.fromColumn) == 2)
				valid = true;
		}
		return valid;
		
	}
	public boolean isEnPassante() {return false;}

	public void clearEnPassante() {}
}
