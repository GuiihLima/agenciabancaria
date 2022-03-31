package backend.exceptions;

public class ClienteInvalidoException extends RuntimeException {
    public ClienteInvalidoException(String mensagem) {
        throw new RuntimeException(mensagem);
    }
}