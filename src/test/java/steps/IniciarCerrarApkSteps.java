package steps;

import conexion.DriverContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static conexion.DriverContext.setUp;

public class IniciarCerrarApkSteps {

    @Given("Inicio en aplicacion {string} desde dispositivo nombre {string}, virtual {string} y wait activity {string}")
    public void inicioEnAplicacionDesdeDispositivoNombreVirtual(String arg0, String arg1, String arg2, String arg3) {
        System.out.println("\nInicio de aplicación "+arg0);
        setUp(arg1,
                "C:\\Users\\excloch\\Documents\\Apk\\"+arg0,
                arg1,
                arg3,
                Boolean.parseBoolean(arg2));
    }

    @And("Cerrar la aplicación")
    public void cerrarLaAplicacion() {
        System.out.println("\nCerrar APK");
        DriverContext.quitDriver();
    }
}
