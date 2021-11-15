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

@WebServlet("/buyTickets")
public class BuyTickets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //não é manager
        if (!(boolean)request.getSession().getAttribute("isManager")) {
            //TODO:
            //1 -> get Nr de tickets e preço de cada 1
            //2. -> Verificar se o User tem dinheiro suficiente
            //Se sim
            //3.a. -> get do ID da Trip (adicionao às variáveis de sessão no "RedirectBuyTickets")
            //4.a. -> Adicionar os Tickets ao Traveler e à Trip
            //5.a. -> Mensagem de Sucesso para as variáveis de sessão
            //6.a. -> request.getRequestDispatcher("main.jsp").forward(request, response);
            //Se não
            //3.b. -> Mensagem de Sucesso para as variáveis de sessão
            //4.b. -> request.getRequestDispatcher("listTrips.jsp").forward(request, response);
        }
        else {
            request.getSession().removeAttribute("email");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}

