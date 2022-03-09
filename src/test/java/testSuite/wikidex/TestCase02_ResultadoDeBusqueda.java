package testSuite.wikidex;

import conexion.DriverContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.wikidexPages.MenuPageWikidex;
import pages.wikidexPages.HomePageWikidex;
import pages.wikidexPages.ResultadoPageWikidex;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase02_ResultadoDeBusqueda {

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
    private String nombrePokemon = "Pikachu";
    /**
     * PAGES
     */
    protected HomePageWikidex homePageWikidex = null;
    protected MenuPageWikidex menuPageWikidex = null;
    protected ResultadoPageWikidex resultadoPageWikidex = null;

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

    @Test(priority = 1, description = "Validar mensaje Bienvenido")
    public void validarMensajeBienvenido(){
        homePageWikidex = new HomePageWikidex();
        softAssert.assertTrue(homePageWikidex.cargaImagen());
        softAssert.assertEquals(homePageWikidex.contenidoTexto(),"Bienvenido a WikiDex");
        finalAssert();
    }

    @Test(priority = 2, description = "Validar click botón buscar")
    public void validarBtnBuscar(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickBuscar();
    }

    @Test(priority = 3, description = "Llenar casilla de texto")
    public void llenarCasillaTexto(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.llenarCasilla(nombrePokemon);
    }

    @Test(priority = 4, description = "Seleccionar Elemento de Resultados")
    public void selecionarElemento(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickPrimerElemento();
    }

    @Test(priority = 5, description = "Validar pagina resultado visible")
    public void validarBusqueda(){
        resultadoPageWikidex = new ResultadoPageWikidex();
        menuPageWikidex = new MenuPageWikidex();
        softAssert.assertTrue(menuPageWikidex.esperarPagina(nombrePokemon),"No Encontrada");
        softAssert.assertEquals(resultadoPageWikidex.textoResultado(nombrePokemon),"No Encontrado");
        finalAssert();
    }
}
