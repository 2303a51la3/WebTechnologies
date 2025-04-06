

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Authenticate using RegisterServlet's HashMap
        if (RegisterServlet.validateUser(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            response.sendRedirect("HomeServlet");
        } else {
            out.println("<h2>Login Failed! Invalid Credentials</h2>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
