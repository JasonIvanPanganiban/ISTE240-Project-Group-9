package edu.rit.sec603w7d1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// This class is like the helper that manages the list of article notes
@Service  // This makes the class a "service" that does work for us in the background
public class ArticleNoteService {

    // This is a list that holds all the article notes
    private List<ArticleNote> articlenotes = new ArrayList<>();

    // This method returns all the article notes
    public List<ArticleNote> findAll() {
        return articlenotes;  // Just give back the list of all article notes
    }

    // This method adds a new article note to the list
    public void addArticleNote(ArticleNote articleNote) {
        this.articlenotes.add(articleNote);  // Add the new article note to the list
    }
}

