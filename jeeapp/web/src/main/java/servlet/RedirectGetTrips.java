package servlet;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import data.Traveler;

@WebServlet("/redirectGetTrips")
public class RedirectGetTrips extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!(boolean)request.getSession().getAttribute("isManager")) {
            request.setAttribute("trips", manageSystem.listTrips(LocalDate.now(), LocalDate.now().plusYears(1000)));
            request.getRequestDispatcher("listTrips.jsp").forward(request, response);
        }
        else {
            request.setAttribute("trips", manageSystem.listTrips(LocalDate.now(), LocalDate.now().plusYears(1000)));
            request.getRequestDispatcher("listTripsManager.jsp").forward(request,response);
        }
    }
}

