package e4;

 import org.junit.jupiter.api.BeforeAll;
 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;

public class BolaBillarTest {
    private static BolaBillar bolaBlanca;
    private static BolaBillar bola8;
    private static BolaBillar bola2;
    private static BolaBillar bola10;
    private static BolaBillar bola15;

    @BeforeAll
    public static void setUp() {
        bolaBlanca = BolaBillar.BLANCA;
        bola8 = BolaBillar.BOLA8;
        bola2 = BolaBillar.BOLA2;
        bola10 = BolaBillar.BOLA10;
        bola15 = BolaBillar.BOLA15;
    }

    @Test
    public void testBolaBlanca() {
        assertEquals(0, bolaBlanca.getNumero());
        assertEquals("BLANCO", bolaBlanca.getColor());
        assertEquals("LISA", bolaBlanca.getTipo());
    }

    @Test
    public void testBola8() {
        assertEquals(8, bola8.getNumero());
        assertEquals("NEGRO", bola8.getColor());
        assertEquals("LISA", bola8.getTipo());
    }

    @Test
    public void testBola2() {
        assertEquals(2, bola2.getNumero());
        assertEquals("AZUL", bola2.getColor());
        assertEquals("LISA", bola2.getTipo());
    }

    @Test
    public void testBola10() {
        assertEquals(10, bola10.getNumero());
        assertEquals("AZUL", bola10.getColor());
        assertEquals("RAYADA", bola10.getTipo());
    }

    @Test
    public void testBola15() {
        assertEquals(15, bola15.getNumero());
        assertEquals("GRANATE", bola15.getColor());
        assertEquals("RAYADA", bola15.getTipo());
    }
}