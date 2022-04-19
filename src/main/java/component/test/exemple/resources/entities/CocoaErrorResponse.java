package component.test.exemple.resources.entities;

public class CocoaErrorResponse {
    private String message;

    public CocoaErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
