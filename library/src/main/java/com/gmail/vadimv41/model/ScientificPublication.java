package com.gmail.vadimv41.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScientificPublication extends  Publication {
    private List<Publication> listOfPublications;
    private String subject;

    public ScientificPublication(String title, LocalDate publishDate, String authorName, String authorSurname,
                                 LocalDate authorBirthday, int pageCount, String subject) {
        super(title, publishDate, new Author(authorName, authorSurname, authorBirthday), pageCount);
        this.subject = subject;
        listOfPublications = new ArrayList<>();
    }

    @Override
    public Publication searchByCriteria(String criteria, String criteriaValue) {
        if(criteria.equals("subject")){

        }
        throw new IllegalArgumentException("Search criteria is invalid for scientific publication");
    }

}
