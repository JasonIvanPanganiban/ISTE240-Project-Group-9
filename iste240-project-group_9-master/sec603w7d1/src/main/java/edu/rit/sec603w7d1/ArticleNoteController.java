package edu.rit.sec603w7d1;

// This is a special class that controls the article notes page. It helps us get and add article notes.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller  // This makes the class a "controller" that helps handle requests from the web page
public class ArticleNoteController {

    // This is like a helper that talks to the "ArticleNoteService" to get and add article notes
    private final ArticleNoteService articleNoteService;

    // The constructor helps us set up the helper (ArticleNoteService) when we create the controller
    public ArticleNoteController(ArticleNoteService articleNoteService) {
        this.articleNoteService = articleNoteService;  // Save the helper for later use
    }

    // This method handles the GET request for the "/articlenotes" page
    @GetMapping("/articlenotes")
    public String articlenotes(Model model) {
        // Ask the ArticleNoteService for all the article notes
        List<ArticleNote> articlenotes = this.articleNoteService.findAll();
        // Add the article notes to the model so the web page can use them
        model.addAttribute("articlenotes", articlenotes);
        // Return the name of the page that will show the article notes
        return "articlenotes";
    }

    // This method handles the POST request for adding a new article note
    @PostMapping("/articlenotes")
    public String addArticleNotes(
            @RequestParam int index,  // Get the index of the article
            @RequestParam String articleName,  // Get the article's name
            @RequestParam String notes,  // Get the notes for the article
            Model model) {

        // Create a new ArticleNote object using the data we got from the web page
        ArticleNote articleNote = new ArticleNote(index, articleName, notes);
        // Ask the ArticleNoteService to add the new article note to the list
        this.articleNoteService.addArticleNote(articleNote);
        // Get the updated list of article notes
        var articlenotes = this.articleNoteService.findAll();
        // Add the updated article notes to the model so the web page can display them
        model.addAttribute("articlenotes", articlenotes);
        // Return the name of the page that will show the updated list of article notes
        return "articlenotes";
    }
}
