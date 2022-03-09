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

    private AppiumDriver driver;
    private String atributoVisible = "enabled";

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

    @AndroidFindBy(xpath = "//*[@class='android.widget.Image']")
    private MobileElement imagen;
    @AndroidFindBy(xpath = "//*[@text='Bienvenido a WikiDex']")
    private MobileElement mensaje;
    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/action_search")
    private MobileElement lupa;
    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/search_src_text")
    private MobileElement casillaTexto;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    private List<MobileElement> listaResultados;

    /**
     * Acciones
     */

    public boolean cargaImagen(){
        return inspeccionarAtributo(imagen, atributoVisible);
    }

    public boolean textoVisible(){
        return inspeccionarAtributo(mensaje, atributoVisible);
    }

    public String contenidoTexto(){
        return retornarTexto(mensaje);
    }

    public boolean botonBuscarVisible(){
        return inspeccionarAtributo(lupa, atributoVisible);
    }

    public void clickBuscar(){
        darClick(lupa,10);
    }

    public boolean casillaTextoVisible(){
        return inspeccionarAtributo(casillaTexto, atributoVisible);
    }

    public void llenarCasilla(String palabra){
        ingresarTexto(casillaTexto,palabra);
    }

    public int cantidadDeResultados(){
        quitarTeclado();
        return contarElementos(listaResultados);
    }

    public void clickPrimerElemento(){
        seleccionarPrimerElemento(listaResultados);
    }
}
