
package kata5p1;
import java.io.*;
import java.sql.*;


public class Kata5P1 {

    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
       Class.forName("org.sqlite.JDBC");
       Connection con= DriverManager.getConnection("jdbc:sqlite:.\\KATA5.DB");
       
       Statement st =con.createStatement();
       
       String query="SELECT * FROM PEOPLE";
       ResultSet rs= st.executeQuery(query);
       String listamail="C:\\Users\\Entrar\\Desktop\\emails.txt";
       BufferedReader reader= new BufferedReader(new FileReader(new File(listamail)));
       while(rs.next()){
           
           System.out.println(rs.getInt(1));
           System .out.println(rs.getString(2));
       }
       query="CREATE TABLE IF NOT EXISTS MAIL"
              + "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'mail' TEXT NOT NULL)";
       
       st.execute(query);
       String mail;
       while ((mail=reader.readLine())!= null){
      
       String query2="INSERT INTO MAIL (mail) VALUES('"+ mail +"')";
       st.executeUpdate(query2);
       }
       st.execute(query);
       
       rs.close();
       st.close();
       con.close();
       
    }
    
}
