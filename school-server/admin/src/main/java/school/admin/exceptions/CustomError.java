package school.admin.exceptions;

public class CustomError {
    private String message;
    private int code;
    private String error;
    private String status;

    public CustomError(String message, int code, String error, String status) {
        this.message = message;
        this.code = code;
        this.error = error;
        this.status = status;
    }

    public CustomError() {
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }
}
