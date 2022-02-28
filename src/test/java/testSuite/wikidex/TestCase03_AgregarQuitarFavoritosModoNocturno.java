package testSuite.wikidex;

import conexion.DriverContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.wikidexPages.FavoritosPageWikidex;
import pages.wikidexPages.HomePageWikidex;
import pages.wikidexPages.MenuPageWikidex;
import pages.wikidexPages.ResultadoPageWikidex;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase03_AgregarQuitarFavoritosModoNocturno {

    // DISPOSITIVO VIRTUAL
    private String nombreDispositivo = "emulator-5554";
    private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    // private String nombreDispositivo = "ZY327WFR7S";
    // private String udId = "ZY327WFR7S";
    private String nombreApk = "Wikidex.apk";
    // DIRECCION PC TSOFT
    private String direccion = "C:\\Users\\excloch\\Documents\\Apk\\";
    // DIRECCION PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\";
    private String appWaitAct = "net.wikidex.www.wikidex.*";
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
    protected HomePageWikidex homePageWikidex = null;
    protected MenuPageWikidex menuPageWikidex = null;
    protected FavoritosPageWikidex favoritosPageWikidex = null;

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

    @Test(priority = 1, description = "Validar mensaje Bienvenido")
    public void validarMensajeBienvenido(){
        homePageWikidex = new HomePageWikidex();
        softAssert.assertEquals(homePageWikidex.cargaImagen(),atributoOk);
        softAssert.assertEquals(homePageWikidex.contenidoTexto(),"Bienvenido a WikiDex");
        finalAssert();
    }

    @Test(priority = 2, description = "Cambiar a modo nocturno")
    public void cambiarModoNocturno(){
        menuPageWikidex = new MenuPageWikidex();
        menuPageWikidex.clickAjustes();
        menuPageWikidex.clickModoNocturno();
    }

    @Test(priority = 3, description = "Ir a una pagina aleatoria")
    public void irPaginaAleatoria(){
        menuPageWikidex = new MenuPageWikidex();
        menuPageWikidex.clickMenu();
        menuPageWikidex.clickEn("Página aleatoria");
    }

    @Test(priority = 4, description = "Agregar página a favoritos")
    public void agregarPaginaFavoritos(){
        menuPageWikidex = new MenuPageWikidex();
        menuPageWikidex.clickMasOpciones();
        menuPageWikidex.elegirOpcion("Guardar");
    }

    @Test(priority = 5, description = "Ver favoritos")
    public void verFavoritos(){
        menuPageWikidex = new MenuPageWikidex();
        menuPageWikidex.clickMenu();
        menuPageWikidex.clickEn("Favoritos");
        softAssert.assertEquals(menuPageWikidex.esperarPagina("Favoritos"),"Encontrada");
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
        softAssert.assertEquals(favoritosPageWikidex.mensajeVisible(),atributoOk);
        softAssert.assertTrue(favoritosPageWikidex.mensaje().contains("No hay favoritos."));
        finalAssert();
    }
}
