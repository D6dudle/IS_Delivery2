package servlet;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import data.Ticket;
import data.Trip;

@WebServlet("/cancelTicket")
public class CancelTicket extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //não é manager
        if (!(boolean)request.getSession().getAttribute("isManager")) {

            Integer tripID = Integer.parseInt(request.getParameter("submit").split("\\:")[1]);
            manageSystem.returnTicket((String) request.getSession().getAttribute("email"), tripID);

            List<Ticket> ticketlist = manageSystem.listMyTickets((String) request.getSession().getAttribute("email"));

            request.setAttribute("myTicketList", ticketlist);
            request.getRequestDispatcher("listUserTickets.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}