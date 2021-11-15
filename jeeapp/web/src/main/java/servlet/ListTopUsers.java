package servlet;

import beans.IManageSystem;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listTopUsers")
public class ListTopUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //é manager
        if ((boolean)request.getSession().getAttribute("isManager")) {
            //TODO:
            //1. -> Get top 5 Travalers c mais tickets
            //2. -> Setar variável de ambiente (topUsers) com as trips
            request.getRequestDispatcher("listTopUsers.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}


