package Edit.AutomationProject;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clase1 {
	//Atributos o variables de uso común
	String url = "http://automationpractice.pl";

	// Método de prueba
	@Test
	public void buscarPalabraChrome() {
		//Define que navegador usar
		WebDriver driver = new ChromeDriver();
		
		//Abre el navegador en la url indicada
		driver.get(url); // o driver.navigate().to(url);
		driver.manage().window().maximize();// Maximiza el navegador
		driver.manage().deleteAllCookies();//Borra las cookies
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")));
		
		//Escribe una palabra en el buscador de la página
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//Realiza la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simula que se presiona la tecla ENTER
		driver.close(); //Cierra la ventana actual
		//driver.quit(); //Cierra todas las ventanas abiertas con el script
}
	
	@Test
	public void buscarPalabraFirefox() {
		//Define que navegador usar
		WebDriver driver = new FirefoxDriver();
		
		//Abre el navegador en la url indicada
		driver.get(url);
		
		//Escribe una palabra en el buscador de la página
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//Realiza la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simula que se presiona la tecla ENTER
		
}
	
	@Test
	public void buscarPalabraEdge() {
		//Define que navegador usar
		WebDriver driver = new EdgeDriver();
		
		//Abre el navegador en la url indicada
		driver.get(url);
		
		//Escribe una palabra en el buscador de la página
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//Realiza la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simula que se presiona la tecla ENTER
		
}	
}
