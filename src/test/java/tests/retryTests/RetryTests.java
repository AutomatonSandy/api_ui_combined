package tests.retryTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RetryTests {

    @Test (dataProvider = "createData")
    public void test1(String key, boolean result){
        System.out.println(" test 1 method "+ result);
        Assert.assertTrue(result);
    }

    @Test(dataProvider = "createData")
    public void test2(String key, boolean result){
        System.out.println(" test 2 method "+result);
        Assert.assertFalse(result);
    }

    @DataProvider
    public Object[][] createData() {
        return new Object[][] {
                { "firstTry", true },
                { "secondTry", false },
                { "thirdTry", true }
        };
    }
}
