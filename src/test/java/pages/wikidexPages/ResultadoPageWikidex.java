package pages.wikidexPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class ResultadoPageWikidex extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;

    /**
     * Constructor
     */

    public ResultadoPageWikidex(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    private List <MobileElement> textosTextView;

    /**
     * Acciones
     */

    public String textoResultado(String palabra){
        return encontrarContenido(textosTextView,palabra);
    }

}
