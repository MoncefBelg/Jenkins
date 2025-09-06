import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;


public class windowhandletest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.skyscanner.fr/?adgroupid=168158420112&associateID=SEM_FLI_19465_00000&campaign_id=21722220700&gad_campaignid=21722220700&gad_source=1&gbraid=0AAAAAD3oWFjAGrJ21F4FNgF-VbHirom49&gclid=CjwKCAjw_pDBBhBMEiwAmY02NkHeD8NxUfx6b4V31EaRbZS10J_7MC8ZXcM-N6z4Gjpbk4hy6lgRiRoCe_kQAvD_BwE&gclsrc=aw.ds&keyword_id=kwd-2916548846&previousCultureSource=COOKIE&redirectedFrom=www.skyscanner.net&utm_campaign=XY-Flights-Search-EN-Competitor&utm_medium=cpc&utm_source=google&utm_term=google+flights");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Add date'])[1]"))).click();


      Boolean found =false;

      while (!found){
         WebElement cMonth= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='June']")));
       // WebElement cMonth = driver.findElement(By.xpath("//div[normalize-space()='mai']"));
          String month = cMonth.getText();

        if (month.equals("July")){

            List<WebElement> days = driver.findElements(By.xpath("//div[@role='rowgroup']"));
            for (WebElement dates:days){
           String dt = dates.getText();
                System.out.println(dt);
                if (dt.contains("12")){
                    dates.click();
                    found=true;
                    break;
                }
            }
        }else {
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next month, July']//span//*[name()='svg']")));
            nextButton.click();

        }

      }



driver.close();



            }}

