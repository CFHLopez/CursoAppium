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

    private String atributoLogo = "enabled";
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

    @AndroidFindBy(xpath = "//*[@class='android.widget.Image']")
    private MobileElement imagen;
    @AndroidFindBy(xpath = "//*[@text='Bienvenido a WikiDex']")
    private MobileElement mensaje;
    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/action_search")
    private MobileElement lupa;
    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/setting")
    private MobileElement ajustes;
    @AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='net.wikidex.www.wikidex:id/nightMode']")
    private MobileElement modoNocturno;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navegar hacia arriba']")
    private MobileElement menu;
    @AndroidFindBy(xpath = "//*[@class='android.widget.CheckedTextView']")
    private List <MobileElement> opcionesMenu;

    /**
     * Acciones
     */

    public String cargaImagen(){
        esperarElemento(imagen);
        return inspeccionarElemento(atributoLogo,imagen);
    }

    public String contenidoTexto(){
        return retornarTexto(mensaje);
    }

    public void clickBuscar(){
        darClick(lupa);
    }

    public void clickAjustes(){
        darClick(ajustes);
    }

    public void clickModoNocturno(){
        darClick(modoNocturno);
    }

    public void clickMenu(){
        darClick(menu);
    }

    public void clickEn(String opcion){
        seleccionarElemento(opcionesMenu,opcion);

    }
}
