package mx.gapsi.restfulservice.exception;

public class NotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 6547754850676794777L;

    public NotFoundException(String detail) {
        super(detail);
    }
}
