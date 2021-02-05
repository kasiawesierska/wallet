package pl.project.wallet.exception;

public class TransactionException extends Exception {
    public TransactionException (String errorMassage) {
        super(errorMassage);
    }
}
