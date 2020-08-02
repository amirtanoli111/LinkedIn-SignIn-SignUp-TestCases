import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.devtools.browser.Browser.close;
//FA17-BSE-030
//ABDULLAH IQBAL

public class test {

    WebDriver w;
    String Expected_Title, Actual_Title, Current_url;

    public void startWebDriver(){
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        this.w = new ChromeDriver();

    }
    //=============================================================================================================================================//

    //LOGIN test cases

    @Test   //ASSUME TEST CASE
    public void Assume_testCase_Signin(){
        startWebDriver();
        w.get("https://www.linkedin.com/login");
        w.findElement(new By.ByXPath("//*[@id=\"username\"]")).sendKeys("abdullah@gmail.com");
        w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456789@.0");
        w.findElement(By.xpath("//*[@id=\"app__container\"]/main/div[2]/form/div[3]/button")).click();

        w.get("https://about.linkedin.com/"); //Without signin it went to about page

        this.Expected_Title = "LinkedIn Login, Sign in | LinkedIn";
        this.Actual_Title = w.getTitle();

        if (this.Expected_Title.equals(this.Actual_Title)){
            System.out.println("Test case passed");
        }
        else{
            System.out.println("Test case failed");
        }

    }

    @Test   //Pass
    public void Singin(){
        startWebDriver();
        w.get("https://www.linkedin.com/login");
        w.findElement(new By.ByXPath("//*[@id=\"username\"]")).sendKeys("abdullah@gmail.com");
        w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456789");
        w.findElement(By.xpath("//*[@id=\"app__container\"]/main/div[2]/form/div[3]/button")).click();

        this.Expected_Title = "LinkedIn";
        this.Actual_Title = w.getTitle();

        if (this.Expected_Title.equals(this.Actual_Title)){
            System.out.println("Test case passed");
        }
        else{
            System.out.println("Test case failed");
        }
    }
    @Test   //Fail
    public void Signin_wrong_pass(){
        startWebDriver();
        w.get("https://www.linkedin.com/login");
        w.findElement(new By.ByXPath("//*[@id=\"username\"]")).sendKeys("abdullah@gmail.com");
        w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test");
        w.findElement(By.xpath("//*[@id=\"app__container\"]/main/div[2]/form/div[3]/button")).click();

        this.Expected_Title = "LinkedIn Login, Sign in | LinkedIn";
        this.Actual_Title = w.getTitle();

        if (this.Expected_Title.equals(this.Actual_Title)){
            System.out.println("Test case passed");
        }
        else{
            System.out.println("Test case failed");
        }

    }

    //=============================================================================================================================================//

    //Sign up Test cases


    @Test   //Assume test case
    public void ASSUME_TestCase_Signup(){
        startWebDriver();
        w.get("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join");
        w.findElement(By.xpath("//*[@id=\"email-address\"]")).sendKeys("ab@gmail.com");
        w.findElement(new By.ByXPath("//*[@id=\"password\"]")).sendKeys("123456789@.0");

        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.findElement(new By.ByXPath("//*[@id=\"join-form-submit\"]")).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Current_url =w.getCurrentUrl();
        //System.out.println(a);

        if (this.Current_url.equals("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join")){
            w.findElement(new By.ByXPath("//*[@id=\"first-name\"]")).sendKeys("Abdullah");
            w.findElement(new By.ByXPath("//*[@id=\"last-name\"]")).sendKeys("     ");
            w.findElement(new By.ByXPath("//*[@id=\"join-form-submit\"]")).click();
            w.get("https://about.linkedin.com/");  //assume and without signup uit went to about page

            if (this.Current_url.equals("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join")){
                System.out.println("Test case passed");
            }
            else{
                System.out.println("Test case failed");
            }
        }
    }

    @Test   //Pass
    public void Signup(){
        startWebDriver();
        w.get("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join");
        w.findElement(By.xpath("//*[@id=\"email-address\"]")).sendKeys("abdullah@gmail.com");
        w.findElement(new By.ByXPath("//*[@id=\"password\"]")).sendKeys("123456789@.0");

        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.findElement(new By.ByXPath("//*[@id=\"join-form-submit\"]")).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.Current_url =w.getCurrentUrl();
        //System.out.println(a);

        if (this.Current_url.equals("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join")){
            w.findElement(new By.ByXPath("//*[@id=\"first-name\"]")).sendKeys("Abdullah");
            w.findElement(new By.ByXPath("//*[@id=\"last-name\"]")).sendKeys("iqbal");
            w.findElement(new By.ByXPath("//*[@id=\"join-form-submit\"]")).click();

        }
    }

    @Test   //Fail
    public void Signup_Empty_lastMane() {
        startWebDriver();
        w.get("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join");
        w.findElement(By.xpath("//*[@id=\"email-address\"]")).sendKeys("ab@gmail.com");
        w.findElement(new By.ByXPath("//*[@id=\"password\"]")).sendKeys("123456789@.0");

        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.findElement(new By.ByXPath("//*[@id=\"join-form-submit\"]")).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Current_url =w.getCurrentUrl();
        //System.out.println(a);

        if (this.Current_url.equals("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join")){
            w.findElement(new By.ByXPath("//*[@id=\"first-name\"]")).sendKeys("Abdullah");
            w.findElement(new By.ByXPath("//*[@id=\"last-name\"]")).sendKeys("     ");
            w.findElement(new By.ByXPath("//*[@id=\"join-form-submit\"]")).click();

            if (this.Current_url.equals("https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join")){
                System.out.println("Test case passed");
            }
            else{
                System.out.println("Test case failed");
            }
        }

    close();
    }


}
