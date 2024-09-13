package Edit.AutomationProject;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Clase2 {
	String url = "http://automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		

		//Abrir el navegador
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign")));
		
		// Paso 1: Hacer click en sign in
		WebElement lnkSignIn = driver.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		//Otra forma de hacerlo
		//driver.findElement(By.partialLinkText("Sign")).click();
		
		//String email = "test" + Math.random() + "@yopmail.com";
		
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		
		// Paso 2: Escribir el correo y hacer click en create an account		
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email_create']"));
		txtEmail.sendKeys(email);
		
		WebElement btnCreate = driver.findElement(By.cssSelector("#SubmitCreate"));
		btnCreate.click();
		
		//Es necesaria una espera porque el formulario tarda en cargar
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// Completar el formulario
		WebElement rbtMrs = driver.findElement(By.id("id_gender1"));
		rbtMrs.click();
		
		WebElement txtFirstName = driver.findElement(By.name("customer_firstname"));
		txtFirstName.sendKeys("Test");
		
		WebElement txtLastName = driver.findElement(By.id("customer_lastname"));
		txtLastName.sendKeys("Testing");
		
		WebElement txtPassword = driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("Test123");
		
		Select selDays = new Select (driver.findElement(By.id("days")));
		selDays.selectByVisibleText("9  ");
		
		Select selMonths = new Select (driver.findElement(By.id("months")));
		selMonths.selectByValue("10");
		
		Select selYears = new Select (driver.findElement(By.id("years")));
		selYears.selectByValue("1998");
		
		WebElement chkNewsletter = driver.findElement(By.cssSelector("#newsletter"));
		chkNewsletter.click();
				
		
		//Paso 4: Hacer click en el botón Register
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		
	}
}
