package e2;

import java.util.LinkedList;
import java.util.Queue;

public class Mapa {

    public int determinarNumeroMinimoNodos(Nodo nodoInicial) {
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(nodoInicial);
        int contadorNodos = 1;

        while (!queue.isEmpty()) {
            int nivelSize = queue.size();  // Tamaño del nivel actual

            for (int i = 0; i < nivelSize; i++) {
                Nodo nodoActual = queue.poll();

                if (nodoActual instanceof NodoFinal) {
                    return contadorNodos;  // Retorna al encontrar el primer nodo final
                }

                // Agrega los nodos hijos a la cola
                if (nodoActual instanceof NodoRutaFija) {
                    queue.add(nodoActual.obtenerSiguienteNodo(null));
                } else if (nodoActual instanceof NodoBifurcacion) {
                    queue.add(((NodoBifurcacion) nodoActual).getHijoIzquierdo());
                    queue.add(((NodoBifurcacion) nodoActual).getHijoDerecho());
                }
            }

            contadorNodos++;  // Incrementa el contador después de procesar un nivel completo
        }

        return -1;  // Retorna -1 si no se encuentra un nodo final
    }

    public void Newick(Nodo nodoInicial) {
        nodoInicial.imprimirArbol();
    }
}
