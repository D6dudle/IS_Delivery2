package servlet;

import beans.IManageSystem;
import data.Ticket;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/createTrip")
public class CreateTrip extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //é manager
        if ((boolean)request.getSession().getAttribute("isManager")) {

            LocalDate date = LocalDate.parse(request.getParameter("departureDate"));
            String departure = request.getParameter("departurePoint");
            String destination = request.getParameter("destinationPoint");
            Integer maxCapacity = Integer.parseInt(request.getParameter("maxCapacity"));
            Double price = Double.parseDouble(request.getParameter("price"));

            manageSystem.newTrip(date, departure, destination, maxCapacity, price);

            request.getRequestDispatcher("mainManager.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}