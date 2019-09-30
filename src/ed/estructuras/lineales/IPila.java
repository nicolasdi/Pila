/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */

package ed.estructuras.lineales;

import java.util.Collection;

/**
 * Estructura "Último en entrar, primero en salir".
 * @author veronica
 */
// El siguiente comentario estaba originalmente en la interfaz, viendo
// las pruebas unitarias, vemos que se pide que se permita agregar
// elemento nulos.
///////* Corresponde a una pila que no permite
// almacenar elementos nulos.
public interface IPila<E> extends Collection<E> {

    /**
     * Muestra el elemento al tope de la pila.
     * Devuelve <code>null</code> si está vacía.
     * @return Una referencia al elemento siguiente.
     */
    public E mira();

    /**
     * Devuelve el elemento al tope de la pila y lo elimina.
     * Devuelve <code>null</code> si está vacía.
     * @return Una referencia al elemento siguiente.
     */
    public E expulsa();

    /**
     * Agrega un elemento al tope de la pila.
     * @param e Referencia al elemento a agregar.
     */
    //@throws IllegalArgumentException si se intenta agregar <code>null</code>.
    public void empuja(E e);

}
