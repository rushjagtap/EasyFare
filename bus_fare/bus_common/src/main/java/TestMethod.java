import org.junit.Assert;
import org.junit.Test;

public class TestMethod {

    @Test
    public  void convertToDoubleTest(){
        OptionValueComparator optionValueComparator = new OptionValueComparator();
        double result = optionValueComparator.convertToDouble("22.22");
        Assert.assertEquals(22.22,result,0.01);

    }

    @Test
    public  void convertToDoubleTest2(){
        OptionValueComparator optionValueComparator = new OptionValueComparator();
        double result = optionValueComparator.convertToDouble("unlimited");
        Assert.assertEquals(0.00,result,0.01);

    }

    @Test
    public  void convertToDoubleTest3(){
        OptionValueComparator optionValueComparator = new OptionValueComparator();
        boolean sha = optionValueComparator.containsNumber("sha2");
        boolean fff= optionValueComparator.containsNumber("fff");
        Assert.assertEquals(sha,fff);
    }

}
