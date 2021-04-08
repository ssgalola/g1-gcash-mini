package ph.apper.purchase.exception;

public class TransferNotFoundException extends Exception {
    public TransferNotFoundException() {
        super();
    }

    public TransferNotFoundException(String message) {
        super(message);
    }

    public TransferNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
