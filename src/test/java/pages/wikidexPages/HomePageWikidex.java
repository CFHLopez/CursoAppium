package pages.wikidexPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class HomePageWikidex extends MetodosGenericos {

    /**
     * Variables
     */

    private String atributoLogo = "displayed";
    private AppiumDriver driver;

    /**
     * Constructor
     */

    public HomePageWikidex(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//*[@class='android.view.View']")
    private List <MobileElement> views;
    @AndroidFindBy(xpath = "//*[@text='Bienvenido a WikiDex']")
    private MobileElement mensaje;
    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/action_search")
    private MobileElement lupa;
    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/search_src_text")
    private MobileElement casillaTexto;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    private List<MobileElement> listaResultados;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and contains(text(),'Rayquaza')")
    private MobileElement texto;

    /**
     * Acciones
     */

    public String textoBienvenido(String palabra){
        return existeContenidoElemento(views,palabra);
    }

    public String contenidoTexto(){
        return retornarTexto(mensaje);
    }

    public void clickBuscar(){
        darClick(lupa);
    }

    public void llenarCasilla(String palabra){
        llenarCampo(casillaTexto,palabra);
    }

    public void clickElemento(String palabra){
        quitarTeclado();
        seleccionarElemento(listaResultados,palabra);
    }

    public String textoResultado(){
        return retornarTexto(texto);
    }
}