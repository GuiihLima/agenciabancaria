package backend.exceptions;

public class TransferenciaInvalidaException extends RuntimeException {
    public TransferenciaInvalidaException(String mensagem) {
        throw new RuntimeException(mensagem);
    }
}
