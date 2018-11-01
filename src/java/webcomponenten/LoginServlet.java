package webcomponenten;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getsession")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);//As soon as the session is created the listener is fired up

        if (session != null) {

            String userid = request.getParameter("sessiontext");
            session.setAttribute("sessiontext", userid);
            System.out.println("Total logged in users: " + Listener.total);
            System.out.println("Current logged in users: " + Listener.current);
            response.sendRedirect(request.getContextPath() + "/index.jsp");

        }else {

            response.sendRedirect("index.jsp");
        }
    }
}
