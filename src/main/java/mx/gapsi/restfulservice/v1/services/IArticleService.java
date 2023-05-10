package mx.gapsi.restfulservice.v1.services;

import mx.gapsi.restfulservice.v1.dto.ArticleDto;
import mx.gapsi.restfulservice.v1.dto.ArticleUpdateDto;
import mx.gapsi.restfulservice.v1.dto.ResponseDto;

/**
 * @author Yamel Alvarez Chacón
 * @Creation 10/05/2023
 */
public interface IArticleService {

    /**
     * Get an article by ID
     *
     * @param id Article ID
     * @return ArticleDto
     */
    ArticleDto getArticleById(String id);

    /**
     * Create a new article
     *
     * @param articleDto ArticleDto
     * @return ResponseDto
     */
    ResponseDto createArticle(ArticleDto articleDto);

    /**
     * Update an existing article
     *
     * @param articleDto ArticleDto
     * @param articleId  Article identifier
     * @return ArticleDto
     */
    ArticleDto updateArticle(ArticleUpdateDto articleDto, String articleId);

}
