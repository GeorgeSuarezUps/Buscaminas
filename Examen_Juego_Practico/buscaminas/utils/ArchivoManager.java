package utils;

import java.io.*;

public class ArchivoManager {

    public static void guardar(Object obj, String archivo)
            throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(archivo)
        );

        out.writeObject(obj);
        out.close();
    }

    public static Object cargar(String archivo)
            throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(archivo)
        );

        Object obj = in.readObject();
        in.close();

        return obj;
    }
}
