package backend.exceptions;

public class Autentica├žaoInvalidaException extends IllegalStateException {
    public Autentica├žaoInvalidaException(String mensagem) {
        throw new IllegalStateException(mensagem);
    }
}
