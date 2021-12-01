package reports;

import conexion.DriverContext;
// import io.qameta.allure.Allure;
// import io.qameta.allure.model.Status;
// import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class Report {
    private static SoftAssert softAssert = new SoftAssert();
    /*
    public static void addStep(String descripcion, Boolean capturaPantalla, Status estatus, Boolean fatal){
        // metodo que trae un ID aleatorio
        String uuId = UUID.randomUUID().toString();
        StepResult resultado = new StepResult().setName(descripcion).setStatus(estatus);
        Allure.getLifecycle().startStep(uuId,resultado);
        if (capturaPantalla){
            // agregar foto
            reportCapturaPantalla();
        }
        Allure.getLifecycle().stopStep(uuId);
        softAssert.assertTrue(true,descripcion);
        if (estatus.equals(Status.FAILED)){
            softAssert.fail(descripcion);
        }
        if (fatal){
            Assert.fail(descripcion);
        }
        System.out.println("[Report] "+ descripcion);
    }

     */
    /*
    private static void reportCapturaPantalla(){
        File scrFile;
        scrFile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
        File foto = new File(scrFile.getPath());
        InputStream image;
        try {
            image = new FileInputStream(foto);
            Allure.addAttachment("Imagen Adjunta",image);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

     */
    public static void finalAssert(){
        softAssert.assertAll();
    }
}
