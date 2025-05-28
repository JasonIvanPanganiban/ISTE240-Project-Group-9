package edu.rit.sec603w7d1;

// This is the ArticleNote class. It's like a container for storing info about our article's notes.
public class ArticleNote {

    // These are the things we need to remember for each article: its index, name, and the notes you took.
    private int index;
    private String articleName;
    private String notes;

    // (constructor)
    public ArticleNote(int index, String articleName, String notes) {
        this.articleName = articleName;
        this.index = index;
        this.notes = notes;
    }

    // This is a method to get the article's number (index).
    public int getIndex() {
        return this.index;  // Return the article's index
    }

    // This is a method to get the article's name.
    public String getArticleName() {
        return this.articleName;  // Return the article's name
    }

    // This is a method to get the notes.
    public String getNotes() {
        return this.notes;  // Return the notes
    }

    // This is a method to change the article's number (index).
    public void setIndex(int index) {
        this.index = index;  // Change the article's index
    }

    // This is a method to change the article's name.
    public void setArticleName(String articleName) {
        this.articleName = articleName;  // Change the article's name
    }

    // This is a method to change the notes.
    public void setNotes(String notes) {
        this.notes = notes;  // Change the notes
    }

    // This is a special method that changes how the ArticleNote looks when we print it.
    @Override
    public String toString() {
        // It makes the ArticleNote look like this: "Article Index: (number), Article Name: (name), Notes: (your notes)"
        return "Article Index: " + this.index + "\nArticle Name: " + this.articleName + "\nNotes: " + this.notes;
    }
}
