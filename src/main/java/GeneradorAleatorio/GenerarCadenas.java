package GeneradorAleatorio;

import ListaDoble.ListaDoble;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerarCadenas {

    public void generarCadenasAleatorias(ListaDoble<String> lista, int cantidad, int longitudMaxima) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            StringBuilder cadena = new StringBuilder();
            int longitudCadena = random.nextInt(longitudMaxima) + 1; // Longitud aleatoria de la cadena
            for (int j = 0; j < longitudCadena; j++) {
                cadena.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            lista.agregarAlFinal(cadena.toString());
        }
    }

    public void generarCadenasAscendentes(ListaDoble<String> lista, int cantidad, int longitudMaxima) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        List<String> cadenas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            StringBuilder cadena = new StringBuilder();
            int longitudCadena = random.nextInt(longitudMaxima) + 1;
            for (int j = 0; j < longitudCadena; j++) {
                cadena.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            cadenas.add(cadena.toString());
        }


        // Agregar las cadenas a la lista
        for (String cadena : cadenas) {
            lista.agregarAlFinal(cadena);
        }
    }

    public void generarCadenasDescendentes(ListaDoble<String> lista, int cantidad, int longitudMaxima) {

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        List<String> cadenas = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            StringBuilder cadena = new StringBuilder();
            int longitudCadena = random.nextInt(longitudMaxima) + 1;
            for (int j = 0; j < longitudCadena; j++) {
                cadena.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            cadenas.add(cadena.toString());
        }

        // Agregar las cadenas a la lista
        for (String cadena : cadenas) {
            lista.agregarAlFinal(cadena);
        }
    }
}
