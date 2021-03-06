package servlet;

import beans.IManageSystem;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTrip")
public class DeleteTrip extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //é manager
        if ((boolean)request.getSession().getAttribute("isManager")) {

            Integer tripID = Integer.parseInt(request.getParameter("submit").split("\\:")[1]);
            manageSystem.deleteTrip(tripID);

            request.getRequestDispatcher("mainManager.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}


