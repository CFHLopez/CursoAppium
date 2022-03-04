package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.agendaPages.CalendarioPageAgenda;
import pages.agendaPages.DiarioPageAgenda;
import pages.agendaPages.HomePageAgenda;

public class PruebasApkMyPersonalAgendaSteps {

    private final HomePageAgenda homePageAgenda = new HomePageAgenda();
    private final DiarioPageAgenda diarioPageAgenda = new DiarioPageAgenda();
    private final CalendarioPageAgenda calendarioPageAgenda = new CalendarioPageAgenda();

    @And("Visualizo el texto {string} en la parte superior")
    public void visualizoElTextoEnLaParteSuperior(String arg0) {
        System.out.println("Visualizo el texto "+arg0+" en la parte superior");
        Assert.assertTrue(homePageAgenda.textoSeccionVisible(),
                "Texto Seccion Visible");
        Assert.assertEquals(homePageAgenda.textoVisibleSeccion(),arg0);
    }

    @Given("Necesito comprobar los elementos visibles")
    public void necesitoComprobarLosElementosVisibles() {
        System.out.println("Necesito comprobar los elementos visibles");
        Assert.assertTrue(homePageAgenda.iconoMenuVisible(),
                "Icono Menu Visible");
        Assert.assertTrue(homePageAgenda.iconoBuscarVisible(),
                "Icono Buscar Visible");
        Assert.assertTrue(diarioPageAgenda.iconoFiltroVisible(),
                "Icono Filtro Visible");
        Assert.assertTrue(homePageAgenda.textoGrupoVisible(),
                "Texto Grupo Visible");
    }

    @And("Visualizo el nombre de grupo texto {string}")
    public void visualizoElNombreDeGrupoTexto(String arg0) {
        System.out.println("visualizo el nombre de grupo texto "+arg0);
        Assert.assertEquals(homePageAgenda.textoVisibleGrupo(),arg0);
    }

    @And("Selecciono el icono menu")
    public void seleccionoElIconoMenu() {
        System.out.println("Selecciono el icono menu");
        Assert.assertTrue(homePageAgenda.iconoMenuClickeable(),
                "Icono Menu Clickeable");
        homePageAgenda.darClickMenu();
    }

    @And("Selecciono el icono de buscar de my personal agenda")
    public void seleccionoElIconoDeBuscarDeMyPersonalAgenda() {
        System.out.println("Selecciono el icono de buscar de my personal agenda");
        Assert.assertTrue(homePageAgenda.iconoBuscarClickeable(),
                "Icono Buscar Clickeable");
        homePageAgenda.darClickBuscar();
    }

    @Then("Visualizo una ventana emergente con texto {string}")
    public void visualizoUnaVentanaEmergenteConTexto(String arg0) {
        System.out.println("Visualizo una ventana emergente con texto "+arg0);
        Assert.assertTrue(homePageAgenda.textoVentanaVisible(),
                "El texto de titulo en la ventana emergente es visible");
        Assert.assertEquals(homePageAgenda.textoVisibleVentana(),arg0);
    }

    @And("Selecciono el icono de filtro")
    public void seleccionoElIconoDeFiltro() {
        System.out.println("Selecciono el icono de filtro");
        Assert.assertTrue(diarioPageAgenda.iconoFiltroClickeable(),
                "Icono Filtro Clickeable");
        diarioPageAgenda.darClickIconoFiltro();
    }

    @And("Visualizo el icono agregar clickeable")
    public void visualizoElIconoAgregarVisibleYClickeable() {
        System.out.println("Visualizo el icono agregar clickeable");
        Assert.assertTrue(homePageAgenda.iconoAgregarClickeable(),
                "Icono Agregar Clickeable");
    }

    @And("Selecciono cerrar la ventana emergente")
    public void seleccionoCerrarLaVentanaEmergente() {
        System.out.println("Selecciono cerrar la ventana emergente");
        homePageAgenda.cerrarVentana();
    }

    @Given("Necesito crear un nuevo registro fecha")
    public void necesitoCrearUnNuevoRegistroFecha() {
        System.out.println("Necesito crear un nuevo registro fecha");
        Assert.assertTrue(homePageAgenda.iconoAgregarVisible(),
                "Icono Agregar Visible");
        Assert.assertTrue(homePageAgenda.iconoAgregarClickeable(),
                "Icono Agregar Clickeable");
    }

    @And("Selecciono el icono de agregar")
    public void seleccionoElIconoDeAgregar() {
        System.out.println("Selecciono el icono de agregar");
        homePageAgenda.darClickAgregar();
    }

