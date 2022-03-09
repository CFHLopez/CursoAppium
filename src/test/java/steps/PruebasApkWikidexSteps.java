package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.wikidexPages.FavoritosPageWikidex;
import pages.wikidexPages.HomePageWikidex;
import pages.wikidexPages.MenuPageWikidex;
import pages.wikidexPages.ResultadoPageWikidex;

import java.util.Objects;

import static utils.MetodosGenericos.esperarSegundos;

public class PruebasApkWikidexSteps {

    private final HomePageWikidex homePageWikidex = new HomePageWikidex();
    private final ResultadoPageWikidex resultadoPageWikidex = new ResultadoPageWikidex();
    private final MenuPageWikidex menuPageWikidex = new MenuPageWikidex();
    private final FavoritosPageWikidex favoritosPageWikidex = new FavoritosPageWikidex();

    @And("Visualizo el mensaje de bienvenida text {string}")
    public void visualizoElMensajeDeBienvenidaText(String arg0) {
        System.out.println("\nVisualizo texto \""+arg0+"\" en pantalla inicial");
        Assert.assertTrue(homePageWikidex.textoVisible(),
                "Elemento NO visible");
        Assert.assertEquals(homePageWikidex.contenidoTexto(),arg0);
    }

    @And("Visualizo imagen de Wikidex")
    public void visualizoImagenDeWikidex() {
        System.out.println("\nVisualizo imagen de Wikidex");
        Assert.assertTrue(homePageWikidex.cargaImagen(),"Imagen NO visible");
    }

    @Given("Necesito buscar un registro en especifico")
    public void necesitoBuscarUnDatoEnEspecifico() {
        System.out.println("\nNecesito buscar un registro en especifico");
        Assert.assertTrue(homePageWikidex.botonBuscarVisible(),
                "Boton buscar NO visible");
    }

    @And("Selecciono el icono de buscar")
    public void seleccionoElIconoDeBuscar() {
        System.out.println("\nSelecciono el icono de buscar");
        homePageWikidex.clickBuscar();
    }

    @And("Ingreso texto en el campo de busquedad texto {string}")
    public void ingresoTextoEnElCampoDeBusquedadTexto(String arg0) {
        System.out.println("\nIngreso texto en el campo de busquedad texto "+ arg0);
        Assert.assertTrue(homePageWikidex.casillaTextoVisible(),
                "Casilla de texto NO visible");
        homePageWikidex.llenarCasilla(arg0);
    }

    @Then("Visualizo los resultados de la busqueda")
    public void visualizoLosResultadosDeLaBusqueda() {
        System.out.println("\nVisualizo los resultados de la busqueda");
        Assert.assertTrue(homePageWikidex.cantidadDeResultados()>1,
                "Los resultados de la busqueda son iguales o menor que 1");
    }

    @And("Selecciono el primer resultado encontrado")
    public void seleccionoElPrimerResultadoEncontrado() {
        System.out.println("\nSelecciono el primer resultado encontrado");
        homePageWikidex.clickPrimerElemento();
    }

    @Then("Visualizo el contenido de {string} en el resultado encontrado")
    public void visualizoElContenidoDeEnElResultadoEncontrado(String arg0) {
        System.out.println("\nVisualizo el contenido de "+arg0+" en el resultado encontrado");
        Assert.assertEquals(resultadoPageWikidex.textoResultado(arg0),
                "Encontrado",
                "Contenido NO encontrado");
    }

    @Given("Necesito cambiar la vista a modo nocturno")
    public void necesitoCambiarLaVistaAModoNocturno() {
        System.out.println("\nNecesito cambiar la vista a modo nocturno");
        Assert.assertTrue(menuPageWikidex.ajustesVisible(),
                "Icono ajustes NO visible");
    }

    @And("Selecciono el icono ajustes")
    public void seleccionoElIconoAjustes() {
        System.out.println("\nSelecciono el icono ajustes");
        menuPageWikidex.clickAjustes();
    }

