package mx.gapsi.restfulservice.v1.services.impl;

import lombok.RequiredArgsConstructor;
import mx.gapsi.restfulservice.exception.NotFoundException;
import mx.gapsi.restfulservice.model.dao.IArticleDao;
import mx.gapsi.restfulservice.model.entity.ArticleEntity;
import mx.gapsi.restfulservice.v1.dto.ArticleDto;
import mx.gapsi.restfulservice.v1.dto.ArticleUpdateDto;
import mx.gapsi.restfulservice.v1.dto.ResponseDto;
import mx.gapsi.restfulservice.v1.dto.mapper.IArticleMapper;
import mx.gapsi.restfulservice.v1.services.IArticleService;
import org.springframework.stereotype.Service;

import static mx.gapsi.restfulservice.utils.Constants.NO_RECORD_FOUND;

/**
 * @author Yamel Alvarez Chacón
 * @Creation 10/05/2023
 */

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements IArticleService {

    private final IArticleDao articleDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleDto getArticleById(String id) {
        ArticleEntity entity = articleDao.findById(id).orElseThrow(() -> new NotFoundException(NO_RECORD_FOUND));
        return IArticleMapper.INSTANCE.toArticleDto(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseDto createArticle(ArticleDto articleDto) {
        articleDao.save(IArticleMapper.INSTANCE.toArticleEntity(articleDto));
        return ResponseDto.builder()
                .message("Artículo creado")
                .detail("El artículo con identificador: " + articleDto.getId() + " ha sido creado satisfactoriamente.")
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleDto updateArticle(ArticleUpdateDto articleUpdateDto, String articleId) {
        ArticleEntity articleEntity = articleDao.findById(articleId).orElseThrow(() -> new NotFoundException(NO_RECORD_FOUND));
        articleEntity.setDescription(articleUpdateDto.getDescription());
        articleEntity.setModel(articleUpdateDto.getModel());
        return IArticleMapper.INSTANCE.toArticleDto(articleDao.save(articleEntity));
    }

}
