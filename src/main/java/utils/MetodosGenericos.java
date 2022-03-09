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
    private String atributoVisible = "enabled";
    private String atributoClickable = "clickable";

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

    // FUNCION DE ESPERAR SEGUNDOS PARTE 1
    public static boolean esperarSegundos(int seconds, String mensaje) {
        try {
            esperar(seconds, mensaje);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    // FUNCION DE ESPERAR SEGUNDOS PARTE 2
    public static void esperar(int segundos, String mensaje) {
        System.out.println("\nREVISANDO: "+mensaje);
        System.out.println("INICIA LA ESPERA DE " + segundos + " SEGUNDOS.");
        long start = System.nanoTime();
        long end = 0L;
        long microseconds = 0L;
        long tiempoTranscurrido = 0L;

        do {
            end = System.nanoTime();
            microseconds = end - start;
            tiempoTranscurrido = TimeUnit.SECONDS.convert(microseconds, TimeUnit.NANOSECONDS);
        } while(tiempoTranscurrido < (long)segundos);

        System.out.println("FIN DE LA ESPERA DE " + segundos + " SEGUNDOS.");
    }

    // FUNCION INGRESAR TEXTO A UN CUADRO DE TEXTO
    protected void ingresarTexto(MobileElement element, String texto){
        if (inspeccionarAtributo(element,atributoVisible)){
            System.out.println("INGRESAMOS TEXTO ( "+texto+" ) AL ELEMENTO:"+ element.toString());
            element.sendKeys(texto);
        }
        else {
            System.out.println("CAMPO DE TEXTO NO VISIBLE");
        }
    }

    // INSPECCIONAR ATRIBUTO DE UN ELEMENTO
    protected boolean inspeccionarAtributo(MobileElement element, String atributo){
        esperarSegundos(5, "ELEMENTO "+ element.toString() +", ATRIBUTO: "+atributo);
        // si el atributo esta activo
        if(element.getAttribute(atributo).contains("true")){
            addStep("ESTADO ATRIBUTO: "+element.getAttribute(atributo), true, Status.PASSED,false);
            return Boolean.parseBoolean(element.getAttribute(atributo));
        }
        else{
            addStep("ESTADO ATRIBUTO: "+element.getAttribute(atributo),true, Status.FAILED,false);
            return Boolean.parseBoolean(element.getAttribute(atributo));
        }
    }

    protected void darClick(MobileElement element, int segundos){
        if(inspeccionarAtributo(element,atributoVisible)){
            element.click();
            addStep("CLICK EN ELEMENTO: "+element.toString(), true, Status.PASSED,false);
            esperarSegundos(segundos, "CARGANDO NUEVA VISTA");
        }
        else{
            addStep("NO SE PUDO DAR CLICK EN ELEMENTO: "+element.toString(),true, Status.FAILED,false);
        }
    }

    protected String retornarTexto(MobileElement element){
        if (inspeccionarAtributo(element,atributoVisible)){
            return element.getText();
        }
        else {
            return "TEXTO NO ENCONTRADO";
        }
    }

    protected void seleccionarElemento(List<MobileElement> elementList, String nombreLista, String textoBuscado){
        // RECORREMOS LA LISTA HASTA ENCONTRAR LA OPCIÓN REQUERIDA
        System.out.println("BUSCANDO: "+textoBuscado+", EN LA LISTA DE NOMBRE: "+nombreLista);
        // System.out.println("CANTIDAD DE ELEMENTOS DE LA LISTA: "+elementList.size());
        for (MobileElement element: elementList){
            if (element.getText().contains(textoBuscado)){
                // System.out.println("OPCIÓN: "+elemento.getText());
                // HACEMOS CLICK EN EL ELEMENTO ENCONTRADO
                darClick(element, 10);
                // AL ENCONTRAR EL ELEMENTO SALIMOS DEL CICLO
                break;
            }
        }
    }

    protected void seleccionarAleatorio(List<MobileElement> elementList){
        // System.out.println("CANTIDAD DE ELEMENTOS DE LA LISTA: "+elementList.size());
        // SE GENERA UN NUMERO AL AZAR ENTRE 1 Y EL LARGO DE LA LISTA
        int numeroAleatorio = generarNumeroAleatorio(1,elementList.size());
        // System.out.println("NÚMERO ALEATORIO GENERADO: "+numeroAleatorio);
        int num = 1;
        /**
         * EN EL SIGUIENTE CICLO
         * SE BUSCA EL ELEMENTO UBICADO EN LA
         * POSICIÓN DEL NUMERO CREADO AL AZAR
         * OJO: SE IGNORA LA POSICIÓN 0 DEBIDO A QUE:
         * LA POSICIÓN 0 EN MY AGENDA PARA CAMBIAR COLOR
         * ESTE VIENE POR DEFECTO EN BLANCO
         */
        for (MobileElement elemento: elementList){
            if (num == numeroAleatorio){
                darClick(elemento,10);
                break;
            }
            num++;
        }
    }

    protected void seleccionarMesJulio(List<MobileElement> elementList, MobileElement btn, MobileElement fecha){
        while (!fecha.getText().contains("jul")){
            btn.click();
            seleccionarElemento(elementList, "CALENDARIO","15");
        }
    }

    protected void seleccionarMesDia(List<MobileElement> elementList, MobileElement btn, MobileElement fecha,String dia, String mes){
        while (!retornarMesApkMyPersonalAgenda(fecha).contains(mes)){
            // System.out.println("FECHA AGENDA: "+retornarMesApkMyPersonalAgenda(fecha)+" != "+mes);
            btn.click();
            seleccionarElemento(elementList, "CALENDARIO",dia);
        }
    }

    protected void seleccionarPrimerElemento(List<MobileElement> lista){
        for (MobileElement elemento: lista){
            darClick(elemento,10);
            break;
        }
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
        for (MobileElement elemento: lista){
            System.out.println("CONTENIDO: "+elemento.getText());
        }
    }

    protected void volver(){
        this.driver.navigate().back();
    }

    protected void quitarTeclado(){
        this.driver.hideKeyboard();
    }

    protected String retornarDiaActual(){
        Calendar calendario = Calendar.getInstance();
        String dia = Integer.toString(calendario.get(Calendar.DATE));
        System.out.println("RETORNARMOS EL DIA ACTUAL: "+dia);
        return dia;
    }

    private static int generarNumeroAleatorio(int limMin, int limMax){
        int numero = (int)(Math.random()*(limMax-limMin+1)+limMin);
        System.out.println("NUMERO GENERADO AL AZAR: "+numero);
        return numero;
    }

    public String retornarMesApkMyPersonalAgenda(MobileElement mobileElement){
        String txtFecha = retornarTexto(mobileElement);
        String [] txtSeparado = txtFecha.split(" ");
        System.out.println("Mes: "+txtSeparado[2]);
        switch (txtSeparado[2]){
            case "ene.":
                return "Enero";
            case "feb.":
                return "Febrero";
            case "mar.":
                return "Marzo";
            case "abr.":
                return "Abril";
            case "may.":
                return "Mayo";
            case "jun.":
                return "Junio";
            case "jul.":
                return "Julio";
            case "ago.":
                return "Agosto";
            case "sep.":
                return "Septiembre";
            case "oct.":
                return "Octubre";
            case "nov.":
                return "Noviembre";
            case "dic.":
                return "Diciembre";
            default:
                return "Texto erroneo";
        }
    }

    public int contarElementos(List<MobileElement> elementList){
        System.out.println("RETORNAMOS LA CANTIDAD DE ELEMENTOS DE LA LISTA");
        return elementList.size();
    }

    public boolean tituloPaginaActual(MobileElement element, String titulo){
        esperarSegundos(5,"ESPERANDO PAGINA "+titulo);
        if(inspeccionarAtributo(element,atributoVisible) && element.getText().contains(titulo)){
            addStep("PÁGINA ACTUAL ES: "+element.getText(), true, Status.PASSED,false);
            return true;
        }
        else{
            addStep("LA PÁGINA ACTUAL NO ES: "+titulo+", ES: "+element.getText(),true, Status.FAILED,false);
            return false;
        }
    }
}