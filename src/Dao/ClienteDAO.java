package Dao;

import Model.Cliente;
import Variables.Variaveis;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Skalybuhr
 */
public class ClienteDAO {
    
    Connection conmysql;
    PreparedStatement psmt;
    ResultSet rs;
    String sql;
    Cliente cliente = new Cliente();

    public ClienteDAO() throws ClassNotFoundException{
        conmysql = conexaomysql.conectabdmysql();
        
    }
    
    public void Cadastrar_Cliente(){
        sql = "Insert into "+Variaveis.TB_CLIENTE+" (nome, endereco, cpf, telefone, celular, nascimento, sexo, status, cadastro) "
                + "values (?,?,?,?,?,?,?,?,?)";
        
        try {
            psmt = conmysql.prepareStatement(sql);
            psmt.setString(1, cliente.getNome());
            psmt.setString(2, cliente.getEndereco());
            psmt.setString(3, cliente.getCpf());
            psmt.setString(4, cliente.getTelefone());
            psmt.setString(5, cliente.getCelular());
            psmt.setDate(6, (Date) cliente.getNascimento());
            psmt.setString(7, cliente.getSexo());
            psmt.setString(8, cliente.getStatus());
            psmt.setDate(9, (Date) cliente.getCadastro());
            psmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            psmt.close();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    
    
}
