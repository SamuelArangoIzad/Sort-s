package Quick;

import ListaDoble.ListaDoble;
import ListaDoble.Nodo;
import Sort.Sort;

public class QuickSort <T extends Comparable<T>> implements Sort<T> {


    //Verificamos que esto tenga elementos es decir la lista para no perder tiempo
    @Override
    public ListaDoble<T> sort(ListaDoble<T> lista) {
        if (lista == null || lista.getCabeza() == null || lista.getCabeza().siguiente == null) {
            return lista; // Lista vacía o con un solo elemento ya está ordenada
        }

        quickSort(lista.getCabeza(), lista.getCola());//de tener elementos entonces empieza la recursividad
        return lista;
    }


    //Aplicamos ordenamiento
    private void quickSort(Nodo<T> cabeza, Nodo<T> cola) {
        if (cabeza != null && cola != null && cabeza != cola && cabeza != cola.siguiente) {
            Nodo<T> pivote = partition(cabeza, cola);//Particion del pivote
            quickSort(cabeza, pivote.anterior); // Ordenar sublista izquierda
            quickSort(pivote.siguiente, cola);  // Ordenar sublista derecha
        }
    }


    //Desplaza los elementos hacia la izquierda del pivote o derecha
    private Nodo<T> partition(Nodo<T> cabeza, Nodo<T> cola) {
        T valorPivote = cola.dato;
        Nodo<T> i = cabeza.anterior;

        for (Nodo<T> j = cabeza; j != cola; j = j.siguiente) {
            if (j.dato.compareTo(valorPivote) <= 0) {
                i = (i == null) ? cabeza : i.siguiente;
                swap(i, j);
            }
        }
        i = (i == null) ? cabeza : i.siguiente;
        swap(i, cola);

        return i;
    }


    //Intercambia los valores de los nodos
    private void swap(Nodo<T> nodo1, Nodo<T> nodo2) {
        T temp = nodo1.dato;
        nodo1.dato = nodo2.dato;
        nodo2.dato = temp;
    }
}
