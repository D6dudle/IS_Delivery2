package servlet;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import data.Traveler;
import data.Trip;

@WebServlet("/redirectBuyTickets")
public class RedirectBuyTickets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //não é manager
        if (!(boolean)request.getSession().getAttribute("isManager")) {

            Integer tripID = Integer.parseInt(request.getParameter("submit").split("\\:")[1]);
            Trip t = manageSystem.getTrip(tripID);
            request.setAttribute("lugares", t.getMaxCapacity()-t.getTicketsSold().size());
            request.setAttribute("tripId", t.getId());
            request.setAttribute("departurePoint", t.getDeparturePoint());
            request.setAttribute("destinationPoint", t.getDestinationPoint());
            request.setAttribute("date", t.getDate());
            request.setAttribute("maxCapacity", t.getMaxCapacity());
            request.setAttribute("soldTickets", t.getTicketsSold().size());
            request.setAttribute("price", t.getPrice());
            request.getRequestDispatcher("buyTickets.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getSession().removeAttribute("isManager");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}

