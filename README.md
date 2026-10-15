# Implementaci-n-rbol-binario-en-Java

Implementación de un árbol binario en Java
Asignatura: Estructura de Datos
Nivel: Tercero – Ingeniería de Software
Modalidad: Individual
Tipo: Práctica de programación
Herramientas: Java, Visual Studio Code y GitHub
Calificación: 3 puntos

1. Objetivo
Implementar un árbol binario utilizando programación orientada a objetos en Java, aplicando operaciones de inserción, consulta y análisis de su estructura jerárquica.

2. Descripción de la actividad
Caso práctico: Sistema de organización jerárquica de departamentos universitarios.

La Universidad requiere un programa que permita representar la organización de sus dependencias académicas mediante un árbol binario.

Cada nodo almacenará el nombre de una dependencia y tendrá como máximo dos hijos.

El estudiante deberá desarrollar una aplicación Java que permita construir, visualizar y analizar esta estructura.

3. Estructura inicial del árbol
Construya el siguiente árbol binario:

             UNIVERSIDAD
             /         \
       FISEI             DIDE
       /   \             /   \
   SOFTWARE  TI     INVEST.  VINCULACIÓN
    /   \
  NIVEL1 NIVEL3
El árbol contiene 9 nodos, 5 hojas y una altura de 3 aristas.

4. Requerimientos de implementación
Parte A. Clase Nodo

Crear la clase genérica Nodo<T> con los siguientes atributos y métodos:

dato: información almacenada.

izquierdo: referencia al hijo izquierdo.

derecho: referencia al hijo derecho.

esHoja(): determina si el nodo es una hoja.

grado(): devuelve el número de hijos.

Métodos getters y setters.

Parte B. Clase ArbolBinario

Implementar las siguientes operaciones:

crearRaiz(dato): crea el nodo raíz.

agregarIzquierdo(padre, dato): agrega un hijo izquierdo.

agregarDerecho(padre, dato): agrega un hijo derecho.

contarNodos(): devuelve el número total de nodos.

contarHojas(): calcula el número de hojas.

altura(): calcula la altura del árbol en aristas.

esVacio(): verifica si el árbol está vacío.

mostrarArbol(): presenta visualmente su estructura en consola.

Parte C. Programa principal

Desarrollar un menú interactivo que permita:

Crear el árbol inicial.

Visualizar el árbol.

Consultar el número de nodos.

Consultar el número de hojas.

Consultar la altura.

Consultar el grado de un nodo.

Verificar si un nodo es hoja.

Salir.

El programa debe utilizar Scanner para la interacción con el usuario.

5. Casos de prueba obligatorios
El estudiante deberá demostrar:

Árbol vacío: cero nodos y altura -1.

Árbol con un solo nodo: una hoja y altura 0.

Árbol inicial: 9 nodos, 5 hojas y altura 3.

Intento de insertar un hijo en una posición ocupada.

Consulta del grado de FISEI y SOFTWARE.

6. Organización del proyecto
El código deberá organizarse en tres paquetes:

src/
 ├── modelo/
 │    └── Nodo.java
 ├── negocio/
 │    └── ArbolBinario.java
 └── app/
      └── Main.java
Restricciones: No se permite utilizar TreeSet, TreeMap, PriorityQueue, NavigableSet ni NavigableMap. Las operaciones de conteo y altura deberán implementarse mediante recursividad.

7. Evidencias y entrega
Cada estudiante deberá:

Crear un repositorio público de GitHub con el nombre T6-ArbolBinario-ApellidoNombre.

Subir las tres clases Java y el archivo README.md.

Documentar en el README el problema, la estructura del árbol, las instrucciones de ejecución y los resultados.

Incorporar capturas de pantalla de la ejecución y de los casos de prueba.

Realizar al menos tres commits significativos que evidencien el desarrollo individual.

Entregar en Moodle un archivo PDF con el enlace al repositorio, capturas de ejecución y una reflexión personal.

8. Preguntas de reflexión
Responder en el PDF:

¿Por qué la altura de un árbol binario depende del camino más largo desde la raíz hasta una hoja?

¿Qué diferencias existen entre almacenar información en una lista enlazada y en un árbol binario?

¿Cómo podría utilizarse un árbol binario en el proyecto integrador SmartETL para organizar o buscar registros?

9. Rúbrica de evaluación (3 puntos)
Criterio	Puntaje
Implementación correcta de la clase Nodo y sus métodos	0,40
Construcción del árbol y operaciones de inserción	0,50
Implementación recursiva de nodos, hojas y altura	0,60
Menú funcional, visualización y casos de prueba	0,50
Repositorio GitHub, README y commits individuales	0,50
Evidencias y respuestas de reflexión	0,50
TOTAL	3,00
10. Indicaciones importantes
La actividad es estrictamente individual.

El estudiante deberá comprender y explicar el funcionamiento del código presentado.

Se evaluará tanto el resultado del programa como su implementación.

No se aceptarán repositorios vacíos ni entregas que contengan únicamente capturas de pantalla.

El código debe compilar y ejecutarse correctamente.

Se verificará el historial de commits en GitHub para comprobar el proceso de desarrollo.

Producto final: Aplicación Java funcional, repositorio GitHub documentado y PDF de evidencias entregado en Moodle.
