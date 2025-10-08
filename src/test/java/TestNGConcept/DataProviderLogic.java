package TestNGConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLogic {
    @DataProvider(name = "pairs")
    public Object[][] getData() {
        return new Object[][]{
                {"Aliyah", "David"},
                {"Emi", "Mansour"},
                {"Naz", "Korean"}

        };
    }

    @Test(dataProvider = "pairs")
    public void pair1(String pair1, String pair2) {
        System.out.println(pair1 + pair2);
//    }
//    @Test
//    public void pair2(){
//        System.out.println("Emi" + "Mansour");
//    }
//    @Test
//    public void pair3(){
//        System.out.println("Naz" + "Korean");
//    }

    }
}