    @And("Selecciono el registro visible")
    public void seleccionoElPrimerRegistroVisible() {
        System.out.println("Selecciono el registro visible");
        Assert.assertTrue(diarioPageAgenda.registroCreadoVisible());
        Assert.assertTrue(diarioPageAgenda.registroCreadoClickeable());
        diarioPageAgenda.darClickFechaCreada();
    }

    @And("Visualizo un calendario con fecha {string} de {string} de {string}")
    public void visualizoUnCalendarioConFechaDeDe(String arg0, String arg1, String arg2) {
        System.out.println("Visualizo un calendario con fecha "+arg0+" de "+arg1+" de "+arg2);
        Assert.assertEquals(calendarioPageAgenda.fechaDocumento(),arg0);
        Assert.assertEquals(calendarioPageAgenda.mesRegistroCreado(),arg1);
        Assert.assertEquals(calendarioPageAgenda.anoRegistroCreado(),arg2);
    }

    @When("Seleciono el icono ok")
    public void selecionoElIconoOk() {
        System.out.println("Seleciono el icono ok");
        diarioPageAgenda.darClickOk();
    }

    @And("Selecciono el icono de agregar texto")
    public void seleccionoElIconoDeAgregarTexto() {
        System.out.println("Selecciono el icono de agregar texto");
        Assert.assertTrue(diarioPageAgenda.agregarTextoVisible());
        Assert.assertTrue(diarioPageAgenda.agregarTextoClickeable());
        diarioPageAgenda.darClickAgregarTexto();
    }

    @Then("Visualizo un nuevo cuadro con texto {string}")
    public void visualizoUnNuevoCuadroConTexto(String arg0) {
        System.out.println("Visualizo un nuevo cuadro con texto "+arg0);
        Assert.assertEquals(diarioPageAgenda.contenidoCuadroTexto(),arg0);
    }

    @And("Selecciono el campo de texto e ingresamos el siguiente texto {string}")
    public void seleccionoElCampoDeTextoEIngresamosElSiguienteTexto(String arg0) {
        System.out.println("Selecciono el campo de texto e ingresamos el siguiente texto "+arg0);
        diarioPageAgenda.escribirTexto(arg0);
    }

    @And("Visualizo el texto {string} agregado")
    public void visualizoElTextoAgregado(String arg0) {
        System.out.println("Visualizo el texto "+arg0+" agregado");
        Assert.assertEquals(diarioPageAgenda.textoDoc(),arg0);
    }

    @And("Visualizo opción de generar pdf")
    public void visualizoOpcionDeGenerarPdf() {
        System.out.println("Visualizo opción de generar pdf");
        Assert.assertTrue(diarioPageAgenda.iconoPDFVisible());
        Assert.assertTrue(diarioPageAgenda.iconoPDFClickeable());
    }

    @And("Visualizo opción de editar")
    public void visualizoOpcionDeEditar() {
        System.out.println("Visualizo opción de editar");
        Assert.assertTrue(diarioPageAgenda.btnEditarVisible());
        Assert.assertTrue(diarioPageAgenda.btnEditarClickeable());
    }

    @And("Visualizo opción de agregar color")
    public void visualizoOpcionDeAgregarColor() {
        System.out.println("Visualizo opción de agregar color");
        Assert.assertTrue(diarioPageAgenda.iconoColorVisible());
        Assert.assertTrue(diarioPageAgenda.iconoColorClickeable());
    }

    @Then("Selecciono la opción {string} del menu")
    public void seleccionoLaOpciónDelMenu(String arg0) {
        System.out.println("Selecciono la opción "+arg0+" del menu");
        homePageAgenda.menuDarClickEn(arg0);
    }

    @And("Modifico la fecha visualizada por {string} de {string} de {string}")
    public void modificoLaFechaVisualizadaPorDeDe(String arg0, String arg1, String arg2) {
        System.out.println("Modifico la fecha visualizada por "+arg0+" de "+arg1+" de "+arg2);
        calendarioPageAgenda.seleccionarFechaEspecifica(arg0,arg1,arg2);
    }

    @When("Selecciono el icono de agregar color")
    public void seleccionoElIconoDeAgregarColor() {
        System.out.println("Selecciono el icono de agregar color");
        diarioPageAgenda.darClickIconoColor();
    }

    @And("Selecciono un color al azar")
    public void seleccionoUnColorAlAzar() {
        System.out.println("Selecciono un color al azar");
        diarioPageAgenda.seleccionarColorAleatorio();
    }
}
