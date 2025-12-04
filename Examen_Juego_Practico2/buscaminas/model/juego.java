
package model;

public class juego {

    private Tablero tablero;
    private boolean terminado;
    private boolean victoria;

    public juego() {
        tablero = new Tablero(10, 10);
        terminado = false;
        victoria = false;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }
}
