import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTestNG {

    WebDriver webDriver = null;
   @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");
   }

   @Test
    public void retrieveTitleTest(){

       System.out.println( webDriver.getTitle());
       Assert.assertEquals(webDriver.getTitle(),"Google");
   }

   @Test
    public void retrieveUrlTest(){
       System.out.println(webDriver.getCurrentUrl());
       Assert.assertEquals(webDriver.getCurrentUrl(),"[https://www.google.com/");
   }

   @BeforeMethod
    public void tearDown(){

       if(webDriver ==null)
       {
           webDriver.quit();
       }
   }
}
