package controler;

import model.*;
import view.ConsolaView;
import exeptions.CasillaYaDescubiertaException;
import java.util.Scanner;

public class Juegocontroller {

    private juego juego;
    private ConsolaView view;
    private Scanner scanner;

    public Juegocontroller() {
        juego = new juego();
        view = new ConsolaView();
        scanner = new Scanner(System.in);

        // Generar minas y calcular números
        utils.Generadorminas.colocarMinas(juego.getTablero(), 20);
        juego.getTablero().calcularMinasAlrededor();
    }

    public void iniciarJuego() {

        while (!juego.isTerminado()) {

            view.mostrarTablero(juego.getTablero());
            view.mostrarInstrucciones();

            System.out.print("Seleccione una casilla: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("SALIR")) {
                juego.setTerminado(true);
                break;
            }

            try {

                int fila = input.charAt(0) - 'A';
                int columna = Integer.parseInt(input.substring(1)) - 1;

                verificarRango(fila, columna);

                juego.getTablero().revelarCasilla(fila, columna);

                // Si hay mina -> PERDER
                if (juego.getTablero().getCasilla(fila, columna).tieneMina()) {
                    view.mostrarTableroFinal(juego.getTablero());
                    view.mostrarMensaje("\n💣 PERDISTE - Pisaste una mina");
                    juego.setTerminado(true);
                }

                // Verificar si ganó
                if (verificarVictoria()) {
                    view.mostrarTableroFinal(juego.getTablero());
                    view.mostrarMensaje("\n🎉 ¡GANASTE! Descubriste todas las casillas seguras");
                    juego.setVictoria(true);
                    juego.setTerminado(true);
                }

            } catch (CasillaYaDescubiertaException e) {
                view.mostrarMensaje("⚠ Esa casilla ya fue descubierta");

            } catch (Exception e) {
                view.mostrarMensaje("⚠ Coordenada inválida. Ej: A5 o B10");
            }
        }
    }

    // Controla límites
    private void verificarRango(int f, int c) {
        if (f < 0 || f >= 10 || c < 0 || c >= 10) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // Verifica si todas las casillas sin minas están descubiertas
    private boolean verificarVictoria() {

        Tablero t = juego.getTablero();

        for (int i = 0; i < t.getFilas(); i++) {
            for (int j = 0; j < t.getColumnas(); j++) {

                if (!t.getCasilla(i, j).tieneMina() &&
                    !t.getCasilla(i, j).isRevelada()) {
                    return false;
                }
            }
        }

        return true;
    }
}
