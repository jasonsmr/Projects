package MineSweeper;

/**********************************************************************
 GameStatus.java simply hold emun data on game status for game
 @author Jason Rupright
 @version 1/30/2019
 **********************************************************************/

public enum GameStatus {
    Lost, Won, NotOverYet;

    private static boolean onSwitch = false;

    public static boolean isOnSwitch() {
        return onSwitch;
    }

    public static void setOnSwitch(boolean onSwitch) {
        onSwitch = onSwitch;
    }

    public boolean firstMoveCheck() {
        boolean reset = false;
        if (!onSwitch && this.toString() == "Lost") {
            reset = true;
        }
        return reset;
    }
    /******************************************************************
     * toString Method override toString
     *
     * @return String value of the enumerator
     ******************************************************************/
    @Override
    public String toString() {
        switch(this) {
            case Lost: return "Lost";
            case Won: return "Won";
            case NotOverYet: return "NotOverYet";
            default: throw new IllegalArgumentException();
        }
    }
}