package models;

import java.io.Serializable;

public class Blog implements Serializable {
    // To implement Serializable in our User class
    private static final long serialVersionUID = 1L;

    private int id;
    private String authorName;
    private String authorImageUrl;
    private String publishedDate;
    private String title;
    private String description;
    private String text;

    // Empty constructor (is needed as its a Java Bean)
    public Blog() {
        this.setId(0);
        this.setAuthorName("");
        this.setAuthorImageUrl("");
        this.setPublishedDate("");
        this.setTitle("");
        this.setDescription("");
        this.setText("");
    }

    public Blog(int id, String authorName, String authorImageUrl, String publishedDate, String title,
            String description, String text) {
        this.setId(id);
        this.setAuthorName(authorName);
        this.setAuthorImageUrl(authorImageUrl);
        this.setPublishedDate(publishedDate);
        this.setTitle(title);
        this.setDescription(description);
        this.setText(text);
    }

    int getWordCount() {
        int wordCount = this.text.trim().split(" ").length;
        return wordCount;
    }

    int getMinutesToRead() {
        int minutesToRead = (this.getWordCount() / 100 + 1);
        return minutesToRead;
    }

    /**
     * ==============================
     * 
     * GETTERS AND SETTERS
     * 
     * ==============================
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorImageUrl() {
        return authorImageUrl;
    }

    public void setAuthorImageUrl(String authorImageUrl) {
        this.authorImageUrl = authorImageUrl;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
