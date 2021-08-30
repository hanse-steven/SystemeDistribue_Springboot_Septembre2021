package hanse.steven.sysdisaout2021.controller;

import hanse.steven.sysdisaout2021.model.Article;
import hanse.steven.sysdisaout2021.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/api/articles")
    public List<Article> ListingArticle() {
        return stockService.getArticles();
    }

    @GetMapping("/api/articles/{idArticles}")
    public Article ListingArticle(@PathVariable int idArticles) {
        return stockService.findByIdArticle(idArticles);
    }
}
