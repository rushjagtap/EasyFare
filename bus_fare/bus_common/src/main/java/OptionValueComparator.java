import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.Comparator;

public class OptionValueComparator implements Comparator<FilterOption>, Serializable {

    private static final long serialVersionUID = 1;

    /**The compareTo() method compares two strings.
     * value1 and value2 representing an objects to be compared.
     * wrapper class
     */
    @Override
    public int compare(FilterOption o1, FilterOption o2) {

        String value1 = ifNull(o1, " " );
        String value2 = ifNull(o2, " " );

        // Convert string to double and compare doubles if value contains numbers
        // Otherwise compare string values
        if (containsNumber(value1) || containsNumber(value2)) {
            double d1 = convertToDouble(value1);
            double d2 = convertToDouble(value2);
            return Double.compare(d1, d2);
        } else {
            return (value1).compareTo(value2);

        }
    }

    /**
     * Returns the nullValue if the filterOption is null, in other case filterOption.getCount().
     *
     * @param filterOption  the filter option that is being checked if null
     * @param nullValue     null value to be returned if the flight option is null
     * @return              null if filter option is null, returns a non-null integer if not
     */
    public static String ifNull(FilterOption filterOption, String nullValue){
        String out;

        if(filterOption == null){
            out = nullValue;
        }else{
            out = filterOption.getValue();
        }

        return out;
    }

    /**
     *The containsNumber() method checks whether a string contains a sequence of digits.
     *
     * @param  s  The String to be searched for
     * @return    true if a specified sequence of digits is present in a given string,otherwise it returns false.
     */

    public static boolean containsNumber(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    containsDigit = true;
                    break;
                }
            }
        }
        return containsDigit;
    }

    /**
     * Converting string to double using parseDouble()
     *
     * @param s
     * @return   parseDouble(String) method of Double
     */

    public static double convertToDouble(String s) {

        // For mileage filter, unlimited is an option - assign 0 value
        if (s.toLowerCase().contains("unlimited")) {
            return 0.00;
        } else {
            return Double.parseDouble(s);
        }
    }

    @Test
    public  void testValue(){
        FilterOption filterOption = new FilterOption();
        filterOption.setValue("111");
        filterOption.setCount(0);
        FilterOption filterOption2 = new FilterOption();
        filterOption2.setValue("222");
        filterOption2.setCount(0);
        int acturalValue = compare(filterOption,filterOption2);
        System.out.println(acturalValue);
        Assert.assertEquals(-1,acturalValue);
    }
    @Test
    public  void convertToDoubleTest(){
        double result = convertToDouble("22.22");
        Assert.assertEquals(22.22,result,0.01);

    }

}
