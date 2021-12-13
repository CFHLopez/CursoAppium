package testSuite.wikidex;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.wikidexPages.BusquedaPageWikidex;
import pages.wikidexPages.HomePageWikidex;
import pages.wikidexPages.ResultadoPageWikidex;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase02_ResultadoDeBusqueda {

    protected HomePageWikidex homePageWikidex = null;
    protected BusquedaPageWikidex busquedaPageWikidex = null;
    protected ResultadoPageWikidex resultadoPageWikidex = null;
    // DISPOSITIVO VIRTUAL
    // private String nombreDispositivo = "emulator-5554";
    // private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    private String nombreDispositivo = "ZY327WFR7S";
    private String udId = "ZY327WFR7S";
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

    @Test(priority = 1,description = "Validar click botón buscar")
    public void validarBtnBuscar(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickBuscar();
    }

    @Test(priority = 2,description = "Llenar casilla de texto")
    public void llenarCasillaTexto(){
        busquedaPageWikidex = new BusquedaPageWikidex();
        busquedaPageWikidex.llenarCasilla("Rayquaza");
    }

    @Test(priority = 3,description = "Seleccionar Elemento de Resultados")
    public void selecionarElemento(){
        busquedaPageWikidex = new BusquedaPageWikidex();
        busquedaPageWikidex.clickPrimerElemento();
    }

    @Test(priority = 5,description = "Validar carga imagen")
    public void validarImagen(){
        resultadoPageWikidex = new ResultadoPageWikidex();
        Assert.assertEquals(resultadoPageWikidex.esperarCargaImagen(),"visible");
    }

    @Test(priority = 5,description = "Validar resultado")
    public void validarResultado(){
        resultadoPageWikidex = new ResultadoPageWikidex();
        resultadoPageWikidex.textoImagenes();
        // Assert.assertTrue(resultadoPageWikidex.textoResultado().contains("Rayquaza"));
        finalAssert();
    }
}
