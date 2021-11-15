package servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import data.*;

@WebServlet("/logIn")
public class LogIn extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Traveler t = manageSystem.tryLogin(request.getParameter("email"), request.getParameter("password"));
        if (t != null) {
            request.getSession().setAttribute("email", request.getParameter("email"));
            request.getSession().setAttribute("isManager", t.getManager());
            if (t.getManager())
                request.getRequestDispatcher("mainManager.jsp").forward(request,response);
            else
                request.getRequestDispatcher("main.jsp").forward(request,response);
        } else {
            response.getWriter().print("Dados incorretos ou conta não existente");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
