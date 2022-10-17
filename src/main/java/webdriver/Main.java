package webdriver;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UV\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		// Atributos
		String dato;
		String datoUltimo;
		boolean bool = true;
		
		driver.get("http://www.pino.mx/act22/avanza.php");
		
		// Atributos WebElement
		WebElement txtDatoSig;
		WebElement txtDato;
		WebElement txtDatoUlt;
		WebElement btnEnviar;
		
		// mientras bool sea true...
		do
		{
			try
			{
				// obtener el dato siguiente
				txtDatoSig = driver.findElement(By.name("dato_siguiente"));
				dato = txtDatoSig.getAttribute("value");
				
				// escribir el dato obtenido dentro del cuadro de texto
				txtDato = driver.findElement(By.name("dato"));
				txtDato.sendKeys(dato);
				
				// hacer el submit
				btnEnviar = driver.findElement(By.id("botonSubmit"));
				btnEnviar.submit();
				
			} catch(Exception e)
			{
				// bool será false, por lo tanto se saldrá del ciclo
				bool = false;
			}
			
		} while(bool);
		
		txtDatoUlt = driver.findElement(By.name("ultimo"));
		datoUltimo = txtDatoUlt.getAttribute("value");
		
		// Mensaje de dialogo
		JOptionPane.showMessageDialog(null, "El ultimo dato es: "+datoUltimo);
		
	}
}
