package servlet;

import db.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Insert",urlPatterns = "/Insert")
public class Insert extends HttpServlet {




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // because our form send data in post method we code in doPost
        // we store the data that past on index.jsp page and save it form a variable
        // in that form data send as post method so the data come on parameter but hide
        // so no one can visible data or parameter

        // in servlet request is method that called to server or page to get data

        String name = request.getParameter("name");
        String school = request.getParameter("school");
        // parameter data came as string by defult so save age we convert to int from parsing
        int age = Integer.parseInt(request.getParameter("age"));


        try {

            // preparedStatement is interface that help to execute parametelize sql query;
            PreparedStatement ps = null;
            // in this line we write a query to insert data to news table
            // news table has 4 column id,name,school,age
            // for the values we pass ? as parameter so we can add them later
            String query = "insert into news values(?,?,?,?)";
            //to database connection we pass query to GetPreparedStatement method in DBUtil class
            ps = DBUtil.GetPreparedStatement(query);
            // now we add values to ? parameter in our query
            // first colum we pass the data is id,its a int values so we need setInt and its 1 parameter , and pass the value
            // values this case is 0 cause id is auto increment
            ps.setInt(1,0);
            // second column is name and its string, its second parameter so 2, and we pass the name variable that store value came form table
            ps.setString(2,name);
            ps.setString(3,school);
            ps.setInt(4,age);
            // and we execute the query
            ps.executeUpdate();

            // in servlet response is method that called to server or page to send data
            // so this operation done it will redirect to AllPost url
            // AllPost is another servlet
            response.sendRedirect("/test01_war_exploded/AllPost");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if form send data in Get method we write operation here
    }
}
