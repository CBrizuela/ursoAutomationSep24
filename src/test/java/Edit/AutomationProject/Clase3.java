package Edit.AutomationProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class Clase3 {
	String url = "http://www.automationpractice.pl";
	String dirEvidencias = "..\\AutomationProject\\Evidencias\\";
	File imagen;
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador(){
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1,description="CP01 - Ir a contactanos")
	public void irAContactanos() {
		
		// Hacer Click en Contact Us
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact us"));
		lnkContactUs.click();
		
		// Completar el formulario
		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys(email);
		
		WebElement txtOrder = driver.findElement(By.id("id_order"));
		txtOrder.sendKeys("1abc");
		
		WebElement fileAttached = driver.findElement(By.id("fileUpload"));
		fileAttached.sendKeys("C:\\Users\\CBrizuela\\OneDrive\\Imágenes\\image.png");
		
		WebElement txAMessage = driver.findElement(By.id("message"));
		txAMessage.sendKeys("Mensaje para contactar a la empresa");
		
		// Hacer click en send
		WebElement btnSend = driver.findElement(By.id("submitMessage"));
		btnSend.click();
		

	}
	
	@Test(priority=2,description="CP02 - Buscar palabra")
	public void buscarPalabra() throws IOException {
		//Captura evidenca
		imagen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(dirEvidencias + "01_pantallaPrincipal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//Captura evidenca
		imagen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(dirEvidencias + "02_palabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		//Captura evidencia
		imagen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(dirEvidencias + "03_resultadoObtenido.jpg"));
		
		//Comprobacion de resultado esperado: URL
		String urlActual = driver.getCurrentUrl();
		String urlEsperada = "http://www.automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		
		Assert.assertEquals(urlActual, urlEsperada);
		
		String tituloActual = driver.getTitle();
		String tituloEsperado = "Search - My Shop";
		
		Assert.assertEquals(tituloActual, tituloEsperado);
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//Cerrar pagina
		driver.close();
	}
}
