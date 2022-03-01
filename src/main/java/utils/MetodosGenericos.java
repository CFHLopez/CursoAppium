package utils;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static reports.Report.addStep;

public class MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;
    public static int segundos = 10;

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

    //funcion copiada proyecto corredora
    public static void esperar(int segundos) {
        System.out.println("Inicia la espera de " + segundos + " segundos;");
        long start = System.nanoTime();
        long end = 0L;
        long microseconds = 0L;
        long tiempoTranscurrido = 0L;

        do {
            end = System.nanoTime();
            microseconds = end - start;
            tiempoTranscurrido = TimeUnit.SECONDS.convert(microseconds, TimeUnit.NANOSECONDS);
        } while(tiempoTranscurrido < (long)segundos);

        System.out.println("Fin de la espera de " + segundos + " segundos;");
    }

    //funcion copiada proyecto corredora
    public static boolean esperarSegundos(int seconds) {
        try {
            MetodosGenericos.esperar(seconds);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void esperaImplicita(){
        driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
        System.out.println("Espera Implicita");
    }

    private boolean esperarObjeto(MobileElement elemento){
        try {
            System.out.println("Esperando elemento: "+elemento.toString()+", "+segundos+" segnudos, hasta que aparezca");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontro el elemento ("+elemento.toString()+"), se retorna true");
            return true;

        }catch (Exception e){
            System.out.println("No se encontró el elemento ("+elemento+"), se retorna false");
            return false;
        }
    }

    public static void esperarElemento(MobileElement elemento){
        WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),segundos);
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    protected void llenarCampo(MobileElement campo, String contenido){
        campo.sendKeys(contenido);
    }

    protected String inspeccionarElemento(String atributo, MobileElement elemento){
        // esperaImplicita();
        esperarSegundos(5);
        System.out.println("estado "+atributo+": "+elemento.getAttribute(atributo));
        if(elemento.getAttribute(atributo).contains("true")){
            addStep("Elemento visible", true, Status.PASSED,false);
            return "visible";
        }
        else{
            addStep("Elemento oculto",true, Status.FAILED,false);
            return "oculto";
        }
    }

    protected void darClick(MobileElement elemento){
        if(esperarObjeto(elemento)){
            elemento.click();
            addStep("Click en elemento: "+elemento, true, Status.PASSED,false);
        }
        else{
            addStep("Click en elemento: "+elemento,true, Status.FAILED,false);
        }
    }

    protected String retornarTexto(MobileElement elemento){
        // esperaImplicita();
        esperarSegundos(5);
        // System.out.println(elemento.getText());
        if (esperarObjeto(elemento)){
            return elemento.getText();
        }
        else {
            return "elemento no encontrado";
        }
    }

    protected void seleccionarElemento(List<MobileElement> lista, String palabra){
        // esperaImplicita();
        esperarSegundos(5);
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

    protected void seleccionarAleatorio(List<MobileElement> lista){
        esperarSegundos(5);
        //esperaImplicita();
        System.out.println("Cantidad elementos: "+lista.size());
        // SE GENERA UN NUMERO AL AZAR ENTRE 1 Y EL LARGO DE LA LISTA
        int numeroAleatorio = generarNumeroAleatorio(1,lista.size());
        System.out.println("Numero aleatorio: "+numeroAleatorio);
        int num = 0;
        /**
         * EN EL SIGUIENTE CICLO
         * SE BUSCA EL ELEMENTO UBICADO EN LA
         * POSICIÓN DEL NUMERO CREADO AL AZAR
         * OJO: SE IGNORA LA POSICIÓN 0 DEBIDO A QUE:
         * LA POSICIÓN 0 EN MY AGENDA PARA CAMBIAR COLOR
         * ESTE VIENE POR DEFECTO EN BLANCO
         */
        for (MobileElement elemento: lista){
            if (num == numeroAleatorio){
                darClick(elemento);
                break;
            }
            num++;
        }
    }

    protected void seleccionarMesJulio(List<MobileElement> lista, MobileElement btn, MobileElement fecha){
        // esperaImplicita();
        esperarSegundos(5);
        while (!fecha.getText().contains("jul")){
            btn.click();
            seleccionarElemento(lista,"15");
        }
    }

    protected void seleccionarPrimerElemento(List<MobileElement> lista){
        // esperaImplicita();
        esperarSegundos(5);
        for (MobileElement elemento: lista){
            darClick(elemento);
            break;
        }
    }

    protected int contarElementos(List<MobileElement> lista){
        esperarSegundos(5);
        addStep("Elementos de la lista", true, Status.PASSED,false);
        return lista.size();
    }

    protected String encontrarContenido(List<MobileElement> lista, String palabra){
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

    protected void recorrerLista(List<MobileElement> lista){
        // esperaImplicita();
        esperarSegundos(5);
        for (MobileElement elemento: lista){
            System.out.println("texto: "+elemento.getText());
        }
    }

    protected String esperarPagina(MobileElement elemento, String palabra){
        // esperaImplicita();
        esperarSegundos(5);
        // POSIBLE MODIFICACIÓN PARA EVITAR UN CICLO INFINITO
        /*
        while (!elemento.getText().contains(palabra)){
            System.out.println("pagina: "+ elemento.getText());
            esperaImplicita();
        }
         */
        // CAMBIAMOS POR UN CICLO FOR DE 5 CICLOS
        String resultado = "No Encontrada";
        for (int i=0;i<5;i++){
            System.out.println("pagina: "+ elemento.getText());
            // esperaImplicita();
            esperarSegundos(5);
            if (elemento.getText().contains(palabra)){
                resultado = "Encontrada";
                break;
            }
        }
        return resultado;
    }

    protected void esperarPaginaAleatoria(MobileElement elemento){
        // esperaImplicita();
        esperarSegundos(5);
        while (elemento.getText().contains("WikiDex")){
            System.out.println("pagina: "+ elemento.getText());
            // esperaImplicita();
            esperarSegundos(5);
        }
    }

    protected void quitarTeclado(){
        this.driver.hideKeyboard();
    }

    protected String retornarDiaActual(){
        // esperaImplicita();
        esperarSegundos(5);
        Calendar calendario = Calendar.getInstance();
        String dia = Integer.toString(calendario.get(Calendar.DATE));
        return dia;
    }

    private int generarNumeroAleatorio(int limMin, int limMax){
        int numero = (int)(Math.random()*(limMax-limMin+1)+limMin);
        return numero;
    }

    public static boolean esperaPorElementoVisible(MobileElement mobileElement){
        System.out.println("[esperaPorElementoVisible] " + segundos + "s - " + mobileElement.toString());
        try {
            esperarElemento(mobileElement);
            System.out.println("[esperaPorElementoVisible] [success] Elemento encontrado: " + mobileElement.toString());
            return true;
        }catch (Exception e) {
            System.err.println("[esperaPorElementoVisible] [" + e.getClass() +"] Elemento no encontrado: " + mobileElement.toString());
            return false;
        }
    }
}