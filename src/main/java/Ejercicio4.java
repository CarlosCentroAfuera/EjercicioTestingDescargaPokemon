import java.util.Arrays;

public class Ejercicio4 {

    public Pokemon[] arrayPokemons = new Pokemon[0];

    /**
     * Inicializa al ejercico 4 y muestra por pantalla los valores inciiales
     */
    public void iniciarEjercicio4() {
        System.out.println("Empezando el ej4");
        // Mostamos al Pokémon por pantalla
        for (Pokemon pokemon : arrayPokemons) {
            System.out.println(pokemon);
        }
        System.out.println("Resultado de pokemonMasGordosQue");
        Pokemon[] result = pokemonMasGordosQue(225);
        for (Pokemon pokemon : result) {
            System.out.println(pokemon);
        }
    }

    /**
     * Obtiene a los pokemon que pesan más que "peso"
     *
     * @param peso si peso es null, se lanzará NullPointerException
     * @return los Pokémon que son más gordos que el "peso" introducido
     */
    public Pokemon[] pokemonMasGordosQue(Integer peso) {
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            if (pokemon.getWeight() > peso) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
    }

    /**
     * Obtiene a los pokemon que pesan menos que "peso"
     *
     * @param peso No debería ser null
     * @return los Pokémon que son más gordos que el "peso" introducido
     */
    public Pokemon[] pokemonMenosGordosQue(int peso) {
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            if (pokemon.getWeight() < peso) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
    }

    /**
     * Obtiene a los pokemon que pesan menos que "peso"
     *
     * @param pesoMaximo No debería ser null
     * @param pesoMinimo No debería ser null
     * @return los Pokémon que son más gordos que el "peso" introducido
     */
    public Pokemon[] getPokemonPesoEntre(int pesoMaximo, int pesoMinimo) {
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            if (pokemon.getWeight() > pesoMinimo && pokemon.getWeight() < pesoMaximo) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
    }

    /**
     * Obtiene a los pokemon que pesan menos que "peso"
     *
     * @param longitudDelTexto No debería ser null
     * @return los Pokémon que son más gordos que el "peso" introducido
     */
    public Pokemon[] getPokemonNombreMasLargoQue(int longitudDelTexto) {
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            if (pokemon.getName().length() > longitudDelTexto) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
    }

    public Pokemon[] getPokemonNombreMasCortoQue(int longitudDelTexto) {
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            if (pokemon.getName().length() < longitudDelTexto) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
    }


    /**
     * @param letras
     * @return
     */
    public Pokemon[] getPokemonQueContengaLasSiguientesLetras(String letras) {
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            char[] arrayLetras = letras.toCharArray();

            boolean encontrado = true;
            for (char letra : arrayLetras) {
                if (!pokemon.getName().contains(String.valueOf(letra))) {
                    encontrado = false;
                    break;
                }
            }
            if (encontrado) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
    }
    // Atención, esta operación debe devolver un array de pokemons vacio si letras fuera null.

    // No hay que tener en cuenta el orden
    public Pokemon[] getArraySinNulos(Pokemon[] pokemons, int comienzoNulos) {
        return Arrays.copyOfRange(pokemons, 0, comienzoNulos);
    }


    /*
    Calculandolo tu mismo
     */
    public Pokemon[] getArraySinNulos(Pokemon[] pokemons) {
        int comienzoNulos = 0;
        while (comienzoNulos < pokemons.length) {
            if (pokemons[comienzoNulos] != null) {
                comienzoNulos++;
            } else {
                break;
            }
        }

        return Arrays.copyOfRange(pokemons, 0, comienzoNulos);
    }

}
