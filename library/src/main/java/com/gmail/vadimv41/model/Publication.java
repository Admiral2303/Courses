package com.gmail.vadimv41.model;

import java.time.LocalDate;

public abstract class Publication {
    private String title;
    private LocalDate publishDate;
    private Author author;
    private int pageCount;

    public Publication(String title, LocalDate publishDate, Author author, int pageCount) {
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.pageCount = pageCount;
    }

    public abstract Publication searchByCriteria(String criteria, String criteriaValue);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
