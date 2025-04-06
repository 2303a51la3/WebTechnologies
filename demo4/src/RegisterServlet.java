
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.GenericServlet;

public class RegisterServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;

    // Temporary storage for registered employees
    private static HashMap<String, String> users = new HashMap<>();

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String department = request.getParameter("department");

        // Store email and password in HashMap (temporary storage)
        users.put(email, password);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Registration Successful!</h2>");
        out.println("<a href='login.html'>Go to Login</a>");
    }

    // Provide a static method to access users
    public static boolean validateUser(String email, String password) {
        return users.containsKey(email) && users.get(email).equals(password);
    }
}
