package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.function.Function;

public class LaunchSingUp {
	public static void main(String[] args) {
        // Configuración del ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/temp/WebDriver/chromedriver.exe"); // Reemplaza con la ruta correcta a chromedriver

        // Opciones del navegador (opcional)
        ChromeOptions options = new ChromeOptions();
        // Opcional: Añadir argumentos si es necesario
        // options.addArguments("--headless");

        // Inicialización del navegador
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navegar a la página de registro
            driver.get("https://test-qa.inlaze.com/auth/sign-up");

            // Crear una instancia de WebDriverWait con un tiempo de espera en segundos
            WebDriverWait wait = new WebDriverWait(driver, 10);

         // Esperar a que el botón de registro esté presente
            WebElement signUpButtonini = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/span/a")));
            // Usar JavaScript para hacer clic en el botón de registro
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButtonini);
            
            // Esperar a que el campo de nombre completo esté presente y sea clickeable
            WebElement nameField = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.id("name")));
            nameField.sendKeys("Cristian David"); // Reemplaza con el nombre completo

            // Esperar a que el campo de correo electrónico esté presente y sea clickeable
            WebElement emailField = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.id("email")));
            emailField.sendKeys("cristian.david@example.com"); // Reemplaza con el email correcto

            // Esperar a que el campo de contraseña esté presente y sea clickeable
            WebElement passwordField = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.id("password")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='Alemania2023@';", passwordField);

            // Esperar a que el campo de repetir contraseña esté presente y sea clickeable
            WebElement confirmPasswordField = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.id("confirmPassword")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='Alemania2023@';", confirmPasswordField);

            // Esperar a que el botón de registro esté presente
            WebElement signUpButton = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            // Usar JavaScript para hacer clic en el botón de registro
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButton);

            // Esperar a que el mensaje de registro exitoso esté presente
            WebElement successMessage = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success-message']")));
            System.out.println("Registro exitoso: " + successMessage.getText());

        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}
