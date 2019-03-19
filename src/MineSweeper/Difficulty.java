package MineSweeper;
/**********************************************************************
 Difficulty.java simply hold Difficulty data on game difficulty
 it will return a string or a array of numbers for different sizes
 @author Jason Rupright
 @version 1/30/2019
 **********************************************************************/
public enum Difficulty {
    Beginner, Intermediate, Expert, NONE;

    /******************************************************************
     * test Method creates an array for different game level settings
     * It sets the default sizes and Layouts called by default
     *
     * @return int[] CONSTRAINTS the array holding level data.
     ******************************************************************/
    public int[] test() {
        int[] CONSTRAINTS = new int[]{8, 8, 10};
        switch (this) {
            case Beginner:
                CONSTRAINTS = new int[]{8, 8, 10};
                break;
            case Intermediate:
                CONSTRAINTS = new int[]{16, 16, 40};
                break;
            case Expert:
                CONSTRAINTS = new int[]{24, 24, 99};
                break;
            case NONE:
                throw new IllegalArgumentException(
                        "Houston we have a problem.");
        }
        return CONSTRAINTS;
    }
    /******************************************************************
     * toString Method override toString
     *
     * @return String value of the enumerator
     ******************************************************************/
    @Override
    public String toString() {
        switch(this) {
            case Beginner: return "Beginner";
            case Intermediate: return "Intermediate";
            case Expert: return "Expert";
            case NONE: return "";
            default: throw new IllegalArgumentException();
        }
    }
}
