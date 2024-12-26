package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_BeforeAfterKullanmak {

    // testotomasyonu anasayfaya gidin
    // phone icin arama yapin
    // arama sonucunda urun bulunabildigini test edin

    /*
        @Test method'unda assertion failed olursa
        kod calismasi durur

        Eger driver'in kapatilmasi
        @Test method'u icerisinde olursa
        FAILED durumlarinda browser kapanmaz

        bu da istenen bir durum degildir
     */
    WebDriver driver;

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void aramaTesti(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        // 2- phone icin arama yapip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualSonucSayisi>10);

        //driver.quit();


    }
}