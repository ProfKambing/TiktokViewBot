import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Level;


public class TiktokViewBot {

    static WebDriver driver;
    static String videoLink = "your tiktok link";

    public static void main(String[] args) {
        openWebsite();
        sleep(5000);
        doCaptcha();
        for (int i = 0; i < 5; i++) {
            doViewBot();
        }

    }

    static void openWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\JAVA PROJECTS\\chromedriver_win32\\chromedriver" + ".exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        driver = new ChromeDriver();
        driver.get("https://zefoy.com/");

    }

    static void doCaptcha() {
        try {
            driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div/div/div/div/button")).click();
        } catch (Exception e) {
            System.out.println("wow u skipepd the captcha without help so clever");
        }
    }

    static void doViewBot() {
        try {
            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[3]/div/div[4]/div/button")).click(); //click share button
        } catch (Exception e) {
            System.out.println("the captcha hasnt been done yet, redoing this shit");
            driver.close();
            main(new String[1]);
        }
        driver.findElement(By.xpath("/html/body/div[4]/div[5]/div/form/div/input")).sendKeys(videoLink);
        driver.findElement(By.xpath("//*[@id=\"sid4\"]/div/form/div/div/button")).click();
        sleep(4000);
        try {
            driver.findElement(By.cssSelector("#c2VuZC9mb2xsb3dlcnNfdGlrdG9V > div.row.text-light.d-flex.justify-content-center > div > form > button")).click();
            driver.navigate().refresh();
            System.out.println("sent views!");
        }catch (Exception e) {
            driver.navigate().refresh();
            System.out.println("timer not done yet, sleeping for 1.45 minute");
            sleep(87000);
        }

    }

    static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


