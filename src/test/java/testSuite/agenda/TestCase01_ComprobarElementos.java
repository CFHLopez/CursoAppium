package testSuite.agenda;

import conexion.DriverContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
    private String sistemaOperativo = "Android";
    // PC TSOFT
    private String direccion = "C:\\Users\\Christian.Lopez\\OneDrive - TSOFT\\Documentos\\Apks\\My Personal Agenda_v6.4.1com.apk";
    // PC PERSONAL
    // private String direccion = "C:\\Users\\chris\\Documents\\Apks\\My Personal Agenda_v6.4.1com.apk";
    private String appWaitAct = "com.tambucho.miagenda.*";
    // DISPOSITIVO VIRTUAL
    // TRUE  -> VIRTUAL
    // FALSE -> REAL
    private boolean emulador = true;
    private SoftAssert softAssert = new SoftAssert();
    protected HomePageAgenda homePageAgenda = null;

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

    @Test(priority = 1, description = "Validar elementos visibles")
    public void validarElementosVisibles(){
        homePageAgenda = new HomePageAgenda();
        softAssert.assertEquals(homePageAgenda.iconoMenuVisible(),"visible");
        softAssert.assertEquals(homePageAgenda.textoSeccionVisible(),"visible");
        softAssert.assertEquals(homePageAgenda.iconoBuscarVisible(),"visible");
        softAssert.assertEquals(homePageAgenda.iconoFiltroVisible(),"visible");
        softAssert.assertEquals(homePageAgenda.textoGrupoVisible(),"visible");
        softAssert.assertEquals(homePageAgenda.iconoAgregarVisible(),"visible");
        finalAssert();
    }

    @Test(priority = 2, description = "Validar elementos clickeables")
    public void validarElementosClickeables(){
        homePageAgenda = new HomePageAgenda();
        softAssert.assertEquals(homePageAgenda.iconoMenuClickeable(),"visible");
        softAssert.assertEquals(homePageAgenda.iconoBuscarClickeable(),"visible");
        softAssert.assertEquals(homePageAgenda.iconoFiltroClickeable(),"visible");
        softAssert.assertEquals(homePageAgenda.iconoAgregarClickeable(),"visible");
        finalAssert();
    }
}
