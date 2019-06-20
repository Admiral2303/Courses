package com.gmail.vadimv41.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PublicationServiceTest {
    private List<Publication> publications = new ArrayList<>();
    private PublicationService service;

    public PublicationServiceTest() {
        publications.add(new ScientificPublication("Aithken integration algorithm", LocalDate.of(2018,4,26),
                "Martin", "Dutka", LocalDate.of(1970,4,12),
                96, "Numerical methods"));
        publications.add(new ScientificPublication("Newthon integration algorithm", LocalDate.of(2018,9,26),
                "Martin", "Dutka", LocalDate.of(1970,4,12),
                50, "Numerical methods"));
        publications.add(new ScientificPublication("Tridiagonal integration algorithm", LocalDate.of(2018,1,26),
                "Martin", "Dutka", LocalDate.of(1970,4,12),
                3, "Numerical methods"));
        service = new PublicationService(publications);
    }

    /**
     * Should return list with one Publication Object if db contains object with search value
     */
    @org.junit.Test
    public void searchByTitle() {
        List<Publication> publicationList = service.searchByCriteria("title", "Aithken");
        assertEquals(publicationList.size(), 1);
        assertEquals(publicationList.get(0).getTitle(), "Aithken integration algorithm");
    }

    /**
     * Should return empty list if db doesnt contain objects with search value
     */
    @org.junit.Test
    public void searchByTitleNoElementsFind() {
        List<Publication> publicationList = service.searchByCriteria("title", "example");
        assertEquals(publicationList.size(), 0);
    }

    /**
     * Should return list of Publications if search value is empty
     */
    @org.junit.Test
    public void searchByTitleEmptySearchValue() {
        List<Publication> publicationList = service.searchByCriteria("title", "");
        assertEquals(publicationList.size(), 3);
    }

    /**
     * Should return list with one Publication Object if db contains publication in which
     * number of pages larger than specified
     */
    @org.junit.Test
    public void searchByPageCount() {
        List<Publication> publicationList = service.searchByCriteria("min page count", "95");
        assertEquals(publicationList.size(), 1);
        assertEquals(publicationList.get(0).getPageCount(), 96);
    }

    /**
     * Should return empty list  if db doesnt contain publication in which
     * number of pages larger than specified
     */
    @org.junit.Test
    public void searchByPageCountNoElementsFind() {
        List<Publication> publicationList = service.searchByCriteria("min page count", "100");
        assertEquals(publicationList.size(), 0);
    }

    /**
     * Should return list of Publications if search value is empty
     */
    @org.junit.Test(expected = NumberFormatException.class)
    public void searchPageCountTrowsException() throws NumberFormatException {
        service.searchByCriteria("min page count", "sdsa");
    }

    /**
     * Should return list of sorted Publications by date
     */
    @org.junit.Test
    public void sortBydDate() {
        List<Publication> publicationList = service.searchAndSortByCriteria("date","title", "");
        assertEquals(publicationList.size(), 3);
        assertEquals(publicationList.get(0).getTitle(), "Tridiagonal integration algorithm");
        assertEquals(publicationList.get(1).getTitle(), "Aithken integration algorithm");
        assertEquals(publicationList.get(2).getTitle(), "Newthon integration algorithm");
    }

    /**
     * Should return list of sorted Publications by pages count
     */
    @org.junit.Test
    public void sortBydPageCount() {
        List<Publication> publicationList = service.searchAndSortByCriteria("page_count", "title", "");
        assertEquals(publicationList.size(), 3);
        assertEquals(publicationList.get(0).getPageCount(), 3);
        assertEquals(publicationList.get(1).getPageCount(), 50);
        assertEquals(publicationList.get(2).getPageCount(), 96);
    }
}