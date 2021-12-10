package testSuite.instagram;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.instagramPages.HomePage;
import utils.MetodosGenericos;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase01_CambiarIdiomaEspanol extends MetodosGenericos {

    protected HomePage homePage = null;
    private String nombreDispositivo = "emulator-5554";
    private String sistemaOperativo = "Android";
    // private String direccion = "C:\\Users\\chris\\Downloads\\Instagram.apk";
    // private String direccion = "C:\\Users\\chris\\IdeaProjects\\CursoAppium\\out\\production\\resources\\Instagram.apk\\";
    private String direccion = obtenerPath("Instagram.apk");
    private String udId = "emulator-5554";
    private String appWaitAct = "";
    private boolean emulador = true;

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
