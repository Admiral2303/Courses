package com.gmail.vadimv41.controller;

import com.gmail.vadimv41.database.DatabaseManager;
import com.gmail.vadimv41.model.Publication;
import com.gmail.vadimv41.model.PublicationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(
        name = "searchPublication",
        urlPatterns = "/searchPublication"
)
public class Controller extends HttpServlet {
    private PublicationService publicationService;

    public Controller() {
        this.publicationService = new PublicationService(DatabaseManager.getPublications());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String searchValue = req.getParameter("name");
        String searchCriteria = req.getParameter("searchCriteria");
        String sortCriteria = req.getParameter("sortCriteria");
        System.out.println(searchCriteria);
        System.out.println(searchValue);
        System.out.println(sortCriteria);
        try {
            if(sortCriteria != null) {
                List<Publication> sortedPublications = publicationService.searchAndSortByCriteria(sortCriteria, searchCriteria, searchValue);
                req.setAttribute("publications", sortedPublications);
            } else if (searchCriteria != null) {
                List<Publication> publications = publicationService.searchByCriteria(searchCriteria, searchValue);
                req.setAttribute("publications", publications);
            }
        } catch (NumberFormatException ex) {
            req.setAttribute("error", "Please input correct number");
        }

        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, res);

    }
}
