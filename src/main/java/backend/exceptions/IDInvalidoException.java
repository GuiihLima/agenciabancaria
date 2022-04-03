package backend.exceptions;

public class IDInvalidoException extends RuntimeException {
    public IDInvalidoException(String mensagem) {
        throw new RuntimeException(mensagem);
    }
}