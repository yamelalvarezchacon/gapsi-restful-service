package mx.gapsi.restfulservice.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private String message;
    private String detail;
}
