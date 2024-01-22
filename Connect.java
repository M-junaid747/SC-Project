
package employee.management.system;
import java.sql.*;

public class Connect {
    Connection c;
    Statement s;
    
    public Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","junaid2002","PHP@myadmin2002");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
