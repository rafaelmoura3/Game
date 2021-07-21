package Dal;

    import java.sql.*;
import javax.swing.JOptionPane;


public class ConectDb {
    
    public static Connection conectdb() throws ClassNotFoundException{
      try{
          Class.forName("org.postgresql.Driver");
          Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Jogo","postgres","unip");
          JOptionPane.showMessageDialog(null, "conexão com sucesso");
          return con;
      } 
      catch(SQLException error){
          JOptionPane.showMessageDialog(null, error);
          
          return null;
      }
    }
}
