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

public class TestCase03_CrearYEliminarCuenta{

    protected HomePage homePage = null;
    protected RegistroPage registroPage = null;
    // DISPOSITIVO VIRTUAL
    private String nombreDispositivo = "emulator-5554";
    private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    // private String nombreDispositivo = "ZY327WFR7S";
    // private String udId = "ZY327WFR7S";
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

    @Test(priority = 1,description = "Validar visualización de Logo")
    public void validarVisualizacionLogo(){
        homePage = new HomePage();
        Assert.assertEquals(homePage.visualizarLogo(),"true");
        finalAssert();
    }

    @Test(priority = 2, description = "Validar click en crear nueva cuenta")
    public void validarClickCrearNuevaCuenta(){
        homePage = new HomePage();
        homePage.darClickCrearNuevaCuenta();
        finalAssert();
    }

    @Test(priority = 3, description = "Validar click en Correo Electrónico")
    public void validarClickCorreoElectronico(){
        registroPage = new RegistroPage();
        registroPage.darClickCorreoElectronico();
        finalAssert();
    }

    @Test(priority = 4, description = "Llenar campo correo electronico")
    public void ingresarCorreoElectronico(){
        registroPage = new RegistroPage();
        registroPage.llenarCampoCorreoElectronico("pruebaappium123@gmail.com");
        finalAssert();
    }

    @Test(priority = 5, description = "Validar click en siguiente")
    public void validarClickSiguente(){
        registroPage = new RegistroPage();
        registroPage.darClickSiguiente();
        finalAssert();
    }

    @Test(priority = 6, description = "Validar alerta")
    public void mensajeAlerta(){
        registroPage = new RegistroPage();
        softAssert.assertTrue(registroPage.mensajeAlertaVisible().contains("true"));
        softAssert.assertTrue(registroPage.contenidoMensajeAlerta().contains("No pudimos completar tu solicitud"));
        finalAssert();
    }
}
