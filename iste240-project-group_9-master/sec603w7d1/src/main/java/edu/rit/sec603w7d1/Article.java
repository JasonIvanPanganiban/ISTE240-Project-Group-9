package edu.rit.sec603w7d1;

// This is the Article class a blueprint for creating article objects.
public class Article {

    private Long id; // This is the article's ID -  unique number for each article. We use Long instead of int because Long can store much bigger numbers
    private String title; // This stores the title of the article.
    private String pdfUrl;  // This holds the URL link to the PDF of the article.
    private String category; // This is the category of the article, like "Climate" or "Renewable energy".
    private int readTime; // This is the estimated time it takes to read the article, in minutes.
    private String imageUrl; // This stores the URL for the image related to the article.

    // Default constructor but does not contain any arguments
    public Article() {}

    // This is the full constructor
    public Article(Long id, String title, String pdfUrl, String category, int readTime, String imageUrl) {
        this.id = id; // Setting the article's ID.
        this.title = title; // Setting the article's title.
        this.pdfUrl = pdfUrl; // Setting the article's PDF URL
        this.category = category; // Setting the article's category.
        this.readTime = readTime; // Setting how long it takes to read the article.
        this.imageUrl = imageUrl; // Setting the image URL for the article.
    }

    // Getter method for the article's ID. It returns the ID of the article.
    public Long getId() {
        return id; // This returns the ID of the article.
    }

    // Setter method for the article's ID.
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method for the article's title. It returns the title of the article.
    public String getTitle() {
        return title;
    }

    // Setter method for the article's title.
    public void setTitle(String title) {
        this.title = title; // This sets the article's title to the value passed in.
    }

    // Getter method for the article's PDF URL.
    public String getPdfUrl() {
        return pdfUrl;
    }

    // Setter method for the article's PDF URL.
    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    // Getter method for the article's category.
    public String getCategory() {
        return category;
    }

    // Setter method for the article's category
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter method for the article's read time.
    public int getReadTime() {
        return readTime;
    }

    // Setter method for the article's read time.
    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }

    // Getter method for the article's image URL.
    public String getImageUrl() {
        return imageUrl;
    }

    // Setter method for the article's image URL.
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

