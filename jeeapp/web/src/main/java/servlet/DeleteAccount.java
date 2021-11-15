package servlet;

import beans.IManageSystem;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAccount")
public class DeleteAccount extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        manageSystem.deleteTraveler((String) request.getSession().getAttribute("email"));

        request.getSession().removeAttribute("email");
        request.getSession().removeAttribute("isManager");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}


