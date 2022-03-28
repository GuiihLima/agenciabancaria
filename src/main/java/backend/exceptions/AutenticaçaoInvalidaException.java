package backend.exceptions;

public class AutenticaçaoInvalidaException extends IllegalStateException {
    public AutenticaçaoInvalidaException(String mensagem) {
        throw new IllegalStateException(mensagem);
    }
}
