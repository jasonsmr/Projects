package MineSweeper;

/**********************************************************************
 MineSweeperGame.java is the main game working class with most of the
 game logic (outside display related logic). It creates a board Array
 of cells and uses this to randomly place mines.
 Also methods for playing game using recursion and non-recursion.
 @author Jason Rupright
 @version 1/30/2019
 **********************************************************************/

import java.awt.*;
import java.util.*;

public class MineSweeperGame {
	/** board variable holds Array of Cells for game buttons */
	private Cell[][] board;
	/** check to see if player has started the game */
	private boolean hasMoved;
	/** status variable holds information
	 * for: win, loss, or not over yet */
	private GameStatus status;
	/** difficulty variable holds information for game levels */
	private Difficulty difficulty;
	/** cord_X variable holds information for COLUMNS X-direction */
	private static int cord_X;
	/** cord_Y variable holds information for ROWS Y-direction */
	private static int cord_Y;
	/** MINES variable holds information for number of MINES total */
	private static int MINES;
	/** numButtonActive place holder variable used to iterate
	 * through a plus one value for each flagged button. */
	private final static int numButtonActive = 1;
	/** count variable holds information for something */
	private int count;

	/******************************************************************
	 * MineSweeperGame Method creates a default game 10x10x10mines
	 * It sets the default sizes and Layouts called by default
	 * constructor.
	 ******************************************************************/
	public MineSweeperGame() {
		status = GameStatus.NotOverYet;
		cord_X = MineSweeperPanel.getROWS();
		cord_Y = MineSweeperPanel.getCOLS();
		board = new Cell[cord_X][cord_Y];
		setEmpty();
		layMines (MINES);
	}
	/******************************************************************
	 * MineSweeperGame Method creates a default game 10x10x10mines
	 * It sets the default sizes and Layouts called by default
	 * constructor.
	 * Used to differentiate between different game types.
	 * @param size int takes argument for board size
	 * @param mines in takes prameter for number of the mines
	 ******************************************************************/
	public MineSweeperGame(int size, int mines) {
		status = GameStatus.NotOverYet;
		MINES = mines;
		cord_X = size;
		cord_Y = size;
		board = new Cell[cord_X][cord_Y];
		setEmpty();
		layMines (mines);
	}
	/******************************************************************
	 * MineSweeperGame Method creates a default game 10x10x10mines
	 * It sets the default sizes and Layouts called by default
	 * constructor.
	 * @return Difficulty difficulty The game difficulty.
	 ******************************************************************/
	public Difficulty getDifficulty() {
		return difficulty;
	}
	/******************************************************************
	 * MineSweeperGame Method creates a default game 10x10x10mines
	 * It sets the default sizes and Layouts called by default
	 * constructor.
	 * @param difficulty Difficulty parameter passed to set game level
	 ******************************************************************/
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	/******************************************************************
	 * setEmpty Method resets all board cells to not exposed no mine.
	 * Used in resetting board.
	 *
	 ******************************************************************/
	private void setEmpty() {
		board = new Cell[cord_X][cord_Y];
		//System.out.println("SET EMPTY GAME Board Size:
		// "+MineSweeperPanel.getROWS()+"x"+MineSweeperPanel.getCOLS());
		for (int r = 0; r < cord_Y; r++)
			for (int c = 0; c < cord_X; c++)
				board[r][c] = new Cell(false, false);
			// totally clear.
			//checkStatus();
	}
	/******************************************************************
	 * zeroCount helper Method resets the count to zero.
	 ******************************************************************/
	public void zeroCount() {
		this.count = 0;
	}
	/******************************************************************
	 * getCount helper Method returns the current game count
	 *
	 * @return int count Returns the current game count.
	 ******************************************************************/
	public int getCount() {
		return count;
	}
	/******************************************************************
	 * inCount helper Method increments the current game count by one.
	 *
	 ******************************************************************/
	public void inCount() {
		this.count++;
	}
	/******************************************************************
	 * getNumButtonActive helper Method returns the static value of one
	 *
	 * @return int numButtonActive Returns the static value of one.
	 ******************************************************************/
	public int getNumButtonActive() {
		return numButtonActive;
	}
	/******************************************************************
	 * getCord_X helper Method returns value of COLUMNS X-direction
	 *
	 * @return int cord_X Returns the COLUMNS X-direction
	 ******************************************************************/
	public static int getCord_X() {
		return cord_X;
	}
	/******************************************************************
	 * setCord_X helper Method sets value of COLUMNS X-direction
	 *
	 * @param cord_X int COLUMNS X-direction
	 ******************************************************************/
	public void setCord_X(int cord_X) {
		this.cord_X = cord_X;
	}
	/******************************************************************
	 * getCord_Y helper Method returns value of ROWS Y-direction
	 *
	 * @return int cord_Y Returns the ROWS Y-direction
	 ******************************************************************/
	public static int getCord_Y() {
		return cord_Y;
	}
	/******************************************************************
	 * setCord_Y helper Method sets value of ROWS Y-direction
	 *
	 * @param cord_Y int ROWS Y-direction
	 ******************************************************************/
	public void setCord_Y(int cord_Y) {
		this.cord_Y = cord_Y;
	}
	/******************************************************************
	 * getBoard Method returns an Array of Cells that represents
	 * the game board.
	 *
	 * @return Cell[][] board The game board.
	 ******************************************************************/
	public Cell[][] getBoard() {
		return board;
	}
	/******************************************************************
	 * setBoard Method sets an Array of Cells that represents
	 * the game board.
	 *
	 * @param board Cell[][] The game board.
	 ******************************************************************/
	public void setBoard(Cell[][] board) {
		this.board = board;
	}
	/******************************************************************
	 * getMINES helper Method returns value of MINES in game
	 *
	 * @return int MINES Returns the MINES in game
	 ******************************************************************/
	public static int getMINES() {
		return MINES;
	}
	/******************************************************************
	 * setMINES helper Method sets value number MINES in game
	 *
	 * @param MINES int The MINES in game
	 ******************************************************************/
	public static void setMINES(int MINES) {
		MineSweeperGame.MINES = MINES;
	}
	/******************************************************************
	 * getCell Method returns current cell in board
	 *
	 * @param row int current row
	 * @param col int current col
	 * @return Cell board[row][col] Returns the current cell queried
	 ******************************************************************/
	public Cell getCell(int row, int col) {
		return board[row][col];
	}
	/******************************************************************
	 * select Method creates a new button selection for given cell
	 * cords (ros, col). has checking for game status.
	 *
	 * @param row int current row
	 * @param col int current col
	 ******************************************************************/
	public void select(int row, int col) {
		if(!board[row][col].isFlagged())
		if(status == GameStatus.NotOverYet) {
			board[row][col].setExposed(true);
			if(getMINES() == (getCord_X()*getCord_Y()))
				status = GameStatus.Won;
			else if (board[row][col].isMine())   // did I lose
				status = GameStatus.Lost;
			else {
				status = GameStatus.Won;    // did I win
				for (int r = 0; r < getCord_Y(); r++) { // are mines left
					for (int c = 0; c < getCord_X(); c++) {
						if (!board[r][c].isExposed() &&
								!board[r][c].isMine()) {
							status = GameStatus.NotOverYet;
						}
					}
				}
			}
		}
	}

