package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchIcon = By.cssSelector("a.slide-search.astra-search-icon");
    private By searchInput = By.cssSelector("input.search-field[type='search']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public HomePage clicarNaLupa() {
        int tentativas = 3;
        for (int i = 0; i < tentativas; i++) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchIcon));

                // Clica usando JavaScript (mais confiável para elementos com animação)
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);

                // Aguarda o input existir no DOM e estar visível
                wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));
                wait.until(driver -> {
                    WebElement input = driver.findElement(searchInput);
                    return input.isDisplayed() && input.isEnabled();
                });

                break;
            } catch (StaleElementReferenceException | TimeoutException e) {
                if (i == tentativas - 1) throw e;
            }
        }
        return this;
    }

    public SearchResultsPage buscar(String texto) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));

        // Garante que o input está visível antes de digitar
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", input);

        input.clear();
        input.sendKeys(texto);
        input.sendKeys(Keys.ENTER);

        return new SearchResultsPage(driver);
    }
}

