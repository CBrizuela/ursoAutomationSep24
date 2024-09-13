package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase5cTest {

	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void Login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClickEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirContraseña(password);
		login.hacerClickEnLogin();
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel(){
		
	}
	
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos(){
		Object[][] datos = new Object[4][2];
		
		datos[0][0] = "test1@gmail.com";
		datos[0][1] = "Test123";
		
		datos[1][0] = "test2@gmail.com";
		datos[1][1] = "Test234";
		
		datos[2][0] = "test3@gmail.com";
		datos[2][1] = "Test345";
		
		datos[3][0] = "test4@gmail.com";
		datos[3][1] = "Test456";
		
		return datos;
	}
	
}
