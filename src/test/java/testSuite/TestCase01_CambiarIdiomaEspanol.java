package testSuite;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static conexion.DriverContext.setUp;

public class TestCase01_CambiarIdiomaEspanol {
    private String nombreDispositivo = "emulator-5554";
    private String sistemaOperativo = "Android";
    private String direccion = "C:\\Users\\chris\\Downloads\\Instagram.apk";
    private String udId = "emulator-5554";
    private boolean emulador = true;

    protected HomePage homePage = null;

    @BeforeMethod
    public void iniciarSeccion(){
        //setUp("ZY327WFR7S","Android","C:\\Users\\chris\\Downloads\\Instagram.apk","ZY327WFR7S",false);
        setUp(nombreDispositivo,
                sistemaOperativo,
                direccion,
                udId,
                emulador
        );
    }

    @AfterMethod
    public void cerrarSeccion(){
        DriverContext.quitDriver();
    }

    @Test
    public void validarCambioDeIdioma(){
        homePage = new HomePage();
        Assert.assertEquals(homePage.visualizarLogo(),"true");
        homePage.darClickIdioma();
        homePage.seleccionarIdioma("Español");
        Assert.assertEquals(homePage.retornarTextoSingUp(),"Crear cuenta nueva");
        Assert.assertEquals(homePage.retornarTextoLogin(),"Iniciar sesión");
    }
}
