import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue; // Assurez-vous d'importer cette ligne

public class WebTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Assurez-vous d'avoir le driver Chrome dans votre PATH
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\formations\\chromedriver-win64\\chromedriver.exe");

    }

   /* @Test
    public void testGoogleSearch() {
        System.setProperty("webdriver.chrome.driver", "C:\\formations\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("JUnit 5");
        driver.findElement(By.name("q")).submit();
       // Assertions.assertTrue(driver.getTitle().contains("JUnit 5"));
    }*/

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        // Attendre que le champ de recherche soit cliquable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

        // Saisir le texte dans le champ avec Javascript si nécessaire
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='JUnit 5';", searchBox);
        searchBox.submit(); // Soumettre le formulaire

        // Attendre que le titre contienne "JUnit 5"
        wait.until(ExpectedConditions.titleContains("JUnit 5"));

        // Vérifier que le titre de la page contient "JUnit 5"
        assertTrue(driver.getTitle().contains("JUnit 5"));
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
