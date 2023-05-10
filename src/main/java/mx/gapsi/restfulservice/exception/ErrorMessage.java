package mx.gapsi.restfulservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private String message;
    private String detail;

    public ErrorMessage(Exception exception) {
        this.message = exception.getClass().getSimpleName();
        this.detail = exception.getMessage();
    }

}
