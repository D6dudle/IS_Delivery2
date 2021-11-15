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

@WebServlet("/redirectGetTrips")
public class RedirectGetTrips extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO: enviar para o .jsp as Trips q n aconteceram
        if (!(boolean)request.getSession().getAttribute("isManager")) {
            request.getRequestDispatcher("listTrips.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("listTripsManager.jsp").forward(request,response);
        }
    }
}

