package MineSweeper;

/**********************************************************************
 MineSweeperPanel.java Creates background panel and game board panel
 button and all containers. It also displays ordered game data WINS,
 LOSSES, TIME COUNTER, NUMBER MINES LEFT. There is a Reset button
 @author Jason Rupright
 @version 01/30/2019
 **********************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class MineSweeperPanel extends JPanel {
	/** adding jpanel item background */
	private JPanel background;
	/** adding menu itemContainer for val time */
	private JPanel numTimeContainer;
	/** adding jpanel itemContainer for val mines */
	private JPanel numMinesContainer;
	/** adding jpanel itemContainer for val won */
	private JPanel numWinsContainer;
	/** adding jpanel itemContainer for val loss */
	private JPanel numLossesContainer;
	/** adding jpanel item for top of board */
	private JPanel top;
	/** adding jpanel item for center of board */
	private JPanel center;
	/** adding jlabel item for value of mines left */
	private JLabel numMines = new JLabel();
	/** adding jlabel item for value of time left */
	private JLabel numTime = new JLabel();
	/** adding jlabel item for value of games won */
	private JLabel numWins = new JLabel();
	/** adding jlabel item for value of games lost */
	private JLabel numLosses = new JLabel();
	/** adding jlabel item for numb mines left */
	private JLabel numMinesLabel = new JLabel();
	/** adding jlabel itemLabel for time */
	private JLabel numTimeLabel = new JLabel();
	/** adding jlabel itemLabel for games won */
	private JLabel numWinsLabel = new JLabel();
	/** adding jlabel itemLabel for games lost */
	private JLabel numLossesLabel = new JLabel();
	/** adding jbutton item Array for board */
	private JButton[][] board;
	/** adding jbutton item reset button */
	private JButton reset;
	/** adding Cell item iCell holds button data */
	private Cell iCell;
	/** holds value for ROWS in board display*/
	private static int ROWS = 10;
	/** holds value for COLS in board display*/
	private static int COLS = 10;
	/** holds value for MINES in board display*/
	private static int MINES = 10;
	/** holds value for COUNT in board display*/
	private static int COUNT = 0;
	/** holds value for WINS in board display*/
	private static int WINS = 0;
	/** holds value for LOSSES in board display*/
	private static int LOSSES = 0;

	/** WIP holds values for ROWS, COLS, and MINES in one Array */
	private static int[] CONSTRAINTS = {ROWS, COLS, MINES};
	/** WIP instantiates default value for game difficulty setting */
	private Difficulty difficulty = Difficulty.Beginner;
	/** MouseListener for Flaggs */
	private FlagListener fListener = new FlagListener();
	/** Minesweeper game model */
	private MineSweeperGame game;
	/** holds boolean value for game menu marks*/
	private boolean marksVisible;
	/** holds boolean value for switched event of
	 * first button click that starts game timer*/
	private boolean onSwitch;
	/** creates Timer class defined at bottom
	 * of MineSweeperPanel class*/
	private Timer timer;
	/** USED and holds value for number of mines
	 *  left to go for math */
	private int leftToGo;
	/** holds value for number of games played total */
	private long gamesCounter = 0;
	/** holds value for buttonSize for auto resize */
	private int buttonSize = 16;
	/** holds value for textHeight for auto resize */
	private int textHeight = 24;
	/** holds value for textWidth for auto resize */
	private int textWidth = 16;
	/** holds value for bufferSize for auto resize */
	private int bufferSize = 20;

	/******************************************************************
	 * MineSweeperPanel class default constructor Instantiates all
	 * default values.
	 ******************************************************************/
	public MineSweeperPanel() {
		MINES = 10;
		ROWS = 10;
		COLS = 10;
		COUNT = 0;
		timer = new Timer();
		background = new JPanel();
		top = new JPanel();
		numMinesContainer = new JPanel();
		numWinsContainer = new JPanel();
		numLossesContainer = new JPanel();
		reset = new JButton("");
		numTimeContainer = new JPanel();
		center = new JPanel();

		drawBoard();
		gamesCounter++;
	}
	/******************************************************************
	 * IncCounter Method is a helper method that increases the static
	 * variable COUNT, for use by the JLabels. Called by internal
	 * private Task class.
	 ******************************************************************/
	private void IncCounter() {
		COUNT++;
	}
	/******************************************************************
	 * drawBoard Method draws everything, buttons and JLabel related.
	 * It sets the default sizes and Layouts called by default
	 * constructor.
	 ******************************************************************/
	private void drawBoard() {
		//create master background container holds everything except
		// possible future boarders around frame.
		background.setLayout(new BorderLayout());
		background.setSize(buttonSize * COLS + 2 * bufferSize,
				buttonSize * ROWS + textHeight + 2 * buttonSize
						+ 2 * bufferSize);
		//holds all numbers or sprites tracking numerical data and
		// labels on games won.
		numWinsContainer.setLayout(new GridLayout(1, 9));
		//holds all numbers or sprites tracking numerical data and
		// labels on mines left.
		numMinesContainer.setLayout(new GridLayout(1, 9));
		//holds all numbers or sprites tracking numerical data and
		// labels on time since game started.
		numTimeContainer.setLayout(new GridLayout(1, 9));
		//holds all numbers or sprites tracking numerical data and
		// labels on games lost.
		numLossesContainer.setLayout(new GridLayout(1, 9));
		//set size of reset button twice a high as buttons
		reset.setPreferredSize(new Dimension(textHeight, textHeight));
		//sets all info about size of the top frame container.
		top.setSize(new Dimension(buttonSize * COLS + 2 *
				bufferSize, textHeight + 2 * buttonSize));
		//track losses in field.
		numLossesLabel = new JLabel("L:");
		numLossesLabel.setPreferredSize(new Dimension(textWidth,
				textHeight));
		numLosses = new JLabel(LOSSES+"");
		numLosses.setPreferredSize(new Dimension(textWidth,
				textHeight));
		//track downed mines in field.
		numMinesLabel = new JLabel("M:");
		numMinesLabel.setPreferredSize(new Dimension(textWidth,
				textHeight));
		numMines = new JLabel(MINES+"");
		numMines.setPreferredSize(new Dimension(textWidth,
				textHeight));
		//track time passed.
		numTimeLabel = new JLabel("T:");
		numTimeLabel.setPreferredSize(new Dimension(textWidth,
				textHeight));
		numTime = new JLabel(COUNT+"");
		numTime.setPreferredSize(new Dimension(textWidth,
				textHeight));
		//track number of games won.
		numWinsLabel = new JLabel("W:");
		numWinsLabel.setPreferredSize(new Dimension(textWidth,
				textHeight));
		numWins = new JLabel(WINS+"");
		numWins.setPreferredSize(new Dimension(textWidth,
				textHeight));
		//adds all the labels and numerical data just configured.
		numLossesContainer.add(numLossesLabel);
		numLossesContainer.add(numLosses);

		numMinesContainer.add(numMinesLabel);
		numMinesContainer.add(numMines);

		numTimeContainer.add(numTimeLabel);
		numTimeContainer.add(numTime);

		numWinsContainer.add(numWinsLabel);
		numWinsContainer.add(numWins);

		top.add(numLossesContainer, BorderLayout.WEST);

		top.add(numMinesContainer, BorderLayout.WEST);

		top.add(reset, BorderLayout.CENTER);

		top.add(numTimeContainer, BorderLayout.EAST);

		top.add(numWinsContainer, BorderLayout.EAST);

		reset.addMouseListener(fListener);


		game = new MineSweeperGame(getROWS(), getMINES());

		// create the board add all panels to background
		center.setLayout(new GridLayout(ROWS, COLS));
		board = new JButton[ROWS][COLS];
		background.add(top, BorderLayout.PAGE_START);
		for (int row = 0; row < getROWS(); row++)
			for (int col = 0; col < getCOLS(); col++) {
				board[row][col] = new JButton("");
				board[row][col].setMargin(new Insets(0,
						0, 0, 0));
				board[row][col].setPreferredSize(new
						Dimension(buttonSize, buttonSize));
				board[row][col].addMouseListener(fListener);
				center.add(board[row][col]);

			}
		center.setPreferredSize(new Dimension(ROWS * buttonSize
				+ bufferSize, COLS * buttonSize + bufferSize));

		background.add(center, BorderLayout.CENTER);

		displayBoardCenter();

		// add all to contentPane
		add(background);
		System.out.println("Game Size - (width x height): " + getCOLS()
				+ " x " + getROWS());
	}
	/******************************************************************
	 * isMarksVisible Method boolean returns true if marks is selected.
	 *
	 * @return boolean marksVisible is if show flags (marks) selected
	 ******************************************************************/
	public boolean isMarksVisible() {
		return marksVisible;
	}
	/******************************************************************
	 * setMarksVisible Method sets boolean value marksVisible.
	 *
	 * @param marksVisible boolean tells us if menu item is selected.
	 ******************************************************************/
	public void setMarksVisible(boolean marksVisible) {
		this.marksVisible = marksVisible;
	}
	/******************************************************************
	 * getROWS Method getter method for ROWS
	 *
	 * @return int ROWS is number of ROWS
	 ******************************************************************/
	public static int getROWS() {
		return ROWS;
	}
	/******************************************************************
	 * getCOLS Method getter method for COLS
	 *
	 * @return int COLS is number of COLS
	 ******************************************************************/
	public static int getCOLS() {
		return COLS;
	}
	/******************************************************************
	 * getMINES Method getter method for MINES
	 *
	 * @return int MINES is number of MINES
	 ******************************************************************/
	public static int getMINES() {
		return MINES;
	}
	/******************************************************************
	 * checkFlaggs Method checks the number buttons flagged in board.
	 *
	 * @return int marksFlags is number of cells in board with flag.
	 ******************************************************************/
	private int checkFlaggs() {
		int marksFlags = 0;
		for (int r = 0; r < getROWS(); r++)
			for (int c = 0; c < getCOLS(); c++) {
				iCell = game.getCell(r, c);
				if (iCell.isFlagged())
					marksFlags++;
			}
		return marksFlags;
	}

	/******************************************************************
	 * displayBoardCenter Method its a drawBoard helper method.
	 * Everything for drawing and checking board cells in board.
	 * Also used when preforming a reset after game won or loss.
	 *
	 ******************************************************************/
	public void displayBoardCenter() {
		for (int r = 0; r < getROWS(); r++)
			for (int c = 0; c < getCOLS(); c++) {
				iCell = game.getCell(r, c);
				board[r][c].setText("");
				game.isCount(r, c);

				if (iCell.isExposed()) {

					if (iCell.isMine()) {
						board[r][c].setText("*");
						board[r][c].setBackground(new Color(
								88, 6, 16, 255));
					} else {
						board[r][c].setText(iCell.getCount() + "");
						board[r][c].setBackground(new Color(
								2, 88, 18, 255));
					}
				} else {
					if (iCell.isMine()) {
						if (isMarksVisible()) {
							board[r][c].setText("!");
							board[r][c].setBackground(new Color(
									128, 128, 90, 255));
							revalidate();
							repaint();
						} else {
							board[r][c].setBackground(new Color(
									128, 128, 90, 255));
						}
					} else board[r][c].setBackground(new Color(
							128, 128, 90, 255));
					if (iCell.isFlagged() && !iCell.isExposed()) {
						board[r][c].setText("fl");
						board[r][c].setBackground(new Color(
								128, 72, 2, 255));
					}
				}


			}
	}
