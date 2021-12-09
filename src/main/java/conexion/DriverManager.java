package conexion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    // Funcion iniciarSeccion
    protected void iniciarSeccion(String nombreDispositivo, String SO, String dirApk, String udId, String appWaitAct, boolean emulador) {
        try {
            server = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException error) {
            error.printStackTrace();
        }
        // INSTANCIA DE CAPABILITIES
        cap.setCapability("deviceName", nombreDispositivo);
        cap.setCapability("platformName", SO);
        cap.setCapability("app", dirApk);
        cap.setCapability("appWaitActivity", appWaitAct);
        if (!emulador) {
            cap.setCapability("udid", udId);
        }

        driver = new AndroidDriver(server, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Funcion getDriver
    // retorna el driver
    protected AppiumDriver getDriver(){
        return driver;
    }
}