import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class EpamTest {


    @Test
    public void main() {
        //1 Create a new test
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Светлана\\IdeaProjects\\epam\\lab1\\drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        //2 Open test site by URL and Test has a name in accordance with checking functionality
        driver.get("https://jdi-framework.github.io/tests/");
        String res="";
        res+=driver.getCurrentUrl()+"\n";
        System.out.print(res);
        //Full window and download page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//загрузка страницы
        driver.manage().window().maximize();//размер окна
        //Assert Browser title
        String resTitle="Index Page";
        if (resTitle.equals(driver.getTitle())){
            System.out.println("Title correct");
        }
        //else System.out.print(driver.getTitle());
        else throw new NullPointerException (driver.getTitle());
        //найти элемент
        WebElement form = driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]"));
        //нажатие кнопки мыши
        Actions actionsClick =new Actions (driver);
        actionsClick.click(form).build().perform();
        //Perform login
        driver.findElement(By.xpath(".//*[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//i[@class='fa fa-sign-in']")).click();
        //Assert User name in the left-top side of screen that user is loggined
        String userName="PITER CHAILOVSKII";
        if (driver.findElements(By.xpath("//li/a/div/span")).size()==1){
            if (userName.equals(driver.findElement(By.xpath("//li/a/div/span")).getText()))
                System.out.println("PITER CHAILOVSKII");
        }
        //else System.out.print("Error with user name");
        else throw new NullPointerException ("Error with user name");
        //Assert Browser title
        String resTitleIndex="Index Page";
        if (resTitleIndex.equals(driver.getTitle())){
            System.out.println("Title correct");
        }
        //else System.out.print(driver.getTitle());
        else throw new NullPointerException(driver.getTitle());
        //Assert that there are 4 images on the Home Page and they are displayed
        if (driver.findElements(By.xpath("//div[@class='col-sm-3']")).size()==4){
            System.out.println("4 images on the Home Page found");
        }
        //else System.out.println("4 images is not found on the Home Page");
        else throw new NullPointerException("4 images is not found on the Home Page");
        //Assert that there are 4 texts on the Home Page and check them by getting texts
        String text1="To include good practices";
        String text2="To be flexible and";
        String text3="To be multiplatform";
        String text4="Already have good base";
        if (driver.findElements(By.xpath("//span[@class='benefit-txt']")).size()==4){
            System.out.println("Texts correct");
            if (text1.equals(driver.findElement(By.xpath("//span[text()='To include good practices']")).getText())){
                System.out.println("Text1 correct");
            }
            else throw new NullPointerException ("Error text1");
            if (text2.equals(driver.findElement(By.xpath("//span[text()='To be flexible and']")).getText())){
                System.out.println("Text2 correct");
            }
            else throw new NullPointerException ("Error text2");
            if (text3.equals(driver.findElement(By.xpath("//span[text()='To be multiplatform']")).getText())){
                System.out.println("Text3 correct");
            }
            else throw new NullPointerException ("Error text3");
            if (text4.equals(driver.findElement(By.xpath("//span[text()='Already have good base']")).getText())){
                System.out.println("Text4 correct");
            }
            else throw new NullPointerException ("Error text4");

        }
        else throw new NullPointerException ("Error texts");
        //Assert that there are the main header and the text below it on the Home Page
        String mainHeader = "EPAM framework Wishes…";
        if (mainHeader.equals(driver.findElement(By.xpath("//h3")).getText())){
            System.out.println("Main text correct");
        }
        else throw new NullPointerException ("Error main text");
        String belowText = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        if (belowText.equals(driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText())){
            System.out.println("Below text correct");
        }
        else throw new NullPointerException ("Error below text");
        //Browser is closed
        driver.quit();
    }
}
