package Dao;

import java.sql.*;
import javax.swing.JOptionPane;
import Variables.Variaveis;

/**
 *
 * @author Skalybuhr
 */
public class conexaomysql {
    
    public static Connection conectabdmysql() throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+Variaveis.NOME_DB,Variaveis.USER_DB, Variaveis.PASSWORD_DB);
            System.out.println("Banco de dados conectado com sucesso!");
            return con;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error: "+error);
            return null;
        }   
        
    }
    
    public static void closeConnection(Connection conecta, Statement stm, ResultSet rs) throws Exception{
        
        closeConnection(conecta, stm, rs);
        
    }
    
    public static void closeConnection(Connection conecta, Statement stm) throws Exception{
        
        closeConnection(conecta, stm, null);
        
    }
    
    public static void closeConnection(Connection conecta) throws Exception{
        
        closeConnection(conecta, null, null);
        
    }
    
    public static void close(Connection conecta, Statement stm, ResultSet rs) throws Exception{
        
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexão: "+e);
        }
        
    }
    
    
}
