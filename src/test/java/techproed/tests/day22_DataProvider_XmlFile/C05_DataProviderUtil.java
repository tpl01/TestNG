package techproed.tests.day22_DataProvider_XmlFile;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtil;

public class C05_DataProviderUtil {
    /*

    TestNG frameWork'unda test class'larımızda genellikle sadece test methodlarımız olur. Dolayısıyla
dataprovider kullanacaksak, @DataProvider notasyonuna sahip methodu da başka bir classta oluşturabiliriz.
Bunun için @Test notasyanundan sonra dataProvider parametresi ile birlikte dataProviderClass parametresini
kullanarak @DataProvider notasyonuna sahip methodu belirttiğimiz class'da oluşturabiliriz

     */

    @Test(dataProvider = "veriler",dataProviderClass = DataProviderUtil.class)
    public void test01(String data) {
        System.out.println(data);
    }
}
