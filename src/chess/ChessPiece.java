package chess;

public abstract class ChessPiece implements IChessPiece {

	private Player owner;

	public boolean hasMoved;

	protected ChessPiece(Player player) {
		this.owner = player;
	}

	public abstract String type();

	public void setType(String type){

	}

	public void setPlayer(Player player){
		this.owner = player;
	}

	public Player player() {
		return owner;
	}

	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = false;

		/* The chess piece that is defined at start of move. */
		IChessPiece fromPiece;

		/* The chess piece that is defined at end of move. */
		IChessPiece toPiece;
		//  THIS IS A START... More coding needed

		//Initializes the fromPice with value(s) gotten from Move move
		fromPiece = board[move.fromRow][move.fromColumn];

		//Initializes the fromPice with value(s) gotten from Move move
		toPiece = board[move.toRow][move.toColumn];

		//does the piece exist on this board** called from model Array
		if(fromPiece != null){
			//did the piece actually move
			if (((move.fromRow == move.toRow) &&
					(move.fromColumn == move.toColumn)) == false){
				//Is there a piece there that you own
				if(toPiece == null)
					valid = true;
				else if(toPiece.player() != owner) {
					valid = true;
				}
			}
		}

		return valid;
	}
	//Modified clone() method in IChessPiece class
	@Override
	public Object clone() throws CloneNotSupportedException {
		IChessPiece cloned = (IChessPiece) super.clone();
		//cloned.setPlayer((Player)cloned.player().clone());
		return cloned;
	}
}
