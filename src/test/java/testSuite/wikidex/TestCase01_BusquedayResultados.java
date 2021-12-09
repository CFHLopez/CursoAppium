package testSuite.wikidex;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.wikidexPage.HomePageWikidex;
import utils.MetodosGenericos;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase01_BusquedayResultados extends MetodosGenericos {

    protected HomePageWikidex homePageWikidex = null;
    private String nombreDispositivo = "emulator-5554";
    private String sistemaOperativo = "Android";
    // private String direccion = "C:\\Users\\chris\\Downloads\\Instagram.apk";
    // private String direccion = "C:\\Users\\chris\\IdeaProjects\\CursoAppium\\out\\production\\resources\\Instagram.apk\\";
    private String direccion = obtenerPath("Wikidex.apk");
    private String udId = "emulator-5554";
    private String appWaitAct = "net.wikidex.www.wikidex.*";
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

    @Test(priority = 1,description = "Validar mensaje Bienvenido")
    public void validarMensajeBienvenido(){
        homePageWikidex = new HomePageWikidex();
        Assert.assertEquals(homePageWikidex.textoBienvenido("Bienvenido"),"true");
        Assert.assertEquals(homePageWikidex.contenidoTexto(),"Bienvenido a WikiDex");
        finalAssert();
    }

    @Test(priority = 2,description = "Validar click btn buscar")
    public void validarBtnBuscar(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickBuscar();
    }

    @Test(priority = 3,description = "Llenar casilla de texto")
    public void llenarCasillaTexto(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.llenarCasilla("Rayquaza");
    }

    @Test(priority = 4,description = "Seleccionar Elemento de Resultados")
    public void selecionarElemento(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickElemento("Rayquaza");
    }

    @Test(priority = 5,description = "Validar resultado")
    public void validarResultado(){
        homePageWikidex = new HomePageWikidex();
        Assert.assertTrue(homePageWikidex.textoResultado().contains("Rayquaza"));
        finalAssert();
    }
}
