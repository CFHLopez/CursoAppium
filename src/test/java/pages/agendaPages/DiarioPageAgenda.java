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
    private String atributoVisible = "enabled";
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

    @AndroidFindBy(xpath = "//*[@resource-id='com.tambucho.miagenda.trial:id/FabFiltro']")
    private MobileElement iconoFiltro;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tambucho.miagenda.trial:id/TxtFecha']")
    private MobileElement fechaCreada;
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
    @AndroidFindBy(xpath = "//*[@class='android.widget.LinearLayout']")
    private List<MobileElement> listaColores;

    /**
     * Acciones
     */

    public boolean iconoFiltroVisible(){
        return inspeccionarAtributo(iconoFiltro, atributoVisible);
    }

    public boolean iconoFiltroClickeable(){
        return inspeccionarAtributo(iconoFiltro, atributoClickable);
    }

    public void darClickIconoFiltro(){
        darClick(iconoFiltro, 5);
    }

    public boolean registroCreadoVisible(){
        return inspeccionarAtributo(fechaCreada, atributoVisible);
    }

    public boolean registroCreadoClickeable(){
        return  inspeccionarAtributo(fechaCreada, atributoClickable);
    }

    public void darClickFechaCreada(){
        darClick(fechaCreada, 5);
    }

    public String diaActual(){
        return retornarDiaActual();
    }

    public void darClickOk(){
        darClick(btnOk, 5);
    }

    public boolean agregarTextoVisible(){
        return inspeccionarAtributo(agregarTexto, atributoVisible);
    }

    public boolean agregarTextoClickeable(){
        return inspeccionarAtributo(agregarTexto, atributoClickable);
    }

    public void darClickAgregarTexto(){
        darClick(agregarTexto, 5);
    }

    public String contenidoCuadroTexto(){
        return retornarTexto(cuadroTexto);
    }

    public void escribirTexto(String texto){
        ingresarTexto(cuadroTexto,texto);
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

    public boolean iconoPDFVisible(){
        return inspeccionarAtributo(iconoPDF, atributoVisible);
    }

    public boolean iconoPDFClickeable(){
        return inspeccionarAtributo(iconoPDF, atributoClickable);
    }

    public boolean iconoColorVisible(){
        return inspeccionarAtributo(iconoColor, atributoVisible);
    }

    public boolean iconoColorClickeable(){
        return inspeccionarAtributo(iconoColor, atributoClickable);
    }

    public boolean btnEditarVisible(){
        return inspeccionarAtributo(btnEditar, atributoVisible);
    }

    public boolean btnEditarClickeable(){
        return inspeccionarAtributo(btnEditar, atributoClickable);
    }

    public void darClickIconoColor(){
        darClick(iconoColor, 10);
    }

    public void seleccionarColorAleatorio(){
        seleccionarAleatorio(listaColores);
    }
}
