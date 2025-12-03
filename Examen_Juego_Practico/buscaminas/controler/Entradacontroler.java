package controler;

import java.util.Scanner;

public class Entradacontroler {

    private Scanner scanner = new Scanner(System.in);

    public int pedirNumero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }
}
