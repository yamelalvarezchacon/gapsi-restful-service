package mx.gapsi.restfulservice.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

/**
 * @author Yamel Alvarez Chacón
 * @Creation 10/05/2023
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateDto {

    @JsonProperty("descripcion")
    @Size(min = 1, max = 200, message = "{validation.description.size}")
    private String description;

    @JsonProperty("modelo")
    @Size(min = 10, max = 10, message = "{validation.model.size}")
    private String model;

}
