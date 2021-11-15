package servlet;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import data.Traveler;

@WebServlet("/redirectEditAccount")
public class RedirectEditAccount extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //não é manager
        if (!(boolean)request.getSession().getAttribute("isManager")) {
            Traveler t = manageSystem.getTraveler((String) request.getSession().getAttribute("email"));
            request.setAttribute("name", t.getName());
            request.setAttribute("dob", t.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            request.getRequestDispatcher("account.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getSession().removeAttribute("isManager");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}

