package utils;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import jdk.net.SocketFlow;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static reports.Report.addStep;

public class MetodosGenericos {
    private AppiumDriver driver;
    public MetodosGenericos(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Variables
     */
    int segundos = 10;

    /**
     * Metodos
     */
    private void esperaIxplicita(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Espera Implicita");
    }
    private boolean esperarObjeto(MobileElement elemento){
        try {
            System.out.println("Esperando elemento: "+elemento+", "+segundos+" segnudos, hasta que aparezca");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontro el elemento ("+elemento+"), se retorna true");
            return true;

        }catch (Exception e){
            System.out.println("No se encontró el elemento ("+elemento+"), se retorna false");
            return false;
        }
    }

    public String inspeccionarElemento(String atributo, MobileElement elemento){
        System.out.println("displayed= "+ elemento.getAttribute(atributo));
        return elemento.getAttribute(atributo);
    }

    public void darClick(MobileElement elemento){
        if(esperarObjeto(elemento)){
            elemento.click();
            esperaIxplicita();
            addStep("Click en elemento: "+elemento, false, Status.PASSED,false);
        }
        else{
            addStep("Click en elemento: "+elemento,false, Status.FAILED,false);
        }
    }

    public String retornarTexto(MobileElement elemento){
        return elemento.getText();
    }

    public void seleccionarElemento(List<MobileElement> lista, String palabra){
        // Recorremos la lista hasta encontrar la palabra requerida
        for (MobileElement elemeto: lista){
            if (elemeto.getText().contains(palabra)){
                // Hacemos click en el elemento buscado
                darClick(elemeto);
                // Al encontrar el elemento no necesitamos seguir buscando
                break;
            }
        }
    }
}
