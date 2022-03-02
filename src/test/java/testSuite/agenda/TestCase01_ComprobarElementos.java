package testSuite.agenda;

import conexion.DriverContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.agendaPages.DiarioPageAgenda;
import pages.agendaPages.HomePageAgenda;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase01_ComprobarElementos {

    // DISPOSITIVO VIRTUAL
    // private String nombreDispositivo = "emulator-5554";
    // private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    private String nombreDispositivo = "ZY327WFR7S";
    private String udId = "ZY327WFR7S";
    // NOMBRE APK
    private String nombreApk = "My Personal Agenda_v6.4.1com.apk";
    // DIRECCION PC TSOFT
    private String direccion = "C:\\Users\\excloch\\Documents\\Apk\\";
    // DIRECCION PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\";
    private String appWaitAct = "com.tambucho.miagenda.*";

    /** DISPOSITIVO
     * TRUE     ->      VIRTUAL
     * FALSE    ->      REAL
     */

    private boolean emulador = true;
    private SoftAssert softAssert = new SoftAssert();

    /**
     * PAGES
     */

    protected HomePageAgenda homePageAgenda = null;
    protected DiarioPageAgenda diarioPageAgenda = null;

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

    @Test(priority = 1, description = "Validar elementos visibles")
    public void validarElementosVisibles(){
        homePageAgenda = new HomePageAgenda();
        diarioPageAgenda = new DiarioPageAgenda();
        softAssert.assertTrue(homePageAgenda.iconoMenuVisible());
        softAssert.assertTrue(homePageAgenda.textoSeccionVisible());
        softAssert.assertTrue(homePageAgenda.iconoBuscarVisible());
        softAssert.assertTrue(diarioPageAgenda.iconoFiltroVisible());
        softAssert.assertTrue(homePageAgenda.textoGrupoVisible());
        softAssert.assertTrue(homePageAgenda.iconoAgregarVisible());
        finalAssert();
    }

    @Test(priority = 2, description = "Validar elementos clickeables")
    public void validarElementosClickeables(){
        homePageAgenda = new HomePageAgenda();
        diarioPageAgenda = new DiarioPageAgenda();
        softAssert.assertTrue(homePageAgenda.iconoMenuClickeable());
        softAssert.assertTrue(homePageAgenda.iconoBuscarClickeable());
        softAssert.assertTrue(diarioPageAgenda.iconoFiltroClickeable());
        softAssert.assertTrue(homePageAgenda.iconoAgregarClickeable());
        finalAssert();
    }

    @Test(priority = 3, description = "Validar textos en elementos")
    public void validarTextos(){
        homePageAgenda = new HomePageAgenda();
        softAssert.assertEquals(homePageAgenda.textoVisibleSeccion(),"Diario");
        softAssert.assertEquals(homePageAgenda.textoVisibleGrupo(),"Todo");
        finalAssert();
    }
}
