package mx.gapsi.restfulservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Yamel Alvarez Chacón
 * @Creation 10/05/2023
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ARTICLE")
public class ArticleEntity {

    @Id
    @Column(name = "ID_ARTICULO", updatable = false)
    @Size(min = 10, max = 10, message = "{validation.articleId.size}")
    private String id;

    @Column(name = "NOMBRE", updatable = false)
    @Size(min = 1, max = 20, message = "{validation.name.size}")
    private String name;

    @Basic
    @Column(name = "DESCRIPCION")
    @Size(min = 1, max = 200, message = "{validation.description.size}")
    private String description;

    @Column(name = "PRECIO", scale = 2, updatable = false)
    private BigDecimal price;

    @Column(name = "MODELO")
    @Size(min = 10, max = 10, message = "{validation.model.size}")
    private String model;

}
