package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findByIdArticle(int idArticle);
}