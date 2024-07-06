package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CuentaBancariaTest {
    private static ClienteNormal cliente1;
    private static ClientePreferente cliente2;
    private static ClienteVIP cliente3;
    private static CuentaCorriente cuenta1C;
    private static CuentaAhorro cuenta1A;
    private static CuentaCorriente cuenta2C;
    private static CuentaAhorro cuenta2A;
    private static CuentaCorriente cuenta3C;
    private static CuentaAhorro cuenta3A;


    @BeforeAll
    static void setUp() {
        cliente1 = new ClienteNormal("12345678A");
        cliente2 = new ClientePreferente("87654321B");
        cliente3 = new ClienteVIP("12348765C");

        cuenta1C = new CuentaCorriente("ES1234567890", 1000, cliente1);
        cuenta1A = new CuentaAhorro("ES1234567891", 1000, cliente1);

        cuenta2C = new CuentaCorriente("ES1234567892", 1000, cliente2);
        cuenta2A = new CuentaAhorro("ES1234567893", 1000, cliente2);

        cuenta3C = new CuentaCorriente("ES1234567894", 1000, cliente3);
        cuenta3A = new CuentaAhorro("ES1234567895", 1000, cliente3);
    }

    @Test
    public void testConsultarSaldo() {
        setUp();
        assertEquals(1000, cuenta2C.consultarSaldo());
        assertEquals(1000, cuenta1A.consultarSaldo());
    }

    @Test
    public void testGetIban(){
        assertEquals("ES1234567890", cuenta1C.getIban());
        assertEquals("ES1234567893", cuenta2A.getIban());
    }

    @Test
    public void testRetirarDineroCuentaCorriente() {
        setUp();
        //Cliente normal
        cuenta1C.retirarDinero(1000);
        assertEquals(0, cuenta1C.consultarSaldo());
        cuenta1C.retirarDinero(1500);
        assertEquals(0, cuenta1C.consultarSaldo());

        //Cliente preferente
        cuenta2C.retirarDinero(15000);
        assertEquals(-14000, cuenta2C.consultarSaldo());

        cuenta2C.retirarDinero(150000);
        assertEquals(-14000, cuenta2C.consultarSaldo());

        //Cliente VIP
        cuenta3C.retirarDinero(15000);
        assertEquals(-14000, cuenta3C.consultarSaldo());

        cuenta3C.retirarDinero(150000);
        assertEquals(-164000, cuenta3C.consultarSaldo());

    }

    @Test
    public void testRetirarDineroCuentaAhorro() {
        setUp();
        //Cliente normal
        cuenta1A.retirarDinero(800);
        assertEquals(1000, cuenta1A.consultarSaldo());

        cuenta1A.retirarDinero(100);
        assertEquals(600, cuenta1A.consultarSaldo());

        cuenta1A.retirarDinero(300);
        assertEquals(0, cuenta1A.consultarSaldo());

        //Cliente preferente
        cuenta2A.retirarDinero(900);
        assertEquals(0, cuenta2A.consultarSaldo());

        cuenta2A.retirarDinero(15000);
        assertEquals(-15300, cuenta2A.consultarSaldo());

        cuenta2A.retirarDinero(84700);
        assertEquals(-15300, cuenta2A.consultarSaldo());

        //Cliente VIP
        cuenta3A.retirarDinero(900);
        assertEquals(100, cuenta3A.consultarSaldo());

        cuenta3A.retirarDinero(15000);
        assertEquals(-14900, cuenta3A.consultarSaldo());

        cuenta3A.retirarDinero(100000);
        assertEquals(-114900, cuenta3A.consultarSaldo());

    }

    @Test
    public void testIngresarDinero(){
        setUp();
        cuenta1C.ingresarDinero(100000);
        assertEquals(101000, cuenta1C.consultarSaldo());

        cuenta1A.ingresarDinero(50000);
        assertEquals(1000, cuenta1A.consultarSaldo());

        cuenta1A.ingresarDinero(150000);
        assertEquals(151000, cuenta1A.consultarSaldo());

        cuenta2C.ingresarDinero(-100000);
        assertEquals(1000, cuenta2C.consultarSaldo());

        cuenta2A.ingresarDinero(50000);
        assertEquals(51000, cuenta2A.consultarSaldo());

        cuenta2A.ingresarDinero(5000);
        assertEquals(51000, cuenta2A.consultarSaldo());

        cuenta3C.ingresarDinero(4000);
        assertEquals(5000, cuenta3C.consultarSaldo());

        cuenta3A.ingresarDinero(4000);
        assertEquals(5000, cuenta3A.consultarSaldo());
    }

}