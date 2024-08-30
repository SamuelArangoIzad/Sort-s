package ListaDoble;

public class ListaDoble <T>{

    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public ListaDoble(){
        this.cabeza=null;
        this.cola=null;
    }

    public void agregarAlFinal(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if(cabeza == null){
            cabeza=cola=nuevo;
        }else{
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }

    public void motrarLista(){
        Nodo<T> actual = cabeza;
        while(actual != null){
            System.out.println(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

}