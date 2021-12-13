package testSuite.wikidex;

import conexion.DriverContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.wikidexPages.FavoritosPageWikidex;
import pages.wikidexPages.HomePageWikidex;
import pages.wikidexPages.ResultadoPageWikidex;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase03_AgregarQuitarFavoritosModoNocturno {

    protected HomePageWikidex homePageWikidex = null;
    protected ResultadoPageWikidex resultadoPageWikidex = null;
    protected FavoritosPageWikidex favoritosPageWikidex = null;
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

    @Test(priority = 2, description = "Cambiar a modo nocturno")
    public void cambiarModoNocturno(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickAjustes();
        homePageWikidex.clickModoNocturno();
    }

    @Test(priority = 3, description = "Ir a una pagina aleatoria")
    public void irPaginaAleatoria(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickMenu();
        homePageWikidex.clickEn("Página aleatoria");
    }

    @Test(priority = 4, description = "Agregar página a favoritos")
    public void agregarPaginaFavoritos(){
        resultadoPageWikidex = new ResultadoPageWikidex();
        resultadoPageWikidex.clickMasOpciones();
        resultadoPageWikidex.clickEn("Guardar");
    }

    @Test(priority = 5, description = "Ver favoritos")
    public void verFavoritos(){
        homePageWikidex = new HomePageWikidex();
        homePageWikidex.clickMenu();
        homePageWikidex.clickEn("Favoritos");
        favoritosPageWikidex = new FavoritosPageWikidex();
        softAssert.assertEquals(favoritosPageWikidex.esperaPagina("Favoritos"),"Encontrada");
        finalAssert();
    }

    @Test(priority = 6, description = "Validar cantidad de resultados")
    public void validarCantidadResultados(){
        favoritosPageWikidex = new FavoritosPageWikidex();
        softAssert.assertEquals(favoritosPageWikidex.cantidadPaginasGuardadas(),1);
        finalAssert();
    }

    @Test(priority = 7, description = "Validar eliminar favorito")
    public void eliminarFavorito(){
        favoritosPageWikidex = new FavoritosPageWikidex();
        favoritosPageWikidex.clickEliminar();
        softAssert.assertEquals(favoritosPageWikidex.mensajeVisible(),"visible");
        softAssert.assertTrue(favoritosPageWikidex.mensaje().contains("No hay favoritos."));
        finalAssert();
    }
}
