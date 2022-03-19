package backend.exceptions;

public class ArgumentoIndefinidoException extends IllegalArgumentException {
    public ArgumentoIndefinidoException(String mensagem) {
        throw new IllegalArgumentException(mensagem);
    }
}
