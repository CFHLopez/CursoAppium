package testSuite;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase01_CambiarIdiomaEspanol {
    private String nombreDispositivo = "emulator-5554";
    private String sistemaOperativo = "Android";
    private String direccion = "C:\\Users\\chris\\Downloads\\Instagram.apk";
    private String udId = "emulator-5554";
    private boolean emulador = true;

    protected HomePage homePage = null;

    @BeforeSuite
    public void iniciarSeccion(){
        //setUp("ZY327WFR7S","Android","C:\\Users\\chris\\Downloads\\Instagram.apk","ZY327WFR7S",false);
        setUp(nombreDispositivo,
                sistemaOperativo,
                direccion,
                udId,
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

    @Test (priority = 2, description = "Validar Dar Click para el cambio de idioma")
    public void validarDarClickIdioma(){
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
