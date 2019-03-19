package SimpleDate;

import org.junit.Assert;
import org.junit.Test;

public class SimpleDateTest {
    Integer[] leapYears = new Integer[] {1756, 1760, 1764, 1768, 1772, 1776, 1780, 1784, 1788, 1792, 1796, 1804, 1808, 1812, 1816, 1820, 1824, 1828, 1832, 1836, 1840, 1844, 1848, 1852, 1856, 1860, 1864, 1868, 1872, 1876, 1880, 1884, 1888, 1892, 1896, 1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096, 2104, 2108, 2112, 2116, 2120, 2124, 2128, 2132, 2136, 2140, 2144, 2148, 2152, 2156, 2160, 2164, 2168, 2172, 2176, 2180, 2184, 2188, 2192, 2196, 2204, 2208, 2212, 2216, 2220, 2224, 2228, 2232, 2236, 2240, 2244, 2248, 2252, 2256, 2260, 2264, 2268, 2272, 2276, 2280, 2284, 2288, 2292, 2296, 2304, 2308, 2312, 2316, 2320, 2324, 2328, 2332, 2336, 2340, 2344, 2348, 2352, 2356, 2360, 2364, 2368, 2372, 2376, 2380, 2384, 2388, 2392, 2396, 2400, 2404, 2408, 2412, 2416, 2420, 2424, 2428, 2432, 2436, 2440, 2444, 2448, 2452, 2456, 2460, 2464, 2468, 2472, 2476, 2480, 2484, 2488, 2492, 2496, 2504, 2508, 2512, 2516, 2520, 2524, 2528, 2532, 2536, 2540, 2544, 2548, 2552, 2556, 2560, 2564, 2568, 2572, 2576, 2580, 2584, 2588, 2592, 2596, 2604, 2608, 2612, 2616, 2620, 2624, 2628, 2632, 2636, 2640, 2644, 2648, 2652, 2656, 2660, 2664, 2668, 2672, 2676, 2680, 2684, 2688, 2692, 2696, 2704, 2708, 2712, 2716, 2720, 2724, 2728, 2732, 2736, 2740, 2744, 2748, 2752, 2756, 2760, 2764, 2768, 2772, 2776, 2780, 2784, 2788, 2792, 2796, 2800, 2804, 2808, 2812, 2816, 2820, 2824, 2828, 2832, 2836, 2840, 2844, 2848, 2852, 2856, 2860, 2864, 2868, 2872, 2876, 2880, 2884, 2888, 2892, 2896, 2904, 2908, 2912, 2916, 2920, 2924, 2928, 2932, 2936, 2940, 2944, 2948, 2952, 2956, 2960, 2964, 2968, 2972, 2976, 2980, 2984, 2988, 2992, 2996, 3004, 3008, 3012, 3016, 3020, 3024, 3028, 3032, 3036, 3040, 3044, 3048, 3052, 3056, 3060, 3064, 3068, 3072, 3076, 3080, 3084, 3088, 3092, 3096, 3104, 3108, 3112, 3116, 3120, 3124, 3128, 3132, 3136, 3140, 3144, 3148, 3152, 3156, 3160, 3164, 3168, 3172, 3176, 3180, 3184, 3188, 3192, 3196, 3200, 3204, 3208, 3212, 3216, 3220, 3224, 3228, 3232, 3236, 3240, 3244, 3248, 3252, 3256, 3260, 3264, 3268, 3272, 3276, 3280, 3284, 3288, 3292, 3296, 3304, 3308, 3312, 3316, 3320, 3324, 3328, 3332, 3336, 3340, 3344, 3348, 3352, 3356, 3360, 3364, 3368, 3372, 3376, 3380, 3384, 3388, 3392, 3396, 3404, 3408, 3412, 3416, 3420, 3424, 3428, 3432, 3436, 3440, 3444, 3448, 3452, 3456, 3460, 3464, 3468, 3472, 3476, 3480, 3484, 3488, 3492, 3496, 3504, 3508, 3512, 3516, 3520, 3524, 3528, 3532, 3536, 3540, 3544, 3548, 3552, 3556, 3560, 3564, 3568, 3572, 3576, 3580, 3584, 3588, 3592, 3596, 3600, 3604, 3608, 3612, 3616, 3620, 3624, 3628, 3632, 3636, 3640, 3644, 3648, 3652, 3656, 3660, 3664, 3668, 3672, 3676, 3680, 3684, 3688, 3692, 3696, 3704, 3708, 3712, 3716, 3720, 3724, 3728, 3732, 3736, 3740, 3744, 3748, 3752, 3756, 3760, 3764, 3768, 3772, 3776, 3780, 3784, 3788, 3792, 3796, 3804, 3808, 3812, 3816, 3820, 3824, 3828, 3832, 3836, 3840, 3844, 3848, 3852, 3856, 3860, 3864, 3868, 3872, 3876, 3880, 3884, 3888, 3892, 3896, 3904, 3908, 3912, 3916, 3920, 3924, 3928, 3932, 3936, 3940, 3944, 3948, 3952, 3956, 3960, 3964, 3968, 3972, 3976, 3980, 3984, 3988, 3992, 3996};

