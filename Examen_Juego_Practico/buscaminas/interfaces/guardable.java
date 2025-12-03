package interfaces;

import java.io.IOException;

public interface guardable {
    void guardar(String archivo) throws IOException;
    void cargar(String archivo) throws IOException, ClassNotFoundException;
}
