package com.gmail.vadimv41.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ScientificBook extends Publication {
    private int cost;
    private String introduction;

    public ScientificBook(String title, LocalDate publishDate, String authorName, String authorSurname,
                          LocalDate authorBirthday, int pageCount, int cost, String introduction) {
        super(title, publishDate, new Author(authorName, authorSurname, authorBirthday), pageCount);
        this.cost = cost;
        this.introduction = introduction;
    }

    @Override
    public Publication searchByCriteria(String criteria, String criteriaValue) {
        return null;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}
