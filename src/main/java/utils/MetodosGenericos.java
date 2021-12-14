package utils;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
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
     */

    protected void esperaIxplicita(){
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

    public void esperarElemento(MobileElement elemento){
        WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),segundos);
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    public void llenarCampo(MobileElement campo, String contenido){
        campo.sendKeys(contenido);
    }

    public String inspeccionarElemento(String atributo, MobileElement elemento){
        System.out.println("estado "+atributo+": "+elemento.getAttribute(atributo));
        if(elemento.getAttribute(atributo).contains("true")){
            esperaIxplicita();
            addStep("Elemento visible", true, Status.PASSED,false);
            return "visible";
        }
        else{
            addStep("Elemento oculto",true, Status.FAILED,false);
            return "oculto";
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
        esperaIxplicita();
        // System.out.println(elemento.getText());
        if (esperarObjeto(elemento)){
            return elemento.getText();
        }
        else {
            return "elemento no encontrado";
        }
    }

    public void seleccionarElemento(List<MobileElement> lista, String palabra){
        // Recorremos la lista hasta encontrar la palabra requerida
        System.out.println("Recorrer lista hasta encontrar: "+palabra);
        System.out.println("Cantidad elementos: "+lista.size());
        for (MobileElement elemento: lista){
            if (elemento.getText().contains(palabra)){
                System.out.println("elemento: "+elemento.getText());
                // Hacemos click en el elemento buscado
                darClick(elemento);
                // Al encontrar el elemento no necesitamos seguir buscando
                break;
            }
        }
    }

    public void seleccionarPrimerElemento(List<MobileElement> lista){
        for (MobileElement elemento: lista){
            darClick(elemento);
            break;
        }
    }

    public int contarElementos(List<MobileElement> lista){
        addStep("Elementos de la lista", true, Status.PASSED,false);
        return lista.size();
    }

    public String encontrarContenido(List<MobileElement> lista, String palabra){
        String resultado = "No Encontrado";
        for (MobileElement elemento: lista){
            if (elemento.getText().contains(palabra)){
                resultado = "Encontrado";
                // Al encontrar el elemento no necesitamos seguir buscando
                break;
            }
        }
        return resultado;
    }

    public void recorrerLista(List<MobileElement> lista){
        for (MobileElement elemento: lista){
            System.out.println("texto: "+elemento.getText());
        }
    }

    public String esperarPagina(MobileElement elemento, String palabra){
        while (!elemento.getText().contains(palabra)){
            System.out.println("pagina: "+ elemento.getText());
            esperaIxplicita();
        }
        return "Encontrada";
    }

    public void esperarPaginaAleatoria(MobileElement elemento){
        while (elemento.getText().contains("WikiDex")){
            System.out.println("pagina: "+ elemento.getText());
            esperaIxplicita();
        }
    }


    public void quitarTeclado(){
        this.driver.hideKeyboard();
    }
}