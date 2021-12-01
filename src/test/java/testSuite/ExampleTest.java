package testSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static conexion.DriverContext.setUp;

public class ExampleTest {
    /*
    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();

     */
    @BeforeMethod
    public void iniciarSeccion(){
        /*
        try{
            server = new URL ("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException error){
            error.printStackTrace();
        }
        // INSTANCIA DE CAPABILITIES
        cap.setCapability("deviceName","ZY327WFR7S");
        cap.setCapability("platformName","Android");
        cap.setCapability("app","C:\\Users\\chris\\Downloads\\Instagram.apk");
        cap.setCapability("udid","ZY327WFR7S");

        driver = new AndroidDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         */
        setUp("ZY327WFR7S","Android","C:\\Users\\chris\\Downloads\\Instagram.apk","ZY327WFR7S",false);
    }
    @Test
    public void testPrueba(){
        System.out.println("Ejecución del test de prueba");
    }
}