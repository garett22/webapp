import jdk.nashorn.internal.ir.debug.JSONWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 07.03.16.
 */
@WebServlet(name = "Exchange")
public class Exchange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doGet(request,response); }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
        String c0=request.getParameter("currency0").toUpperCase();
        String c1=request.getParameter("currency1").toUpperCase();
        long t=request.getDateHeader("");

        //TODO tutaj mogłoby być zapytanie do jakiegoś serwisu
        Double rate = Decoy.get(t,c0,c1);
        JsonObject json = Json.createObjectBuilder()
                .add("time", t)
                .add("currency0", c0)
                .add("currency1", c1)
                .add("rate", rate).build();
        response.setContentType("application/json");
        response.getWriter().print(json.toString());
//        response.getWriter().print("<p>"+request.getParameter("p1")+"</p><br><br><h3>"+request.getParameter("p2")+"</h3>");
    }
}
