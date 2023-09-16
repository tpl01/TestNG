package techproed.tests.day20_Properties;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_ClassWork {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        ReusableMethods.bekle(2);

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        centerPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        centerPage.loginButton.click();
        ReusableMethods.bekle(2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.verify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logOut.click();
        softAssert.assertTrue(centerPage.logOutVerify.isDisplayed());
        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        ReusableMethods.bekle(2);

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"), Keys.TAB,ConfigReader.getProperty("techpro_test_password"),Keys.ENTER);
        ReusableMethods.bekle(2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.verify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logOut.click();
        softAssert.assertTrue(centerPage.logOutVerify.isDisplayed());

       ////Sayfadan cikis yap ve cikis yapildigini test et
       //centerPage.logout.click();
       //softAssert.assertEquals("Login",Driver.getDriver().getTitle());

        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();
    }

    @Test
    public void test03() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        String url = ConfigReader.getProperty("testCenterUrl");
        Driver.getDriver().get(url);
        ReusableMethods.bekle(2);

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        String kullaniAdi = ConfigReader.getProperty("techpro_test_username");
        String password = ConfigReader.getProperty("techpro_test_password");
        centerPage.username.sendKeys(kullaniAdi, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.verify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logOut.click();
        softAssert.assertTrue(centerPage.logOutVerify.isDisplayed());
        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();
    }
}
