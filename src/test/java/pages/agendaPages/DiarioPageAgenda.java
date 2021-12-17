package pages.agendaPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class DiarioPageAgenda extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;
    private String atributoEnabled = "enabled";
    private String atributoClickable = "clickable";

    /**
     * Constructor
     */

    public DiarioPageAgenda(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tambucho.miagenda.trial:id/TxtFecha']")
    private MobileElement fechaCreada;
    @AndroidFindBy(xpath = "//android.view.View[@checked='true']")
    private MobileElement fechaDoc;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/FabOk']")
    private MobileElement btnOk;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tambucho.miagenda.trial:id/NuevoTexto']")
    private MobileElement agregarTexto;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/Texto']")
    private MobileElement cuadroTexto;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtTexto']")
    private MobileElement txtTexto;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtDia']")
    private MobileElement txtDia;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtMes']")
    private MobileElement txtMes;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/TxtAno']")
    private MobileElement txtAno;
    @AndroidFindBy(xpath = "//*[@content-desc='Exportar a Pdf']")
    private MobileElement iconoPDF;
    @AndroidFindBy(xpath = "//*[@content-desc='Color de Fondo']")
    private MobileElement iconoColor;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/FabEdit']")
    private MobileElement btnEditar;
    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/LayoutColor']")
    private List<MobileElement> listaDocsDiario;

    /**
     * Acciones
     */

    public void darClickFechaCreada(){
        darClick(fechaCreada);
    }

    public String fechaDocumento(){
        return retornarTexto(fechaDoc);
    }

    public String diaActual(){
        return retornarDiaActual();
    }

    public void darClickOk(){
        darClick(btnOk);
    }

    public String agregarTextoVisible(){
        return inspeccionarElemento(atributoEnabled,agregarTexto);
    }

    public String agregarTextoClickeable(){
        return inspeccionarElemento(atributoClickable,agregarTexto);
    }

    public void darClickAgregarTexto(){
        darClick(agregarTexto);
    }

    public void escribirTexto(String texto){
        llenarCampo(cuadroTexto,texto);
    }

    public int cantidadDocs(){
        return contarElementos(listaDocsDiario);
    }

    public String diaDoc(){
        return retornarTexto(txtDia);
    }

    public String mesDoc(){
        return retornarTexto(txtMes);
    }

    public String anoDoc(){
        return retornarTexto(txtAno);
    }

    public String textoDoc(){
        return retornarTexto(txtTexto);
    }

    public String iconoPDFVisible(){
        return inspeccionarElemento(atributoEnabled,iconoPDF);
    }

    public String iconoPDFClickeable(){
        return inspeccionarElemento(atributoClickable,iconoPDF);
    }

    public String iconoColorVisible(){
        return inspeccionarElemento(atributoEnabled,iconoColor);
    }

    public String iconoColorClickeable(){
        return inspeccionarElemento(atributoClickable,iconoColor);
    }

    public String btnEditarVisible(){
        return inspeccionarElemento(atributoEnabled,btnEditar);
    }

    public String btnEditarClickeable(){
        return inspeccionarElemento(atributoClickable,btnEditar);
    }
}
