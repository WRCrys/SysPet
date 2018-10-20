package Dao;

import Model.Cliente;
import Variables.Variaveis;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    
    public static boolean Cadastrar_Cliente(Cliente c) {
        sql = "Insert into " + Variaveis.TB_CLIENTE + " (nome, endereco, cpf, telefone, celular, nascimento, sexo, status, cadastro) "
                + "values (?,?,?,?,?,?,?,?,?)";
        try {            
            conmysql = conexaomysql.conectabdmysql();
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
    
    public List<Cliente> Listar_Cliente(){
        
    List<Cliente> clientes = new ArrayList<>();
        
        sql = "Select id, nome, endereco, telefone, celular from "+Variaveis.TB_CLIENTE;
        
        try {
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
   public static boolean Atualizar_Cliente(Cliente c) {
        sql = "Update " + Variaveis.TB_CLIENTE + " set nome = ?, endereco = ?, cpf = ?, telefone = ?, celular = ?, nascimento = ?,"
                + " sexo = ?, status = ?, cadastro = ? where id = ?";
        try {            
            conmysql = conexaomysql.conectabdmysql();
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
            psmt.setInt(10, c.getId());
            psmt.executeUpdate();
            psmt.close();
            return true;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }
   
   public List<Cliente> Buscar_Cliente(Integer id){
        
    List<Cliente> clientes = new ArrayList<>();
        
        sql = "Select nome, endereco, cpf, telefone, celular, nascimento, sexo, status, cadastro"
                + " from "+Variaveis.TB_CLIENTE+" where id = ?";
        
        try {
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();   

            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setNascimento(rs.getDate("nascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setStatus(rs.getString("status"));
                cliente.setCadastro(rs.getDate("cadastro"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
   
   public static boolean Deletar_Cliente(Cliente c) {
        sql = "Delete from " + Variaveis.TB_CLIENTE + " where id = ?";
        try {            
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            psmt.setInt(1, c.getId());
            psmt.execute();
            psmt.close();
            return true;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }
   
   public List<Cliente> Id_Cliente(){
       List<Cliente> id_clientes = new ArrayList();
       
       sql = "Select id from "+Variaveis.TB_CLIENTE;
       
        try {
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            rs = psmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                id_clientes.add(cliente);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return id_clientes;
   }

}
