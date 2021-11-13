package servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

@WebServlet("/login")
public class LogIn extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (manageSystem.tryLogin(request.getParameter("email"), request.getParameter("password"))) {
            request.getSession().setAttribute("email", request.getParameter("email"));
            request.getRequestDispatcher("main").forward(request,response);
        } else {
            response.getWriter().print("Dados incorretos ou conta não existente");
        }
    }
}
