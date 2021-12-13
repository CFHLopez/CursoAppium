package pages.wikidexPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class BusquedaPageWikidex extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;

    /**
     * Constructor
     */

    public BusquedaPageWikidex(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/search_src_text")
    private MobileElement casillaTexto;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    private List<MobileElement> listaResultados;

    /**
     * Acciones
     */

    public void llenarCasilla(String palabra){
        llenarCampo(casillaTexto,palabra);
        quitarTeclado();
    }

    public int cantidadDeResultados(){
        return contarElementos(listaResultados);
    }

    public void clickPrimerElemento(){
        seleccionarPrimerElemento(listaResultados);
    }
}
