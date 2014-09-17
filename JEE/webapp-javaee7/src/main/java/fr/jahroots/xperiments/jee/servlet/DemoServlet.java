package fr.jahroots.xperiments.jee.servlet;

import fr.jahroots.xperiments.jee.dao.UserDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jahroots.
 */
@WebServlet(name = "demoServlet", urlPatterns = {"/demoServlet"})
public class DemoServlet extends HttpServlet {

    @Inject
    private UserDao userDao;


    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final PrintWriter out = resp.getWriter();
        out.println("<html><head></head><body>");
        if (null == userDao) {
            out.println("userDao is null");
        } else {
            out.println(userDao.save());
        }
        out.println("</body></html>");
    }
}