    @Test
    public void SimpleDateConstructorTest01(){
        SimpleDate date = new SimpleDate();
        date.setDay(04,06,1979);
        int temp = date.getIncrement();
        System.out.println(temp);
        Assert.assertTrue(date.getMonth() == 04);
        Assert.assertTrue(date.getDay() == 06);
        Assert.assertTrue(date.getYear() == 1979);
        System.out.println(date.toString());
        Assert.assertTrue(date.toString().equals("April 06, 1979"));

    }

    @Test
    public void SimpleDate_SimpleDate_other_Test01(){
        SimpleDate date = new SimpleDate(01, 01, 1753);
        date.setDay(04,06, 1979);
        SimpleDate other = new SimpleDate(date);

        Assert.assertEquals(date.getDay(), other.getDay());
        Assert.assertEquals(date.getMonth(), other.getMonth());
        Assert.assertEquals(date.getYear(), other.getYear());
        //Assert.assertTrue(date.getIncrement() == 1);
        Assert.assertTrue(date.toString().equals(other.toString()));
    }
    @Test
    public void SimpleDateInstancesTest00() {
        int TEST_NUM_DAYS = -460;
        //And.. thats-a-one, two..
        SimpleDate testDate = new SimpleDate(01, 01, 1978);
        SimpleDate date = new SimpleDate();
        date.setDay(04, 06, 1979);
    }
    @Test
    public void testSimpleDateConstructor(){
        SimpleDate date0 = new SimpleDate(01, 01, 1753);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDateConstructor01(){
        SimpleDate date0 = new SimpleDate(01, 01, 1752);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDateConstructor02(){
        SimpleDate date0 = new SimpleDate(13, 13, 2000);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDateConstructor03(){
        SimpleDate date0 = new SimpleDate(02, 30, 2000);
    }
    @Test
    public void testSimpleDateConstructor04(){
        SimpleDate date0 = new SimpleDate(02, 29, 2000);
    }

    @Test
    public void testSimpleDate_Param_String00(){
        String string = "01/01/1753";
        SimpleDate date = new SimpleDate(string);
        Assert.assertEquals(01, date.getDay());
        Assert.assertEquals(01, date.getMonth());
        Assert.assertEquals(1753, date.getYear());
        Assert.assertEquals("January 01, 1753", date.toString());
    }
    @Test
    public void testSimpleDate_Param_String01(){
        String string = "01/01/1753";
        SimpleDate date = new SimpleDate(string);
        Assert.assertEquals("January 01, 1753", date.toString());
    }
    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void testSimpleDate_Param_String02(){
        String string = "1/01/1753";
        SimpleDate date = new SimpleDate(string);
    }
    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void testSimpleDate_Param_String03(){
        String string = "01/1/1753";
        SimpleDate date = new SimpleDate(string);
    }
    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void testSimpleDate_Param_String04(){
        String string = "01/001/1753";
        SimpleDate date = new SimpleDate(string);
    }
    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void testSimpleDate_Param_String05(){
        String string = "001/01/1753";
        SimpleDate date = new SimpleDate(string);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDate_Param_String07(){
        String string = "01/01//1753";
        SimpleDate date = new SimpleDate(string);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDate_Param_String08(){
        String string = "01/AA/1753";
        SimpleDate date = new SimpleDate(string);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDate_Param_String09(){
        String string = "AA/01/1753";
        SimpleDate date = new SimpleDate(string);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDate_Param_String10(){
        String string = "#$/01/1753";
        SimpleDate date = new SimpleDate(string);
    }
    //Check for valid dates after *split. given String
    //verified from :
    // https://www.calculator.net/date-calculator.html
    // ?today=01%2F01%2F1753&ageat=01%2F01%2F9999&calctype=diff&x=49&y=23
    @Test
    public void testSimpleDate_Param_String11() {
        String string = "1/1/1753";
        SimpleDate date0 = new SimpleDate();
        SimpleDate date = new SimpleDate(string);
        date0.daysFromNow(3011789);
        Assert.assertEquals(1, date0.getMonth());
        Assert.assertEquals(1, date0.getDay());
        Assert.assertEquals(9999, date0.getYear());
    }
    @Test
    public void testSimpleDate_Equals00() {
        SimpleDate date = new SimpleDate();
        Object temp = date;
        Assert.assertTrue(date.equals(temp));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDate_Equals01() {
        SimpleDate date = new SimpleDate();
        Object temp = null;
        Assert.assertTrue(date.equals(temp));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSimpleDate_Equals02() {
        SimpleDate date = new SimpleDate();
        Object temp = "I am a String";
        Assert.assertTrue(date.equals(temp));
    }
    @Test
    public void testSimpleDate_Equals03() {
        SimpleDate date = new SimpleDate();
        SimpleDate date0 = new SimpleDate("04/06/1979");

        Object temp = date0;
        Assert.assertFalse(date.equals(temp));
    }
    @Test
    public void testSimpleDate_Equals_TwoArgs00() {
        SimpleDate date = new SimpleDate();
        SimpleDate date0 = new SimpleDate("04/06/1979");

        SimpleDate temp = date0;
        Assert.assertFalse(date.equals(date, temp));
    }
    @Test
    public void testSimpleDate_Equals_TwoArgs01() {
        SimpleDate date = new SimpleDate();
        SimpleDate date0 = new SimpleDate();

        Assert.assertTrue(date.equals(date, date0));
    }
    @Test
    public void testSimpleDate_compareTo00() {
        SimpleDate date = new SimpleDate();
        SimpleDate date0 = new SimpleDate();

        Assert.assertEquals(0, date.compareTo(date0));
    }
    @Test
    public void testSimpleDate_compareTo01() {
        SimpleDate date = new SimpleDate();
        SimpleDate date0 = new SimpleDate("04/06/1979");

        Assert.assertEquals(1, date0.compareTo(date));
    }
    @Test
    public void testSimpleDate_compareTo02() {
        SimpleDate date = new SimpleDate();
        SimpleDate date0 = new SimpleDate("04/06/1979");

        Assert.assertEquals(-1, date.compareTo(date0));
    }
    @Test
    public void testSimpleDate_compareTo03() {
        SimpleDate date = new SimpleDate("01/06/1979");
        SimpleDate date0 = new SimpleDate("04/06/1951");

        Assert.assertEquals(1, date.compareTo(date0));
    }
    @Test
    public void testSimpleDate_compareTo04() {
        SimpleDate date = new SimpleDate("04/06/1979");
        SimpleDate date0 = new SimpleDate("01/07/1979");

        Assert.assertEquals(1, date.compareTo(date0));
    }
    @Test
    public void testSimpleDate_compareTo05() {
        SimpleDate date = new SimpleDate("04/06/1979");
        SimpleDate date0 = new SimpleDate("04/05/1979");

        Assert.assertEquals(1, date.compareTo(date0));
    }
    @Test
    public void testSimpleDate_compareTo06() {
        SimpleDate date = new SimpleDate("03/06/1979");
        SimpleDate date0 = new SimpleDate("04/05/1979");

        Assert.assertEquals(-1, date.compareTo(date0));
    }
    @Test
    public void SimpleDateSaveLoadTest00(){
        SimpleDate date = new SimpleDate(04, 06, 1979);
        SimpleDate temp = date;
        date.save("A??.txt");
        date.setDay(01, 01, 2000);
        date.setMonth(02);
        date.setYear(2001);
        date.load("A__.txt");
        Assert.assertEquals(date.getDay(), temp.getDay());

    }
    @Test
    public void SimpleDateSaveLoadTest01(){
        SimpleDate date = new SimpleDate(04, 06, 1979);
        SimpleDate temp = date;

        date.save("A.txt");
        date.setDay(01, 01, 2000);
        date.setMonth(02);
        date.setYear(2001);
        date.load("A.txt");
        Assert.assertEquals(date.getDay(), temp.getDay());
    }
    @Test
    public void SimpleDateSaveLoadTest02(){
        SimpleDate date = new SimpleDate(04, 06, 1979);
        SimpleDate temp = date;
        date.save("");
        date.setMonth(02);
        date.setYear(2001);
        date.load("");
        Assert.assertEquals(date.getDay(), temp.getDay());
    }
    @Test
    public void SimpleDateSaveTest00(){
        SimpleDate date = new SimpleDate(04, 06, 1979);
        SimpleDate temp = date;
        date.save("");
    }
    @Test
    public void SimpleDateSaveTest01(){
        SimpleDate date = new SimpleDate(04, 06, 1979);
        SimpleDate temp = date;
        date.save("C:/Users/Administrator/Documents/CLASSES/CIS 163/Projects/MyOut.txt");
    }
    @Test
    public void SimpleDateSaveTest02(){
        SimpleDate date = new SimpleDate(04, 06, 1979);
        SimpleDate temp = date;
        System.out.println("C:/Users/Administrator/Documents/CLASSES/CIS 163/Projects/MyOut.txt");

        date.save("C:/Users/Administrator/Documents/CLASSES/CIS 163/Projects/MyOut.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay00(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(13, 01, 1923);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay01(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(00, 01, 1923);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay02(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(-01, 01, 1923);
    }
    @Test
    public void SimpleDateSetDay03(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(001, 01, 1923);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay04(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(01, 32, 1923);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay05(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(01, 00, 1923);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay06(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(01, -01, 1923);
    }
    @Test
    public void SimpleDateSetDay07(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(01, 001, 1923);
        System.out.println(temp.getDay());
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay08(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(01, 01, 1752);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay09(){
        SimpleDate temp = new SimpleDate();
        temp.setDay(01, 01, 00000);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay13(){
        SimpleDate temp = new SimpleDate();
        temp.setMonth(13);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay14(){
        SimpleDate temp = new SimpleDate();
        temp.setMonth(00);
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateSetDay15(){
        SimpleDate temp = new SimpleDate();
        temp.setMonth(-01);
    }
    @Test
    public void SimpleDateisLeapYear00(){
        SimpleDate temp = new SimpleDate();
        int count = 0;
        int count0 = 0;
        //list of leap years from 1953 to 3999 having fun yet. Of witch are 544.\
        for (int i: leapYears){
            temp.setYear(i);
            temp.setMonth(02);
            Assert.assertTrue(temp.isLeapYear() && temp.getDay() != 29);
            if(temp.isLeapYear())
                count++;
            if(temp.isLeapYear(i))
                count0++;
            }
            Assert.assertEquals(count, leapYears.length);
            Assert.assertEquals(count0, leapYears.length);
    }
    @Test
    public void SimpleDateisLeapYear01(){
        int count = 0;
        int count0 = 0;
        SimpleDate temp = new SimpleDate();
        //list of total years from 1953 to 3999 having fun yet. Of witch are 2246.\
        //Out of those that are non leap years, check the non-leap years using out method.
        //Non-leap years are totaling at 1702.
        int[] array = new int[3999-1753];
        array[0] = 1753;
        for(int i = 1; i < array.length; i++)
            array[i] = array[0] + i;
        for (int y: array){
            temp.setYear(y);
            temp.setMonth(02);
            if(temp.isLeapYear())
                count++;
            if(temp.isLeapYear(y))
                count0++;
        }
        //System.out.println(betweenLeapYears[2245]);
        Assert.assertEquals(544, count);
        Assert.assertEquals(544, count0);
    }
    @Test
    public void SimpleDateOrdinalDate00() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        Assert.assertEquals(1, temp.ordinalDate());
        temp.setDay(01, 31, 1979);
        Assert.assertEquals(31, temp.ordinalDate());
        temp.setDay(03, 01, 2000);
        Assert.assertEquals(61, temp.ordinalDate());
        temp.setDay(03, 01, 2001);
        Assert.assertEquals(60, temp.ordinalDate());
    }
    @Test
    public void SimpleDateIncrement00() {
        SimpleDate temp = new SimpleDate("01/01/2000");
        int n = 1;
        int total_tests = 461;
        while(n <= total_tests) {
            if(temp.getYear() == 2000)
            Assert.assertEquals(n, temp.ordinalDate());
            temp.increment();
            n++;
        }
        Assert.assertEquals("April 06, 2001", temp.toString());
    }
    @Test
    public void SimpleDateIncrement01() {
        SimpleDate temp = new SimpleDate("02/28/2000");
        temp.increment();
        Assert.assertEquals("February 29, 2000", temp.toString());
    }
    @Test
    public void SimpleDateDecrement00() {
        SimpleDate temp = new SimpleDate("04/06/2001");
        int total_tests = 461;
        int days_left = temp.ordinalDate()-1;
            for(int n = total_tests; n > 0; n--){
            temp.decrement();
        }
        Assert.assertEquals("January 01, 2000", temp.toString());
    }
    @Test
    public void SimpleDateDecrement01() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        int total_tests = 460;
        int days_left = temp.ordinalDate()-1;
        for(int n = 0; n < total_tests; n++){
            temp.increment();
        }
        Assert.assertEquals("April 06, 1754", temp.toString());
    }
    @Test
    public void SimpleDateDaysSince00() {
        SimpleDate temp = new SimpleDate("01/03/1753");
        SimpleDate other = new SimpleDate("01/01/1753");
        Assert.assertEquals(2, temp.daysSince(other));
    }
    @Test
    public void SimpleDateDaysSince01() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        SimpleDate other = new SimpleDate("01/03/1753");
        Assert.assertEquals(-2, temp.daysSince(other));
    }
    @Test
    public void SimpleDateDaysSince02() {
        SimpleDate temp = new SimpleDate("02/29/2000");
        SimpleDate other = new SimpleDate("01/01/2000");
        Assert.assertEquals(59, temp.daysSince(other));
    }
    @Test
    public void SimpleDateDaysSince03() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        SimpleDate other = new SimpleDate("01/03/1753");
        Assert.assertEquals(-2, temp.daysSince(other));
    }
    @Test
    public void SimpleDateDaysSince04() {
        SimpleDate temp = new SimpleDate("01/03/1753");
        SimpleDate other = new SimpleDate("01/01/1753");
        Assert.assertEquals(2, temp.daysSince(other));
    }
    @Test
    public void SimpleDateDaysSince05() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        SimpleDate other = new SimpleDate("01/03/1753");
        Assert.assertEquals(-2, temp.daysSince(other));
    }
    @Test
    public void SimpleDateDaysSince06() {
        SimpleDate temp = new SimpleDate("04/06/2001");
        SimpleDate other = new SimpleDate("01/01/2000");
        Assert.assertEquals(461, temp.daysSince(other));
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateDaysFromNow0() {
        SimpleDate temp = new SimpleDate("");
    }
    @Test
    public void SimpleDateDaysFromNow00() {
        SimpleDate temp = new SimpleDate("04/06/1754");
        temp.daysFromNow(-460);
        Assert.assertEquals("January 01, 1753", temp.toString());
    }
    @Test
    public void SimpleDateDaysFromNow01() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        temp.daysFromNow(460);
        Assert.assertEquals("April 06, 1754", temp.toString());
    }
    @Test
    public void SimpleDateDaysFromNow02() {
        SimpleDate temp = new SimpleDate("04/06/1754");
        temp.daysFromNow(-1);
        Assert.assertEquals("April 05, 1754", temp.toString());
    }
    @Test
    public void SimpleDateDaysFromNow03() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        temp.daysFromNow(1);
        Assert.assertEquals("January 02, 1753", temp.toString());
    }
    @Test(expected = IllegalArgumentException.class)
    public void SimpleDateDaysFromNow04() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        temp.daysFromNow(-1);
    }
    @Test
    public void SimpleDateDaysFromNow05() {
        SimpleDate temp = new SimpleDate("01/01/1753");
        temp.daysFromNow(0);
        Assert.assertEquals("January 01, 1753", temp.toString());
    }
    @Test
    public void testIsLeapYearAA()  {
        SimpleDate d = new SimpleDate("3/1/2013");
        Assert.assertFalse(d.isLeapYear());

        d  =  new SimpleDate("3/1/2000");
        Assert.assertTrue(d.isLeapYear());
    }

    @Test
    public void testCompareTo1AA()  {
        SimpleDate d1 = new SimpleDate("3/1/2013");
        SimpleDate d2 = new SimpleDate("8/21/2000");
        Assert.assertTrue(d1.compareTo(d2) > 0);
    }

    @Test
    public void testCompareTo2AA()  {
        SimpleDate d1 = new SimpleDate(2, 29, 2000);
        SimpleDate d2 = new SimpleDate("3/001/2000");
        Assert.assertTrue(d1.compareTo(d2) < 0);
    }

    @Test
    public void testCompareTo3AA()  {
        SimpleDate d1 = new SimpleDate("2/29/2004");
        SimpleDate d2 = new SimpleDate(2, 29, 2004);
        Assert.assertTrue(d1.compareTo(d2) == 0);
    }

    @Test
    public void testCompareTo4AA()  {
        SimpleDate d1 = new SimpleDate(2, 29, 2004);
        SimpleDate d2 = new SimpleDate("2/29/2008");
        Assert.assertTrue(d1.compareTo(d2) < 0);
    }

    @Test
    public void testCompareTo5AA()  {
        SimpleDate d1 = new SimpleDate("03/02/2004");
        SimpleDate d2 = new SimpleDate("03/1/2004");
        Assert.assertTrue(d1.compareTo(d2) > 0);
    }

    @Test
    public void testCompareTo6AA()  {
        SimpleDate d1 = new SimpleDate(3, 1, 2004);
        SimpleDate d2 = new SimpleDate("2/29/2004");
        Assert.assertTrue(d1.compareTo(d2) > 0);
    }

    @Test
    public void testCompareTo7AA()  {
        SimpleDate d1 = new SimpleDate(5, 4, 2015);
        SimpleDate d2 = new SimpleDate(5, 5, 2015);
        Assert.assertTrue(d1.compareTo(d2) < 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectYearAA() {
        SimpleDate d1 = new SimpleDate("3/1/1752");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectDayAA(){
        SimpleDate d1 = new SimpleDate("3/-1/1800");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectMonthAA() {
        SimpleDate d1 = new SimpleDate("-3/1/1800");
    }

    @Test
    public void testSimpleDate1AA(){
        SimpleDate d1 = new SimpleDate(2, 29, 2000);
        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 29);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testSimpleDate2AA(){
        SimpleDate d1 = new SimpleDate("2/29/2000");
        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 29);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidDate1AA(){
        SimpleDate d1 = new SimpleDate(-1, 1, 2011);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidDate2AA(){
        SimpleDate d1 = new SimpleDate(1, -1, 2011);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidDate3AA(){
        SimpleDate d1 = new SimpleDate(1, 1, -2011);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testTooFewSlashesAA(){
        SimpleDate d1 = new SimpleDate("12/122000");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testTooManySlashesAA(){
        SimpleDate d1 = new SimpleDate("01/01/20/20");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyStringDateAA(){
        SimpleDate d1 = new SimpleDate("");
    }

    @Test
    public void testOtherConstructorAA(){
        SimpleDate d1 = new SimpleDate(12, 31, 2000);
        SimpleDate d2 = new SimpleDate(d1);

        Assert.assertTrue(d2.getMonth() == 12);
        Assert.assertTrue(d2.getDay() == 31);
        Assert.assertTrue(d2.getYear() == 2000);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testOtherConstructorNullAA(){
        SimpleDate d1 = null;
        SimpleDate d2 = new SimpleDate(d1);
    }

    @Test
    public void testLeadingZeroes1AA(){
        SimpleDate d1 = new SimpleDate("02/02/2000");
        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 2);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testLeadingZeroes2AA(){
        SimpleDate d1 = new SimpleDate("05/005/02019");
        Assert.assertTrue(d1.getMonth() == 5);
        Assert.assertTrue(d1.getDay() == 5);
        Assert.assertTrue(d1.getYear() == 2019);
    }

    @Test
    public void testCounter1AA(){
        SimpleDate.resetCounter();

        SimpleDate d1 = new SimpleDate(12, 12, 2012);
        SimpleDate d2 = new SimpleDate("12/12/2012");
        SimpleDate d3 = new SimpleDate(2, 29, 2000);
        SimpleDate d4 = new SimpleDate("10/31/2019");
        Assert.assertTrue(SimpleDate.getNumberOfSimpleDates() == 4);
    }

    @Test
    public void testCounter2AA(){
        SimpleDate.resetCounter();

        SimpleDate d1 = new SimpleDate(12, 12, 2012);
        SimpleDate d2 = new SimpleDate("12/12/2012");
        SimpleDate d3 = new SimpleDate(2, 29, 2000);
        SimpleDate d4 = new SimpleDate("10/31/2019");
        SimpleDate d5 = new SimpleDate(d4);
        SimpleDate d6 = new SimpleDate("005/005/02018");

        Assert.assertTrue(SimpleDate.getNumberOfSimpleDates() == 6);
    }

    @Test
    public void testEquals1AA(){
        SimpleDate d1 = new SimpleDate(10, 10, 2010);
        SimpleDate d2 = new SimpleDate("10/10/2010");
        Assert.assertEquals(d1, d2);
    }

    @Test
    public void testEquals2AA(){
        SimpleDate d1 = new SimpleDate(10, 10, 2010);
        SimpleDate d2 = new SimpleDate("10/10/2009");
        Assert.assertNotEquals(d1, d2);
    }

    @Test
    public void testEquals3AA(){
        SimpleDate d1 = new SimpleDate(2, 29, 2000);
        SimpleDate d2 = new SimpleDate("2/29/2000");
        Assert.assertTrue(SimpleDate.equals(d1, d2));
    }

    @Test
    public void testEquals4AA(){
        SimpleDate d1 = new SimpleDate(2, 29, 2000);
        SimpleDate d2 = new SimpleDate("2/28/2000");
        Assert.assertFalse(SimpleDate.equals(d1, d2));
    }

    @Test
    public void testEquals5AA(){
        SimpleDate d1 = new SimpleDate("12/00018/001900");
        SimpleDate d2 = new SimpleDate("2/28/2000");
        Assert.assertFalse(d1.equals(d2));
    }

    @Test
    public void testEqualsOtherConstructor1AA(){
        SimpleDate d1 = new SimpleDate(10, 31, 1999);
        SimpleDate d2 = new SimpleDate(d1);
        Assert.assertTrue(SimpleDate.equals(d1, d2));
    }

    @Test
    public void testEqualsOtherConstructor2AA(){
        SimpleDate d1 = new SimpleDate(10, 31, 1999);
        SimpleDate d2 = new SimpleDate(d1);
        Assert.assertTrue(d1.equals(d2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEqualsWithNull1AA(){
        SimpleDate d1 = new SimpleDate(12, 25, 1999);
        SimpleDate d2 = null;
        d1.equals(d2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEqualsWithNull2AA(){
        SimpleDate d1 = new SimpleDate("005/15/2015");
        SimpleDate d2 = null;
        SimpleDate.equals(d1, d2);
    }

    @Test
    public void testToString1AA(){
        SimpleDate d1 = new SimpleDate(2, 29, 2000);
        Assert.assertEquals(d1.toString(), "February 29, 2000");
    }

    @Test
    public void testToString2AA(){
        SimpleDate d1 = new SimpleDate("003/00000029/0001800");
        Assert.assertEquals(d1.toString(), "March 29, 1800");
    }

    @Test
    public void testToStringLeadingZeroAA(){
        SimpleDate d1 = new SimpleDate(1, 1, 1970);
        Assert.assertEquals(d1.toString(), "January 01, 1970");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidToStringAA(){
        SimpleDate d1 = new SimpleDate("");
        d1.toString();
    }

    @Test
    public void testSettersAA(){
        SimpleDate d1 = new SimpleDate("2/29/2000");

        d1.setDay(12, 12, 1990);

        Assert.assertTrue(d1.getMonth() == 12);
        Assert.assertTrue(d1.getDay() == 12);
        Assert.assertTrue(d1.getYear() == 1990);
    }

    @Test
    public void testSetMonthAA(){
        SimpleDate d1 = new SimpleDate(6, 7, 1980);

        d1.setMonth(7);

        Assert.assertTrue(d1.getMonth() == 7);
        Assert.assertTrue(d1.getDay() == 7);
        Assert.assertTrue(d1.getYear() == 1980);
    }

    @Test
    public void testSetDayAA(){
        SimpleDate d1 = new SimpleDate("6/7/1980");

        d1.setDay(01, 20, 2000);

        Assert.assertTrue(d1.getMonth() == 1);
        Assert.assertTrue(d1.getDay() == 20);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testSetYearAA(){
        SimpleDate d1 = new SimpleDate("6/7/1980");

        d1.setYear(2019);

        Assert.assertTrue(d1.getMonth() == 6);
        Assert.assertTrue(d1.getDay() == 7);
        Assert.assertTrue(d1.getYear() == 2019);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetIncorrectMonthAA(){
        SimpleDate d1 = new SimpleDate(5, 9, 2017);
        d1.setMonth(15);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetIncorrectDayAA(){
        SimpleDate d1 = new SimpleDate("05/006/2019");

        d1.setDay(01,-10, 2000);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetIncorrectYearAA(){
        SimpleDate d1 = new SimpleDate("05/006/2019");

        d1.setYear(1500);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetIncorrectYearLeapYearAA(){
        SimpleDate d1 = new SimpleDate("2/29/2000");

        d1.setYear(1999);
    }

    @Test
    public void testOrdinalDate1AA(){
        SimpleDate d1 = new SimpleDate("2/10/2013");
        Assert.assertTrue(d1.ordinalDate() == 41);
    }

    @Test
    public void testOrdinalDate2AA(){
        SimpleDate d1 = new SimpleDate(7, 28, 2019);
        Assert.assertTrue(d1.ordinalDate() == 209);
    }

    @Test
    public void testOrdinalDate3AA(){
        SimpleDate d1 = new SimpleDate("01/1/1999");
        Assert.assertTrue(d1.ordinalDate() == 1);
    }

    @Test
    public void testOrdinalDateFullYearAA(){
        SimpleDate d1 = new SimpleDate("12/31/1999");
        Assert.assertTrue(d1.ordinalDate() == 365);
    }

    @Test
    public void testOrdinalDateFullLeapYearAA(){
        SimpleDate d1 = new SimpleDate("12/31/2000");
        Assert.assertTrue(d1.ordinalDate() == 366);
    }

    @Test
    public void testIncrementNextDayAA(){
        SimpleDate d1 = new SimpleDate("10/009/2010");
        d1.increment();

        Assert.assertTrue(d1.getMonth() == 10);
        Assert.assertTrue(d1.getDay() == 10);
        Assert.assertTrue(d1.getYear() == 2010);
    }

    @Test
    public void testIncrementNextMonth1AA(){
        SimpleDate d1 = new SimpleDate(1, 31, 2019);
        d1.increment();

        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 1);
        Assert.assertTrue(d1.getYear() == 2019);
    }

    @Test
    public void testIncrementNextMonth2AA(){
        SimpleDate d1 = new SimpleDate("06/30/2018");
        d1.increment();

        Assert.assertTrue(d1.getMonth() == 7);
        Assert.assertTrue(d1.getDay() == 1);
        Assert.assertTrue(d1.getYear() == 2018);
    }

    @Test
    public void testIncrementNextYearAA(){
        SimpleDate d1 = new SimpleDate("12/31/2018");
        d1.increment();

        Assert.assertTrue(d1.getMonth() == 1);
        Assert.assertTrue(d1.getDay() == 1);
        Assert.assertTrue(d1.getYear() == 2019);
    }

    @Test
    public void testIncrementLeapYear1AA(){
        SimpleDate d1 = new SimpleDate("02/28/2000");
        d1.increment();

        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue (d1.getDay() == 29);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testIncrementLeapYear2AA(){
        SimpleDate d1 = new SimpleDate("02/28/2001");
        d1.increment();

        Assert.assertTrue(d1.getMonth() == 3);
        Assert.assertTrue (d1.getDay() == 1);
        Assert.assertTrue(d1.getYear() == 2001);
    }

    @Test
    public void testIncrementLeapYear3AA(){
        SimpleDate d1 = new SimpleDate("02/28/2000");
        d1.increment();

        SimpleDate d2 = new SimpleDate(2, 29, 2000);
        Assert.assertEquals(d1, d2);
    }

    @Test
    public void testIncrementLoopAA(){
        SimpleDate d1 = new SimpleDate(2, 12, 1919);

        for (int i = 0; i < 500000; i++)
            d1.increment();

        Assert.assertTrue(d1.getMonth() == 1);
        Assert.assertTrue(d1.getDay() == 25);
        Assert.assertTrue(d1.getYear() == 3288);
    }

    @Test
    public void testDecrementDayBeforeAA(){
        SimpleDate d1 = new SimpleDate("05/19/1982");
        d1.decrement();

        Assert.assertTrue(d1.getMonth() == 5);
        Assert.assertTrue(d1.getDay() == 18);
        Assert.assertTrue(d1.getYear() == 1982);
    }

    @Test
    public void testDecrementLastMonth1AA(){
        SimpleDate d1 = new SimpleDate(2, 1, 2019);
        d1.decrement();

        Assert.assertTrue(d1.getMonth() == 1);
        Assert.assertTrue(d1.getDay() == 31);
        Assert.assertTrue(d1.getYear() == 2019);
    }

    @Test
    public void testDecrementLastMonth2AA(){
        SimpleDate d1 = new SimpleDate("10/001/2018");
        d1.decrement();

        Assert.assertTrue(d1.getMonth() == 9);
        Assert.assertTrue(d1.getDay() == 30);
        Assert.assertTrue(d1.getYear() == 2018);
    }

    @Test
    public void testDecrementLastYearAA(){
        SimpleDate d1 = new SimpleDate(1, 1, 2000);
        d1.decrement();

        Assert.assertTrue(d1.getMonth() == 12);
        Assert.assertTrue(d1.getDay() == 31);
        Assert.assertTrue(d1.getYear() == 1999);
    }

    @Test
    public void testDecrementLeapYear1AA(){
        SimpleDate d1 = new SimpleDate("03/01/2000");
        d1.decrement();

        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 29);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testDecrementLeapYear2AA(){
        SimpleDate d1 = new SimpleDate("03/01/2001");
        d1.decrement();

        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 28);
        Assert.assertTrue(d1.getYear() == 2001);
    }

    @Test
    public void testDecrementLoopAA(){
        SimpleDate d1 = new SimpleDate(2, 29, 1904);

        for (int i = 0; i < 50000; i++)
            d1.decrement();

        Assert.assertTrue(d1.getMonth() == 4);
        Assert.assertTrue(d1.getDay() == 7);
        Assert.assertTrue(d1.getYear() == 1767);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDecrementLoopFailAA(){
        SimpleDate d1 = new SimpleDate("3/28/1800");

        for (int i = 0; i < 50000; i++)
            d1.decrement();
    }

    @Test
    public void testDaysFromNow1AA(){
        SimpleDate d1 = new SimpleDate(1, 1, 2000);
        d1.daysFromNow(10);

        Assert.assertTrue(d1.getMonth() == 1);
        Assert.assertTrue(d1.getDay() == 11);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testDaysFromNow2AA(){
        SimpleDate d1 = new SimpleDate("02/12/2001");
        d1.daysFromNow(-49);

        Assert.assertTrue(d1.getMonth() == 12);
        Assert.assertTrue(d1.getDay() == 25);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testDaysFromNowLeapYear1AA(){
        SimpleDate d1 = new SimpleDate(3, 31, 2000);
        d1.daysFromNow(-31);

        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 29);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testDaysFromNowLeapYear2AA(){
        SimpleDate d1 = new SimpleDate(2, 20, 2000);
        d1.daysFromNow(9);

        Assert.assertTrue(d1.getMonth() == 2);
        Assert.assertTrue(d1.getDay() == 29);
        Assert.assertTrue(d1.getYear() == 2000);
    }

    @Test
    public void testInvalidDaysFromNowAA(){
        SimpleDate d1 = new SimpleDate(1, 1, 1754);
        d1.daysFromNow(-365);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidDaysFromNowAB(){
        SimpleDate d1 = new SimpleDate(1, 1, 1754);
        d1.daysFromNow(-366);
        System.out.println("CURRENT DATE>>>>"+d1.toString());
    }
    @Test
    public void testDaysSince1AA(){
        SimpleDate d1 = new SimpleDate(7, 28, 2000);
        SimpleDate d2 = new SimpleDate("1/15/2000");

        Assert.assertTrue(d1.daysSince(d2) == 195);
    }

    @Test
    public void testDaysSince2AA(){
        SimpleDate d1 = new SimpleDate(1, 15, 2000);
        SimpleDate d2 = new SimpleDate("7/28/2000");

        Assert.assertTrue(d1.daysSince(d2) == -195);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDaysSinceInvalidDate1AA(){
        SimpleDate d1 = new SimpleDate(7, 28, 2000);
        d1.daysSince(new SimpleDate(-1, 50, 1600));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDaysSinceInvalidDate2AA(){
        SimpleDate d1 = new SimpleDate("12/20/1985");
        d1.daysSince(new SimpleDate("50/20/1982"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDaysSinceNullDateAA(){
        SimpleDate d1 = new SimpleDate(7, 28, 2000);
        d1.daysSince(null);
    }

    @Test
    public void testSaveAndLoadAA(){
        SimpleDate d1 = new SimpleDate(2, 29, 2000);
        d1.save("simpledate.txt");

        d1.setDay(1,12,1990);

        SimpleDate d2 = new SimpleDate("3/03/1993");
        d2.load("simpledate.txt");

        Assert.assertTrue(d2.getMonth() == 2);
        Assert.assertTrue(d2.getDay() == 29);
        Assert.assertTrue(d2.getYear() == 2000);

        Assert.assertTrue(d1.getMonth() == 1);
        Assert.assertTrue(d1.getDay() == 12);
        Assert.assertTrue(d1.getYear() == 1990);
    }

    @Test
    public void testSaveFailAA(){
        SimpleDate d1 = new SimpleDate("02/29/2000");
        d1.save("!@#$%^&*()_+-0987??/");
    }

    @Test
    public void testLoadFailAA(){
        SimpleDate d1 = new SimpleDate("02/29/2000");
        d1.load("!@#$%^&*()_+-0987??/");
    }
}
