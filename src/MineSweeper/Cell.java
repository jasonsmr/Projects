package MineSweeper;

/**********************************************************************
 Cell.java holds information for each button on game board
 @author Jason Rupright
 @version 1/30/2019
 **********************************************************************/
public class Cell {
    /** store value of button exposure */
    private boolean isExposed;
    /** store value if button has a mine under*/
    private boolean isMine;
    /** store value of button count */
    private int count;
    /** store value of button flooded */
    private boolean flooded;
    /** store value of button flagged */
    private boolean flagged;

    /******************************************************************
     * isFlagged helper Method return boolean value of button flag
     *
     * @return boolean value of button flag status
     ******************************************************************/
    public boolean isFlagged() {
        return flagged;
    }
    /******************************************************************
     * toggleFlagged helper Method changes the flag status switches it
     ******************************************************************/
    public void toggleFlagged() {
        this.flagged ^= true;
    }
    /******************************************************************
     * isFlooded helper Method return boolean value of button flood
     *
     * @return boolean value of button flood status
     ******************************************************************/
    public boolean isFlooded() {
        return flooded;
    }
    /******************************************************************
     * setFlooded helper Method sets the current flooded status
     *
     * @param flooded boolean flooded the status passed
     ******************************************************************/
    public void setFlooded(boolean flooded) {
        this.flooded = flooded;
    }

    /******************************************************************
     * zeroCount helper Method zeros out current count value
     ******************************************************************/
    public void zeroCount() {
        this.count = 0;
    }
    /******************************************************************
     * getCount helper Method returns the current value of the count
     *
     * @return int count this is number current count
     ******************************************************************/
    public int getCount() {
        return count;
    }
    /******************************************************************
     * inCount helper Method increments the current count by value one
     ******************************************************************/
    public void inCount() {
        this.count++;
    }
    /******************************************************************
     * Cell default constructor creates cell with default variables
     *
     * @param exposed boolean is cell exposed
     * @param mine boolean is cell a mine
     ******************************************************************/
    public Cell(boolean exposed, boolean mine) {
        isExposed = exposed;
        isMine = mine;
    }
    /******************************************************************
     * isExposed helper Method return boolean true if cell is exposed
     *
     * @return boolean isExposed If cell is exposed
     ******************************************************************/
    public boolean isExposed() {
        return isExposed;
    }
    /******************************************************************
     * setExposed Method sets the current flooded status
     *
     * @param exposed boolean exposed the status passed
     ******************************************************************/
    public void setExposed(boolean exposed) {
        isExposed = exposed;
    }
    /******************************************************************
     * isMine helper Method return boolean true if cell is mine
     *
     * @return boolean isMine If cell is mine
     ******************************************************************/
    public boolean isMine() {
        return isMine;
    }
    /******************************************************************
     * setMine Method sets the current cell mine status
     *
     * @param mine boolean mine status for cell is passed
     ******************************************************************/
    public void setMine(boolean mine) {
        isMine = mine;
    }
}
