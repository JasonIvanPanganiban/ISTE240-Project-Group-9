package edu.rit.sec603w7d1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// This is the ArticleService class, and it's marked with @Service to tell Spring it's a service component
@Service
public class ArticleService {

    // This will automatically inject the ArticleRepository into the service so we can use it for database operations
    @Autowired
    private ArticleRepository articleRepository;

    // This method returns a list of all articles from the database
    public List<Article> getAllArticles() {
        return articleRepository.findAll();  // Uses the repository to get all articles
    }

    // This method returns an article by its ID. If no article is found, it returns an empty Optional
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);  // Looks up an article by its ID
    }

    // This method finds articles based on their title and returns a list of matching articles
    public List<Article> findArticlesByTitle(String title) {
        return articleRepository.findByTitle(title);  // Finds articles by title
    }

    // This method finds articles by their category and returns a list of matching articles
    public List<Article> findArticlesByCategory(String category) {
        return articleRepository.findByCategory(category);  // Finds articles by category
    }

    // This method saves a new article or updates an existing article in the database
    public Article saveArticle(Article article) {
        return articleRepository.save(article);  // Saves or updates the article and returns the saved article
    }

    // This method updates an existing article by its ID. If the article is found, it's updated and saved
    public Article updateArticle(Long id, Article article) {
        // First, it checks if the article with the given ID exists
        if (articleRepository.findById(id).isPresent()) {
            article.setId(id);  // Sets the ID to make sure we are updating the right article
            return articleRepository.save(article);  // Saves the updated article
        }
        return null;  // If no article was found, return null
    }

    // This method deletes an article by its ID and returns true if the deletion was successful
    public boolean deleteArticle(Long id) {
        return articleRepository.deleteById(id);  // Deletes the article and returns a success status
    }
}
