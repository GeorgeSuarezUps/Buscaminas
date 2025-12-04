package exeptions;

public class CoordenadalnvalidaException extends Exception {

    private static final long serialVersionUID = 1L;

    public CoordenadalnvalidaException() {
        super("Coordenada inválida");
    }

    public CoordenadalnvalidaException(String mensaje) {
        super(mensaje);
    }
}
