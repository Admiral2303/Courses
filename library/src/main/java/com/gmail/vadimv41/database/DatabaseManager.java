package com.gmail.vadimv41.database;

import com.gmail.vadimv41.model.Publication;
import com.gmail.vadimv41.model.ScientificBook;
import com.gmail.vadimv41.model.ScientificPublication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DatabaseManager {

    FIRST_PUBLICATION(new ScientificPublication("Romberg integration algorithm", LocalDate.of(2018,6,26),
            "Jacques", "Dutka", LocalDate.of(1970,4,12),
            98, "Numerical methods"),
            new ScientificPublication("Mathematic", LocalDate.of(2018,3,26),
                    "Martin", "Dutka", LocalDate.of(1970,4,12),
                    50, "Numerical methods")),
    SECOND_PUBLICATION(new ScientificPublication("Aithken integration algorithm", LocalDate.of(2018,4,26),
            "Martin", "Dutka", LocalDate.of(1970,4,12),
            50, "Numerical methods")),
    THIRD_PUBLICATION(new ScientificPublication("Newthon integration algorithm", LocalDate.of(2018,3,26),
            "Jacques", "Dutka", LocalDate.of(1970,4,12),
            2, "Numerical methods")),
    FORTH_PUBLICATION(new ScientificPublication("Trapezodial integration algorithm", LocalDate.of(2018,9,26),
            "Jacques", "Dutka", LocalDate.of(1970,4,12),
            12, "Numerical methods")),
    FIFTH_PUBLICATION(new ScientificBook("Mathematical algorithms", LocalDate.of(2018,9,26),
            "Robert", "Wilson", LocalDate.of(1970,4,12),
                    12, 96, "some text"));



    private Publication publication;

    DatabaseManager(Publication publication) {
        if(publication != null) {
            this.publication = publication;
        }
    }

    DatabaseManager(ScientificPublication publication, Publication ...publicationsList) {
        if(publication != null) {
            for(Publication pub: publicationsList) {
                publication.addPublicationToList(pub);
            }
            this.publication = publication;

        }
    }

    /**
     * Get publications from enum
     * @return list of publications
     */
    public static List<Publication> getPublications() {
        return Arrays.asList(values()).stream().map(DatabaseManager::getPublication).collect(Collectors.toList());
    }

    public Publication getPublication() {
        return publication;
    }

}
