/**
 * Custom error class for generating bank errors
 */
class BankDenialError extends Error {

    /**
     * Constructs a new error with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BankDenialError(String message) {
        super(message);
    }
}
