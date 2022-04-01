package backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    public static boolean serialize(Banco banco) throws IOException {
        boolean okay = true;
        FileOutputStream fos = new FileOutputStream("agenciabancaria\\src\\main\\java\\backend\\database\\bbank.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            oos.writeObject(banco);
        } catch (IOException e) {
            okay = false;
        } finally {
            oos.close();
            fos.close();
        }
        return okay;
    }

    public static Banco desserialize() throws IOException, ClassNotFoundException {
        Banco banco = null;
        FileInputStream fis = new FileInputStream("agenciabancaria\\src\\main\\java\\backend\\database\\bbank.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        banco = (Banco) ois.readObject();
        ois.close();
        fis.close();
        return banco;
    }
}
