package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import paginas.PaginaContactUs;
import paginas.PaginaInicio;

public class Clase5bTest {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabraABuscar("dress");
		inicio.hacerClickEnBuscar();
	}
	
	@Test
	public void irAContactanos() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClickEnContactUs();
		
		PaginaContactUs contactUs = new PaginaContactUs(driver);
		contactUs.seleccionarSubject("Webmaster");
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		contactUs.escribirEmail(email);
		contactUs.escribirNumeroDeOrden("12345");
		contactUs.adjuntarArchivo("C:\\Users\\CBrizuela\\OneDrive\\Imágenes\\image.png");
		contactUs.escribirMensaje("Test");
		contactUs.ClickEnEnviar();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
