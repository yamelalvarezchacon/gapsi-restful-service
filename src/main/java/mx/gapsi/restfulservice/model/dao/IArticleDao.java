package mx.gapsi.restfulservice.model.dao;

import mx.gapsi.restfulservice.model.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yamel Alvarez Chacón
 * @Creation 10/05/2023
 */
@Repository
public interface IArticleDao
        extends PagingAndSortingRepository<ArticleEntity, String>, JpaSpecificationExecutor<ArticleEntity> {

}
