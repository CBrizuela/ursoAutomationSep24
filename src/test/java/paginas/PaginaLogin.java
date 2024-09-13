package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy (id="email")
	WebElement txtEmail;
	
	@FindBy (id="passwd")
	WebElement txtContraseña;
	
	@FindBy (id="SubmitLogin")
	WebElement btnLogin;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirContraseña(String contraseña) {
		txtContraseña.sendKeys(contraseña);
	}
	
	public void hacerClickEnLogin() {
		btnLogin.click();
	}
}
