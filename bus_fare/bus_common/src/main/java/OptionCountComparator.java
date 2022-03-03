import org.junit.Test;

import java.io.Serializable;
import java.util.Comparator;

public class OptionCountComparator implements Comparator<FilterOption>, Serializable {

    private static final long serialVersionUID = 1;


    @Override
    public int compare(FilterOption o1, FilterOption o2) {

        int count1 = ifNull(o1, -1 );
        int count2 = ifNull(o2, -1 );

        return Integer.compare(count1,count2);
    }

    /**
     * (x < y) ? -1 : ((x == y) ? 0 : 1);
     */
    @Test
    public  void test(){
        FilterOption filterOption = new FilterOption();
        filterOption.setValue("111");
        filterOption.setCount(0);
        FilterOption filterOption2 = new FilterOption();
        filterOption2.setValue("111");
        filterOption2.setCount(1);
        int result = compare(filterOption,filterOption2);
        System.out.println(result);
        FilterOption filterOption3 = new FilterOption();
        filterOption3.setValue("111");
        filterOption3.setCount(1);
        FilterOption filterOption4 = new FilterOption();
        filterOption4.setValue("111");
        filterOption4.setCount(1);
        result = compare(filterOption3,filterOption4);
        System.out.println(result);
        FilterOption filterOption5 = new FilterOption();
        filterOption5.setValue("111");
        filterOption5.setCount(2);
        FilterOption filterOption6 = new FilterOption();
        filterOption6.setValue("111");
        filterOption6.setCount(1);
        result = compare(filterOption5,filterOption6);
        System.out.println(result);
    }



    /**
     * Returns the nullValue if the filterOption is null, in other case filterOption.getCount().
     *
     * @param filterOption  the filter option that is being checked if null
     * @param nullValue     null value to be returned if the flight option is null
     * @return              null if filter option is null, returns a non-null integer if not
     */
    public static int ifNull(FilterOption filterOption, int nullValue){
        int out;

        if(filterOption == null){
            out = nullValue;
        }else{
            out = filterOption.getCount();
        }

        return out;
    }
}
