package testSuite.instagram;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.instagramPages.HomePage;
import pages.instagramPages.RegistroPage;
import utils.MetodosGenericos;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase03_CrearYEliminarCuenta extends MetodosGenericos {

    protected HomePage homePage = null;
    protected RegistroPage registroPage = null;
    private String nombreDispositivo = "emulator-5554";
    private String sistemaOperativo = "Android";
    // private String direccion = "C:\\Users\\chris\\Downloads\\Instagram.apk";
    // private String direccion = "C:\\Users\\chris\\IdeaProjects\\CursoAppium\\out\\production\\resources\\Instagram.apk\\";
    private String direccion = obtenerPath("Instagram.apk");
    private String udId = "emulator-5554";
    private String appWaitAct = "";
    private boolean emulador = true;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void iniciarSeccion(){
        // Dispositivo real
        /*
        setUp("ZY327WFR7S",
                "Android",
                "C:\\Users\\chris\\Downloads\\Instagram.apk",
                "ZY327WFR7S",
                false);
         */
        // Dispositivo virtual
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
