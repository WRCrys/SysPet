package Dao;

import java.sql.*;
import javax.swing.JOptionPane;
import Variables.Variaveis;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Skalybuhr
 */
public class conexaomysql {

    public static Connection conectabdmysql() throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + Variaveis.NOME_DB, Variaveis.USER_DB, Variaveis.PASSWORD_DB);
            return con;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
            return null;
        }

    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexaomysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement psmt) {

        closeConnection(con);

        try {

            if (psmt != null) {
                psmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexaomysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement psmt, ResultSet rs) {

        closeConnection(con, psmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexaomysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
