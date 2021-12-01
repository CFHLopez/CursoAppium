package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManagger driverManagger = new DriverManagger();

    // Funcion setUp
    public static void setUp(String nombreDispositivo, String SO, String dirApk, String udId, boolean emulador){
        driverManagger.iniciarSeccion(nombreDispositivo,SO,dirApk,udId,emulador);
    }

    // Funcion getDriver
    public static AppiumDriver getDriver(){
        return driverManagger.getDriver();
    }

    // Funcion quitDriver
    // Cerrar la conexion
    public static void quitDriver(){
        driverManagger.getDriver().quit();
    }
}