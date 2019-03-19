package SimpleDate;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;


public class SimpleDate {
    /******************************************************************
     *  month represents the current month
     ******************************************************************/
    private int month;

    /******************************************************************
     * day represents the current day
     ******************************************************************/
    private int day;
    /******************************************************************
     * year represents the current year
     ******************************************************************/
    private int year;
    /******************************************************************
     * Number of instances started of SimpleDate.
     ******************************************************************/
    private static int instances = 0;
    /******************************************************************
     * Number of increments_stored started of additional SimpeDate days
     * added using the additional increment method.
     ******************************************************************/
    private int increment = 0;
    /******************************************************************
     * Numerical (Gregorian) calender array also called.. DAYS_IN_MONTH
     ******************************************************************/
    private static final Integer[] DAYS_IN_MONTH = new Integer[]
            {0, 31, 28, 31, 30, 31, 30, 31, 31 , 30, 31, 30, 31};
    /******************************************************************
     * Epoch calender array also called..  EPOCH_CALENDER
     ******************************************************************/
    Integer[] EPOCH_CALENDER = new Integer[] {0, 31, 59, 90, 120
            , 151, 181, 212, 243 , 273, 304, 334, 335};
    /******************************************************************
     * String array of month names also called.. MONTH_NAMES
     ******************************************************************/
    String[] MONTH_NAMES = new String[] {null,
            "January", "February",
            "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};
    /******************************************************************
     * Static variable for number of months in a year.
     ******************************************************************/
    private static final int NUM_MONTHS = 12;
    /******************************************************************
     * Static variable for number of days in a year.
     ******************************************************************/
    private static final int DAYS_YEAR = 365;
    /******************************************************************
     * Static variable for minimum year number.
     ******************************************************************/
    public static final int MIN_YEAR = 1753;
    /******************************************************************
     * Default Constructor taking no arguments.
     * Sets month, day, and year variables to zero.
     *
     ******************************************************************/
    public SimpleDate() {
        this.month = 01;
        this.day = 01;
        this.year = MIN_YEAR;
        instances ++;
    }
    /******************************************************************
     * Constructor taking month, day, and year as integers.
     *
     * @param month the month
     * @param day   the day
     * @param year  the year
     * @throws IllegalArgumentException if input
     * doesn't represent a valid date.
     ******************************************************************/
    public SimpleDate(int month, int day, int year) {
        if(validYear(year) && validDay(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
            instances ++;
        }
    }
    /******************************************************************
     * Constructor taking other as SimpleDate argument.
     *
     * @param other Other SimpleDate to compare.
     * @throws IllegalArgumentException if input
     * isn't an instance of SimpleDate
     ******************************************************************/
    public SimpleDate(SimpleDate other) {
        if(other != null) {
            int month = other.getMonth();
            int day = other.getDay();
            int year = other.getYear();
            if (validDay(month, day, year)) {
                this.day = day;
                this.month = month;
                this.year = year;
                instances++;
            }
        }else throw new IllegalArgumentException("Other SimpleDate Cannot be NULL!");
    }
    /******************************************************************
     * A constructor that accepts a string that represents
     * a date
     *
     * @param startDate A string that represents a date
     * @throws IllegalArgumentException if parameter doesn't
     * represent a valid date.
     ****************************************************************/
    public SimpleDate(String startDate) {
        int count = 0;
        if(startDate == null) {throw new IllegalArgumentException("startDate Cannot be null.");}
            String[] test = startDate.split("/");
            for (char ch : startDate.toCharArray()) {
                if (ch == '/')
                    count++;

            }
            if(count != 2) throw new IllegalArgumentException("" +
                    "POPUP Please " +
                    "Enter a Valid date string in format 01/20/2000" +
                    " With no more than two forward slashes!");
            if (validProjectString(test[0], test[1], test[2])) {
                this.month = Integer.parseInt(test[0]);
                this.day = Integer.parseInt(test[1]);
                this.year = Integer.parseInt(test[2]);
            }
            instances++;

    }
    /******************************************************************
     * Method that accepts a string that represents
     * a date and checks it to assure it is valid.
     *
     * @param month A string that represents a date
     * @param day A string that represents a date
     * @param year A string that represents a date
     * @return boolean If valid date then return true.
     * @throws IllegalArgumentException if parameter doesn't
     * represent a valid date.
     ****************************************************************/
    public boolean validProjectString(
            String month, String day, String year){
        boolean output = false;
        try {
            int month0 = Integer.parseInt(month);
            int day0 = Integer.parseInt(day);
            int year0 = Integer.parseInt(year);
            if (validYear(year0) && validDay(
                    month0, day0, year0)) {
                output = true;
            }

        }catch(NumberFormatException num){
            throw new IllegalArgumentException(
                    "Invalid Day.%nMust be in format mm/dd/yyyy." +
                            "%nMust not contain AlphaNumeric " +
                            "characters or Keyboard Symbols other " +
                            "than forward slash (/).");
        }
        return output;
    }

    /******************************************************************
     * Method that returns a string that represents a SimpleDate
     * with the following format:  "Month, Day, Yea".
     *
     * @return String Representing format: Month, day, year.
     ******************************************************************/
    @Override
    public String toString() {
        String month = MONTH_NAMES[this.month];
        String day = "" + this.day;
        String year = "" + this.year;
        if (this.day < 10)
            day = "0" + day;
        return month + " " + day + ", " + year;
    }
    /******************************************************************
     * A method that accepts a integer that represents
     * a month and returns if it is indeed.
     *
     * @param month A integer that represents a month.
     * @return boolean If month is valid.
     * @throws IllegalArgumentException Throws if parameter doesn't
     * represent a valid month.
     ****************************************************************/
    private boolean validMonth(int month){
        if(month <= NUM_MONTHS && month > 0){
            return true;
        }
        throw new IllegalArgumentException(
                "Not a valid month!");
    }
    /******************************************************************
     * A method that accepts a integers that represents
     * a day & month, and returns if it is indeed a valid day.
     *
     * @param month A integer that represents a day.
     * @param day A integer that represents a month.
     * @return boolean If month & day is valid.
     * @throws IllegalArgumentException Throws if parameter doesn't
     * represent a valid day.
     ****************************************************************/
    private boolean validDay(int month, int day, int year) {
        if (month <= NUM_MONTHS && month > 0) {
            if (day > 0 && day <= daysInMonth(month, year)) {
                return true;
            }
            throw new IllegalArgumentException(
                    "Not a valid day!");
        }
        throw new IllegalArgumentException(
                "Not a valid month, day or year!");
    }
    /******************************************************************
     * A method that accepts a integers that represents
     * a day & month, and returns if it is indeed a valid day.
     *
     * @param year A integer that represents a day.
     * @return boolean If year is valid.
     * @throws IllegalArgumentException Throws if parameter doesn't
     * represent a valid year.
     ****************************************************************/
    private boolean validYear(int year){
        if(this.isLeapYear() && !isLeapYear(year)) {
            if (month == 2 && day == 29) {
                throw new IllegalArgumentException("When changing year " +
                        "from Leep Year to Non-Leep Year, day cannot be " +
                        "February 29!!");
            }
        }
        if(year >= MIN_YEAR){
            return true;
        }
        else throw new IllegalArgumentException(
                "Not a valid year!");
    }
    /******************************************************************
     * A method that accepts a integers that represents
     * a year & month, and returns int for days in that month.
     *
     * @param year A integer that represents a day.
     * @param month A integer that represents a month.
     * @return int If month & year is valid.
     * @throws IllegalArgumentException Throws if parameter doesn't
     * represent a valid day.
     ****************************************************************/
    private int daysInMonth(int month, int year) {
        //if(validMonth(month) && validYear(year)) {
        if(validMonth(month) && year >= 1753){
            if (month == 2 && isLeapYear(year)) {
                return 29;
            }
        }
        else throw new IllegalArgumentException("Not a valid month or year is less than 1753!");
        return DAYS_IN_MONTH[month];
    }
    /******************************************************************
     * A method that accepts a object that represents a SimpleDate
     * its checked against SimpleDate type and also against if other
     * equals this.SimpleDate. It returns boolean if it is equal
     *
     * @param other A object that represents a SimpleDate.
     * @return boolean If object valid and equal to this.SimpleDate
     * @throws IllegalArgumentException Throws if parameter doesn't
     * represent a valid SimpleDate.
     ****************************************************************/
    public boolean equals(Object other){
        if(other == null){
            throw new IllegalArgumentException(
                    "Not instance of " +
                            "SimpleDate%nUse to compare two " +
                            "SimpleDates only please.");
        }
        if(!(other instanceof SimpleDate)){
            throw new IllegalArgumentException(
                    "Not instance" +
                            " of SimpleDate" +
                            "%nUse to compare two SimpleDates" +
                            " only please.");
        }
        if ((this.getYear() == (
                (SimpleDate) other ).getYear()) &&
                (this.getMonth() == (
                        (SimpleDate) other).getMonth() )
                && (this.getDay() == (
                (SimpleDate) other).getDay()) ) {
            return true;
        } else return false;
    }
    /******************************************************************
     * A method that returns this. (current) known increment.
     *
     * @return int this. (current) increment
     ****************************************************************/
    public int getIncrement() {
        return increment;
    }

    /******************************************************************
     * A method that returns the (current) known day.
     *
     * @return int This (current) day
     ****************************************************************/
    public int getDay() {
        return day;
    }
    /******************************************************************
     * A method that sets (current day) if passed valid day.
     *
     * @param month int Sets (current day) if passed valid day.
     * @param day int Sets (current day) if passed valid day.
     * @param year int Sets (current day) if passed valid day.
     ****************************************************************/
    public void setDay(int month, int day, int year) {
        if(validDay(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }
    /******************************************************************
     * A method that returns the (current) known month.
     *
     * @return int This (current) month
     ****************************************************************/
    public int getMonth() {
        return month;
    }
    /******************************************************************
     * A method that sets (current month) if passed valid month.
     *
     * @param month int Sets (current month) if passed valid month.
     ****************************************************************/
    public void setMonth(int month) {
        if (validMonth(month)) {
            this.month = month;
        }
    }
    /******************************************************************
     * A method that returns the (current) known year.
     *
     * @return int This (current) year
     ****************************************************************/
    public int getYear() {
        return year;
    }
    /******************************************************************
     * A method that sets (current year) if passed valid year.
     *
     * @param year int Sets (current year) if passed valid year.
     ****************************************************************/
    public void setYear(int year) {
        if(validYear(year)){
            this.year = year;
        }
    }
    /******************************************************************
     * A method that accepts a SimpleDate, and if s2.SimpleDate equals
     * s2.SimpleDate. It returns boolean if it is equal.
     *
     * @param s1 A SimpleDate to compare.
     * @param s2 A SimpleDate to compare to.
     * @return boolean If s2.SimpleDate is equal to s1.SimpleDate
     ****************************************************************/
    public static boolean equals(SimpleDate s1, SimpleDate s2){
        if (s1.equals(s2)) {
            return true;
        }
        else return false;
    }
    /******************************************************************
     * A method that compares other.SimpleDate to this.SimpleDate
     *
     * @param other A SimpleDate to compare.
     * @return int [0,1,-1]]If this.SimpleDate
     * equal/greater/less_then other.SimpleDate.
     *
     ****************************************************************/
    public int compareTo(SimpleDate other) {
            if ((validYear(other.year) && validDay(
                    other.month, other.day, other.year))) {
            }
            if(this.year != other.year) {
                if (this.year > other.year) {
                    return 1;
                } else if (this.year < other.year) {
                    return -1;
                }
            }
            else if(this.month != other.month) {
                if (this.month > other.month) {
                    return 1;
                } else if (this.month < other.month) {
                    return -1;
                }
            }
            else if(this.day != other.day) {

                if (this.day > other.day) {
                    return 1;
                } else if (this.day < other.day) {
                    return -1;
                }
            }
            return 0;
    }
    /******************************************************************
     * A method that checks if current year is a leap year.
     *
     * @return boolean If this.year is a leap year.
     ****************************************************************/
    public boolean isLeapYear() {
        if (((year % 4 == 0) && (year % 100!= 0)) ||
                (year%400 == 0)){
            return true;
        } else return false;
    }
    /******************************************************************
     * A method that checks if year passed as param is a leap year.
     *
     * @param year int It is a year to check.
     * @return boolean If year is a leap year.
     ****************************************************************/
    public static boolean isLeapYear(int year){
        if (((year % 4 == 0) && (year % 100!= 0)) ||
                (year%400 == 0)){
            return true;
        } else return false;
    }
    /******************************************************************
     * A method that returns the total Epic Calender day from day one
     * equals 01/01/year
     *
     * @return int Return this current Epic Calender day.
     ****************************************************************/
    public int ordinalDate(){
        int check = this.month;
        if(this.month > 1) {
            if (isLeapYear() && check > 2) {
                return EPOCH_CALENDER[check-1] + 1 + this.day;
            }
            else return EPOCH_CALENDER[check-1] + this.day;
        }else return this.day;

    }
    /******************************************************************
     * A method that increments the date by one day.
     *
     * @return boolean  success return true.
     ****************************************************************/
    public boolean increment(){
        int check_day = day+1;
        int check_month = month+1;
        if(check_day > daysInMonth(month, year)) {
            this.day = 01;
            this.increment++;
            if (check_month > NUM_MONTHS) {
                year++;
                month = 01;
            } else month = check_month;
        }
        else {this.day = check_day; this.increment++;}

        return true;
    }
    /******************************************************************
     * A method that decrements the date by one day.
     *
     * @return boolean On success return true.
     ****************************************************************/
    public boolean decrement(){
        int check = this.day-1;

        if(check < 1) {
            this.month--;
            if (this.month < 1) {
                this.year--;
                this.month = NUM_MONTHS;
                this.day = daysInMonth(
                        this.month,this.year);
                this.increment--;
            } else {this.day = daysInMonth(
                    this.month, this.year); this.increment--;}
        }else {this.day--; this.increment--;}
        return true;
    }
    /******************************************************************
     * A method that returns count of every instance of SimpleDate.
     *
     * @return int Representing every instance of SimpleDate
     ****************************************************************/
    public static int getNumberOfSimpleDates(){
        return instances;
    }
    /******************************************************************
     * A method that resets the static variable instances for testing.
     *
     ****************************************************************/
    public static void resetCounter(){
        instances = 0;
    }
    /******************************************************************
     * A method that saves the "this" SimpleDate to a file;
     * use the parameter filename for the name of the file
     *
     * @param fileName A file given in calling Method.
     ****************************************************************/
    public void save(String fileName){
        //fileName = fileName.replaceAll("C:", "");
        fileName = fileName.replaceAll(
                "[^a-zA-Z0-9\\.\\-]", "_");

        PrintWriter writer = null;
        try {

            writer = new PrintWriter(new FileWriter(
                    fileName));
            writer.println(this.month);
            writer.println(this.day);
            writer.println(this.year);
            writer.flush();
            writer.close();

        } catch(java.io.IOException e){
            //System.out.println("createFile failed:" + e);
            //e.printStackTrace();
        }


    }
    /******************************************************************
     * A  method that loads the "this" SimpleDate object from a file;
     * use the parameter filename for the name of the file
     *
     * @param fileName A file given in calling Method.
     ****************************************************************/
    public void load(String fileName){
        fileName = fileName.replaceAll(
                "[^a-zA-Z0-9\\.-]", "_");

        List<Integer> list = new ArrayList<>();
        int [] tall = new int [100];
        int i = 0;

        try {
            Scanner scanner;
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        }catch(FileNotFoundException file){
        }
        try {
            if (validYear(list.get(2)) &&
                    validDay(list.get(0),
                    list.get(1), list.get(2))) {
                this.month = list.get(0);
                this.day = list.get(1);
                this.year = list.get(2);
            }
        }catch(IndexOutOfBoundsException ind){
        }

    }
    /******************************************************************
     * A method that returns a new SimpleDate object representing the
     * date "n" days from now. If "n" is negative, then return
     * the date "n" days in the past.
     *
     * @param n int Representing number of days in the future/past.
     * @return  SimpleDate Returned date representing n future/past
     ****************************************************************/
    public SimpleDate daysFromNow(int n){
        SimpleDate date = this;
        if(n == 0)
            return date;
        if(n < 0){
            for(int i = Math.abs(n); i > 0; i--){
                date.decrement();
            }
        }
        else{
            for(int i = 1; i <= n; i++){
                date.increment();
            }
        }
        return date;
    }
    /******************************************************************
     * A method that returns a new SimpleDate object representing the
     * date "n" days from now. If  "other" follows "this" date,
     * then the value returned is negative.
     *
     * @param other SimpleDate Representing date in future/past.
     * @return  int Returned as number of days future/past
     ****************************************************************/
    public int daysSince (SimpleDate other) {

        SimpleDate temp = this;
        if(!temp.equals(other)) {
            while (temp.compareTo(other) < 0) {
                other.decrement();
            }
            while (temp.compareTo(other) > 0) {
                other.increment();
            }
        }
        return other.getIncrement();
    }

}