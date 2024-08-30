package GeneradorAleatorio;

import ListaDoble.ListaDoble;

import java.util.Random;

public class generarNumeros {

    //Aelatorios
    public void generarNumerosAleatorios(ListaDoble<Integer> lista, int cantidad, int limiteInferior, int limiteSuperior) {
        Random random = new Random();
        for (int ii = 0; ii < cantidad; ii++) {
            int numeroAleatorio = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
            lista.agregarAlFinal(numeroAleatorio);
        }
    }

    // Método para generar números en orden ascendente
    public void generarNumerosOrdenadosAscendente(ListaDoble<Integer> lista, int cantidad, int limiteInferior) {
        for (int ii = 0; ii < cantidad; ii++) {
            lista.agregarAlFinal(limiteInferior + ii);
        }
    }

    // Método para generar números en orden descendente
    public void generarNumerosOrdenadosDescendente(ListaDoble<Integer> lista, int cantidad, int limiteSuperior) {
        for (int ii = 0; ii < cantidad; ii++) {
            lista.agregarAlFinal(limiteSuperior - ii);
        }
    }
}
