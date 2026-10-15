package app;

import modelo.Nodo;
import negocio.ArbolBinario;

import java.util.Scanner;

public class main {

    private static ArbolBinario<String> arbol = new ArbolBinario<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc);
            System.out.println();

            switch (opcion) {
                case 1:
                    arbol = crearArbolInicial();
                    System.out.println("Arbol inicial creado correctamente.");
                    break;
                case 2:
                    arbol.mostrarArbol();
                    break;
                case 3:
                    System.out.println("Numero de nodos: " + arbol.contarNodos());
                    break;
                case 4:
                    System.out.println("Numero de hojas: " + arbol.contarHojas());
                    break;
                case 5:
                    System.out.println("Altura : " + arbol.altura());
                    break;
                case 6:
                    consultarGrado(sc);
                    break;
                case 7:
                    verificarHoja(sc);
                    break;
                case 8:
                    ejecutarCasosDePrueba();
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Crear el Arbol inicial");
        System.out.println("2. Visualizar el arbol");
        System.out.println("3. Consultar el numero de nodos");
        System.out.println("4. Consultar el numero de hojas");
        System.out.println("5. Consultar la altura");
        System.out.println("6. Consultar el grado de un nodo");
        System.out.println("7. Verificar si un nodo es hoja");
        System.out.println("8. Ejecutar casos de prueba");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int leerEntero(Scanner sc) {
        String linea = sc.nextLine().trim();
        try {
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    private static ArbolBinario<String> crearArbolInicial() {
        ArbolBinario<String> a = new ArbolBinario<>();
        a.crearRaiz("UNIVERSIDAD");
        Nodo<String> raiz = a.getRaiz();

        a.agregarIzquierdo(raiz, "FISEI");
        a.agregarDerecho(raiz, "DIDE");

        Nodo<String> fisei = raiz.getIzquierdo();
        Nodo<String> dide = raiz.getDerecho();

        a.agregarIzquierdo(fisei, "SOFTWARE");
        a.agregarDerecho(fisei, "TI");
        a.agregarIzquierdo(dide, "INVEST.");
        a.agregarDerecho(dide, "VINCULACIÓN");

        Nodo<String> software = fisei.getIzquierdo();
        a.agregarIzquierdo(software, "NIVEL1");
        a.agregarDerecho(software, "NIVEL3");

        return a;
    }

    private static void consultarGrado(Scanner sc) {
        if (arbol.esVacio()) {
            System.out.println("El arbol esta vacio. Cree el arbol inicial).");
            return;
        }
        System.out.print("Nombre del nodo: ");
        Nodo<String> nodo = arbol.buscar(sc.nextLine());
        if (nodo == null) {
            System.out.println("El nodo no existe en el arbol.");
        } else {
            System.out.println("Grado de " + nodo.getDato() + ": " + nodo.grado());
        }
    }

    private static void verificarHoja(Scanner sc) {
        if (arbol.esVacio()) {
            System.out.println("El arbol esta vacio. Cree el arbol inicial }.");
            return;
        }
        System.out.print("Nombre del nodo: ");
        Nodo<String> nodo = arbol.buscar(sc.nextLine());
        if (nodo == null) {
            System.out.println("El nodo no existe en el arbol.");
        } else if (nodo.esHoja()) {
            System.out.println(nodo.getDato() + " ES una hoja.");
        } else {
            System.out.println(nodo.getDato() + " NO es una hoja.");
        }
    }


    private static void ejecutarCasosDePrueba() {
        System.out.println("===== CASOS DE PRUEBA =====");


        ArbolBinario<String> vacio = new ArbolBinario<>();
        System.out.println("\n[1] Árbol vacío");
        System.out.println("    Nodos: " + vacio.contarNodos() + " (esperado 0)");
        System.out.println("    Altura: " + vacio.altura() + " (esperado -1)");
        System.out.println("    ¿Vacío?: " + vacio.esVacio());


        ArbolBinario<String> unNodo = new ArbolBinario<>();
        unNodo.crearRaiz("UNIVERSIDAD");
        System.out.println("\n[2] Arbol con un solo nodo");
        System.out.println("    Hojas: " + unNodo.contarHojas() + " (esperado 1)");
        System.out.println("    Altura: " + unNodo.altura() + " (esperado 0)");

        ArbolBinario<String> inicial = crearArbolInicial();
        System.out.println("\n[3] Arbol inicial");
        System.out.println("    Nodos: " + inicial.contarNodos() + " (esperado 9)");
        System.out.println("    Hojas: " + inicial.contarHojas() + " (esperado 5)");
        System.out.println("    Altura: " + inicial.altura() + " (esperado 3)");


        System.out.println("\n[4] Intento de insertar en una posición ocupada");
        Nodo<String> fisei = inicial.buscar("FISEI");
        boolean ok = inicial.agregarIzquierdo(fisei, "NUEVO");
        System.out.println("    agregarIzquierdo(FISEI, \"NUEVO\") -> " + ok
                + (ok ? "" : " (rechazado: la posición ya está ocupada)"));


        System.out.println("\n[5] Grado de nodos");
        System.out.println("    Grado de FISEI: " + inicial.buscar("FISEI").grado() + " (esperado 2)");
        System.out.println("    Grado de SOFTWARE: " + inicial.buscar("SOFTWARE").grado() + " (esperado 2)");
    }
}