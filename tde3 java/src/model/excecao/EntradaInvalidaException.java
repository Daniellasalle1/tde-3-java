package model.excecao;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException() {
        super();
    }

    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }

    public EntradaInvalidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public EntradaInvalidaException(Throwable causa) {
        super(causa);
    }
}