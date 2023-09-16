package techproed.tests.day22_DataProvider_XmlFile;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProvider {



    @Test(dataProvider = "veriler")
    public void test01(String data) {
        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //DataProvider ile istediğimiz arac isimlerini aratalım
        GooglePage page = new GooglePage();
        page.aramaKutusu.sendKeys(data, Keys.ENTER);

        //sayfayı kapatalım
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

    @Test(dataProvider = "veriler")
    public void test02(String data) {
        //amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().refresh();

        //aramakutusunda dataprovider'dan gelen verileri aratalım
        new AmazonPage().aramaKutusu.sendKeys(data,Keys.ENTER);

        //Her çıkan sonuctan sonra rastgele 5 ürüne tıklayıp tıklandığını doğrulayın

        //sayfayı kapatınız
        Driver.closeDriver();
    }
    @DataProvider(name = "araclar")
    public static Object[][] veriler() {

        return new Object[][]{{"honda"},{"ford"},{"audi"},{"volvo"},{"tesla"}};
    }

    @Test(dataProvider = "araclar")
    public void test03(String data) {
        System.out.println(data);
    }
}
