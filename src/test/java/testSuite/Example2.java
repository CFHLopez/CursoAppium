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
    @BeforeMethod
    public void iniciarSeccion(){
        //setUp("ZY327WFR7S","Android","C:\\Users\\chris\\Downloads\\Instagram.apk","ZY327WFR7S",false);
        setUp("emulator-5554","Android","C:\\Users\\chris\\Downloads\\Instagram.apk","emulator-5554",true);
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
