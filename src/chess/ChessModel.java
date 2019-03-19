package chess;

import java.util.ArrayList;
import java.util.Stack;

public class ChessModel implements IChessModel {
	public Stack<IChessPiece[][]> iBoardStack = new Stack<IChessPiece[][]>();
    private IChessPiece[][] board;
    public ArrayList<IChessPiece[][]> iBoardArray = new ArrayList<IChessPiece[][]>();
    private boolean isFirstMove = true;
	private Player player;
	public Integer moveNum = 0;
	// declare other instance variables as needed

	public ChessModel() {
		board = new IChessPiece[8][8];
		//boardArray = new ArrayList[board];
		//first player traditionally in favor of white.
		player = Player.WHITE;
		//place all black initial pieces
		board[0][0] = new Rook(Player.BLACK);
		board[0][1] = new Knight(Player.BLACK);
		board[0][2] = new Bishop(Player.BLACK);
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
		board[0][5] = new Bishop(Player.BLACK);
		board[0][6] = new Knight (Player.BLACK);
		board[0][7] = new Rook(Player.BLACK);
		board[1][0] = new Pawn(Player.BLACK);
		board[1][1] = new Pawn(Player.BLACK);
		board[1][2] = new Pawn(Player.BLACK);
		board[1][3] = new Pawn(Player.BLACK);
		board[1][4] = new Pawn(Player.BLACK);
		board[1][5] = new Pawn(Player.BLACK);
		board[1][6] = new Pawn(Player.BLACK);
		board[1][7] = new Pawn(Player.BLACK);
		//place all white initial pieces
		board[6][0] = new Pawn(Player.WHITE);
		board[6][1] = new Pawn(Player.WHITE);
		board[6][2] = new Pawn(Player.WHITE);
		board[6][3] = new Pawn(Player.WHITE);
		board[6][4] = new Pawn(Player.WHITE);
		board[6][5] = new Pawn(Player.WHITE);
		board[6][6] = new Pawn(Player.WHITE);
		board[6][7] = new Pawn(Player.WHITE);
		board[7][0] = new Rook(Player.WHITE);
        board[7][1] = new Knight(Player.WHITE);
        board[7][2] = new Bishop(Player.WHITE);
        board[7][3] = new Queen(Player.WHITE);
        board[7][4] = new King(Player.WHITE);
        board[7][5] = new Bishop(Player.WHITE);
        board[7][6] = new Knight (Player.WHITE);
        board[7][7] = new Rook(Player.WHITE);
	}

	public boolean isComplete() {
		boolean valid = false;
		return valid;
	}

	public boolean isValidMove(Move move) {
		boolean valid = false;
		if (board[move.fromRow][move.fromColumn] != null)
			if(board[move.fromRow][move.fromColumn].player() == currentPlayer()){
				if (board[move.fromRow][move.fromColumn].isValidMove(move, board) == true) {
					valid = true;
				}
			}

		if(valid)
			setNextPlayer();
		return valid;
	}

	public void move(Move move) throws CloneNotSupportedException{
		//which side am I castled on
		if(board[move.fromRow][move.fromColumn].type().equals("King") ) {
			if (((King) board[move.fromRow][move.fromColumn]).hasCastledKingSide ||
					((King) board[move.fromRow][move.fromColumn]).hasCastledQueenSide) {
				//create a temp king to hold its value
				ChessPiece tempK = ((King) board[move.fromRow][move.fromColumn]);
				//overwrite king position with rook
				board[move.fromRow][move.fromColumn] = board[move.toRow][move.toColumn];
				//finally swap the king with where the rook was
				board[move.toRow][move.toColumn] = tempK;
				((King) board[move.toRow][move.toColumn]).hasCastledKingSide = false;
				((King) board[move.toRow][move.toColumn]).hasCastledQueenSide = false;
			}
		}
		else {
				System.out.println(board[move.fromRow][move.fromColumn].player().toString() + " " + board[move.fromRow][move.fromColumn].type() + move.toString());
				board[move.toRow][move.toColumn] = board[move.fromRow][move.fromColumn];
				board[move.fromRow][move.fromColumn] = null;
			}
	}



	public IChessPiece[][] fillIBoard(IChessPiece[][] board) {
		//this.boardArray.add(board);
		IChessPiece[][] iBoard = new IChessPiece[8][8];
		for (int row = 0; row < board.length; row++ ){
			for(int col = 0; col < board[row].length; col++){
				//if(board[row][col] == null)
					//System.out.println("Warn piece NULL "+board[row][col]);
				iBoard[row][col] = clonePiece(board[row][col]);

			}
		}
		return iBoard;
	}

	private IChessPiece clonePiece(IChessPiece piece){
		IChessPiece tempPiece = null;
		try {
			if(piece == null)
				return null;
			if (piece.type().equals("Pawn"))
				tempPiece = (Pawn) piece.clone();
			if (piece.type().equals("Rook"))
				tempPiece = (Rook) piece.clone();
			if (piece.type().equals("Bishop"))
				tempPiece = (Bishop) piece.clone();
			if (piece.type().equals("Knight"))
				tempPiece = (Knight) piece.clone();
			if (piece.type().equals("Queen"))
				tempPiece = (Queen) piece.clone();
			if (piece.type().equals("King"))
				tempPiece = (King) piece.clone();
		}catch(CloneNotSupportedException clone){
			clone.printStackTrace();
		}
		if(tempPiece != null)
			return tempPiece;
		else throw new NullPointerException("Cannot Clone Null Chess Piece Type Error;");
	}
	public void arrayAdd(){
		this.moveNum ++;
		iBoardStack.push(fillIBoard(board));
		System.out.println("Model Move #"+this.moveNum);
	}

	public void arraySubtract(int moveNum){
		this.moveNum --;
		if(this.moveNum != moveNum)
			throw new IllegalArgumentException("Move Numbers must be the same between Model Class and Panel Class!\nModel Move #"+this.moveNum);
		IChessPiece[][] iBoard = iBoardStack.pop();
		for (int row = 0; row < iBoard.length; row++ ){
			for(int col = 0; col < iBoard[row].length; col++){
				this.board[row][col] = clonePiece(iBoard[row][col]);
			}
		}
		System.out.println("Model Move #"+this.moveNum);
	}

	public boolean inCheck(Player p) {
		boolean valid = false;
		return valid;
	}

	public Player currentPlayer() {
		return player;
	}

	public int numRows() {
		return 8;
	}

	public int numColumns() {
		return 8;
	}

	public IChessPiece pieceAt(int row, int column) {		
		return board[row][column];
	}

	public void setNextPlayer() {
		player = player.next();
	}

//	public void setPiece(int row, int column, IChessPiece piece) {
//		board[row][column] = piece;
//	}

	public void AI() {
		/*
		 * Write a simple AI set of rules in the following order. 
		 * a. Check to see if you are in check.
		 * 		i. If so, get out of check by moving the king or placing a piece to block the check 
		 * 
		 * b. Attempt to put opponent into check (or checkmate). 
		 * 		i. Attempt to put opponent into check without losing your piece
		 *		ii. Perhaps you have won the game. 
		 *
		 *c. Determine if any of your pieces are in danger, 
		 *		i. Move them if you can. 
		 *		ii. Attempt to protect that piece. 
		 *
		 *d. Move a piece (pawns first) forward toward opponent king 
		 *		i. check to see if that piece is in danger of being removed, if so, move a different piece.
		 */

		}
}
