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

public class TestCase02_CrearNuevoTxtFecha {

    // DISPOSITIVO VIRTUAL
    // private String nombreDispositivo = "emulator-5554";
    // private String udId = "emulator-5554";
    // DISPOSITIVO REAL
    private String nombreDispositivo = "ZY327WFR7S";
    private String udId = "ZY327WFR7S";
    // NOMBRE APK
    private String nombreApk = "My Personal Agenda_v6.4.1com.apk";
    // DIRECCION PC TSOFT
    private String direccion = "C:\\Users\\Christian.Lopez\\OneDrive - TSOFT\\Documentos\\Apks\\";
    // DIRECCION PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\";
    private String appWaitAct = "com.tambucho.miagenda.*";
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
        softAssert.assertEquals(homePageAgenda.iconoAgregarVisible(),atributoOk);
        softAssert.assertEquals(homePageAgenda.iconoAgregarClickeable(),atributoOk);
        homePageAgenda.darClickAgregar();
        finalAssert();
    }

    @Test(priority = 2, description = "Validar que el dia coincida con el actual")
    public void validarDiaDocumento(){
        diarioPageAgenda = new DiarioPageAgenda();
        calendarioPageAgenda = new CalendarioPageAgenda();
        diarioPageAgenda.darClickFechaCreada();
        softAssert.assertEquals(calendarioPageAgenda.fechaDocumento(),diarioPageAgenda.diaActual());
        diarioPageAgenda.darClickOk();
        finalAssert();
    }

    @Test(priority = 3, description = "Validar click agregar texto")
    public void validarClickAgregarTexto(){
        diarioPageAgenda = new DiarioPageAgenda();
        softAssert.assertEquals(diarioPageAgenda.agregarTextoVisible(),atributoOk);
        softAssert.assertEquals(diarioPageAgenda.agregarTextoClickeable(),atributoOk);
        diarioPageAgenda.darClickAgregarTexto();
        finalAssert();
    }

    @Test(priority = 4, description = "Ingresar texto")
    public void ingresarTexto(){
        diarioPageAgenda = new DiarioPageAgenda();
        diarioPageAgenda.escribirTexto("Nuevo txt creado");
        diarioPageAgenda.darClickOk();
        diarioPageAgenda.darClickOk();
    }

    @Test(priority = 5, description = "Validar nuevos botones visibles")
    public void validarNuevosBotonesVisibles(){
        diarioPageAgenda = new DiarioPageAgenda();
        softAssert.assertEquals(diarioPageAgenda.iconoPDFVisible(), atributoOk);
        softAssert.assertEquals(diarioPageAgenda.iconoColorVisible(), atributoOk);
        softAssert.assertEquals(diarioPageAgenda.btnEditarVisible(), atributoOk);
        softAssert.assertEquals(diarioPageAgenda.iconoPDFClickeable(), atributoOk);
        softAssert.assertEquals(diarioPageAgenda.iconoColorClickeable(), atributoOk);
        softAssert.assertEquals(diarioPageAgenda.btnEditarClickeable(), atributoOk);
        finalAssert();
    }

    @Test(priority = 6, description = "Ir a home Diario")
    public void irHomeDiario() {
        homePageAgenda = new HomePageAgenda();
        softAssert.assertEquals(homePageAgenda.iconoMenuVisible(), atributoOk);
        softAssert.assertEquals(homePageAgenda.iconoMenuClickeable(), atributoOk);
        homePageAgenda.darClickMenu();
        homePageAgenda.menuDarClickEn("Diario");
        finalAssert();
    }

    @Test(priority = 7, description = "Validar datos creados")
    public void validarDatosCreados(){
        diarioPageAgenda = new DiarioPageAgenda();
        softAssert.assertEquals(diarioPageAgenda.cantidadDocs(),1);
        softAssert.assertEquals(diarioPageAgenda.textoDoc(),"Nuevo txt creado");
        /**
         * LOS DATOS SON VARIABLES DEPENDIENDO EL DIA DE LA EJECUCIÓN
         * FECHA DE LA ULTIMA EJECUCIÓN 22 DE DICIEMBRE 2021
         */
        softAssert.assertTrue(diarioPageAgenda.diaDoc().contains("22"));
        softAssert.assertTrue(diarioPageAgenda.mesDoc().contains("Dic"));
        softAssert.assertEquals(diarioPageAgenda.anoDoc(),"2021");
        finalAssert();
    }
}
