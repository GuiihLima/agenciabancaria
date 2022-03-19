package backend.exceptions;

public class ArgumentoInvalidoException extends IllegalArgumentException {
    public ArgumentoInvalidoException(String mensagem) {
        throw new IllegalArgumentException(mensagem);
    }
}
