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

    public void addPublicationToList(Publication publication) {
        listOfPublications.add(publication);
    }

    public List<Publication> getListOfPublications() {
        return listOfPublications;
    }

    public void setListOfPublications(List<Publication> listOfPublications) {
        this.listOfPublications = listOfPublications;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ScientificPublication{" +
                "listOfPublications=" + listOfPublications +
                ", subject='" + subject + '\'' +
                '}';
    }
}
