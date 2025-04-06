
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("employeeName") == null) {
            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html");
        response.getWriter().println("<h2>Welcome, " + session.getAttribute("employeeName") + "!</h2>");
        response.getWriter().println("<a href='LogoutServlet'>Logout</a>");
    }
}
