package backend.exceptions;

public class ContaInvalidaException extends RuntimeException{
    public ContaInvalidaException(String mensagem) {
        throw new RuntimeException(mensagem);
    }
}
