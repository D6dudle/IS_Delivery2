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

@WebServlet("/redirectGetTopUsers")
public class RedirectGetTopUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Traveler t = manageSystem.tryLogin(request.getParameter("email"), request.getParameter("password"));
        if (t != null) {
            if (t.getManager()) {
                //TODO: enviar para o .jsp o top 5 users com mais tickets comprados
                request.getRequestDispatcher("listTopUsers.jsp").forward(request, response);
            }
            else {
                request.getSession().removeAttribute("email");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else {
            request.getSession().removeAttribute("email");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}

