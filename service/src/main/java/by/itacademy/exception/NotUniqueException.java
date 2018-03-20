package by.itacademy.exception;

public class NotUniqueException extends java.lang.Exception {
    public NotUniqueException() {
        super();
    }

    public NotUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUniqueException(Throwable cause) {
        super(cause);
    }

    protected NotUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotUniqueException(String message) {

    }
}
