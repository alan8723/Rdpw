package rdpw.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    
    public Connection get_connection(){
         Connection con = null;
         
             try {
                //Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rpdw", "root","");
                if( con != null){

                }
                
            } catch (SQLException e){
                System.err.println("Error: " +e);
                }
             return con;     
    }
         
}    