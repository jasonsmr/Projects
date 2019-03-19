package chess;

public class Queen extends ChessPiece implements Cloneable{

	public static boolean hasMoved;
	private Player player;

	public Queen(Player player) {
		super(player);
		this.player = player;
		this.hasMoved = false;
	}

	public String type() {
		return "Queen";
	}
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = false;
		Bishop move1 = new Bishop(board[move.fromRow][move.fromColumn].player());
		Rook move2 = new Rook(board[move.fromRow][move.fromColumn].player());
		if ((move1.isValidMove(move, board) || move2.isValidMove(move, board))){
			valid = true;
			this.hasMoved = true;
		}
		return valid;
	}
	public boolean isEnPassante() {return false;}

	public void clearEnPassante() {}
}
