package MineSweeper;

/**********************************************************************
 MineSweeperGUI.java Creates topFrame topPanel called and added, also
 handles all menu item logic.
 @author Jason Rupright
 @version 01/30/2019
 **********************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MineSweeperGUI extends JFrame implements ActionListener{
	/** Declare panel type MineSweeperPanel */
	MineSweeperPanel panel;
	/** Holds menu bar */
	private JMenuBar menus;
	/** Menus in the menu bar */
	private JMenu gameMenu;
	/** Adds menu item new game to menu */
	private JMenuItem newGameItemMenu;
	/** Adds menu item marks to menu */
	private JCheckBoxMenuItem marksMenuItem;
	/** Adds menu item exit game to menu */
	private JMenuItem exitGameItemMenu;


	/******************************************************************
	 * main class calls MineSweeperGUI to run
	 ******************************************************************/
	public static void main (String[] args){new MineSweeperGUI();}

	/******************************************************************
	 * MineSweeperGUI class default constructor Instantiates all
	 * default values.
	 ******************************************************************/
	private MineSweeperGUI(){
		//instantiate the selector for menus
		menus = new JMenuBar();
		//instantiate the main menu selection(s) named game
		gameMenu = new JMenu("Game");
		//instantiate the JMenu item new game
		newGameItemMenu = new JMenuItem("New" +
				"                      F2");
		//instantiate the JMenu item marks
		marksMenuItem = new JCheckBoxMenuItem("Marks [?]");
		//instantiate the JMenu item exit
		exitGameItemMenu = new JMenuItem("Exit");


		/** adding menu items */
		gameMenu.add(newGameItemMenu);
		gameMenu.add(marksMenuItem);
		gameMenu.add(exitGameItemMenu);
		menus.add(gameMenu);
		newGameItemMenu.addActionListener(this);
		marksMenuItem.addActionListener(this);
		exitGameItemMenu.addActionListener(this);
		marksMenuItem.setState(false);
		setJMenuBar(menus);
		//default is to close game
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//my minesweeper title
		setTitle("MineSweeper");
		JFrame topFrame = (JFrame) SwingUtilities.
				getWindowAncestor(this);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				titleAlign(topFrame);
			}

		});
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		panel = new MineSweeperPanel();
		panel.setDifficulty(Difficulty.Beginner);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		//setSize(16*panel.getCOLS(),24+16*panel.getROWS());
		setSize(20*panel.getCOLS()+64, 20
				*panel.getROWS()+128);

	}
	/********************************************************************
	 * Method to create a center aligned text title for topframe JFrame
	 * Found at StackOverflow (the website)
	 * Posted by: Articuno L
	 * On: Sep, 14, 2017
	 * Found at: 'https://stackoverflow.com/questions/9662393/
	 * how-to-center-align-the-title-in-a-jframe'
	 * @param frame JFrame This is passed to set title.
	 *******************************************************************/
	private void titleAlign(JFrame frame) {
		Font font = getFont();
		String currentTitle = getTitle().trim();
		FontMetrics fm = getFontMetrics(font);
		int frameWidth = getWidth();
		int titleWidth = fm.stringWidth(currentTitle);
		int spaceWidth = fm.stringWidth(" ");
		int centerPos = (frameWidth / 2) - (titleWidth / 2);
		int spaceCount = centerPos / spaceWidth;
		String pad = "";
		pad = String.format("%" + (spaceCount - 14) + "s", pad);
		setTitle(pad + currentTitle);
	}
	/******************************************************************
	 * actionPerformed method ActionEvent listener for the GUI menus
	 * This also produces clean checked game options from user inputs.
	 * @param e ActionEvent This action event
	 ******************************************************************/
	public void actionPerformed(ActionEvent e) {
		int sizeN = 10;
		int minesN = 10;
		if(	e.getSource() == newGameItemMenu) {
			String size = JOptionPane.showInputDialog("" +
					"Please Input desired board size, between " +
					"3 and 30: ");
			String mines = JOptionPane.showInputDialog("" +
					"Please Input desired number of Mines" +
					"(Default 10): ");

			boolean caught = false;
			if (!("".equals(size)) && !("".equals(mines))) {
				try{
					sizeN = Integer.parseInt(size);
					minesN = Integer.parseInt(mines);
					if (sizeN < 3 ||
							minesN < 1) {
						JOptionPane.showMessageDialog(
								null,
								"Invalid size too small.\n" +
										"Or not a number!\n" +
										"Setting to Default size " +
										"(10 x 10).\n" +
										"Setting to Default mines ( 10).");
						sizeN = 10;
						minesN = 10;
						panel.resizeBoard(sizeN, minesN);
					}
					else if (sizeN > 30 || minesN > sizeN*sizeN) {
						JOptionPane.showMessageDialog(
								null,
								"Invalid size too large\n" +
										"Or not a number!\n" +
										"Setting to Default 10 x 10");
						sizeN = 10;
						minesN = 10;
						panel.resizeBoard(sizeN, minesN);
					}
				}catch (NumberFormatException num) {
					System.out.println(
							"Remember to fix in game class too!\n" +
									"Just in case panel is broken " +
									"too.\n"+num.getMessage());
					caught = true;
				}
				if(caught == false)
					panel.resizeBoard(Integer.parseInt(size),
							Integer.parseInt(mines));
				else{
					JOptionPane.showMessageDialog(
							null, "Invalid " +
									"size not a number setting to " +
									"Default 10 x 10");
					sizeN = 10;
					minesN = 10;
					panel.resizeBoard(sizeN, minesN);
				}
			}else {
				JOptionPane.showMessageDialog(
						null, "Invalid size "+
								" 'null' setting to Default 10 x 10");
				sizeN = 10;
				minesN = 10;
				panel.resizeBoard(sizeN, minesN);
			}

			if(sizeN > 6)
				setSize(20*panel.getCOLS()+64,
					20*panel.getROWS()+128);
			panel.repaint();
		}
		//MenuBar options
		if (e.getSource() == exitGameItemMenu) {
			System.exit(1);
		}

		if (marksMenuItem.isSelected()) {
			panel.setMarksVisible(true);
			panel.displayBoardCenter();
		}
		else {
			panel.setMarksVisible(false);
			panel.displayBoardCenter();
		}

	}
}

