package testSuite.wikidex;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.wikidexPages.HomePageWikidex;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase01_BusquedayResultados{

    protected HomePageWikidex homePageWikidex = null;
    // DISPOSITIVO VIRTUAL
    private String nombreDispositivo = "emulator-5554";
    private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    // private String nombreDispositivo = "ZY327WFR7S";
    // private String udId = "ZY327WFR7S";
    private String sistemaOperativo = "Android";
    // PC TSOFT
    private String direccion = "C:\\Users\\Christian.Lopez\\OneDrive - TSOFT\\Documentos\\Apks\\Wikidex.apk";
    // PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\Wikidex.apk";
    private String appWaitAct = "net.wikidex.www.wikidex.*";
    // DISPOSITIVO VIRTUAL
    // TRUE  -> VIRTUAL
    // FALSE -> REAL
    private boolean emulador = true;

    @BeforeSuite
    public void iniciarSeccion(){
        setUp(nombreDispositivo,
                sistemaOperativo,
                direccion,
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
        Assert.assertEquals(homePageWikidex.textoBienvenido("Bienvenido"),"true");
        Assert.assertEquals(homePageWikidex.contenidoTexto(),"Bienvenido a WikiDex");
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

    @Test(priority = 4,description = "Seleccionar Elemento de Resultados")
    public void selecionarElemento(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickElemento("Rayquaza");
    }

    @Test(priority = 5,description = "Validar resultado")
    public void validarResultado(){
        homePageWikidex = new HomePageWikidex();
        Assert.assertTrue(homePageWikidex.textoResultado().contains("Rayquaza"));
        finalAssert();
    }
}
