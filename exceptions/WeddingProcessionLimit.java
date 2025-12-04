package exceptions;

public class WeddingProcessionLimit extends RuntimeException {
    private String message;
    public WeddingProcessionLimit(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Недостаточно памяти для шествия: " + message;
    }
    
}
