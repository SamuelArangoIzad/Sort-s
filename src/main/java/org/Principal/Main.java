package org.Principal;

import GeneradorAleatorio.GenerarCadenas;
import GeneradorAleatorio.generarNumeros;
import Heap.HeapSort;
import ListaDoble.ListaDoble;
import Merge.MergeSort;
import Quick.QuickSort;
//  # EL ARANGO CÓDIGO

public class Main {
    public static void main(String[] args) {

        //QUITAR /* PARA DESBLOQUEAR EL CÓDIGO :D

        /*

        // Prueba con Integer
        ListaDoble<Integer> listEnteros = new ListaDoble<Integer>();
        generarNumeros generarnumeros = new generarNumeros();


        //generarnumeros.generarNumerosAleatorios(listEnteros, 5000 , 1 , 10000);
        //generarnumeros.generarNumerosOrdenadosAscendente(listEnteros,5000,1);
        generarnumeros.generarNumerosOrdenadosDescendente(listEnteros,100,10000);


        System.out.println("List Original: ");
        listEnteros.motrarLista();

        long startTime = System.nanoTime();

        HeapSort<Integer> heapSort = new HeapSort<>();
        ListaDoble<Integer> listaOrdenada = heapSort.sort(listEnteros);

        System.out.println("Lista Ordenada: ");
        listaOrdenada.motrarLista();

        long endTime = System.nanoTime();
        System.out.println("Nano Seconds Time: " + (endTime-startTime));

        //QUE VAINA PA RARA REVISAR EL DOCUMENTO SI LO PRUEBO CON LOS 3 FUNCIONAN 2 O 1 PERO SI LOS PRUEBO INDEPENDIENTE
        //FUNCIONAN NORMAL, DEBE SER A GASTO DE MEMORIA ?? NO SE. TODO ESTA DEFINIDO EN EL DOCUMENTO



         */




        ListaDoble<String> listaCadenas = new ListaDoble<String>();
        GenerarCadenas generarCadenas = new GenerarCadenas();


        //generarCadenas.generarCadenasAleatorias(listaCadenas,5000,2);
        //generarCadenas.generarCadenasAscendentes(listaCadenas,5000,2);
        generarCadenas.generarCadenasDescendentes(listaCadenas,5000,2);

        System.out.println("Original List: ");
        listaCadenas.motrarLista();

        long startTime = System.nanoTime();
        HeapSort<String> heapSort = new HeapSort<>();
        ListaDoble<String> listaOrdenada = heapSort.sort(listaCadenas);

        System.out.println("Order List");
        listaOrdenada.motrarLista();

        long endTime = System.nanoTime();
        System.out.println("Nano Seconds Time: " + (endTime-startTime));



    }
}