    @And("Selecciono activar el modo nocturno")
    public void seleccionoActivarElModoNocturno() {
        System.out.println("\nSelecciono activar el modo nocturno");
        if (menuPageWikidex.opcionModoNocturnoVisible()){
            if (!menuPageWikidex.estadoModoNocturno()){
                menuPageWikidex.clickModoNocturno();
            }
            else {
                System.out.println("\nModo nocturno estaba activado");
            }
        }
        else {
            System.out.println("\nModo Nocturno no habilitado");
        }
    }

    @Given("Necesito buscar una pagina al azar")
    public void necesitoBuscarUnaPaginaAlAzar() {
        System.out.println("\nNecesito buscar una pagina al azar");
        Assert.assertTrue(menuPageWikidex.menuVisible(),
                "Menu NO visible");
    }

    @And("Selecciono el menu lateral izquierdo")
    public void seleccionoElMenuLateralIzquierdo() {
        System.out.println("\nSelecciono el menu lateral izquierdo");
        menuPageWikidex.clickMenu();
    }

    @And("Selecciono {string} del menu lateral izquierdo")
    public void seleccionoDelMenuLateralIzquierdo(String arg0) {
        System.out.println("\nSelecciono "+arg0+" del menu lateral izquierdo");
        menuPageWikidex.clickEn(arg0);
    }

    @Then("Visualizo una pagina aleatoria")
    public void visualizoUnaPaginaAleatoria() {
        System.out.println("\nVisualizo una pagina aleatoria");
        Assert.assertTrue(!Objects.equals(menuPageWikidex.nombrePaginaActual(), "Wikidex"),
                "NO se genera una Página aleatoria distinta de Wikidex Home");
        // para cerrar menu se da click en menu mas opciones
        menuPageWikidex.clickMasOpciones();
    }

    @And("Selecciono el menu de mas opciones")
    public void seleccionoElMenuDeMasOpciones() {
        System.out.println("\nSelecciono el menu de mas opciones");
        Assert.assertTrue(menuPageWikidex.masOpcionesVisible(),
                "Menu más opciones NO visible");
        menuPageWikidex.clickMasOpciones();
    }

    @And("Seleciono {string} de el menu mas opciones")
    public void selecionoDeElMenuMasOpciones(String arg0) {
        System.out.println("\nSeleciono "+arg0+" de el menu mas opciones");
        menuPageWikidex.elegirOpcion(arg0);
    }

    @Then("Visualizo la vista de favoritos")
    public void visualizoLaVistaDeFavoritos() {
        System.out.println("\nVisualizo la vista de favoritos");
        Assert.assertTrue(Objects.equals(menuPageWikidex.nombrePaginaActual(),"Favoritos"),
                "La página actual es la de favoritos");
    }

    @And("Visualizo solo {string} resultado agregado en la pagina de favoritos")
    public void visualizoSoloResultadoAgregadoEnLaPaginaDeFavoritos(String arg0) {
        System.out.println("\nVisualizo solo "+arg0+" resultado agregado en la pagina de favoritos");
        Assert.assertTrue(favoritosPageWikidex.cantidadPaginasGuardadas()==Integer.parseInt(arg0),
                "La cantidad de favoritos guardados es 1");
    }

    @Then("Necesito eliminar la pagina guardada")
    public void necesitoEliminarLaPaginaGuardada() {
        System.out.println("\nNecesito eliminar la pagina guardada");
        Assert.assertTrue(favoritosPageWikidex.iconoEliminarVisible(),
                "Icono para eliminar la página guardada visible");
    }

    @And("Selecciono eliminar la pagina guardada")
    public void seleccionoEliminarLaPaginaGuardada() {
        System.out.println("\nSelecciono eliminar la pagina guardada");
        favoritosPageWikidex.clickEliminar();
    }

    @Then("Visualizo mensaje {string}")
    public void visualizoMensaje(String arg0) {
        System.out.println("\nVisualizo mensaje "+arg0);
        Assert.assertTrue(favoritosPageWikidex.mensajeVisible(),
                "Mensaje NO visible luego de eliminar favorito agregado");
        Assert.assertEquals(favoritosPageWikidex.mensaje(),arg0,
                "Mensaje -> "+ arg0 +" <- visible");
    }
}