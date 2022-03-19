package backend.exceptions;

public class ClienteInexistenteException extends RuntimeException {
    public ClienteInexistenteException(String mensagem) {
        throw new RuntimeException(mensagem);
    }
}