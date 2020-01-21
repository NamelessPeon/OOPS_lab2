import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/signup"})
public class signup extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/plain");
        var pw = resp.getWriter();
        var name = req.getParameter("user");
        var password = req.getParameter("password");
        var sess = req.getSession();
        if( name == null ){
            pw.printf("No username provided");
        } else {
           
            sess.setAttribute("name", name );
            pw.printf("Logged in as "+name);
        }
        if(password == null)
        {
            pw.printf("No password provided");
        }
        else{
            
            sess.setAttribute("password", password);
           
            pw.printf("Logged in as "+password);
        }
    }

}