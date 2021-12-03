package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManager driverManager = new DriverManager();

    // Funcion setUp
    // inicia la ejecusión
    public static void setUp(String nombreDispositivo, String SO, String dirApk, String udId, boolean emulador){
        driverManager.iniciarSeccion(nombreDispositivo,SO,dirApk,udId,emulador);
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