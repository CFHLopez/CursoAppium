package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManager driverManager = new DriverManager();

    // Funcion setUp
    // inicia la ejecusión
    public static void setUp(String nombreDispositivo, String dirApk, String udId, String appWaitAct, boolean emulador){
        driverManager.iniciarSeccion(nombreDispositivo,dirApk,udId, appWaitAct,emulador);
    }

    // Funcion getDriver
    // nos retorna el objeto driver
    public static AppiumDriver getDriver(){
        return driverManager.getDriver();
    }

    // Funcion quitDriver
    // Cerrar la conexion
    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}