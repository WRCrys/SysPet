package Dao;

import Model.Cliente;
import Variables.Variaveis;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Skalybuhr
 */
public class ClienteDAO {

    public static Connection conmysql;
    public static PreparedStatement psmt;
    public static ResultSet rs;
    public static String sql;
    Cliente cliente = new Cliente();

    public ClienteDAO() throws ClassNotFoundException {
        conmysql = conexaomysql.conectabdmysql();

    }

    public static boolean Cadastrar_Cliente(Cliente c) {
        sql = "Insert into " + Variaveis.TB_CLIENTE + " (nome, endereco, cpf, telefone, celular, nascimento, sexo, status, cadastro) "
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            psmt = conmysql.prepareStatement(sql);
            psmt.setString(1, c.getNome());
            psmt.setString(2, c.getEndereco());
            psmt.setString(3, c.getCpf());
            psmt.setString(4, c.getTelefone());
            psmt.setString(5, c.getCelular());
            psmt.setDate(6, new java.sql.Date(c.getNascimento().getTime()));
            psmt.setString(7, c.getSexo());
            psmt.setString(8, c.getStatus());
            psmt.setDate(9, new java.sql.Date(c.getCadastro().getTime()));
            psmt.execute();
            psmt.close();
            return true;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }

}
