package testovi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stan.AgencijaProdajeStanova;
import stan.Stan;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class AgencijaProdajeStanovaTest {

    @BeforeEach
    public void setUp() {
        AgencijaProdajeStanova.stan = new LinkedList<>();
    }

    @AfterEach
    public void tearDown() {
        AgencijaProdajeStanova.stan.clear();
    }

    @ParameterizedTest
    @CsvSource({
        "'Adresa 1', 50, 1000",
        "'Adresa 2', 60, 1500",
        "'Adresa 3', 70, 2000",
        "'Adresa 4', 80, 2500"
    })
    public void testDodajStan(String adresa, int kvadratura, int cenaPoKvadratu) {
        Stan stan = new Stan(adresa, kvadratura, cenaPoKvadratu);
        AgencijaProdajeStanova.dodajStan(stan);
        assertTrue(AgencijaProdajeStanova.stan.contains(stan));
    }

    @ParameterizedTest
    @CsvSource({
        "'Adresa 1', 50, 1000",
        "'Adresa 2', 60, 1500",
        "'Adresa 3', 70, 2000",
        "'Adresa 4', 80, 2500"
    })
    public void testDodajStanException(String adresa, int kvadratura, int cenaPoKvadratu) {
        Stan stan = new Stan(adresa, kvadratura, cenaPoKvadratu);
        AgencijaProdajeStanova.dodajStan(stan);
        assertThrows(RuntimeException.class, () -> {
            AgencijaProdajeStanova.dodajStan(stan);
        });
    }

    @ParameterizedTest
    @CsvSource({
        "'Adresa 1', 50, 1000",
        "'Adresa 2', 60, 1500",
        "'Adresa 1', 70, 2000",
        "'Adresa 4', 80, 2500"
    })
    public void testPronadjiStan(String adresa, int kvadratura, int cenaPoKvadratu) {
        Stan stan = new Stan(adresa, kvadratura, cenaPoKvadratu);
        AgencijaProdajeStanova.dodajStan(stan);
        LinkedList<Stan> pronadjeniStanovi = AgencijaProdajeStanova.pronadjiStan(adresa);
        assertFalse(pronadjeniStanovi.isEmpty());
        assertEquals(adresa, pronadjeniStanovi.getFirst().getAdresa());
    }
}
