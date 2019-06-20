package com.gmail.vadimv41.model;

import com.gmail.vadimv41.database.DatabaseManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PublicationService {
    List<Publication> publications = new ArrayList<>();

    public PublicationService(List<Publication> publications) {
        if(publications != null) {
            this.publications = publications;
        }
    }

    /**
     * Search Publications by criteria
     * @param criteria search criteria
     * @param criteriaValue criteria value
     * @return list of publications
     * @throws NumberFormatException if input number is invalid
     */
    public List<Publication> searchByCriteria(String criteria, String criteriaValue) throws NumberFormatException {
        switch (criteria) {
            case "title":
                return publications.stream()
                        .filter(el -> el.getTitle().toLowerCase().contains(criteriaValue.toLowerCase()))
                        .collect(Collectors.toList());
            case "min page count":
                try {
                    int minPagesCount = Integer.parseInt(criteriaValue);
                    return publications.stream()
                            .filter(el -> el.getPageCount() > minPagesCount)
                            .collect(Collectors.toList());
                } catch (NumberFormatException ex) {
                    throw ex;
                }

            default:
                return publications;

        }
    }

    /**
     * Sort publications list by criteria
     * @param sortCriteria sort criteria
     * @param searchCriteria search criteria
     * @param searchValue search value
     * @return sorted publications list
     */
    public List<Publication> searchAndSortByCriteria(String sortCriteria, String searchCriteria, String searchValue) {
        List<Publication> searchList = searchByCriteria(searchCriteria,searchValue);
        switch (sortCriteria) {
            case "date":
                return searchList.stream()
                        .sorted(Comparator.comparing(Publication::getPublishDate))
                        .collect(Collectors.toList());
            case "page_count":
                return searchList.stream()
                        .sorted(Comparator.comparingInt(Publication::getPageCount))
                        .collect(Collectors.toList());
            default:
                return searchList;

        }
    }


}
