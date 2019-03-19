package RedBox;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**********************************************************************
 BluRay.java implements a BluRay unit having parameters such as title,
 customer name, as well as the date when it was purchased and the
 date when it is due.
 @author Jason Rupright
 @version 10/26/2018
 **********************************************************************/
//@XmlRootElement(name = "Game")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "BluRay")
//@XmlAccessorType(XmlAccessType.FIELD)
public class BluRay extends ISO implements Serializable {
    /**
     * Keeps a static version of the serial version ID for that compiled class
     */
    protected final long serialVersionUID = super.serialVersionUID;
    /**
     * The name of the BluRayEdition type from BluRayEdition class*
     */
    protected BluRayEdition bluRayEdition;
    /**
     * The name of the info type from Information class
     */
//    protected Info i;
    /**
     * The string info returned formatted from information class call
     */
    public String info = "ERR: BLANK BluRay 0";
    /**
     * The double daysLate returned.
     */
    protected double daysLate;
    /**
     * String form of bluRayEdition var
     */
    protected String doubleString;
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
        if(this.doubleString=="DirectorsCut" || this.doubleString=="Enhanced") {
            if (2 * this.cost > 100) {
                this.cost = 100;
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
     *getter method for BluRayEdition
     * @Return bluRayEdition type BluRayEdition
     ******************************************************************/
    @Override
    public BluRayEdition getBluRayEdition() {
        return this.bluRayEdition;
    }
    /******************************************************************
     *setter method for bluRayEdition
     * @Return void
     * @param bluRayEdition
     ******************************************************************/
	@Override
	public void setBluRayEdition(BluRayEdition bluRayEdition) {
		this.bluRayEdition = bluRayEdition;
		this.doubleString = bluRayEdition.toString();
	}
    /******************************************************************
     *setter method for Info
     * @Return void
     * @param bluRayEdition
     ******************************************************************/
    @Override
    public void setInfo(BluRayEdition bluRayEdition) {
        this.info = "ERR: BLANK GAME 2";
        Info i = new Info(bluRayEdition);
        if (i != null) {
            this.doubleString = bluRayEdition.toString();
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
    public BluRay() {
        super();
        System.out.println("Warn: No bluRayEdition: "+bluRayEdition);
    }
    /******************************************************************
     Constructs a BluRay given parameters
     @param rentedOn Date the rental was initially rented.
     @param dueBack Date that rental was expected back.
     @param title The Title of the Rental.
     @param name The User/Customer Name Type String.
     ******************************************************************/
    public BluRay(GregorianCalendar rentedOn, GregorianCalendar dueBack,
                String title, String name, BluRayEdition bluRayEdition) {
        super(rentedOn, dueBack, title, name);
        this.info = "ERR: BLANK GAME 1";
        //this.dvdEdition = null;
        this.bluRayEdition = bluRayEdition;
        Info i = new Info(bluRayEdition);
        if (i != null) {
            this.info = i.getInfo();
        } else
            throw new NullPointerException("Information var cannot be null in Game");
        this.doubleString = bluRayEdition.toString();
        //this.cost = this.setCost();
    }


}
