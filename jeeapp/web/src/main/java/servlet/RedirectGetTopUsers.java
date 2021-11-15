package servlet;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
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

        if ((boolean)request.getSession().getAttribute("isManager")) {
            List<Traveler> list = manageSystem.listTopTravelers();
            System.out.println(list.toString());
            if (list != null)
                request.setAttribute("topUsers", list);
            request.getRequestDispatcher("listTopUsers.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getSession().removeAttribute("isManager");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}

