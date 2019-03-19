package RedBox;

import javax.swing.*;
import static java.util.Comparator.comparing;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.concurrent.TimeUnit;


/**********************************************************************
 ISO.java implements a ISO unit having parameters such as title,
 customer name, as well as the date when it was purchased and the
 date when it is due.
 @author Jason Rupright
 @version 10/26/2018
 **********************************************************************/
//@XmlRootElement(name = "ISO")
//@XmlAccessorType(XmlAccessType.FIELD)

//@XmlSeeAlso({DVD.class, Game.class, BluRay.class})
public class ISO implements Serializable, Comparable<ISO>{
    /**
     * Keeps a static version of the serial version ID for that compiled class
     */
    protected static final long serialVersionUID = 1L;
    /**
     * The date the DISK was rented
     */
    protected GregorianCalendar rentedOn;
    /**
     * The date the DISK is due back
     */
    protected GregorianCalendar dueBack;
    /**
     * The date the DISK is due back
     */
//    protected GregorianCalendar returnDate;
//    /**
//     * The title of the DISK
//     */
    protected String title;
    /**
     * The name of the person who is renting the DISK
     */
    protected String nameOfRenter;
    /**
     * The name of the DISK type from Info class
     */
//    protected Info i;
    /**
     * The string info returned formated from info class call
     */
    protected String info = "ERR: BLANK ISO 0";
    /**
     * The name of the PlayerType type from PlayerType class
     */
    protected double daysLate;
    /**
     * The name of the PlayerType type from PlayerType class
     */
    private PlayerType player;
    /**
     * The status of bluRayEdition for BluRay class
     */
    private BluRayEdition bluRayEdition;
    /**
     * The status of dvdEdition for BluRay class
     */
    private DVDEdition dvdEdition;
    /**
     * String form of bluRayEdition var
     */
    protected String doubleString;
    /**
     * The double cost stored.
     */
    protected double cost;

    //
//    private long diffInMillies;
//



    /******************************************************************
     Constructs a blank DISK
     ******************************************************************/
    public ISO() {
        System.out.println("Warn: No DISK Information");
    }

    /******************************************************************
     Constructs a ISO class given each of the disk's parameters
     @throws NullPointerException
     @param rentedOn Date the rental was initially rented.
     @param dueBack Date that rental was expected back.
     @param title The Title of the Rental.
     @param name The User/Customer Name Type String.
     ******************************************************************/
    public ISO(GregorianCalendar rentedOn, GregorianCalendar dueBack, String title, String name) {
        super();

        this.rentedOn = rentedOn;
        this.dueBack = dueBack;
        this.title = title;
        this.nameOfRenter = name;
        this.player = null;
        this.bluRayEdition = null;
        this.dvdEdition = null;
        this.info = "ERR: BLANK ISO 1";
        Info i = new Info();
        if (i != null) {
            this.info = i.getInfo();
        } else
            throw new NullPointerException("Information var cannot be null in ISO");
        //this.cost = setCost();
    }
    public double getDaysLate(GregorianCalendar returnDate){
        Date today = Calendar.getInstance().getTime();
        long diffInMillies = (today.getTime() - returnDate.getTime().getTime());
        this.daysLate = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return this.daysLate;
    }
    /******************************************************************
     *getter method getRentedOn
     * @return rentedOn GregorianCalendar Date
     ******************************************************************/
    public GregorianCalendar getRentedOn() {
        return this.rentedOn;
    }
    /******************************************************************
     *setter method getRentedOn
     * @param opened GregorianCalendar Date
     ******************************************************************/
    public void setRentedOn(GregorianCalendar opened) {
        this.rentedOn = opened;
    }

