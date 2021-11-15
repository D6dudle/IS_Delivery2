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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //é manager
        if ((boolean)request.getSession().getAttribute("isManager")) {
            //TODO:
            //1. -> Get do ID da Trip (verificar se está a setar essa variável no .jsp)
            //2. -> Se tiver bilhetes, reembolsar os users e enviar mail (deixar mail p o fim)
            //3. -> Delete
            //4. -> Mensagem de sucesso para as variáveis de ambiente
            request.getRequestDispatcher("mainManager.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}


