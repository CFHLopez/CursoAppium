package pages.instagramPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class HomePage extends MetodosGenericos {

    /**
     * Variables
     */

    private String atributoLogo = "displayed";
    private AppiumDriver driver;

    /**
     * Constructor
     */

    public HomePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(id = "com.instagram.android:id/logo")
    private MobileElement logo;
    @AndroidFindBy(id = "com.instagram.android:id/language_selector_button")
    private MobileElement btnidioma;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    private List <MobileElement> opciones;
    @AndroidFindBy(id = "com.instagram.android:id/sign_up_with_email_or_phone")
    private MobileElement singUp;
    @AndroidFindBy(id = "com.instagram.android:id/log_in_button")
    private MobileElement login;

    /**
     * Acciones
     */

    public boolean visualizarLogo(){
        return inspeccionarAtributo(atributoLogo,logo);
    }

    public void darClickIdioma(){
        // System.out.println("Idioma Actual= "+retornarTexto(btnidioma));
        darClick(btnidioma);
    }

    public void seleccionarIdioma(String idioma){
        seleccionarElemento(opciones,idioma);
    }

    public String retornarTextoSingUp(){
        return retornarTexto(singUp);
    }

    public String retornarTextoLogin(){
        return retornarTexto(login);
    }

    public void darClickCrearNuevaCuenta(){
        darClick(singUp);
    }
}