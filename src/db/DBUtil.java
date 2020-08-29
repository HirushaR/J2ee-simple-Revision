package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    public static PreparedStatement GetPreparedStatement(String sql) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        // this is our url to database
        // test is mt database name
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        // root is my username
        String user = "root";
        String pass = "";

        // now we pass the connection to Driver manager to connect with database
        Connection con = DriverManager.getConnection(url,user,pass);
        ps = con.prepareStatement(sql);

        return ps;
    }

    // check connection
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GetPreparedStatement("select * from news");
    }
}
