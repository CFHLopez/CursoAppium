package pages.agendaPages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.util.List;

public class CalendarioPageAgenda extends MetodosGenericos {

    /**
     * Variables
     */

    private AppiumDriver driver;
    private String atributoEnabled = "enabled";
    private String atributoClickable = "clickable";

    /**
     * Constructor
     */

    public CalendarioPageAgenda(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/date_picker_header_year']")
    private MobileElement txtAno;
    @AndroidFindBy(xpath = "//android.view.View[@checked='true']")
    private MobileElement diaFecha;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/date_picker_header_date']")
    private MobileElement txtFecha;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/prev']")
    private MobileElement btnPrev;
    @AndroidFindBy(xpath = "//*[@class='android.view.View']")
    private List <MobileElement> listaDiasMes;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/text1']")
    private List <MobileElement> listaAnos;

    /**
     * Acciones
     */

    public String fechaDocumento(){
        return retornarTexto(diaFecha);
    }

    public String anoRegistroCreado(){
        return retornarTexto(txtAno);
    }

    public String mesRegistroCreado(){
        return retornarMesApkMyPersonalAgenda(txtFecha);
    }

    public boolean txtAnoVisible(){
        return inspeccionarAtributo(atributoEnabled,txtAno);
    }

    public boolean txtAnoClickeable(){
        return inspeccionarAtributo(atributoClickable,txtAno);
    }

    public void darClickTxtAno(){
        darClick(txtAno);
    }

    public void selecionarJulio(){
        seleccionarMesJulio(listaDiasMes,btnPrev,txtFecha);
    }

    public void seleccionarFechaEspecifica(String dia, String mes, String ano){
        System.out.println("Cambio de dia y mes");
        seleccionarMesDia(listaDiasMes,btnPrev,txtFecha,dia,mes);
        System.out.println("Cambio de Año");
        darClick(txtAno);
        seleccionarElemento(listaAnos, ano);
    }

    public void seleccionarAno(String anoSelecionado){
        seleccionarElemento(listaAnos, anoSelecionado);
    }
}