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

@WebServlet("/createuser")
public class CreateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /*
    @EJB
    private IManageStudents manageStudents;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> field1List = manageStudents.listStudents().stream().map(User::getName).collect(Collectors.toList());
        String result = "Students list: " + field1List;
        System.out.println(result);
        response.getWriter().print(result);
    }*/
    @EJB
    private IManageSystem manageSystem;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LocalDateTime dob = LocalDateTime.now();
        manageSystem.newTraveler("Teste1", "email@email.com", "naoeumapass", dob);
        response.getWriter().print("User registado");
    }
}

