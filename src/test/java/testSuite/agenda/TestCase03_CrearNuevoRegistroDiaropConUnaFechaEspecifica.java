package testSuite.agenda;

import conexion.DriverContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.agendaPages.CalendarioPageAgenda;
import pages.agendaPages.DiarioPageAgenda;
import pages.agendaPages.HomePageAgenda;

import static conexion.DriverContext.setUp;
import static reports.Report.finalAssert;

public class TestCase03_CrearNuevoRegistroDiaropConUnaFechaEspecifica {

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
    protected CalendarioPageAgenda calendarioPageAgenda = null;

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

    @Test(priority = 1, description = "Validar dar click en agregar")
    public void validarDarClickAgregar(){
        homePageAgenda = new HomePageAgenda();
        softAssert.assertTrue(homePageAgenda.iconoAgregarVisible());
        softAssert.assertTrue(homePageAgenda.iconoAgregarClickeable());
        homePageAgenda.darClickAgregar();
        finalAssert();
    }

    @Test(priority = 2, description = "Cambiar fecha Creada")
    public void cambiarFechaCreada(){
        diarioPageAgenda = new DiarioPageAgenda();
        calendarioPageAgenda = new CalendarioPageAgenda();
        diarioPageAgenda.darClickFechaCreada();
        calendarioPageAgenda.selecionarJulio();
        softAssert.assertTrue(calendarioPageAgenda.txtAnoVisible());
        softAssert.assertTrue(calendarioPageAgenda.txtAnoClickeable());
        calendarioPageAgenda.darClickTxtAno();
        calendarioPageAgenda.seleccionarAno("2022");
        diarioPageAgenda.darClickOk();
        finalAssert();
    }

    @Test(priority = 3, description = "Agregar Texto")
    public void agregarTexto(){
        diarioPageAgenda = new DiarioPageAgenda();
        diarioPageAgenda.darClickAgregarTexto();
        diarioPageAgenda.escribirTexto("Se selecciona fecha 15 de julio 2022");
        diarioPageAgenda.darClickOk();
        diarioPageAgenda.darClickOk();
    }

    @Test(priority = 4, description = "Cambiar color")
    public void cambiarColor(){
        diarioPageAgenda = new DiarioPageAgenda();
        diarioPageAgenda.darClickIconoColor();
        diarioPageAgenda.seleccionarColorAleatorio();
    }

    @Test(priority = 5, description = "Ir a home Diario")
    public void irHomeDiario() {
        homePageAgenda = new HomePageAgenda();
        softAssert.assertTrue(homePageAgenda.iconoMenuVisible());
        softAssert.assertTrue(homePageAgenda.iconoMenuClickeable());
        homePageAgenda.darClickMenu();
        homePageAgenda.menuDarClickEn("Diario");
        finalAssert();
    }

    @Test(priority = 7, description = "Validar datos creados")
    public void validarDatosCreados(){
        diarioPageAgenda = new DiarioPageAgenda();
        softAssert.assertEquals(diarioPageAgenda.cantidadDocs(),1);
        softAssert.assertEquals(diarioPageAgenda.textoDoc(),"Se selecciona fecha 15 de julio 2022");
        softAssert.assertTrue(diarioPageAgenda.diaDoc().contains("15"));
        softAssert.assertTrue(diarioPageAgenda.mesDoc().contains("Jul"));
        softAssert.assertEquals(diarioPageAgenda.anoDoc(),"2022");
        finalAssert();
    }
}
