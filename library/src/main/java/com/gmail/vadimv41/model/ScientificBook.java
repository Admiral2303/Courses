package com.gmail.vadimv41.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class ScientificBook extends Publication {
    private int cost;
    private String introduction;

    public ScientificBook(String title, LocalDate publishDate, String authorName, String authorSurname,
                          LocalDate authorBirthday, int pageCount, int cost, String introduction) {
        super(title, publishDate, new Author(authorName, authorSurname, authorBirthday), pageCount);
        this.cost = cost;
        this.introduction = introduction;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScientificBook that = (ScientificBook) o;
        return cost == that.cost &&
                Objects.equals(introduction, that.introduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, introduction);
    }

    @Override
    public String toString() {
        return "ScientificBook{" +
                "cost=" + cost +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
