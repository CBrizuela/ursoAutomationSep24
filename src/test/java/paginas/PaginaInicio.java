package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos de la Página
	@FindBy (partialLinkText = "Sign")
	WebElement lnkSignIn;
	
	@FindBy (id = "search_query_top")
	WebElement txtBuscador;
	
	@FindBy (name = "submit_search")
	WebElement btnBuscar;
	
	@FindBy (linkText = "Contact us")
	WebElement lnkContactUs;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Acciones sobre los elemetos de la página
	public void hacerClickEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabraABuscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClickEnBuscar() {
		btnBuscar.click();
	}
	
	public void hacerClickEnContactUs() {
		lnkContactUs.click();
	}
}