    /******************************************************************
     getter method getDueBack
     @return dueBack GregorianCalendar Date on which the DISK is due
     ******************************************************************/
    public GregorianCalendar getDueBack() {
        return dueBack;
    }
    /******************************************************************
     *setter method setDueBack
     * @param  dueBack GregorianCalender Date the Rental is due back
     * @returns void
     ******************************************************************/
    public void setDueBack(GregorianCalendar dueBack) {
        this.dueBack = dueBack;
    }
    /******************************************************************
     *getter method for title
     * @return title String
     ******************************************************************/
    public String getTitle() {
        return title;
    }
    /******************************************************************
     *setter method for Title
     * @param title String states Rental title name
     ******************************************************************/
    public void setTitle(String title) {
        this.title = title;
    }
    /******************************************************************
     *getter method for userName
     * @return nameOfRenter String
     ******************************************************************/
    public String getNameOfRenter() {
        return nameOfRenter;
    }
    /******************************************************************
     *getter method for setting userName/renterName
     * @returns void
     * @param nameOfRenter String val sets username/Customer name.
     ******************************************************************/
    public void setNameOfRenter(String nameOfRenter) {
        this.nameOfRenter = nameOfRenter;
    }
    /******************************************************************
     *setter method for Info
     * @returns void
     * @param player PlayerType class var passed to set this type value
     ******************************************************************/
    public void setInfo(PlayerType player) {
        this.info = "I AM IN ISO NOT GAME";
        System.out.println("PlayerType Was Passed to Game as: " +player + "\nAlso, current Information: " +info);
    }
    /******************************************************************
     * setter method for Info
     * @returns void
     * @param bluRayEdition BluRayEdition type
     ******************************************************************/
    public void setInfo(BluRayEdition bluRayEdition) {
        this.info = "I AM IN DVD, NOT BLURAY";
        System.out.println("bluRayEdition Was Passed to BluRay as: " +bluRayEdition + "\nAlso, current Information: " +info);
    }
    /******************************************************************
     * setter method for Info
     * @returns void
     ******************************************************************/
    public void setInfo(DVDEdition dvdEdition) {
        this.info = "I AM IN ISO, NOT DVD";
        System.out.println("dvdEdition Was Passed to DVD as: " +dvdEdition + "\nAlso, current Information: " +info);
    }
    /******************************************************************
     *getter method for Info
     * @return info String
     ******************************************************************/
    //@XmlAttribute(name = "info")
    public String getInfo() {
        System.out.println("Currently info: "+this.info);
        return this.info;
    }
    /******************************************************************
     *getter method for PlayerType
     * @return player PlayerType
     ******************************************************************/
    public PlayerType getPlayer() {
        return player;
    }
    /******************************************************************
     *setter method for player
     * @returns void
     * @param player
     ******************************************************************/
    public void setPlayer(PlayerType player) {
        this.player = null;
    }
    /******************************************************************
     *getter method for bluRayEdition
     * @return bluRayEdition Enum type BlueRayEDITION.class
     ******************************************************************/
    public BluRayEdition getBluRayEdition() {
        return bluRayEdition;
    }
    /******************************************************************
     *setter method for bluRayEdition
     * @param bluRayEdition Enum value default null
     ******************************************************************/
    public void setBluRayEdition(BluRayEdition bluRayEdition) {
        this.bluRayEdition = null;
    }
    /******************************************************************
     *getter method for DVDEdition
     * @Return dvdEdition type DVDEdition
     ******************************************************************/
    public DVDEdition getDVDEdition() {
        return dvdEdition;
    }
    /******************************************************************
     *setter method for dvdEdition
     * @param dvdEdition Enum type DVDEdition.class
     ******************************************************************/
    public void setDVDEdition(DVDEdition dvdEdition) {
        this.dvdEdition = null;
    }

    /******************************************************************
     Returns whether or not the DVD is a Game
     @return If the DVD is a game (false)
     ******************************************************************/
    public boolean isGame() {
        return false;
    }
    /******************************************************************
     Experimental unit to setCost using the DVD type class
     ******************************************************************/
    public double setCost(GregorianCalendar returnDate) {
        this.cost = 3.00;
        Calendar cal = returnDate;
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        date = cal.getTime();

        System.out.println("Return Date: "+dateFormat.format(date));


        long diffInMillies = (returnDate.getTime().getTime() - this.rentedOn.getTime().getTime());
        this.daysLate = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        double cost = 0.00;
        if (daysLate < 0) {

            JOptionPane.showConfirmDialog(null, "Err: Bad Return Date: \nCannot occur before rental date!", JOptionPane.MESSAGE_PROPERTY, JOptionPane.PLAIN_MESSAGE);
        }

        if (daysLate == 1 || daysLate == 0) {
            System.out.println("DVD Class cost0: " + cost);
            this.cost = 3.00;
        }
        if (daysLate > 1) {
            if (daysLate > 50) {
                this.cost = 50.00;
                System.out.println("DVD Class cost1: " + cost);
            } else {
                System.out.println("DVD Class cost2: " + cost);
                this.cost = cost + daysLate;
            }
        }

        return this.cost;
    }
    /******************************************************************
     * getter method for cost
     * @return cost var type: double
     ******************************************************************/
    public double getCost() {
        return this.cost;
    }
    /******************************************************************
     * getter method for serialVersionUID
     * @Return serialVersionUID var type long
     ******************************************************************/
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /******************************************************************
     CompareTo method for the date due, used in sorting the ArrayList
     @param disk
     @return result of the comparison of the dates of two objects
     ******************************************************************/
    public int compareTo(ISO disk) {
        return dueBack.compareTo(disk.getDueBack());
    }
}