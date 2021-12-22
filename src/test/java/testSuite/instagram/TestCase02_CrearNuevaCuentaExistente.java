package testSuite.instagram;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.instagramPages.HomePage;
import pages.instagramPages.RegistroPage;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase02_CrearNuevaCuentaExistente{

    // DISPOSITIVO VIRTUAL
    // private String nombreDispositivo = "emulator-5554";
    // private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    private String nombreDispositivo = "ZY327WFR7S";
    private String udId = "ZY327WFR7S";
    private String nombreApk = "Instagram.apk";
    // DIRECCION PC TSOFT
    private String direccion = "C:\\Users\\Christian.Lopez\\OneDrive - TSOFT\\Documentos\\Apks\\";
    // DIRECCION PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\";
    private String appWaitAct = "com.instagram.*";
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
    protected HomePage homePage = null;
    protected RegistroPage registroPage = null;

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

    @Test(priority = 1,description = "Validar visualización de Logo")
    public void validarVisualizacionLogo(){
        homePage = new HomePage();
        Assert.assertEquals(homePage.visualizarLogo(),atributoOk);
        finalAssert();
    }

    @Test(priority = 2, description = "Validar click en crear nueva cuenta")
    public void validarClickCrearNuevaCuenta(){
        homePage = new HomePage();
        homePage.darClickCrearNuevaCuenta();
    }

    @Test(priority = 3, description = "Validar click en Correo Electrónico")
    public void validarClickCorreoElectronico(){
        registroPage = new RegistroPage();
        registroPage.darClickCorreoElectronico();
    }

    @Test(priority = 4, description = "Llenar campo correo electronico")
    public void ingresarCorreoElectronico(){
        registroPage = new RegistroPage();
        registroPage.llenarCampoCorreoElectronico("don.xekito@gmail.com");
    }

    @Test(priority = 5, description = "Validar click en siguiente")
    public void validarClickSiguente(){
        registroPage = new RegistroPage();
        registroPage.darClickSiguiente();
    }

    @Test(priority = 7, description = "Validar alerta")
    public void mensajeAlerta(){
        registroPage = new RegistroPage();
        softAssert.assertEquals(registroPage.mensajeAlertaVisible(),atributoOk);
        softAssert.assertTrue(registroPage.contenidoMensajeAlerta().contains("No pudimos completar tu solicitud"));
        finalAssert();
    }

    @Test(priority = 6,description = "Validar mensaje advertencia")
    public void mensajeAdvertencia(){
        registroPage = new RegistroPage();
        softAssert.assertEquals(registroPage.mensajeAdvertenciaVisible(),atributoOk);
        softAssert.assertTrue(registroPage.contenidoMensajeAdvertencia().contains("se usa en otra cuenta"));
        finalAssert();
    }
}