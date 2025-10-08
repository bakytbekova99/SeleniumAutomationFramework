package TestNGConcept;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiplication (int num1, int num2){
        return num1*num2;
    }
    @Test
    public void validateHappyPathMultiplication(){
        int actualResult = multiplication(3, 5);
        int expectedResult = 15;
        Assert.assertEquals(actualResult,expectedResult);

    }
    @Test
    public void validateZerLogic(){
        int actualResult = multiplication(0, 999999);
        int expectedResult = 1;
        Assert.assertTrue(actualResult == expectedResult);

    }
}
