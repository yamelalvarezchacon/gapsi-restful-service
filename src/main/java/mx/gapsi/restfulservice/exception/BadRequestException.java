package mx.gapsi.restfulservice.exception;

public class BadRequestException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -8168794214579908279L;

    public BadRequestException(String detail) {
        super(detail);
    }
}
