package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.wikidexPages.HomePageWikidex;
import pages.wikidexPages.MenuPageWikidex;
import pages.wikidexPages.ResultadoPageWikidex;

import static utils.MetodosGenericos.esperarSegundos;

public class PruebasApkWikidexSteps {

    private final HomePageWikidex homePageWikidex = new HomePageWikidex();
    private final ResultadoPageWikidex resultadoPageWikidex = new ResultadoPageWikidex();
    private final MenuPageWikidex menuPageWikidex = new MenuPageWikidex();

    @And("visualizo el mensaje de bienvenida text {string}")
    public void visualizoElMensajeDeBienvenidaText(String arg0) {
        System.out.println("Visualizo texto \""+arg0+"\" en pantalla inicial");
        Assert.assertTrue(homePageWikidex.textoVisible(),"Elemento visible");
        Assert.assertEquals(homePageWikidex.contenidoTexto(),arg0);
    }

    @And("visualizo imagen de Wikidex")
    public void visualizoImagenDeWikidex() {
        System.out.println("Visualizo imagen de Wikidex");
        Assert.assertTrue(homePageWikidex.cargaImagen(),"Imagen visible");
    }

    @Given("necesito buscar un registro en especifico")
    public void necesitoBuscarUnDatoEnEspecifico() {
        System.out.println("Necesito buscar un registro en especifico");
        Assert.assertTrue(homePageWikidex.botonBuscarVisible(),"Boton buscar visible");
    }

    @And("selecciono el icono de buscar")
    public void seleccionoElIconoDeBuscar() {
        System.out.println("Selecciono el icono de buscar");
        homePageWikidex.clickBuscar();
    }

    @And("ingreso texto en el campo de busquedad texto {string}")
    public void ingresoTextoEnElCampoDeBusquedadTexto(String arg0) {
        System.out.println("ingreso texto en el campo de busquedad texto "+ arg0);
        Assert.assertTrue(homePageWikidex.casillaTextoVisible(), "Casilla de texto visible");
        homePageWikidex.llenarCasilla(arg0);
    }

    @Then("visualizo los resultados de la busqueda")
    public void visualizoLosResultadosDeLaBusqueda() {
        System.out.println("Visualizo los resultados de la busqueda");
        Assert.assertTrue(homePageWikidex.cantidadDeResultados()>1,"Los resultados de la busqueda son mayores que uno");
    }

    @And("selecciono el primer resultado encontrado")
    public void seleccionoElPrimerResultadoEncontrado() {
        System.out.println("Selecciono el primer resultado encontrado");
        homePageWikidex.clickPrimerElemento();
    }

    @Then("visualizo el contenido de {string} en el resultado encontrado")
    public void visualizoElContenidoDeEnElResultadoEncontrado(String arg0) {
        System.out.println("Visualizo el contenido de {string} en el resultado encontrado");
        esperarSegundos(10);
        Assert.assertEquals(resultadoPageWikidex.textoResultado(arg0), "Encontrado");
    }

    @Given("necesito cambiar la vista a modo nocturno")
    public void necesitoCambiarLaVistaAModoNocturno() {
        System.out.println("Necesito cambiar la vista a modo nocturno");
        Assert.assertTrue(menuPageWikidex.ajustesVisible(),"Icono Ajustes visible");
    }

    @And("selecciono el icono ajustes")
    public void seleccionoElIconoAjustes() {

    }
}
