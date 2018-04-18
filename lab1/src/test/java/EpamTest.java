import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class EpamTest {
    String res = "https://jdi-framework.github.io/tests/index.htm";
    String resTitle = "Index Page";
    String userName = "PITER CHAILOVSKII";
    String text1 = "To include good practices";
    String text2 = "To be flexible and";
    String text3 = "To be multiplatform";
    String text4 = "Already have good base";
    String mainHeader = "EPAM framework Wishes…";
    String belowText = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

    private WebDriver driver;

    @Before
    public void BeforeTest() {
        //1 Create a new test
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Светлана\\IdeaProjects\\epam\\lab1\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Full window and download page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//загрузка страницы
        driver.manage().window().maximize();//размер окна
    }

    @Test
    public void OpenSite() {
        //2 Open test site by URL and Test has a name in accordance with checking functionality
        driver.get("https://jdi-framework.github.io/tests/");
        Assert.assertEquals(driver.getCurrentUrl(), res);
    }

    @Test
    public void BrowserAssert() {
        //Assert Browser title
        Assert.assertEquals(driver.getTitle(), resTitle);

    }

    @Test
    public void LogIn() {
        //найти элемент
        WebElement form = driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]"));
        //нажатие кнопки мыши
        Actions actionsClick = new Actions(driver);
        actionsClick.click(form).build().perform();
        //Perform login
        driver.findElement(By.xpath(".//*[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//i[@class='fa fa-sign-in']")).click();
        //Assert User name in the left-top side of screen that user is loggined
        Assert.assertTrue(driver.findElements(By.xpath("//li/a/div/span")).size() == 1);
        Assert.assertEquals(driver.findElement(By.xpath("//li/a/div/span")).getText(), userName);

    }

    @Test
    public void PageObject() {
        //Assert that there are 4 images on the Home Page and they are displayed
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='col-sm-3']")).size() == 4);
        Assert.assertEquals(driver.getTitle(), resTitle);

        //Assert that there are 4 texts on the Home Page and check them by getting texts
        Assert.assertTrue(driver.findElements(By.xpath("//span[@class='benefit-txt']")).size() == 4);
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='To include good practices']")).getText(), text1);
        Assert.assertEquals(text2, driver.findElement(By.xpath("//span[text()='To be flexible and']")).getText());
        Assert.assertEquals(text3, driver.findElement(By.xpath("//span[text()='To be flexible and']")).getText());
        Assert.assertEquals(text4, driver.findElement(By.xpath("//span[text()='To be flexible and']")).getText());
    }

    @Test
    public void Header() {
        //Assert that there are the main header and the text below it on the Home Page
        Assert.assertEquals(mainHeader, driver.findElement(By.xpath("//h3")).getText());
        Assert.assertEquals(belowText, driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText());
    }

    @After
    public void CloseBrowser() {
        //Browser is closed
        driver.quit();
        //ctr+alt+shift+l
    }
}
