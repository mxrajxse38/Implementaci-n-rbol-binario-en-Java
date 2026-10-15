package negocio;

import modelo.Nodo;

import java.text.Normalizer;



public class ArbolBinario<T> {

    private Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }


    public boolean crearRaiz(T dato) {
        if (raiz != null) {
            return false;
        }
        raiz = new Nodo<>(dato);
        return true;
    }


    public boolean agregarIzquierdo(Nodo<T> padre, T dato) {
        if (padre == null || padre.getIzquierdo() != null) {
            return false;
        }
        padre.setIzquierdo(new Nodo<>(dato));
        return true;
    }
    public boolean agregarDerecho(Nodo<T> padre, T dato) {
        if (padre == null || padre.getDerecho() != null) {
            return false;
        }
        padre.setDerecho(new Nodo<>(dato));
        return true;
    }

    public boolean esVacio() {
        return raiz == null;
    }


    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.esHoja()) {
            return 1;
        }
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }

   
    public Nodo<T> buscar(String nombre) {
        return buscar(raiz, normalizar(nombre));
    }

    private Nodo<T> buscar(Nodo<T> nodo, String objetivo) {
        if (nodo == null) {
            return null;
        }
        if (normalizar(String.valueOf(nodo.getDato())).equals(objetivo)) {
            return nodo;
        }
        Nodo<T> encontrado = buscar(nodo.getIzquierdo(), objetivo);
        if (encontrado != null) {
            return encontrado;
        }
        return buscar(nodo.getDerecho(), objetivo);
    }

    private String normalizar(String texto) {
        String sinTildes = Normalizer.normalize(texto.trim(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return sinTildes.toUpperCase();
    }

    public void mostrarArbol() {
        if (esVacio()) {
            System.out.println("(árbol vacío)");
            return;
        }
        System.out.println(raiz.getDato());
        mostrarHijos(raiz, "");
    }

    private void mostrarHijos(Nodo<T> nodo, String prefijo) {
        Nodo<T> izq = nodo.getIzquierdo();
        Nodo<T> der = nodo.getDerecho();

        if (izq != null) {
            boolean ultimo = (der == null);
            System.out.println(prefijo + (ultimo ? "`-- " : "|-- ") + "(I) " + izq.getDato());
            mostrarHijos(izq, prefijo + (ultimo ? "    " : "|   "));
        }
        if (der != null) {
            System.out.println(prefijo + "`-- " + "(D) " + der.getDato());
            mostrarHijos(der, prefijo + "    ");
        }
    }
}