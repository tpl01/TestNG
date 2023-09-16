package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_BlueRentalCarExcelTest {
    @Test
    public void excelTest() {
        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //Excel dosyasındaki herhangi bir kullanıcı adı ve password ile login olalım
        String dosyaYolu="src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi="customer_info";
        ExcelReader excelReader=new ExcelReader(dosyaYolu,sayfaIsmi);
        String email=excelReader.getCellData(2,0);
        String password=excelReader.getCellData(2,1);
        System.out.println(email +" || " +password);
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);

        //Girilen kullanıcı adı ile login olduğumuzu doğrulayalım
        ReusableMethods.bekle(2);
        blueRentalPage.profilButton.click();
        blueRentalPage.profil.click();
        ReusableMethods.bekle(2);
        String emailWebElement=blueRentalPage.profilEmail.getText();
        Assert.assertEquals(email,emailWebElement,"emailler uyumsuzdur");

        Driver.closeDriver();


    }
}
