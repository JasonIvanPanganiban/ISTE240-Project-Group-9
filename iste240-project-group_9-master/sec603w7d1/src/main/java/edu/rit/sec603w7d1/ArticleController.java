package edu.rit.sec603w7d1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/articles") // This is the base URL for all article-related requests.
public class ArticleController {

    @Autowired
    private ArticleService articleService; // ArticleService handles the business logic for articles.

    // Get all articles
    @GetMapping // The @GetMapping annotation means this method handles GET requests.
    public List<Article> getAllArticles() {
        return articleService.getAllArticles(); // Fetches all articles from the service.
    }

    // Get article by ID
    @GetMapping("/{id}") // The @GetMapping("/{id}") means this method handles GET requests for a specific article by its ID.
    public Article getArticleById(@PathVariable Long id) {
        Optional<Article> article = articleService.getArticleById(id); // this will find the article by its ID

        if (article.isPresent()) { // this will check if the article was found.
            return article.get(); // If it exists; it will return the article.
        }

        return null; // If the article isn't found, it will return null.
    }

    // Search articles by title
    @GetMapping("/search") // This handles GET requests with a query parameter to search articles by title.
    public List<Article> searchArticlesByTitle(@RequestParam String title) {
        return articleService.findArticlesByTitle(title); // Calls the service to find articles by title
    }

    // Create a new article
    @PostMapping // The @PostMapping annotation means this method handles POST requests to create new resources.
    public Article createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article); // Saves the article and returns the saved article
    }

    // Update an existing article
    @PutMapping("/{id}") // The @PutMapping annotation means this method handles PUT requests to update a resource.
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return articleService.updateArticle(id, article); // Updates the article with the given ID and returns the updated article.
    }

    // Delete an article by ID
    @DeleteMapping("/{id}") // The @DeleteMapping annotation means this method handles DELETE requests to remove a resource.
    public boolean deleteArticle(@PathVariable Long id) {
        return articleService.deleteArticle(id); // Calls the service to delete the article
    }
}


