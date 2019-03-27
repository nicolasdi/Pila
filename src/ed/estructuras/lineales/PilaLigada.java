package ed.estructuras.lineales;

import ed.estructuras.ColeccionAbstracta;
import java.util.Collection;
import java.util.Iterator;

/**
 * Clase que implementa interfaz Pila y hereda de ColeccionAbstracta.
 */

/*
 * Características de *esta* clase: - Permite elementos nulos -
 * Permite elementos repetidos Implementación:
 * - Al final del código se encuentra la implementación
 * de las clases internas Nodo e Iterador.
 */
public class PilaLigada<E> extends ColeccionAbstracta<E> implements IPila<E> {

    /* Acceso a la pila*/
    private Nodo cabeza;

    //se reasignan los valores para hacer explícitos los valores
    //iniciales de la PilaLigada.
    public PilaLigada() {
        this.cabeza = null;
        this.tam = 0;
    }

    /**
     *{@inheritDoc}
     */
    public boolean add(E e) {
        //if(e == null) return false;
        this.empuja(e);
        return true;
    }

    @Override
    public void clear() {
        this.cabeza = null;
        this.tam = 0;
    }

    /**
     *{@inheritDoc}
     */
    public void empuja(E e) {
        //if(e == null) return;

        Nodo nuevaCabeza = new Nodo(this.cabeza, e);
        this.cabeza = nuevaCabeza;
        this.tam++;
    }

    /**
     *{@inheritDoc}
     */
    public E expulsa() {
        if(this.isEmpty()) return null;

        Nodo eliminado = this.cabeza;
        this.cabeza = eliminado.getSiguiente();
        this.tam--;;
        return eliminado.getElemento();
    }

    /**
     *{@inheritDoc}
     */
    public E mira() {
        if(this.isEmpty()) return null;
        E aux = (E) this.cabeza.getElemento();
        return aux;
    }


    /* Métodos no permitidos por la estructura */
    @Override
    public Iterator<E> iterator() {
        return new Iterador();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /* Los siguientes comentarios no se agregaron javadoc pues sólo le
     * interesan al programador */

    /* Iterador para estructura PilaLigada */
    private class Iterador implements Iterator<E> {
        /* Índice del elemento siguiente a visitar */
        private int i = 0;
        Nodo transeunte = cabeza;

        //Duda sobre los accesos que le puse a los siguientes métodos:
        //No es necesario que la clase sea pública pues se accede a
        //ésta a través de un método público, pero dado que hereda de
        //ColeccionAbstracta y ésta ocupa los métodos de esta clase
        //¿es necesario que sean públicos? En caso de que no sea
        //necesario que san públicos, ¿por qué se permite que la clase
        //ColecciónAbstracta utilice estos métodos si la clase es
        //privada?
        //Duda, para size() acostumbro poner this, pero no
        //sé cómo indicar explícitamente que vamos a tomar al método
        //de un obj de la clase PilaLigada

        /* Se utiliza para saber si aún existe elemento siguiente en la
         * estructura
         * @return true si existen más elementos, false en otro caso.
         */
	    @Override
        public boolean hasNext() {
		    //return transeunte == null;
		    return i < PilaLigada.this.size();
        }

        /* Entrega el siguiente elemento de la estructura
         * @return el siguiente elemento de la estructura
         * IllegalStateException - si la iteración no tiene más
         * elementos
         */
        @Override
        public E next() {
            if(!this.hasNext()) throw new IllegalStateException("No hay elemento siguiente");
            E aux = transeunte.getElemento();
            transeunte = transeunte.getSiguiente();
            this.i++;
            return aux;
        }

        /* No se agrega .remove() porque no es una operación
         * soportada por la estructura */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

	/* Nodos donde se guardan los elementos de la estructura. */
    private class Nodo {

        /* Nodo sobre el que está en la pila*/
        private Nodo siguiente;
        /* Elemento que guarda el Nodo */
        private E elemento;

	    /* Guarda en el Nodo a E elemento y lo conecta con su
	     * siguiente */
        public Nodo(Nodo siguiente, E elemento) {
            this.siguiente = siguiente;
            this.elemento = elemento;
        }

	    /* Obtiene al elemento que guarda el Nodo */
	    public E getElemento() {
            return this.elemento;
        }

	    /* Obtiene al siguiente de el Nodo que manda a llamar al
	     * método */
        public Nodo getSiguiente() {
            return this.siguiente;
        }
    }
}
