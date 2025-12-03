package model;

import exeptions.CasillaYaDescubiertaException;

public class Tablero {

    private int filas;
    private int columnas;
    private casilla[][] casillas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = new casilla[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new casilla();
            }
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public casilla getCasilla(int fila, int col) {
        return casillas[fila][col];
    }

    // ✅ Calcula cuántas minas hay alrededor
    public void calcularMinasAlrededor() {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (casillas[i][j].tieneMina()) continue;

                int contador = 0;

                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {

                        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
                            if (casillas[x][y].tieneMina()) {
                                contador++;
                            }
                        }
                    }
                }

                casillas[i][j].setMinasAlrededor(contador);
            }
        }
    }

    // ✅ Revela una casilla
    public void revelarCasilla(int fila, int col) throws CasillaYaDescubiertaException {

        casilla c = casillas[fila][col];

        if (c.isRevelada()) {
            throw new CasillaYaDescubiertaException("⚠ Casilla ya descubierta");
        }

        c.setRevelada(true);

        if (!c.tieneMina() && c.getMinasAlrededor() == 0) {
            revelarAdyacentes(fila, col);
        }
    }

    // ✅ Revela las casillas vecinas automáticamente
    private void revelarAdyacentes(int fila, int col) {

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {

                if (i >= 0 && i < filas && j >= 0 && j < columnas) {

                    casilla c = casillas[i][j];

                    if (!c.isRevelada() && !c.tieneMina()) {

                        c.setRevelada(true);

                        if (c.getMinasAlrededor() == 0) {
                            revelarAdyacentes(i, j);
                        }
                    }
                }
            }
        }
    }

    // ✅ TABLERO PERFECTAMENTE ALINEADO
    public void mostrarTablero(boolean revelarTodo) {

        // Encabezado columnas
        System.out.print("   ");
        for (int j = 1; j <= columnas; j++) {
            if (j < 10) {
                System.out.print(j + "  ");
            } else {
                System.out.print(j + " ");
            }
        }
        System.out.println();

        // Filas
        for (int i = 0; i < filas; i++) {

            // Letras A - J
            char letraFila = (char) ('A' + i);
            System.out.print(letraFila + "  ");

            for (int j = 0; j < columnas; j++) {

                casilla c = casillas[i][j];

                if (revelarTodo && c.tieneMina()) {
                    System.out.print("X  ");
                }
                else if (!c.isRevelada()) {
                    System.out.print("■  "); // Cuadro negro
                }
                else if (c.tieneMina()) {
                    System.out.print("X  ");
                }
                else if (c.getMinasAlrededor() == 0) {
                    System.out.print("V  ");
                }
                else {
                    System.out.print(c.getMinasAlrededor() + "  ");
                }
            }

            System.out.println();
        }
    }
}
