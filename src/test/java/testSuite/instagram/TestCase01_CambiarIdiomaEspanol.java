package testSuite.instagram;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.instagramPages.HomePage;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase01_CambiarIdiomaEspanol {

    // DISPOSITIVO VIRTUAL
    // private String nombreDispositivo = "emulator-5554";
    // private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    private String nombreDispositivo = "ZY327WFR7S";
    private String udId = "ZY327WFR7S";
    private String nombreApk = "Instagram.apk";
    // DIRECCION PC TSOFT
    private String direccion = "C:\\Users\\excloch\\Documents\\Apk\\";
    // DIRECCION PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\";
    private String appWaitAct = "com.instagram.*";

    /** DISPOSITIVO
     * TRUE     ->      VIRTUAL
     * FALSE    ->      REAL
     */

    private boolean emulador = true;
    private SoftAssert softAssert = new SoftAssert();

    /**
     * PAGES
     */

    protected HomePage homePage = null;

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

    @Test (priority = 1,description = "Validar visualización de Logo")
    public void validarVisualizacionLogo(){
        homePage = new HomePage();
        softAssert.assertTrue(homePage.visualizarLogo());
        finalAssert();
    }

    @Test (priority = 2, description = "Validar click para el cambio de idioma")
    public void validarClickIdioma(){
        homePage = new HomePage();
        homePage.darClickIdioma();
        finalAssert();
    }

    @Test (priority = 3, description = "Validar el cambio de idioma")
    public void validarCambioIdioma(){
        homePage = new HomePage();
        homePage.seleccionarIdioma("Español");
        softAssert.assertEquals(homePage.retornarTextoSingUp(),"Crear cuenta nueva");
        softAssert.assertEquals(homePage.retornarTextoLogin(),"Iniciar sesión");
        finalAssert();
    }
}
