package Heap;

import ListaDoble.ListaDoble;
import ListaDoble.Nodo;
import Sort.Sort;

public class HeapSort <T extends Comparable<T>> implements Sort<T> {

    //Verificamos que esto tenga elementos es decir la lista para no perder tiempo
    @Override
    public ListaDoble<T> sort(ListaDoble<T> lista) {//Verificamos el siguiente si la cabeza solo tiene un elemento
        if (lista == null || lista.getCabeza() == null || lista.getCabeza().siguiente == null) {
            return lista; // Lista vacía o con un solo elemento ya está ordenada
        }

        int n = getSize(lista);//Calcula el tamaño de la lista usando el método

        // Construir el heap (max-heap) desde la lista
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lista, n, i);
        }

        // Extraer elementos del heap
        for (int i = n - 1; i > 0; i--) {
            // Mover el nodo raíz (mayor) al final de la lista
            swapNodes(lista, 0, i);

            // Llamar heapify en la raíz del heap reducido
            heapify(lista, i, 0);
        }

        return lista;//return lisa ordenada
    }


    //Este método asegura que el subárbol con raíz en el índice i cumple con la propiedad
    // de un max-heap (el valor de la raíz es mayor o igual que el de sus hijos).
    private void heapify(ListaDoble<T> lista, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        Nodo<T> root = getNodeAtIndex(lista, i);
        Nodo<T> leftChild = getNodeAtIndex(lista, left);
        Nodo<T> rightChild = getNodeAtIndex(lista, right);

        if (left < n && leftChild != null && leftChild.dato.compareTo(root.dato) > 0) {
            largest = left;
        }

        if (right < n && rightChild != null && rightChild.dato.compareTo(getNodeAtIndex(lista, largest).dato) > 0) {
            largest = right;
        }

        if (largest != i) {
            swapNodes(lista, i, largest);
            heapify(lista, n, largest);
        }

        /*
        Calcula los índices de los hijos izquierdo y derecho del nodo en el índice i.
        Obtiene los nodos correspondientes a i, left, y right usando getNodeAtIndex.
        Compara los valores de los nodos para determinar cuál es el más grande.
        Si el nodo más grande no es el nodo actual (índice i), intercambia los valores usando swapNodes y vuelve a llamar a heapify en el nuevo nodo para mantener la propiedad de heap.
         */
    }


    //Este método intercambia los valores de los nodos ubicados en las posiciones index1 e index2
    private void swapNodes(ListaDoble<T> lista, int index1, int index2) {
        Nodo<T> node1 = getNodeAtIndex(lista, index1);
        Nodo<T> node2 = getNodeAtIndex(lista, index2);

        if (node1 != null && node2 != null) {
            T temp = node1.dato;
            node1.dato = node2.dato;
            node2.dato = temp;
        }
        /*
        Obtiene los nodos correspondientes a index1 y index2 usando getNodeAtIndex.
        Si ambos nodos existen, intercambia sus valores (datos).
         */
    }


    //Este método obtiene el nodo en la posición index dentro de la lista.
    private Nodo<T> getNodeAtIndex(ListaDoble<T> lista, int index) {
        Nodo<T> current = lista.getCabeza();
        int i = 0;

        while (current != null && i < index) {
            current = current.siguiente;
            i++;
        }

        return current;
        /*
        nicia desde la cabeza de la lista y recorre nodo por nodo hasta alcanzar el índice deseado.
        Devuelve el nodo correspondiente a la posición index o null si no existe.
         */
    }


    //ste método calcula el tamaño de la lista, es decir, cuántos nodos tiene.
    private int getSize(ListaDoble<T> lista) {
        int size = 0;
        Nodo<T> current = lista.getCabeza();
        while (current != null) {
            size++;
            current = current.siguiente;
        }

        return size;
    }
    /*
    Inicia desde la cabeza de la lista y recorre nodo por nodo incrementando un contador.
    Devuelve el valor del contador, que representa el tamaño de la lista.
     */

}
