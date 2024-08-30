package Sort;

import ListaDoble.ListaDoble;

public interface Sort <T extends Comparable<T>>{
    ListaDoble<T> sort(ListaDoble<T> lista);
}
