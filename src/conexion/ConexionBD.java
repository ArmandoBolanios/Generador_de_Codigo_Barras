package conexion;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private final String bd = "imagenes";
    private final String user = "root";
    private final String pswd = "";
    private final String url = "jdbc:mysql://localhost:3306/" + bd;
    
    private Connection con = null;
    
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.pswd);
        }catch(SQLException e) {
            System.out.println(e);
        }catch(ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
