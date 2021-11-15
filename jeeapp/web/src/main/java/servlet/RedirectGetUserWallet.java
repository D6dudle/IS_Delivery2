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

@WebServlet("/redirectGetUserWallet")
public class RedirectGetUserWallet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //não é manager
        if (!(boolean)request.getSession().getAttribute("isManager")) {
            request.setAttribute("wallet", manageSystem.chargeWallet((String) request.getSession().getAttribute("email"), 0.0));
            request.getRequestDispatcher("myWallet.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getSession().removeAttribute("isManager");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}

