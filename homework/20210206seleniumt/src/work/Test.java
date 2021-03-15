package work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);

    @ParameterizedTest
    @CsvFileSource(resources = "login.csv", delimiter = ',')
    public void test(String name, String password) throws InterruptedException {
        App test = new App(name, password);
        String result = test.selenium();
        Assert.assertEquals(result, "接收验证码");
    }

}
