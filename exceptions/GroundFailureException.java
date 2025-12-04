package exceptions;

public class GroundFailureException extends Exception {
    private String message;
    public GroundFailureException(String message) {
        super(message);
        this.message = message;
    }
    @Override
        public String getMessage() {
            return "Неудалось: " + message;
    }
}
