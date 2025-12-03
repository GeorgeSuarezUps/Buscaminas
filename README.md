# 💣 Buscaminas (Minesweeper) - Java Console Edition

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

## 📖 Descripción del Proyecto

Este proyecto es una implementación del clásico juego **Buscaminas** desarrollado en Java para ejecutarse en consola. El objetivo principal es aplicar conceptos avanzados de **Programación Orientada a Objetos (POO)**, patrones de diseño y buenas prácticas de desarrollo de software.

El juego consiste en un tablero de **10x10 casillas** con **10 minas** ocultas. El jugador debe descubrir las casillas seguras mediante coordenadas y lógica, evitando detonar las minas.

## 🚀 Características Técnicas

El desarrollo cumple con los siguientes requerimientos técnicos y de diseño:

* **Arquitectura MVC:** Separación clara entre **Modelo** (Lógica), **Vista** (Consola) y **Controlador** (Flujo del juego).
* **POO Avanzada:** Uso de Herencia, Polimorfismo, Encapsulamiento y Relaciones entre clases.
* **Manejo de Excepciones:**
    * Control de errores estándar (`InputMismatchException`, `ArrayIndexOutOfBoundsException`).
    * Excepciones personalizadas (ej. `CasillaYaDescubiertaException`).
* **Persistencia de Datos:** Capacidad para guardar y cargar la partida (Serialización/Archivos de texto).
* **Código Limpio:** Aplicación de principios DRY, KISS y refactorización.
* **Testing:** Pruebas unitarias (TDD) para validar la lógica del núcleo.

## 🛠️ Requisitos Previos

* **Java Development Kit (JDK):** Versión 11 o superior.
* **Git:** Para el control de versiones.
* **IDE Recomendado:** IntelliJ IDEA, Eclipse o NetBeans.

## 🔧 Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/](https://github.com/)[TU_USUARIO]/[NOMBRE_DEL_REPO].git
    ```

2.  **Compilar el proyecto:**
    Navega a la carpeta raíz (`src`) y compila los archivos `.java`:
    ```bash
    javac -d ../bin Main.java
    ```

3.  **Ejecutar el juego:**
    ```bash
    java -cp ../bin Main
    ```

## 🎮 Instrucciones de Uso

### Interfaz del Tablero
El tablero se muestra con coordenadas:
* **Filas:** Letras (A - J)
* **Columnas:** Números (1 - 10)
* **Símbolos:**
    * `X`: Mina (solo visible al perder).
    * `V`: Casilla vacía seleccionada.
    * `#`: Casilla cubierta.
    * `F`: Bandera (posible mina).

### Controles
Durante la partida, el sistema solicitará ingresar una acción y una coordenada.

**Ejemplo de entrada:**
```text
Ingrese coordenada (ej. A5): B3
¿Desea marcar bandera? (S/N): N
