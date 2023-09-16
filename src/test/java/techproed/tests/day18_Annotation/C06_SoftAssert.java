package techproed.tests.day18_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {
    /*
         SoftAssertion kullanmak için önce SoftAssert class'ından bir obje oluştururuz. Ve bu obje ile daha önce
     assertion da kullandığımız aynı methodlar ile doğrulama yaparız. Ve yaptğımız assertionlar en son nerde
     assertAll methodu kullanırsak orda asertionların sonucunu bize verir
      */

    /*
    SoftAssertion, yazılım test otomasyonunda kullanılan bir kavramdır. Bu kavram,
    bir test senaryosunun belirli bir aşamasında hata oluşsa bile, testin devam etmesine izin verir.
    Yani, test senaryosu hata tespit ederse, hata mesajını kaydeder ancak testin geri kalanını çalıştırmaya devam eder.
    Bu, özellikle bir test senaryosunda birden fazla doğrulama (assertion) yapılması gerektiğinde faydalıdır.
    Eğer bir assertion başarısız olursa, bu diğer doğrulamaların da yapılmasını engellemez.
    Özetle, SoftAssertion, test senaryolarının devam etmesine olanak tanırken hataları raporlamayı sağlar. Bu, test senaryolarının daha esnek ve verimli olmasını sağlar.
     */
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //başlığın alışveris içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("alisveris"));


        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        softAssert.assertEquals(2,2);

        //sonuç yazısının iphone içerdiğini test edelim
        String sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));
        softAssert.assertTrue(false);
        softAssert.assertAll();

        /*
        assetALL()
        Bu yaklaşım, bir test senaryosunda birden fazla doğrulamanın yapılması gerektiği durumlarda kullanılır.
        Eğer herhangi bir doğrulama başarısız olursa, bu diğer doğrulamaların da yapılmasına engel olmaz.
        Ancak, assertAll() çağrıldığında başarısız olan doğrulamalar raporlanır.
         */


    }
}