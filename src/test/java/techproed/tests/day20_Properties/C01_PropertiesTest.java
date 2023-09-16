package techproed.tests.day20_Properties;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PropertiesTest {
    @Test
    public void test01() {

        String url = ConfigReader.getProperty("amazonUrl");
        System.out.println(url);

        System.out.println(ConfigReader.getProperty("techproedUrl"));


    }
}
