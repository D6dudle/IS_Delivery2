package servlet;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

@WebServlet("/updateWallet")
public class updateWallet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Double amount = Double.parseDouble(request.getParameter("income"));
        manageSystem.chargeWallet((String) request.getSession().getAttribute("email"), amount);

        //TODO:Adicionar mensagem de sucesso
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}




