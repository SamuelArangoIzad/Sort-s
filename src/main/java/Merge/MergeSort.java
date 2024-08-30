package Merge;

import ListaDoble.ListaDoble;
import ListaDoble.Nodo;
import Sort.Sort;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    //Verificamos que esto tenga elementos es decir la lista para no perder tiempo
    @Override
    public ListaDoble<T> sort(ListaDoble<T> lista) {
        if (lista == null || lista.getCabeza() == null || lista.getCabeza().siguiente == null) {
            return lista; // Lista vacía o con un solo elemento ya está ordenada
        }

        return mergeSort(lista);
    }



    //Recursividad para dividir las listas en sublistas y ordenarlas
    private ListaDoble<T> mergeSort(ListaDoble<T> lista) {
        if (lista.getCabeza() == null || lista.getCabeza().siguiente == null) {
            return lista;
        }

        ListaDoble<T> mitad1 = new ListaDoble <T>();
        ListaDoble<T> mitad2 = new ListaDoble <T>();

        Nodo<T> medio = getMiddle(lista.getCabeza());
        Nodo<T> siguienteMitad = medio.siguiente;
        medio.siguiente = null;
        if (siguienteMitad != null) {
            siguienteMitad.anterior = null;
        }

        mitad1.setCabeza(lista.getCabeza());
        mitad1.setCola(medio);

        mitad2.setCabeza(siguienteMitad);
        mitad2.setCola(lista.getCola());

        mitad1 = mergeSort(mitad1);
        mitad2 = mergeSort(mitad2);

        return merge(mitad1, mitad2);
    }



    //Encuentra el medio de la lista
    private Nodo<T> getMiddle(Nodo<T> cabeza) {
        if (cabeza == null) {
            return null;
        }
        Nodo<T> lento = cabeza;
        Nodo<T> rapido = cabeza;

        while (rapido.siguiente != null && rapido.siguiente.siguiente != null) {
            rapido = rapido.siguiente.siguiente;
            lento = lento.siguiente;
        }

        return lento;
    }



    //Fusiona las dos listas ordenadas en una sola
    private ListaDoble<T> merge(ListaDoble<T> lista1, ListaDoble<T> lista2) {
        ListaDoble<T> resultado = new ListaDoble<T>();
        Nodo<T> nodo1 = lista1.getCabeza();
        Nodo<T> nodo2 = lista2.getCabeza();

        while (nodo1 != null && nodo2 != null) {
            if (nodo1.dato.compareTo(nodo2.dato) <= 0) {
                resultado.agregarAlFinal(nodo1.dato);
                nodo1 = nodo1.siguiente;
            } else {
                resultado.agregarAlFinal(nodo2.dato);
                nodo2 = nodo2.siguiente;
            }
        }

        while (nodo1 != null) {
            resultado.agregarAlFinal(nodo1.dato);
            nodo1 = nodo1.siguiente;
        }

        while (nodo2 != null) {
            resultado.agregarAlFinal(nodo2.dato);
            nodo2 = nodo2.siguiente;
        }

        return resultado;
    }
}
