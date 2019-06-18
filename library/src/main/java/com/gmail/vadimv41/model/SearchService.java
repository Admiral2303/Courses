package com.gmail.vadimv41.model;

public class SearchService {
    private Publication scientificPublication;
    private Publication scientificBook;

    public SearchService(Publication scientificPublication, Publication scientificBook) {
        this.scientificPublication = scientificPublication;
        this.scientificBook = scientificBook;
    }

    public Publication searchScientificPublicationByCriteria(String criteria, String criteriaValue) {
        return null;
    }

    public Publication searchScientificBookByCriteria(String criteria, String criteriaValue) {
        return null;
    }
}
