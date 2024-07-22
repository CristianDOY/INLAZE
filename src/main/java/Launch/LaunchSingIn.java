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

public class LaunchSingIn {
	
	public JavascriptExecutor jse;
	
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
            // Navegar a la página de inicio de sesión
            driver.get("https://test-qa.inlaze.com/auth/sign-in");

            // Crear una instancia de WebDriverWait con un tiempo de espera en segundos
            WebDriverWait wait = new WebDriverWait(driver, 10);
            
           
         // Esperar a que el campo de correo electrónico esté presente y sea clickeable
            WebElement emailField = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.id("email")));
            emailField.sendKeys("cristian.david@example.com"); // Reemplaza con el email correcto

            WebElement pass = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.id("email")));
            ((JavascriptExecutor) driver).executeScript("document.querySelector('#password').value = 'Alemania2023@';", pass);

            // Esperar a que el botón de inicio de sesión esté presente
            WebElement loginButton = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            // Usar JavaScript para hacer clic en el botón de inicio de sesión
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

            // Esperar a que el nombre del usuario esté presente después del inicio de sesión
            WebElement userName = wait.until((Function<WebDriver, WebElement>)ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='user-name']")));
            System.out.println("Inicio de sesión exitoso. Usuario: " + userName.getText());

        } finally {
            // Cerrar el navegador
            driver.quit();
        }

    }
	
}

