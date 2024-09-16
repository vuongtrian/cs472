package web;

import model.BeerExpert;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerSelect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String color = request.getParameter("color");

        if (color != null && !color.isEmpty()) {
            BeerExpert beerExpert = new BeerExpert();
            List<String> recommendations = beerExpert.getBrands(color);
            request.setAttribute("styles", recommendations);
        }

        request.getRequestDispatcher("pages/result.jsp").forward(request, response);
    }
}