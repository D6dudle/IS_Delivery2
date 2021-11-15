package servlet;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

@WebServlet("/register")
public class Register extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password");
        String password2 = request.getParameter("passwordCopy");
        String dobString = request.getParameter("dob");

        if (!password1.equals(password2)) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        LocalDate dob = LocalDate.parse(dobString);
        if (manageSystem.newTraveler(name, email, password1, dob)){
            request.getSession().setAttribute("email", request.getParameter("email"));
            request.getSession().setAttribute("isManager", false);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
        else
            request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}

