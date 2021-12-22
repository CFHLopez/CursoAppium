package testSuite.wikidex;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.wikidexPages.HomePageWikidex;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase01_BusquedayResultados{

    // DISPOSITIVO VIRTUAL
    // private String nombreDispositivo = "emulator-5554";
    // private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    private String nombreDispositivo = "ZY327WFR7S";
    private String udId = "ZY327WFR7S";
    private String nombreApk = "Wikidex.apk";
    // DIRECCION PC TSOFT
    private String direccion = "C:\\Users\\Christian.Lopez\\OneDrive - TSOFT\\Documentos\\Apks\\";
    // DIRECCION PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\";
    private String appWaitAct = "net.wikidex.www.wikidex.*";
    /** DISPOSITIVO
     * TRUE     ->      VIRTUAL
     * FALSE    ->      REAL
     */
    private boolean emulador = true;
    private SoftAssert softAssert = new SoftAssert();
    private String atributoOk = "visible";
    /**
     * PAGES
     */
    protected HomePageWikidex homePageWikidex = null;

    @BeforeSuite
    public void iniciarSeccion(){
        setUp(nombreDispositivo,
                direccion+nombreApk,
                udId,
                appWaitAct,
                emulador
        );
    }

    @AfterSuite
    public void cerrarSeccion(){
        DriverContext.quitDriver();
    }

    @Test(priority = 1,description = "Validar mensaje Bienvenido")
    public void validarMensajeBienvenido(){
        homePageWikidex = new HomePageWikidex();
        softAssert.assertEquals(homePageWikidex.cargaImagen(),atributoOk);
        softAssert.assertEquals(homePageWikidex.contenidoTexto(),"Bienvenido a WikiDex");
        finalAssert();
    }

    @Test(priority = 2,description = "Validar click btn buscar")
    public void validarBtnBuscar(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickBuscar();
    }

    @Test(priority = 3,description = "Llenar casilla de texto")
    public void llenarCasillaTexto(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.llenarCasilla("Rayquaza");
    }

    @Test(priority = 4,description = "Validar cantidad resultados mayor a 1")
    public void validarCantidadResultados(){
        homePageWikidex = new HomePageWikidex();
        softAssert.assertTrue(homePageWikidex.cantidadDeResultados()>1);
        finalAssert();
    }
}
