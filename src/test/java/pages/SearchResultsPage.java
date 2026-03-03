package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By resultItems = By.cssSelector("article.post");
    private By noResults = By.cssSelector(".no-results");
    private By archiveTitle = By.cssSelector("section.ast-archive-description h1.page-title");
    private By mainElement = By.cssSelector("main#main.site-main");
    private By mensagemNenhumResultado = By.cssSelector("p");


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean existemResultados() {
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.presenceOfElementLocated(resultItems),
                    ExpectedConditions.presenceOfElementLocated(noResults)
            ));
            return !driver.findElements(resultItems).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public int getQuantidadeResultados() {
        return driver.findElements(resultItems).size();
    }

    public boolean validarMensagemResultado(String termoBuscado) {
        try {
            WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(archiveTitle));
            String textoEsperado = "Resultados encontrados para: " + termoBuscado;
            return titulo.getText().equals(textoEsperado);
        } catch (Exception e) {
            return false;
        }
    }

    public String getMensagemResultado() {
        try {
            WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(archiveTitle));
            return titulo.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean temMaisDeUmArtigo() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(mainElement));
            return getQuantidadeResultados() > 1;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean nenhumArtigoEncontrado() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(mainElement));
            return getQuantidadeResultados() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean exibeMensagemSemResultados() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(noResults));
            return driver.findElement(noResults).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getMensagemNenhumResultado() {
        try {
            WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemNenhumResultado));
            return mensagem.getText();
        } catch (Exception e) {
            return "";
        }
    }




}
