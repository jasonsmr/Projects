package RedBox;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**********************************************************************
 Game.java implements a Game unit having parameters such as title,
 customer name, as well as the date when it was purchased and the
 date when it is due.
 @author Jason Rupright
 @version 10/26/2018
 **********************************************************************/
//@XmlRootElement(name = "Game")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "Game")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Game extends ISO implements Serializable {
	/**
	 * Keeps a static version of the serial version ID for that compiled class
	 */
	protected final long serialVersionUID = super.serialVersionUID;
	/**
	 * The name of the player type from PlayerType class*
	 */
	protected PlayerType player;
	/**
	 * The name of the player type from PlayerType class
	 */
//	protected Info i;
	/**
	 * The string info returned formated from information class call
	 */
	public String info = "ERR: BLANK GAME 0";
	/**
	 * The double daysLate returned.
	 */
	protected double daysLate;
	/**
	 * String form of player var
	 */
	protected String playString;
	/**
	 * var to store double cost var
	 */
	protected double cost;


	/******************************************************************
	 * Experimental Overridden unit to setCost using the DVD type class
	 *
	 ******************************************************************/
	@Override
	public double setCost(GregorianCalendar returnDate) {
		this.cost = super.setCost(returnDate);
		if (this.playString == "PC") {
			if (2 * this.cost > 100) {
				this.cost = 100.00;
			} else {
				this.cost = 2 * this.cost;
			}
		}
		return this.cost;
	}
	/******************************************************************
	 *getter method for cost
	 * @return double cost
	 ******************************************************************/
	@Override
	public double getCost() {
		return this.cost;
	}
	/******************************************************************
	 *getter method for playertype
	 * @Return Playertype
	 ******************************************************************/
	@Override
	public PlayerType getPlayer() {
		return this.player;
	}
	/******************************************************************
	 *setter method for playertype
	 * @Return void
	 * @param player
	 ******************************************************************/
	@Override
	public void setPlayer(PlayerType player) {
		this.player = player;
		this.playString = player.toString();
	}
	/******************************************************************
	 *setter method for Info
	 * @Return void
	 * @param player
	 ******************************************************************/
	@Override
	public void setInfo(PlayerType player) {
		this.info = "ERR: BLANK GAME 2";

		Info i = new Info(player);
		if (i != null) {
			this.playString = player.toString();
			this.info = i.getInfo();
		} else
			throw new NullPointerException("Information var cannot be null in Game");
	}
	/******************************************************************
	 *getter method for Info
	 * @Return String
	 ******************************************************************/

	@Override
	//@XmlElement(name = "info")
	public String getInfo() {
		System.out.println("Currently Info: "+this.info);
		return this.info;
	}
	/******************************************************************
	 *Game Class default constructor
	 *
	 ******************************************************************/
	public Game() {
		super();
		System.out.println("Warn: No player: "+player);
	}
	/******************************************************************
	 Constructs a Game given parameters
	 @param rentedOn Date the rental was initially rented.
	 @param dueBack Date that rental was expected back.
	 @param title The Title of the Rental.
	 @param name The User/Customer Name Type String.
	 ******************************************************************/
	public Game(GregorianCalendar rentedOn, GregorianCalendar dueBack,
			String title, String name, PlayerType player) {
		super(rentedOn, dueBack, title, name);
		this.info = "ERR: BLANK GAME 1";
		this.player = player;
		Info i = new Info(player);
		if (i != null) {
			this.info = i.getInfo();
		} else
			throw new NullPointerException("Information var cannot be null in Game");
		this.playString = player.toString();
		//this.cost = this.setCost();
	}
	/******************************************************************
	 Constructs a Game using Extra Player Type
	 @param player
	 ******************************************************************/
//	public Game(PlayerType player) {
//		super();
//		//this.player = player;
//		//this.playString = player.toString();
//	}

}