//	public MineSweeperPanel() {
//		MINES = 10;
//		ROWS = 10;
//		COLS = 10;
//		COUNT = 0;
//		timer = new Timer();
//		background = new JPanel();
//		top = new JPanel();
//		numMinesContainer = new JPanel();
//		numWinsContainer = new JPanel();
//		numLossesContainer = new JPanel();
//		reset = new JButton("");
//		numTimeContainer = new JPanel();
//		center = new JPanel();
//
//		drawBoard();
//		gamesCounter++;
//	}
	/******************************************************************
	 * reset Method is a method to assist in resetting the game.
	 * removes everything then returns everything to default values.
	 ******************************************************************/
	public void reset() {
		this.removeAll();
		background = new JPanel();
		top = new JPanel();
		numMinesContainer = new JPanel();
		reset = new JButton("");
		numTimeContainer = new JPanel();
		numLossesContainer = new JPanel();
		numWinsContainer = new JPanel();
		center = new JPanel();
		revalidate();
		repaint();
		//These are here just in case we want to reset wins and losses.
		//WINS = 0;
		//LOSSES = 0;
		drawBoard();
		resetTimer();
		System.out.println("BOARD SIZE>> ROWS x COLS x MINES x " +
				"NumGAMES: " + ROWS + " x " + COLS
				+ " x " + MINES + " x " + gamesCounter);
		gamesCounter++;
		//reset mines after win or loss in reset because we
		// want to view how many mines to start.
		numMines.setText(MINES - checkFlaggs() + "");
	}
	/******************************************************************
	 * resizeBoard Method assists ing resizing the board and then
	 * calls the reset method.
	 * @param size int Takes the square board size.
	 * @param mines int Takes the number of mines.
	 ******************************************************************/
	public void resizeBoard(int size, int mines) {
		if (size < 3 || size > 30 ) {
			JOptionPane.showMessageDialog(
					null,
					"Board size value must be between: " +
							"(3- 30).");
		if (mines < 1 || mines > (size*size-1))
			JOptionPane.showMessageDialog(
					null,"For Board size of: "+
							""+size+"\nMine values must be between: "+
							" 1- "+(size*size));
		} else {
			this.removeAll();
			MINES = mines;
			ROWS = size;
			COLS = size;
			reset();
		}
	}
	/******************************************************************
	 * getDifficulty Method this gets the current game difficulty.
	 * @return difficulty type Difficulty for passing to array of
	 * possibilities. (NOTE NOT IMPLEMENTED YET)
	 *
	 ******************************************************************/
	public Difficulty getDifficulty() {
		return difficulty;
	}
	/******************************************************************
	 * setDifficulty Method this sets the difficulty setting and in so
	 * doing the board size changes accordingly.
	 * @param difficulty Difficulty var for passing to array of
	 * possibilities. (NOTE NOT IMPLEMENTED YET)
	 ******************************************************************/
	public void setDifficulty(Difficulty difficulty) {
		for (int i = 0; i < 3; i++) {
			CONSTRAINTS[i] = difficulty.test()[i];
		}
		this.difficulty = difficulty;
	}
	/******************************************************************
	 * FlagListener class MouseListener for the panel board This
	 * allows the panel class to update button colors and mine count.
	 *
	 ******************************************************************/
	private class FlagListener implements MouseListener {
		/******************************************************************
		 * mousePressed method listens for MouseEvent tells if mouse
		 * button depressed but not yet released.
		 *
		 * @param me MouseEvent
		 ******************************************************************/
		public void mousePressed(MouseEvent me) {
		}
		/******************************************************************
		 * mouseReleased method listens for MouseEvent if mouse released
		 *
		 * @param me MouseEvent
		 ******************************************************************/
		public void mouseReleased(MouseEvent me) {
		}
		/******************************************************************
		 * mouseEntered method listens for MouseEvent if mouse entered area
		 * of interest (mouse hovered)
		 * @param me MouseEvent
		 ******************************************************************/
		public void mouseEntered(MouseEvent me) {
		}
		/******************************************************************
		 * mouseExited method listens for MouseEvent is mouse exited area
		 * of interest (mouse stopped hovering)
		 * @param me MouseEvent
		 ******************************************************************/
		public void mouseExited(MouseEvent me) {
		}
		/******************************************************************
		 * mouseClicked method listens for MouseEvent if mouse pressed
		 * and released and is still over same area counts as a click.
		 * @param me MouseEvent
		 ******************************************************************/
		public void mouseClicked(MouseEvent me) {
			//checks status of all buttons and tracks mines
			for (int r = 0; r < getROWS(); r++) {
				for (int c = 0; c < getCOLS(); c++) {
					iCell = game.getCell(r, c);
					if (board[r][c] == me.getSource() && me.getButton()
							== MouseEvent.BUTTON1) {
						numTime.setText( (COUNT) + "");
						startTimer();
						onSwitch = true;
						leftToGo = (getROWS() * getCOLS() - getMINES())
								- game.getNumButtonActive();
						//game.floodFind(r, c);
						game.floodFindNonRecursive(r, c);

						numMines.setText((MINES - checkFlaggs()) + "");
					}
					//checks if right mouse button is clicked
					if (board[r][c] == me.getSource() && me.getButton()
							== MouseEvent.BUTTON3 && !iCell.isExposed()) {

						numTime.setText( (COUNT) + "");
						startTimer();
						onSwitch = true;
						iCell.toggleFlagged();
						numMines.setText(MINES - checkFlaggs() + "");
					}
				}
			}

			displayBoardCenter();

			//checks if game needs a reset
			if (me.getSource() == reset) {
				reset();
			}
			//checks if game is lost
			if (game.getGameStatus() == GameStatus.Lost) {
				JOptionPane dialog = new JOptionPane();
				dialog.showMessageDialog(
						null,
						"You Lose \n The game will reset");
				LOSSES++;
				numLosses.setText( (LOSSES) + "");
				reset();
				displayBoardCenter();

			}
			//checks if game is won
			if (game.getGameStatus() == GameStatus.Won) {
				JOptionPane.showMessageDialog(
						null,
						"You Win: all mines have been found!"+
								"\n The game will reset");
				WINS++;
				numWins.setText( (WINS) + "");
				reset();
				displayBoardCenter();
			}

		}

	}
	/******************************************************************
	 * resetTimer method that resets the timer COUNT to zero.
	 * This also instantiates a fresh new timer.
	 *
	 * @throws Exception if timer does not exist when it trys to cancel
	 ******************************************************************/
	private void resetTimer(){
		onSwitch = false;
		COUNT = 0;
		numTime.setText( (COUNT) + "");
		try {
			timer.cancel();
			timer = new Timer();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/******************************************************************
	 * startTimer method that starts the timer COUNT from zero.
	 * This initializes the Timer subclass to start with a 1-sec delay.
	 *
	 * @throws Exception caught for now until testing confirms print.
	 ******************************************************************/
	private void startTimer(){
		if(onSwitch != true) {
			try {
				timer.schedule(new Task(), 0, 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/******************************************************************
	 * Task subclass is a class that starts the timer COUNT from zero.
	 * This initializes the TimerTask to run the IncCounter() method
	 * this is controlled by the startTimer method.
	 *
	 ******************************************************************/
	private class Task extends TimerTask {
		// run is a abstract method that defines task performed
		// at scheduled time.
		public void run() {
			IncCounter();
			numTime.setText( (COUNT) + "");
		}
	}
}



