package pages.instagramPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class RegistroPage extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;
    private String atributoMensaje = "displayed";

    /**
     * Constructor
     */

    public RegistroPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//*[@content-desc='Correo electrónico']")
    private MobileElement correo;
    @AndroidFindBy(id = "com.instagram.android:id/email_field")
    private MobileElement campoCorreo;
    @AndroidFindBy(id = "com.instagram.android:id/button_text")
    private MobileElement btnSiguiente;
    @AndroidFindBy(id = "com.instagram.android:id/notification_bar")
    private MobileElement mensajeAlerta;
    @AndroidFindBy(id = "com.instagram.android:id/igds_headline_headline")
    private MobileElement mensajeAdvertencia;
    @AndroidFindBy(id = "com.instagram.android:id/dialog_container")
    private MobileElement msnAdvertencia;

    /**
     * Acciones
     */

    public void darClickCorreoElectronico(){
        darClick(correo);
    }

    public void llenarCampoCorreoElectronico(String email){
        llenarCampo(campoCorreo,email);
    }

    public void darClickSiguiente(){
        darClick(btnSiguiente);
    }

    public boolean mensajeAlertaVisible(){
        return inspeccionarAtributo(atributoMensaje,mensajeAlerta);
    }

    public String contenidoMensajeAlerta(){
        return retornarTexto(mensajeAlerta);
    }

    public boolean mensajeAdvertenciaVisible(){
        return inspeccionarAtributo(atributoMensaje,msnAdvertencia);
    }

    public String contenidoMensajeAdvertencia(){
        return retornarTexto(mensajeAdvertencia);
    }
}
