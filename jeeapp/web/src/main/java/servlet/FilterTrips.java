package servlet;

import beans.IManageSystem;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/filterTrips")
public class FilterTrips extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //não é manager
        if (!(boolean)request.getSession().getAttribute("isManager")) {
            LocalDate from;
            LocalDate to;

            if (request.getParameter("de") == null || request.getParameter("de").equals(""))
                from = LocalDate.now();
            else
                from = LocalDate.parse(request.getParameter("de"));

            if (request.getParameter("a") == null || request.getParameter("a").equals(""))
                to = LocalDate.now().plusYears(1000);
            else
                to = LocalDate.parse(request.getParameter("a"));

            if (from.isAfter(LocalDate.now().minusDays(1)))
                request.setAttribute("trips", manageSystem.listTrips(from, to));

            request.getRequestDispatcher("listTrips.jsp").forward(request, response);
        }
        else {

            LocalDate from = null;
            LocalDate to = null;
            LocalDate at = null;

            if(!request.getParameter("em").equals("")){
                at = LocalDate.parse(request.getParameter("em"));
            }
            if (!request.getParameter("de").equals("")){
                from = LocalDate.parse(request.getParameter("de"));
            }
            if (!request.getParameter("a").equals("")){
                to = LocalDate.parse(request.getParameter("a"));
            }

            if (from != null && to != null){
                request.setAttribute("trips", manageSystem.listTrips(from, to));
            } else {
                if (at != null){
                    request.setAttribute("trips", manageSystem.listTrips(at, at));
                } else {
                    request.setAttribute("trips", manageSystem.listTrips(LocalDate.now(), LocalDate.now().plusYears(1000)));
                }
            }
            request.getRequestDispatcher("listTripsManager.jsp").forward(request,response);
        }
    }
}

