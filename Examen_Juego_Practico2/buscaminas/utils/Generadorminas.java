package utils;

import java.util.Random;
import model.Tablero;
import model.casilla;

public class Generadorminas {

    public static void colocarMinas(Tablero tablero, int cantidadMinas) {

        Random random = new Random();
        int minasColocadas = 0;
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();

        while (minasColocadas < cantidadMinas) {

            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            casilla casilla = tablero.getCasilla(fila, columna);

            // Si no tiene mina, le ponemos una
            if (!casilla.tieneMina()) {
                casilla.setMina(true);
                minasColocadas++;
            }
        }

        // Después de poner todas las minas, calculamos los números
        calcularNumeros(tablero);
    }

    private static void calcularNumeros(Tablero tablero) {

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {

                casilla casilla = tablero.getCasilla(i, j);

                if (!casilla.tieneMina()) {
                    int minasAlrededor = contarMinasAlrededor(tablero, i, j);
                    casilla.setMinasAlrededor(minasAlrededor);
                }
            }
        }
    }

    private static int contarMinasAlrededor(Tablero tablero, int fila, int columna) {

        int contador = 0;

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {

                if (i >= 0 && i < tablero.getFilas() &&
                    j >= 0 && j < tablero.getColumnas()) {

                    casilla vecina = tablero.getCasilla(i, j);

                    if (vecina.tieneMina()) {
                        contador++;
                    }
                }
            }
        }

        return contador;
    }
}
