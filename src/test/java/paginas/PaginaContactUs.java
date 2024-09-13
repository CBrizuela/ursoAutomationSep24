package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaContactUs {
	
	@FindBy (id = "id_contact")
	WebElement selSubject;
	
	@FindBy (id = "email")
	WebElement txtEmail;
	
	@FindBy (id = "id_order")
	WebElement txtOrder;
	
	@FindBy (id = "fileUpload")
	WebElement filAttached;
	
	@FindBy (id = "message")
	WebElement txtMessage;
	
	@FindBy (id = "submitMessage")
	WebElement btnEnviar;
	
	public PaginaContactUs (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void seleccionarSubject(String subject) {
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(subject);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirNumeroDeOrden(String orden) {
		txtOrder.sendKeys(orden);
	}
	
	public void adjuntarArchivo(String ubicacion) {
		filAttached.sendKeys(ubicacion);
	}
	
	public void escribirMensaje(String mensaje) {
		txtMessage.sendKeys(mensaje);
	}
	
	public void ClickEnEnviar() {
		btnEnviar.click();
	}
}
