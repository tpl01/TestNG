package techproed.tests.day22_DataProvider_XmlFile;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProviderConfigReader {
    @DataProvider
    public static Object[][] kullaniciBilgileri() {
        return new Object[][]{{ConfigReader.getProperty("email1"), ConfigReader.getProperty("password1")},
                {ConfigReader.getProperty("email2"), ConfigReader.getProperty("password2")},
                {ConfigReader.getProperty("email3"), ConfigReader.getProperty("password3")},
                {ConfigReader.getProperty("email4"), ConfigReader.getProperty("password4")}};
    }

    @Test(dataProvider = "kullaniciBilgileri")
    public void test01(String email,String password) {

        //BlueRentalCar Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


        //Login butonuna tıklayalım
        BlueRentalPage rentalPage=new BlueRentalPage();
        rentalPage.loginButton.click();
        ReusableMethods.bekle(2);

        //Dataprovider Kullanarak email ve password bilgileri ile login olalım
        rentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);



        //Sayfayı kapatalım
        Driver.closeDriver();
    }
}
