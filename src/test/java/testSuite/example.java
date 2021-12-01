package testSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class example {
    private SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void metodo1(){
        System.out.println("Inicio de Suite");
    }
    @AfterSuite
    public void metodo2(){
        System.out.println("Termino de Suite");
    }
    @Test (priority = 1,description = "Prueba 1")
    public void metodo3(){
        System.out.println("Test 1");
        softAssert.fail("Fail SOFT");
        System.out.println("Test 1");
        // se evaluan todos los softAssert
        softAssert.assertAll();
    }
    @Test(priority = 2,description = "Prueba 2")
    public void metodo4(){
        System.out.println("Test 2");
        Assert.assertTrue(true);
        Assert.assertTrue(false);
        Assert.assertEquals("1","0","Los Números no sn iguales");
        //Assert.fail("FAIL");
        // System.out.println("Test 2");
    }

    @AfterMethod
    public void metodo5(){
        System.out.println("Termino Test");
        Assert.assertTrue(true);
    }
}