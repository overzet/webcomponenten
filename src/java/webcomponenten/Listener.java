package webcomponenten;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements HttpSessionListener {

    ServletContext context = null;

    static int total = 0;
    static int current = 0;

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        total++;
        current++;
        context = sessionEvent.getSession().getServletContext();
        context.setAttribute("total", total);
        context.setAttribute("current", current);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        current--;
        context.setAttribute("current", current);
    }
}
