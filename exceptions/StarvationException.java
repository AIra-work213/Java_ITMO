package exceptions;

public class StarvationException extends Exception {
    private String message;
    public StarvationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Голод: " + message;
    }
}
