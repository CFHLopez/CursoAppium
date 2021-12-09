package testSuite;

import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static conexion.DriverContext.setUp;
import static reports.Report.addStep;

public class Example2 {
    private String nombreDispositivo = "emulator-5554";
    private String sistemaOperativo = "Android";
    private String direccion = "C:\\Usevrs\\chris\\Downloads\\Instagram.apk";
    private String udId = "emulator-5554";
    private String appWaitAct = "";
    private boolean emulador = true;

    @BeforeMethod
    public void iniciarSeccion(){
        //setUp("ZY327WFR7S","Android","C:\\Users\\chris\\Downloads\\Instagram.apk","ZY327WFR7S",false);
        setUp(nombreDispositivo,
                sistemaOperativo,
                direccion,
                udId,
                appWaitAct,
                emulador
        );
    }

    @AfterMethod
    public void cerrarSeccion(){
        DriverContext.quitDriver();
    }

    @Test
    public void testCambiarIdioma(){
        MobileElement el1 = (MobileElement) DriverContext.getDriver().findElementByAccessibilityId("Select language. English (United States)  .");
        el1.click();
        MobileElement el2 = (MobileElement) DriverContext.getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[8]/android.widget.LinearLayout");
        el2.click();
        addStep("Validar Cambio de idioma",true, Status.PASSED,false);
    }
}
