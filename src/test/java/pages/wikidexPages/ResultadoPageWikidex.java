package pages.wikidexPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class ResultadoPageWikidex extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;

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

    @AndroidFindBy(xpath = "//*[@resource-id='net.wikidex.www.wikidex:id/textTitle']")
    private MobileElement contenedor;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    private List <MobileElement> textosTextView;
    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView']")
    private MobileElement masOpciones;
    @AndroidFindBy(xpath = "//*[@resource-id='net.wikidex.www.wikidex:id/title']")
    private List <MobileElement> opcionesMasOpciones;

    /**
     * Acciones
     */
    public String esperarContenedor(String palabra){
        return esperarPagina(contenedor,palabra);
    }

    public String textoResultado(String palabra){
        return encontrarContenido(textosTextView,palabra);
    }

    public void clickMasOpciones(){
        esperarPaginaAleatoria(contenedor);
        // se da click 2 veces en el panel debido a que se debe quitar el panel de menu
        darClick(masOpciones);
        darClick(masOpciones);
        esperaIxplicita();
    }

    public void clickEn(String opcion){
        seleccionarElemento(opcionesMasOpciones,opcion);
    }
}
