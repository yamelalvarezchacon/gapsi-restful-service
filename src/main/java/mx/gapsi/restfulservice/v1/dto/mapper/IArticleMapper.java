package mx.gapsi.restfulservice.v1.dto.mapper;

import mx.gapsi.restfulservice.model.entity.ArticleEntity;
import mx.gapsi.restfulservice.v1.dto.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Yamel Alvarez Chacón
 * @Creation 10/05/2023
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IArticleMapper {

    IArticleMapper INSTANCE = Mappers.getMapper(IArticleMapper.class);

    ArticleEntity toArticleEntity(ArticleDto articleDto);

    ArticleDto toArticleDto(ArticleEntity entity);

}
