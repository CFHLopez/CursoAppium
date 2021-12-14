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

    protected HomePageWikidex homePageWikidex = null;
    protected MenuPageWikidex menuPageWikidex = null;
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
    private boolean emulador = false;
    private SoftAssert softAssert = new SoftAssert();

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

    @Test(priority = 1, description = "Validar mensaje Bienvenido")
    public void validarMensajeBienvenido(){
        homePageWikidex = new HomePageWikidex();
        softAssert.assertEquals(homePageWikidex.cargaImagen(),"visible");
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
        homePageWikidex.llenarCasilla("Rayquaza");
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
        softAssert.assertEquals(menuPageWikidex.esperarPagina("Rayquaza"),"Encontrada");
        softAssert.assertEquals(resultadoPageWikidex.textoResultado("Rayquaza"),"Encontrado");
        finalAssert();
    }
}
