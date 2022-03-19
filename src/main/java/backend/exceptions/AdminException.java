package backend.exceptions;

public class AdminException extends IllegalStateException {
    public AdminException(String mensagem) {
        throw new IllegalStateException(mensagem);
    }
}
