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

    protected HomePage homePage = null;
    // DISPOSITIVO VIRTUAL
    // private String nombreDispositivo = "emulator-5554";
    // private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    private String nombreDispositivo = "ZY327WFR7S";
    private String udId = "ZY327WFR7S";
    private String sistemaOperativo = "Android";
    // PC TSOFT
    private String direccion = "C:\\Users\\Christian.Lopez\\OneDrive - TSOFT\\Documentos\\Apks\\Instagram.apk";
    // PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\Instagram.apk";
    private String appWaitAct = "com.instagram.*";
    // DISPOSITIVO VIRTUAL
    // TRUE  -> VIRTUAL
    // FALSE -> REAL
    private boolean emulador = true;
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

    @Test (priority = 1,description = "Validar visualización de Logo")
    public void validarVisualizacionLogo(){
        homePage = new HomePage();
        Assert.assertEquals(homePage.visualizarLogo(),"true");
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
        Assert.assertEquals(homePage.retornarTextoSingUp(),"Crear cuenta nueva");
        Assert.assertEquals(homePage.retornarTextoLogin(),"Iniciar sesión");
        finalAssert();
    }
}
