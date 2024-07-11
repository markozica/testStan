package testovi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stan.Stan;


public class StanTest {

    @Test
    public void testKonstruktorIDohvatioci() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        assertEquals("Neka Adresa 123", stan.getAdresa());
        assertEquals(50, stan.getKvdratura());
        assertEquals(1000, stan.getCenaPoKvadratu());
    }

    @Test
    public void testPostaviKvadraturuValidno() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        stan.setKvadratura(60);
        assertEquals(60, stan.getKvdratura());
    }

    @Test
    public void testPostaviKvadraturuNevalidno() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stan.setKvadratura(-1);
        });
        assertEquals("Kvadratura ne sme biti manja od 0", exception.getMessage());
    }

    @Test
    public void testPostaviCenuPoKvadratuValidno() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        stan.setCenaPoKvadratu(1200);
        assertEquals(1200, stan.getCenaPoKvadratu());
    }

    @Test
    public void testPostaviCenuPoKvadratuNevalidno() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stan.setCenaPoKvadratu(-1);
        });
        assertEquals("Cena mora biti veca od 0 i manja od 5000", exception.getMessage());
    }

    @Test
    public void testPostaviAdresuValidno() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        stan.setAdresa("Nova Adresa 456");
        assertEquals("Nova Adresa 456", stan.getAdresa());
    }

    @Test
    public void testPostaviAdresuNevalidno() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stan.setAdresa(null);
        });
        assertEquals("Morate uneti adresu", exception.getMessage());
    }

    @Test
    public void testIzracunajCenu() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        assertEquals(50000, stan.izracunajCenu());
    }

    @Test
    public void testPovoljanStan() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        assertTrue(stan.povoljanStan());
        stan.setCenaPoKvadratu(2000);
        assertFalse(stan.povoljanStan());
    }

    @Test
    public void testToString() {
        Stan stan = new Stan("Neka Adresa 123", 50, 1000);
        assertEquals("Stan [adresa=Neka Adresa 123, kvadratura=50, cena po kvadratu=1000]", stan.toString());
    }
}
