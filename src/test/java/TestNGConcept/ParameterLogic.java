package TestNGConcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterLogic {
    @Parameters("firstName")
    @Test
    public void person(String name){
        System.out.println(name);
    }
    @Parameters({"firstName", "lastName", "zipCode"})
    @Test
    public void information(String name, String lastName, String zipCode){
        System.out.println(name + lastName + zipCode);
    }
}
