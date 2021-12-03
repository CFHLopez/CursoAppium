package utils;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MetodosGenericos {
    private AppiumDriver driver;
    public MetodosGenericos(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Metodos
     */
    public void esperaIxplicita(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Espera Implicita");
    }
    public String inspeccionarElemento(String atributo, MobileElement elemento){
        System.out.println("displayed= "+ elemento.getAttribute(atributo));
        return elemento.getAttribute(atributo);
    }
    public void darClick(MobileElement elemento){
        elemento.click();
    }
    public String retornarTexto(MobileElement elemento){
        return elemento.getText();
    }
    public void seleccionarElemento(List<MobileElement> lista, String palabra){
        // Recorremos la lista hasta encontrar la palabra requerida
        for (MobileElement elemeto: lista){
            if (elemeto.getText().contains(palabra)){
                // Hacemos click en el elemento buscado
                elemeto.click();
                // Al encontrar el elemento no necesitamos seguir buscando
                break;
            }
        }
    }
}
