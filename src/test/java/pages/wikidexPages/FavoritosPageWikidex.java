package pages.wikidexPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class FavoritosPageWikidex extends MetodosGenericos {

    /**
     * Variables
     */

    private String atributoPaginaGuardada = "enabled";
    private AppiumDriver driver;

    /**
     * Constructor
     */

    public FavoritosPageWikidex(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//*[@resource-id='net.wikidex.www.wikidex:id/label']")
    private List <MobileElement> paginasGuardadas;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Eliminar']")
    private MobileElement btnEliminar;
    @AndroidFindBy(xpath = "//*[@resource-id='net.wikidex.www.wikidex:id/header']")
    private MobileElement noHayFavoritos;

    /**
     * Acciones
     */

    public int cantidadPaginasGuardadas(){
        return contarElementos(paginasGuardadas);
    }

    public void clickEliminar(){
        darClick(btnEliminar);
    }

    public String mensaje(){
        return retornarTexto(noHayFavoritos);
    }

    public String mensajeVisible(){
        return inspeccionarElemento(atributoPaginaGuardada,noHayFavoritos);
    }
}
