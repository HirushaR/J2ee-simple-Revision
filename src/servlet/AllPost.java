package servlet;

import db.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "AllPost", urlPatterns = "/AllPost")
public class AllPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // printwriter is a object that we can use to write on out html page
        // so i create a object from print writer so i can out put values
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");

        // this is out query
        String query = "select * from news";
        try {
            // pass the query to database connection
            ResultSet rs = DBUtil.GetPreparedStatement(query).executeQuery();
            // i create a table
            out.println("<table cellpadding=\"10\">");
            out.println(" <tr>\n" + "<th>ID</th>\n" + "<th>Name</th>\n" + "<th>School</th>\n" + "<th>Age</th>\n" + "</tr>");
            while (rs.next())
            {
                // this is our table data i assignt to variable
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String school = rs.getString("school");
                int age = rs.getInt("age");

                //and the variable out put
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + school + "</td></tr>"+age);
            }
            out.println("</table>");
            out.println("</html></body>");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
