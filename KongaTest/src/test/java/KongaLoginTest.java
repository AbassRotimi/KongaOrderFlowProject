import org.apache.velocity.tools.view.VelocityLayoutServlet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class KongaLoginTest {
    //import Selenium Webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Konga Page URL
        driver.get("https://www.konga.com/");

        //Test1. Verify that the user input the right URL and is on the right webpage
        if(driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong webpage");
        Thread.sleep(3000);

        //3. Maximize the browser
        driver.manage().window().maximize();

        //4. Click on the login button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
    }
        @Test (priority = 0)
        public void postiveLogin() throws InterruptedException {
            //5. Input valid email in email field
            //Test1. Verify is user can sign in with valid details
            driver.findElement(By.id("username")).sendKeys("favorebube17@gmail.com");
            Thread.sleep(5000);
            //6. Input password in the password field
            driver.findElement(By.id("password")).sendKeys("Google22clau");
            Thread.sleep(5000);
            //7. Click on the login button
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(5000);
    }
        @Test (priority = 1)
        //8. Click on the Categories
        public void verifyCategories() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]")).click();
            //9. Click on "Computer and Accessories"
            //Test2 Verify if the user clicks on categories, user gets directed to the categories section.
            String expectedUrl = "https://www.konga.com/category/accessories-computing-5227";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong webpage");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
            Thread.sleep(7000);
            //10. CLick on the Laptop SubCatergory
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a")).click();
            Thread.sleep(5000);
        }

    @Test (priority = 2)
    public void AppleMackbook() throws InterruptedException {
            //11. CLick on the Apple MacBooks
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
            Thread.sleep(14000);
            //12. Add an item to the Cart
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[3]/div/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(7000);
            //Test2 Verify if the user clicks on categories, user gets directed to the categories section.
    }

    @Test (priority = 3)
    public void VerifyCart() throws InterruptedException {

            //13. Click on Cart
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
            Thread.sleep(7000);
            //14. Click on ChatFloat
            driver.findElement(By.xpath("/html/div/div/div[1]/button")).click();
            Thread.sleep(7000);
        }

    @Test (priority = 4)
    public void CheckOut() throws InterruptedException {
            //15. Click on CheckOut
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
            Thread.sleep(10000);
        String expectedUrl = "https://www.konga.com/checkout/complete-order";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong webpage");
Thread.sleep(7000);
    }

    @Test (priority = 5)
    public void DeliveryAddress() throws InterruptedException {
        //16. Select Click for Change(for Address)
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
            Thread.sleep(7000);
            //17. Click "Add Delivery Address"
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
            Thread.sleep(7000);
            //18. Select Address
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[2]/form/button")).click();
            Thread.sleep(5000);
            //19. Click Use this Address
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
            Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void Payment() throws InterruptedException {

            //20. Select a Card Payment Method
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
            Thread.sleep(5000);
            //21. Continue to make payment
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
            Thread.sleep(13000);

    }

    @Test (priority = 7)
    public void iFrame() throws InterruptedException {
            //22. Locate the iFrame element
            WebElement iFrame = driver.findElement(By.tagName("iframe"));
            //23. Switch focus to iFrame
            driver.switchTo().frame("kpg-frame-component");

            //24. Click the card button on the iFrame
            WebElement Cardbutton = driver.findElement(By.className("Card"));
            Cardbutton.click();
            Thread.sleep(4000);

            //25. Input Card Number
            WebElement CardNumber = driver.findElement(By.id("card-number"));
            Thread.sleep(2000);
            CardNumber.sendKeys("5594235686781846");
            Thread.sleep(7000);

            //26. Input Date
            WebElement Date = driver.findElement(By.id("expiry"));
            Date.sendKeys("08/26");
            Thread.sleep(4000);

            //27. Input CVV
            WebElement CVV = driver.findElement(By.id("cvv"));
            CVV.sendKeys("732");
            Thread.sleep(5000);

            //28. Print Out the error message:Invalid Card Number
            WebElement InvalidCardNumber = driver.findElement(By.id("card-number_unhappy"));
            System.out.println(InvalidCardNumber.getText());
            Thread.sleep(5000);

            //29. Close the iFrame that displays the input card Modal
            WebElement CloseiFrame = driver.findElement(By.className("data-card__close"));
            CloseiFrame.click();
            Thread.sleep(3000);

            //30. Switch out of iFrame
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
        }

        @AfterTest
        public void closeBrowser() {
        //31. Quit the browser.
        driver.quit();
    }
}
