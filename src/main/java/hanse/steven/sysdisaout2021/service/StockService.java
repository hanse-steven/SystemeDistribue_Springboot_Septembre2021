package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.model.Article;
import hanse.steven.sysdisaout2021.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    ArticleRepository articleRepository;

    @Autowired
    public StockService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article findByIdArticle(int idArticle) {
        return articleRepository.findByIdArticle(idArticle);
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public boolean checkInventory(int idArticle, int quantite) {
        Article article = articleRepository.findByIdArticle(idArticle);
        return article.getQuantiteDisponible() >= quantite;
    }




}
