package exeptions;

public class CasillaYaDescubiertaException extends Exception {

    public CasillaYaDescubiertaException() {
        super("Coordenada inválida");
    }

    public CasillaYaDescubiertaException(String mensaje) {
        super(mensaje);
    }
}

 