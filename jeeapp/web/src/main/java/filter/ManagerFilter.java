package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
@WebFilter("/manager/*")
public class ManagerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);

        if (session != null && session.getAttribute("email") != null){
            chain.doFilter(request, response);
        }
        else{
            request.getRequestDispatcher("/errorLogin.html").forward(request, response);
        }

        if (session != null && session.getAttribute("isManager") != null && (Boolean)session.getAttribute("isManager")){
            chain.doFilter(request, response);
        }
        else{
            request.getRequestDispatcher("/errorNotManager.html").forward(request, response);
        }
    }
}
 */