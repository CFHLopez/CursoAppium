package pages.wikidexPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class MenuPageWikidex extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;

    /**
     * Constructor
     */

    public MenuPageWikidex(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(id = "net.wikidex.www.wikidex:id/setting")
    private MobileElement ajustes;
    @AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='net.wikidex.www.wikidex:id/nightMode']")
    private MobileElement modoNocturno;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navegar hacia arriba']")
    private MobileElement menu;
    @AndroidFindBy(xpath = "//*[@resource-id='net.wikidex.www.wikidex:id/textTitle']")
    private MobileElement pagina;
    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView']")
    private MobileElement masOpciones;
    @AndroidFindBy(xpath = "//*[@class='android.widget.CheckedTextView']")
    private List <MobileElement> opcionesMenu;
    @AndroidFindBy(xpath = "//*[@resource-id='net.wikidex.www.wikidex:id/title']")
    private List <MobileElement> opcionesMasOpciones;

    /**
     * Acciones
     */

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

    public void clickMasOpciones(){
        esperarPaginaAleatoria(pagina);
        // se da click 2 veces en el panel debido a que se debe quitar el panel de menu
        darClick(masOpciones);
        darClick(masOpciones);
        esperaIxplicita();
    }

    public void elegirOpcion(String opcion){
        seleccionarElemento(opcionesMasOpciones,opcion);
    }

    public String esperarPagina(String palabra){
        return esperarPagina(pagina,palabra);
    }
}
