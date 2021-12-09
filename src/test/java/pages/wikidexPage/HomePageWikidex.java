package pages.wikidexPage;

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

    private String atributoLogo = "displayed";
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

    @AndroidFindBy(xpath = "//*[@class='android.view.View' and contains(text(),'Bienvenido']")
    private MobileElement bienvenido;

    /**
     * Acciones
     */

    public String textoBienvenido(){
        return retornarTexto(bienvenido);
    }
}
