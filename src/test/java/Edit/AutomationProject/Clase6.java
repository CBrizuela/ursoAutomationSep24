package Edit.AutomationProject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Clase6 {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void alertaNotificacion() {
		driver.findElement(By.id("alertButton")).click();;
		
		String textoAlerta = driver.switchTo().alert().getText();
		System.out.println(textoAlerta);
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void alertaDemorada() {
		driver.findElement(By.id("timerAlertButton")).click();;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void rechazarAlerta() {
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void escribirEnAlerta() {
		driver.findElement(By.id("promtButton")).click();
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Test");
		alerta.accept();
	}
	
	
	}
