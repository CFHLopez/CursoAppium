package pages.agendaPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class HomePageAgenda extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;
    private String atributoVisible = "enabled";
    private String atributoClickable = "clickable";

    /**
     * Constructor
     */

    public HomePageAgenda(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Mi Agenda']")
    private MobileElement iconoMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView")
    private MobileElement textoSeccion;
    @AndroidFindBy(xpath = "//*[@content-desc='Buscar']")
    private MobileElement iconoBuscar;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtGrupo']")
    private MobileElement txtGrupo;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/FabAdd']")
    private MobileElement iconoAdd;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TitDialog']")
    private MobileElement textoVentana;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtTitulo']")
    private List <MobileElement> listaMenu;

    /**
     * Acciones
     */

   public boolean iconoMenuVisible(){
       return inspeccionarAtributo(iconoMenu, atributoVisible);
   }

   public boolean iconoMenuClickeable(){
       return inspeccionarAtributo(iconoMenu, atributoClickable);
   }

   public boolean textoSeccionVisible(){
       return inspeccionarAtributo(textoSeccion, atributoVisible);
   }

   public String textoVisibleSeccion(){
       return retornarTexto(textoSeccion);
   }

   public boolean textoVentanaVisible(){
       return inspeccionarAtributo(textoSeccion, atributoVisible);
   }

   public String textoVisibleVentana(){
       return retornarTexto(textoVentana);
   }

   public boolean textoGrupoVisible(){
       return inspeccionarAtributo(txtGrupo, atributoVisible);
   }

   public String textoVisibleGrupo(){
       return retornarTexto(txtGrupo);
   }

   public boolean iconoBuscarVisible(){
       return inspeccionarAtributo(iconoBuscar, atributoVisible);
   }

   public boolean iconoBuscarClickeable(){
       return inspeccionarAtributo(iconoBuscar, atributoClickable);
   }

   public boolean iconoAgregarVisible(){
       return inspeccionarAtributo(iconoAdd, atributoVisible);
   }

   public boolean iconoAgregarClickeable(){
       return inspeccionarAtributo(iconoAdd, atributoClickable);
   }

   public void darClickAgregar(){
       darClick(iconoAdd,5);
   }

   public void darClickBuscar(){
       darClick(iconoBuscar,5);
   }

   public void menuDarClickEn(String campo){
        seleccionarElemento(listaMenu, "MENU DISPONIBLE",campo);
   }

   public void cerrarVentana(){
       volver();
   }

   public void darClickMenu(){darClick(iconoMenu,5);}
}