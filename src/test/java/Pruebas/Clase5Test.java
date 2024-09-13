package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase5Test {

	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void Login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClickEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo@gmail.com");
		login.escribirContraseña("Test123");
		login.hacerClickEnLogin();
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
