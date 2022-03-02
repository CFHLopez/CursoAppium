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
    private String atributoEnabled = "enabled";
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
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtTitulo']")
    private List <MobileElement> listaMenu;

    /**
     * Acciones
     */

   public boolean iconoMenuVisible(){
       return inspeccionarAtributo(atributoEnabled,iconoMenu);
   }

   public boolean iconoMenuClickeable(){
       return inspeccionarAtributo(atributoClickable,iconoMenu);
   }

   public boolean textoSeccionVisible(){
       return inspeccionarAtributo(atributoEnabled,textoSeccion);
   }

   public String textoVisibleSeccion(){
       return retornarTexto(textoSeccion);
   }

   public boolean textoGrupoVisible(){
       return inspeccionarAtributo(atributoEnabled,txtGrupo);
   }

   public String textoVisibleGrupo(){
       return retornarTexto(txtGrupo);
   }

   public boolean iconoBuscarVisible(){
       return inspeccionarAtributo(atributoEnabled,iconoBuscar);
   }

   public boolean iconoBuscarClickeable(){
       return inspeccionarAtributo(atributoClickable,iconoBuscar);
   }

   public boolean iconoAgregarVisible(){
       return inspeccionarAtributo(atributoEnabled,iconoAdd);
   }

   public boolean iconoAgregarClickeable(){
       return inspeccionarAtributo(atributoClickable,iconoAdd);
   }

   public void darClickAgregar(){
       darClick(iconoAdd);
   }

    public void darClickMenu(){
        darClick(iconoMenu);
    }

    public void menuDarClickEn(String campo){
       seleccionarElemento(listaMenu,campo);
    }
}