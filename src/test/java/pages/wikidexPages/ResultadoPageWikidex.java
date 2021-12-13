package pages.wikidexPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

public class ResultadoPageWikidex extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;
    private String atributoImagen = "enabled";

    /**
     * Constructor
     */

    public ResultadoPageWikidex(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//*[contains(text(),'Ilustración de Rayquaza')]")
    private MobileElement imagen;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and contains(text(),'Rayquaza')")
    private MobileElement texto;

    /**
     * Acciones
     */
    public String esperarCargaImagen(){
        esperarElemento(imagen);
        return inspeccionarElemento(atributoImagen,imagen);
    }
    public String textoResultado(){
        return retornarTexto(texto);
    }
}
