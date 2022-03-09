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
    private String atributoChecked = "checked";
    private String atributoVisible = "enabled";

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

    public boolean ajustesVisible(){
        return inspeccionarAtributo(ajustes, atributoVisible);
    }

    public void clickAjustes(){
        darClick(ajustes,5);
    }

    public boolean opcionModoNocturnoVisible(){
        return inspeccionarAtributo(modoNocturno, atributoVisible);
    }

    public boolean estadoModoNocturno(){
        return inspeccionarAtributo(modoNocturno, atributoChecked);
    }

    public void clickModoNocturno(){
        darClick(modoNocturno,8);
    }

    public boolean menuVisible(){
        return inspeccionarAtributo(menu, atributoVisible);
    }

    public void clickMenu(){
        darClick(menu,5);
    }

    public void clickEn(String opcion){
        seleccionarElemento(opcionesMenu, "MENU OPCIONES",opcion);
    }

    public boolean masOpcionesVisible(){
        return inspeccionarAtributo(masOpciones, atributoVisible);
    }

    public void clickMasOpciones(){
        darClick(masOpciones,5);
    }

    public void elegirOpcion(String opcion){
        seleccionarElemento(opcionesMasOpciones, "MAS OPCIONES",opcion);
    }

    public boolean esperarPagina(String palabra){
        return tituloPaginaActual(pagina, palabra);
    }

    public String nombrePaginaActual(){
        return retornarTexto(pagina);
    }
}
