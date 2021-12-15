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
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/FabFiltro']")
    private MobileElement iconoFiltro;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtGrupo']")
    private MobileElement txtGrupo;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/FabAdd']")
    private MobileElement iconoAdd;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtTitulo']")
    private List <MobileElement> listaMenu;

    /**
     * Acciones
     */

   public String iconoMenuVisible(){
       return inspeccionarElemento(atributoEnabled,iconoMenu);
   }

   public String iconoMenuClickeable(){
       return inspeccionarElemento(atributoClickable,iconoMenu);
   }

   public String textoSeccionVisible(){
       return inspeccionarElemento(atributoEnabled,textoSeccion);
   }

   public String textoVisibleSeccion(){
       return retornarTexto(textoSeccion);
   }

   public String textoGrupoVisible(){
       return inspeccionarElemento(atributoEnabled,txtGrupo);
   }

   public String textoVisibleGrupo(){
       return retornarTexto(txtGrupo);
   }

   public String iconoBuscarVisible(){
       return inspeccionarElemento(atributoEnabled,iconoBuscar);
   }

   public String iconoBuscarClickeable(){
       return inspeccionarElemento(atributoClickable,iconoBuscar);
   }

   public String iconoFiltroVisible(){
       return inspeccionarElemento(atributoEnabled,iconoFiltro);
   }

   public String iconoFiltroClickeable(){
       return inspeccionarElemento(atributoClickable,iconoFiltro);
   }

   public String iconoAgregarVisible(){
       return inspeccionarElemento(atributoEnabled,iconoAdd);
   }

   public String iconoAgregarClickeable(){
       return inspeccionarElemento(atributoClickable,iconoAdd);
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