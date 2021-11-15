package servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

@WebServlet("/logOut")
public class LogOut extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("email");
        request.getSession().removeAttribute("isManager");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