	/******************************************************************
	 * floodFind Method to find all zero values in game and if not
	 * already marked as floodFilled, then call the floodFill method.
	 * recursively.
	 *
	 * @param row Integer passed for current row checking
	 * @param col Integer passed for current column checking
	 ******************************************************************/
	public void floodFind(int row, int col) {
		if (row < 0 || row >= getCord_Y() || col < 0 ||
				col >= getCord_X()) {
			return;
		}
			// check for bounds
			if (!board[row][col].isFlagged() && !board[row][col].isFlooded() &&
					board[row][col].getCount() == 0) {
				floodFill(row, col);
				floodFind(row + 1, col);
				floodFind(row - 1, col);
				floodFind(row, col - 1);
				floodFind(row, col + 1);

				floodFind(row + 1, col + 1);
				floodFind(row - 1, col + 1);
				floodFind(row - 1, col - 1);
				floodFind(row + 1, col - 1);

			}
			else {
				select(row,col);
			}
	}
	/******************************************************************
	 * floodFindNonRecursive Method to find all zero values in game
	 * and if not already marked as floodFilled.
	 *
	 * @param row Integer passed for current row checking
	 * @param col Integer passed for current column checking
	 ******************************************************************/
	public void floodFindNonRecursive(int row, int col) {
		if(getMINES() == (getCord_X()*getCord_Y())) {
			status = GameStatus.Won;
			for (int r = 0; r < getCord_Y(); r++) // are mines left
				for (int c = 0; c < getCord_X(); c++)
					board[r][c].setExposed(true);
			return;
		}
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(new Point(col, row));

			while (!queue.isEmpty())
			{
				Point p = queue.remove();

				if(floodFillNonRecursiveHelper(p.y,p.x))
				{
					queue.add(new Point(p.x,p.y - 1));
					queue.add(new Point(p.x,p.y + 1));
					queue.add(new Point(p.x - 1,p.y));
					queue.add(new Point(p.x + 1,p.y));

					queue.add(new Point(p.x + 1,p.y + 1));
					queue.add(new Point(p.x - 1,p.y + 1));
					queue.add(new Point(p.x - 1,p.y - 1));
					queue.add(new Point(p.x + 1,p.y - 1));


				}
			}
		if (board[row][col].getCount() != 0)
			select(row,col);
	}
	/******************************************************************
	 * floodFillNonRecursiveHelper Method to help check the full range
	 * of cells marked as floodFilled if not then flood fill them.
	 * by calling floodFill method.
	 *
	 * @param row Integer passed for current row checking
	 * @param col Integer passed for current column checking
	 ******************************************************************/
	private boolean floodFillNonRecursiveHelper(int row, int col)
	{
		if (row < 0) return false;
		if (col < 0) return false;
		if (row > getCord_Y()-1) return false;
		if (col > getCord_X()-1) return false;

		if (board[row][col].isFlooded()){
			System.out.println("RETURNS First tis^flooded: false");
			return false;
		}

		if(board[row][col].isFlagged()) return false;
		if (board[row][col].getCount() != 0){
			if(board[row][col].isMine()){
				if(!hasMoved) {
					while (!floodFill(row, col)) {
						setEmpty();
						layMines(MINES);
						isCount(row,col);
					}
					hasMoved = true;
					if (board[row][col].isFlooded() && board[row][col].getCount() == 0) {
						System.out.println("RETURNS Second tis^flooded: false");
						return true;
					}
					else {
						System.out.println("RETURNS Second tis^flooded: true");
						return false;
					}
				}
				System.out.println("RETURNS after has-moved: false");
				return false;
			}
			else{
				select(row, col);
				hasMoved = true;
				return false;
			}
			//System.out.println("RETURNS after not-mine: false");
			//return false;
		}
		// valid, paint it
		floodFill(row,col);
		hasMoved = true;
		System.out.println("RETURNS after is zero: true");
		return true;
	}
	/******************************************************************
	 * floodFill helper Method to fill those cells not flooded yet with
	 * checking of cells marked as floodFilled. used by both the
	 * recursive and non-recursive methods.
	 *
	 * @param row Integer passed for current row checking
	 * @param col Integer passed for current column checking
	 ******************************************************************/
	public boolean floodFill(int row, int col) {
		boolean stat = false;
		if(board[row][col].isMine() && !hasMoved) {
			return false;
		}
		if(board[row][col].getCount() == 0 && !board[row][col].isFlagged()) {
			for (int r = row - 1; r <= row + 1; r++) {
				for (int c = col - 1; c <= col + 1; c++) {
					if (r >= 0 && r < getCord_Y() && c >= 0 &&
							c < getCord_X() && !board[r][c].isMine()) {
						isCount(r,c);
						System.out.println("This is At> row:"+r+" col:"+c+" count:"+board[r][c].getCount());
						select(r, c);
						stat = true;
					}
				}
			}
		}
		board[row][col].setFlooded(stat);
		return true;
	}
	/******************************************************************
	 * isCount method checks the count for each surrounding cell
	 *
	 * @param row int y-direction
	 * @param col int x-direction
	 ******************************************************************/
	public void isCount(int row, int col) {
		board[row][col].zeroCount();
		for (int r = row -1; r <= row +1; r++) {
			for (int c = col -1; c <= col +1; c++) {
				if (r >= 0 && r < getCord_Y() && c >= 0 &&
						c < getCord_X()){
					if(board[r][c].isMine()){
						board[row][col].inCount();
					}
				}
			}
		}
	}
	/******************************************************************
	 * getGameStatus helper method returns current game status.
	 *
	 * @return	GameStatus status This is the game status.
	 ******************************************************************/
	public GameStatus getGameStatus() {
		return status;
	}
	/******************************************************************
	 * reset method resets game to fresh state new game
	 *
	 ******************************************************************/
	public void reset() {

		status = GameStatus.NotOverYet;
		for (int r = 0; r < cord_Y; r++)
			for (int c = 0; c < cord_X; c++) {
				board[r][c].setExposed(false);
			}
		setEmpty();
		layMines (MINES);
	}
	/******************************************************************
	 * reset method resizes board then it calls reset method that
	 * resets game to fresh state new game
	 *
	 * @param size int This is the ROWS /and or/COL
	 * @param mines int This is the number of MINES
	 ******************************************************************/
	public void resize(int size, int mines) {
		MINES = mines;
		cord_X = size;
		cord_Y = size;
		reset();
	}
	/******************************************************************
	 * layMines method lays the mines down on the board randomly.
	 *
	 * @param mineCount int This is the Mine count for the game
	 ******************************************************************/
	private void layMines(int mineCount) {
		int i = 0;		// ensure all mines are set in place

		Random random = new Random();
		while (i < mineCount) {
			cord_X = MineSweeperPanel.getROWS();
			cord_Y = MineSweeperPanel.getCOLS();

			int c = random.nextInt(cord_Y);
			int r = random.nextInt(cord_X);

			if (!board[r][c].isMine()) {
				board[r][c].setMine(true);
				i++;
			}
		}
	}
}


