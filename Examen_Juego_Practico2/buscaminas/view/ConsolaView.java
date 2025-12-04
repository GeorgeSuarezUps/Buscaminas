package view;

import model.Tablero;

public class ConsolaView {

    public void mostrarTablero(Tablero tablero) {
        tablero.mostrarTablero(false);
    }

    public void mostrarTableroFinal(Tablero tablero) {
        tablero.mostrarTablero(true);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarInstrucciones() {
        System.out.println("\nIngrese coordenadas (ej: A5, B10, C3)");
        System.out.println("Escriba 'salir' para terminar el juego\n");
    }
}