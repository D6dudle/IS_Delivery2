package servlet;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import data.Traveler;

@WebServlet("/updateAccount")
public class UpdateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (manageSystem.tryLogin((String) request.getSession().getAttribute("email"), request.getParameter("oldPassword")) != null) {
            if (request.getParameter("password").equals(request.getParameter("passwordCopy"))){
                manageSystem.updateTraveler(request.getParameter("name"),
                        (String) request.getSession().getAttribute("email"),
                        request.getParameter("password"),
                        LocalDate.parse(request.getParameter("dob")),
                        false);

                request.getRequestDispatcher("main.jsp").forward(request, response);
            } else {
                Traveler t = manageSystem.getTraveler((String) request.getSession().getAttribute("email"));
                request.setAttribute("name", t.getName());
                request.setAttribute("dob", t.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                request.getRequestDispatcher("account.jsp").forward(request, response);
            }
        } else {
            Traveler t = manageSystem.getTraveler((String) request.getSession().getAttribute("email"));
            request.setAttribute("name", t.getName());
            request.setAttribute("dob", t.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            request.getRequestDispatcher("account.jsp").forward(request, response);
        }

    }
}
