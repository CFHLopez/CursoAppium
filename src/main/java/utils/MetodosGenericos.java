package utils;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import io.qameta.allure.util.PropertiesUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static reports.Report.addStep;

public class MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;
    private int segundos = 10;

    /**
     * Constructor
     */

    public MetodosGenericos(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Metodos
     * @return
     */

    public String readPropertiesFiles(String apk){
        // buscamos la direccion de la apk
        ClassLoader classLoader = PropertiesUtils.class.getClassLoader();
        // con la siguiente linea nos retorna lo siguiente (en mi caso)
        // /C:/Users/chris/IdeaProjects/CursoAppium/out/production/resources/Instagram.apk
        String path = classLoader.getResource(apk).getPath();
        // necesitamos cambiar / por \\
        // eliminamos los / y agregamos los caracteres a un arreglo
        String [] arreglo = path.split("/");
        // creamos un arreglo para retornar la direccion arreglada
        String direccion = new String();
        // comenzamos desde la posicion 1 dado que 0 es vacio
        for (int i=1;i<arreglo.length;i++){
            // agregamos lo que contiene el arreglo
            direccion = direccion + arreglo[i];
            // agregamos -> \\
            direccion = direccion + "\\\\";
        }
        // retornamos la direccion modificada
        return direccion;
    }

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
        // System.out.println("displayed= "+ elemento.getAttribute(atributo));
        if(elemento.getAttribute(atributo).contains("true")){
            esperaIxplicita();
            addStep("Elemento visible", true, Status.PASSED,false);
            return elemento.getAttribute(atributo);
        }
        else{
            addStep("Elemento oculto",true, Status.FAILED,false);
            return "false";
        }
    }

    public void darClick(MobileElement elemento){
        if(esperarObjeto(elemento)){
            elemento.click();
            esperaIxplicita();
            addStep("Click en elemento: "+elemento, true, Status.PASSED,false);
        }
        else{
            addStep("Click en elemento: "+elemento,true, Status.FAILED,false);
        }
    }

    public String retornarTexto(MobileElement elemento){
        return elemento.getText();
    }

    public void seleccionarElemento(List<MobileElement> lista, String palabra){
        // Recorremos la lista hasta encontrar la palabra requerida
        for (MobileElement elemento: lista){
            if (elemento.getText().contains(palabra)){
                // Hacemos click en el elemento buscado
                darClick(elemento);
                // Al encontrar el elemento no necesitamos seguir buscando
                break;
            }
        }
    }
}