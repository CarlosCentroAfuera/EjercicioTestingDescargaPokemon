import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio4Test {

    static Ejercicio4 ej;

    @BeforeAll
    static void firstInit() {
        System.out.println("firstInit");
        ej = new Ejercicio4();
        ej.arrayPokemons = ObtenerPokemonsRequest.Companion.get(1,9);
    }


    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }


    @Test
    void pokemonMasGordosQueCasoNormal() {
        Pokemon[] pokemonEsperados = {
                new Pokemon(20, 3, "venusaur", 1000),
                new Pokemon(17, 6, "charizard", 905),
                new Pokemon(16, 9, "blastoise", 855)
        };
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(250);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonMasGordosQueCasoTodos() {
        Pokemon[] pokemonEsperados = ej.arrayPokemons;
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(0);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonMasGordosQueCasoNinguno() {
        Pokemon[] pokemonEsperados = new Pokemon[]{};
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(50000);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonMasGordosQueCasoPesoNegativo() {
        Pokemon[] pokemonEsperados = ej.arrayPokemons;
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(-100);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }


    @Test
    void pokemonMasGordosQueCasoNull() {
         Assertions.assertThrows(NullPointerException.class, ()-> ej.pokemonMasGordosQue(null));
    }


    @Test
    void getPokemonQueContengaLasSiguientesLetras() {
        Pokemon[] pokemonEsperados = {
                new Pokemon(7, 1, "bulbasaur", 69),
                new Pokemon(10, 2, "ivysaur", 130),
                new Pokemon(20, 3, "venusaur", 1000)
        };
        Pokemon[] pokemonActuales = ej.getPokemonQueContengaLasSiguientesLetras("saur");
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }


}