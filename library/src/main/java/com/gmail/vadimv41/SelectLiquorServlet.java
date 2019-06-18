package com.gmail.vadimv41;

import com.gmail.vadimv41.LiquorService;
import com.gmail.vadimv41.model.LiquorType;
import com.gmail.vadimv41.model.Publication;
import com.gmail.vadimv41.model.ScientificPublication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@WebServlet(
        name = "selectliquorservlet",
        urlPatterns = "/SelectLiquor"
)
public class SelectLiquorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String liquorType = req.getParameter("Type");

        LiquorService liquorService = new LiquorService();
        com.gmail.vadimv41.model.LiquorType l = LiquorType.valueOf(liquorType);

        List liquorBrands = liquorService.getAvailableBrands(l);

        req.setAttribute("brands", liquorBrands);
        Publication pub = new ScientificPublication("Romberg integration algorithm", LocalDate.of(2018,3,26),
                "Jacques", "Dutka", LocalDate.of(1970,4,12),
                50, "Numerical methods");
        req.setAttribute("publication", pub);
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, res);

    }
}
